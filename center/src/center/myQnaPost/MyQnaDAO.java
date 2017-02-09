package center.myQnaPost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MyQnaDAO {

private static MyQnaDAO instance = new MyQnaDAO();
	
	public static MyQnaDAO getInstance(){
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
					"select num, center,writer, title, content,regDate, readCount, r  " +
				            "from (select num,center,writer,title,content,regDate,readCount, rownum r " +
				            "from (select * " +
				            "from qna order by num) order by num ) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articleList = new ArrayList(end);
				do{
					MyQnaDTO article = new MyQnaDTO();
					article.setNum(rs.getInt("num"));
					article.setCenter(rs.getString("center"));
					article.setWriter(rs.getString("Writer"));
					article.setTitle(rs.getString("title"));
					article.setContent(rs.getString("content"));
					article.setRegDate(rs.getTimestamp("regDate"));
					article.setReadCount(rs.getInt("readCount"));
					
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
	public void insertArticle(MyQnaDTO article) throws Exception{
		
		//답변글인지 일반글인지를 구분해서 입력시켜주는 로직

		//ref 	  : 게시글의 그룹. 게시글과 답글의 번호
		//reStep  : 답글을 나누기 위한 번호 
		//reLevel : 답글의 그룹
		
		int num=article.getNum();
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

			sql = "insert into qna(num,center,title,content,writer,regDate) values(seq_notice.NEXTVAL,?,?,?,?,sysdate)";
				pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, article.getCenter());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContent());
			pstmt.setString(4, article.getWriter());
			
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
    public MyQnaDTO getArticle(int num) throws Exception {
    	MyQnaDTO article=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "update qna set readCount = readCount+1 where num = ?");
            pstmt.setInt(1, num);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(
            "select * from qna where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new MyQnaDTO();
                article.setNum(rs.getInt("num"));
                article.setWriter(rs.getString("Writer"));
                article.setCenter(rs.getString("center"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setRegDate(rs.getTimestamp("regDate"));
                article.setReadCount(rs.getInt("readCount"));
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
    
	public boolean deleteId(String num) {
		boolean result = false;
		try{
			conn = getConnection();
			if(num!=null) {
					String delsql="delete from qna where num=?";
					pstmt = conn.prepareStatement(delsql);
					pstmt.setString(1, num);
					pstmt.executeUpdate();		
					result = true;
				}else{
					result=false;
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
    public MyQnaDTO updateGetArticle(int num) throws Exception {
        
    	MyQnaDTO article=null;
        
    	try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from qna where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new MyQnaDTO();
                article.setNum(rs.getInt("num"));
                article.setWriter(rs.getString("Writer"));
                article.setCenter(rs.getString("center"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setRegDate(rs.getTimestamp("regDate"));
                article.setReadCount(rs.getInt("readCount"));
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
    public int updateArticle(MyQnaDTO article) throws Exception {
        String sql="";
        int x=-1;
        try {
            conn = getConnection();
           
            if(article!=null){
            	sql="update qna set center=?,title=?,content=? where num=?";
                pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, article.getCenter());
                pstmt.setString(2, article.getTitle());
                pstmt.setString(3, article.getContent());
                pstmt.setInt(4, article.getNum());
                pstmt.executeUpdate();
                x= 1;
            }else{
	    		x= 0;
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
	
    //검색기능
    public int getArticleCount(int n, String searchKeyword) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String[] column_name = {"title","content","center"};
		
		int x = 0;
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count (*) from qna where "+column_name[n]+" like '%"+searchKeyword+"%'");
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
				x = rs.getInt(1);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return x;
	}    
    
    public List getArticles(int start, int end, int n, String searchKeyword) throws Exception
   	{
   		Connection conn = null;
   		PreparedStatement pstmt = null;
   		ResultSet rs = null;
   		List articleList = null;
   		
   		String[] column_name = {"title","content","center","writer"};
   		
   		try
   		{
   			conn = getConnection();
   			
   			String sql = "select num,center,writer,title,content,regDate,readCount,r "	
						+ "from (select num,center,writer,title,content,regDate,readCount,rownum r "
						+"from (select num,center,writer,title,content,regDate,readCount "
						+"from qna order by num) where "+column_name[n]+" like '%"+searchKeyword+"%' order by num) where r >= ? and r <= ?";
   			
   			pstmt = conn.prepareStatement(sql);
   			pstmt.setInt(1, start);
   			pstmt.setInt(2,	end);
   			
   			rs = pstmt.executeQuery();
   			
   			if(rs.next())
   			{
   				articleList = new ArrayList(end);
   				
   				do{
   					MyQnaDTO article = new MyQnaDTO();
   					
   					article.setNum(rs.getInt("num"));
   					article.setCenter(rs.getString("center"));
   					article.setTitle(rs.getString("title"));
   					article.setContent(rs.getString("content"));
   					article.setRegDate(rs.getTimestamp("regDate"));
   					article.setReadCount(rs.getInt("readCount"));
   					
   					articleList.add(article);
   				}while(rs.next());
   				
   			}
   			
   		}
   		catch(Exception ex)
   		{
   			ex.printStackTrace();
   		}
   		finally
   		{
   			if(rs != null) try {rs.close();} catch(SQLException ex){}
   			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
   			if(conn != null) try {conn.close();} catch(SQLException ex){}
   		}
   		
   		return articleList;
   	}
    

    
    public String match (String name,String id) {
    	String sql = null;
    	String match =null;
    	


    	try {
    		conn = getConnection();
    		sql = "select id from join where id=? and name=?"; 
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    		pstmt.setString(2, name);
    		rs = pstmt.executeQuery(); // 실행
    		if(rs.next()){
    			match = rs.getString("id");
    			match = rs.getString("name");
    			
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	return match; 
    }
    }