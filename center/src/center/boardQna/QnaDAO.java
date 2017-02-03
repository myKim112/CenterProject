package center.boardQna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class QnaDAO {

private static QnaDAO instance = new QnaDAO();
	
	public static QnaDAO getInstance(){
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws Exception {
		Context ctx= new InitialContext();
		Context env = (Context)ctx.lookup("java:comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/orcl");
		
		return ds.getConnection();
	}
	
	//QnaList.jsp ==> Paging!
	public List getArticles(int start, int end) throws Exception{
		
		List articleList = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select num, center, title, content, writer, pw, regDate, readCount, ref, reLevel, reStep, r  " +
		            "from (select num,center,title,content,writer,pw,regDate,readCount,ref,reLevel,reStep,rownum r " +
		            "from (select * " +
		            "from qna order by ref desc, reStep asc) order by ref desc, reStep asc ) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articleList = new ArrayList(end);
				do{
					QnaDTO article = new QnaDTO();
					article.setNum(rs.getInt("num"));
					article.setCenter(rs.getString("center"));
					article.setTitle(rs.getString("title"));
					article.setContent(rs.getString("content"));
					article.setWriter(rs.getString("writer"));
					article.setPw(rs.getString("pw"));
					article.setRegDate(rs.getTimestamp("regDate"));
					article.setReadCount(rs.getInt("readCount"));
					article.setRef(rs.getInt("ref"));
					article.setReStep(rs.getInt("reStep"));
					article.setReLevel(rs.getInt("reLevel"));
					
					articleList.add(article);
					
				}while(rs.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
	           if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}			
		}
		return articleList;
	}
	
    //qnawritePro.jsp
	public void insertArticle(QnaDTO article) throws Exception{
		
		//답변글인지 일반글인지를 구분해서 입력시켜주는 로직

		//ref 	  : 게시글의 그룹. 게시글과 답글의 번호
		//reStep  : 답글을 나누기 위한 번호 
		//reLevel : 답글의 그룹
		
		int num=article.getNum();
		int ref=article.getRef();
		int reStep=article.getReStep();
		int reLevel=article.getReLevel();
		int number=0;
		
		String sql="";
		
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement("select max(num) from qna");
			rs = pstmt.executeQuery();
			if (rs.next()) 
				number=rs.getInt(1)+1;	
			else
				number=1; 
			if (num!=0) 
			{ 
				sql="update qna set reStep=reStep+1 where ref= ? and reStep> ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, reStep);
				pstmt.executeUpdate();
				reStep=reStep+1;
				reLevel=reLevel+1;
			}else{ 
				ref=number;
				reStep=0;
				reLevel=0;
			}
 
			sql = "insert into qna(num,center,title,content,writer,pw,regDate,ref,reStep,reLevel) values(seq_qna.NEXTVAL,?,?,?,?,?,sysdate,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, article.getCenter());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getWriter());
			pstmt.setString(5, article.getPw());
			pstmt.setInt(6, article.getRef());
			pstmt.setInt(7, article.getReStep());
			pstmt.setInt(8, article.getReLevel());
			
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	
	public int getArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int x=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from qna");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x= rs.getInt(1); 
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return x; 
	}
	
    //qnaContentAction.java : DB로부터 한줄의 데이터를 가져온다.
    public QnaDTO getArticle(int num) throws Exception {
        QnaDTO article=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "update qna set readCount=readCount+1 where num = ?");
            pstmt.setInt(1, num);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(
            "select * from qna where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new QnaDTO();
                article.setNum(rs.getInt("num"));
                article.setCenter(rs.getString("center"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setWriter(rs.getString("writer"));
                article.setPw(rs.getString("pw"));
                article.setRegDate(rs.getTimestamp("regDate"));
                article.setReadCount(rs.getInt("readCount"));
                article.setRef(rs.getInt("ref"));
                article.setReStep(rs.getInt("reStep"));
                article.setReLevel(rs.getInt("reLevel"));
	    }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return article;
    }
    
	public boolean deleteId(String num, String pw) {
		boolean result = false;
		String dbpw="";
		try{
			conn = getConnection();
			String sql="select pw from qna where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();			
			
			if(rs.next()) {
				dbpw = rs.getString("pw");
				if(dbpw.equals(pw)) {
					String delsql="delete from qna where num=?";
					pstmt = conn.prepareStatement(delsql);
					pstmt.setString(1, num);
					pstmt.executeUpdate();		
					result = true;
				}else{
					result=false;
				}
			}			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{rs.close();}catch(SQLException s){}
			try{pstmt.close();}catch(SQLException s){}
			try{conn.close();}catch(SQLException s){}
		}		
		return result;
	}

    //QnaupdateFormAction.java : 수정폼에 한줄의 데이터를 가져올때.
    public QnaDTO updateGetArticle(int num) throws Exception {
        
    	QnaDTO article=null;
        
    	try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from qna where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new QnaDTO();
                article.setNum(rs.getInt("num"));
                article.setCenter(rs.getString("center"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setWriter(rs.getString("writer"));
                article.setPw(rs.getString("pw"));
                article.setRegDate(rs.getTimestamp("regDate"));
                article.setReadCount(rs.getInt("readCount"));
                article.setRef(rs.getInt("ref"));
                article.setReStep(rs.getInt("reStep"));
                article.setReLevel(rs.getInt("reLevel"));
	    }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	return article;
    }
	
    //QnaUpdateProAction.jsp : 실제 데이터를 수정하는 메소드.
    public int updateArticle(QnaDTO article) throws Exception {
        String dbpasswd="";
        String sql="";
        int x=-1;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select pw from qna where num = ?");
            pstmt.setInt(1, article.getNum());
            rs = pstmt.executeQuery();
           
	if(rs.next()){
	    dbpasswd= rs.getString("pw");
	    if(dbpasswd.equals(article.getPw())){
		sql="update qna set writer=?,center=?,title=?,content=? where num=?";
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, article.getWriter());
                pstmt.setString(2, article.getCenter());
                pstmt.setString(3, article.getTitle());
                pstmt.setString(4, article.getContent());
                pstmt.setInt(5, article.getNum());
                pstmt.executeUpdate();
                x= 1;
	    }else{
	    		x= 0;
	    }
	  }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
	    if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
	 return x;
    }
}













