package center.boardNotice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class NoticeDAO {

private static NoticeDAO instance = new NoticeDAO();
	
	public static NoticeDAO getInstance(){
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
					"select num, center, title, content,regDate, readCount, r  " +
				            "from (select num,center,title,content,regDate,readCount, rownum r " +
				            "from (select * " +
				            "from notice order by num) order by num ) where r >= ? and r <= ? ");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articleList = new ArrayList(end);
				do{
					NoticeDTO article = new NoticeDTO();
					article.setNum(rs.getInt("num"));
					article.setCenter(rs.getString("center"));
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
	public void insertArticle(NoticeDTO article) throws Exception{
		
		//�亯������ �Ϲݱ������� �����ؼ� �Է½����ִ� ����

		//ref 	  : �Խñ��� �׷�. �Խñ۰� ����� ��ȣ
		//reStep  : ����� ������ ���� ��ȣ 
		//reLevel : ����� �׷�
		
		int num=article.getNum();
		int number=0;
		String sql="";
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement("select max(num) from notice");
			rs = pstmt.executeQuery();
			if (rs.next()) 
				number=rs.getInt(1)+1;	
			else
				number=1; 

			sql = "insert into notice(num,center,title,content,regDate) values(seq_notice.NEXTVAL,?,?,?,sysdate)";
				pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, article.getCenter());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getContent());
			
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
			pstmt = conn.prepareStatement("select count(*) from notice");
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
	
    //qnaContentAction.java : DB�κ��� ������ �����͸� �����´�.
    public NoticeDTO getArticle(int num) throws Exception {
    	NoticeDTO article=null;
        try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "update notice set readCount = readCount+1 where num = ?");
            pstmt.setInt(1, num);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement(
            "select * from notice where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new NoticeDTO();
                article.setNum(rs.getInt("num"));
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
					String delsql="delete from notice where num=?";
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

    //QnaupdateFormAction.java : �������� ������ �����͸� �����ö�.
    public NoticeDTO updateGetArticle(int num) throws Exception {
        
    	NoticeDTO article=null;
        
    	try {
            conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from notice where num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                article = new NoticeDTO();
                article.setNum(rs.getInt("num"));
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
	
    //QnaUpdateProAction.jsp : ���� �����͸� �����ϴ� �޼ҵ�.
    public int updateArticle(NoticeDTO article) throws Exception {
        String sql="";
        int x=-1;
        try {
            conn = getConnection();
           
            if(article!=null){
            	sql="update notice set center=?,title=?,content=? where num=?";
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
	
    //�˻����
    public int getArticleCount(int n, String searchKeyword) throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		
		String[] column_name = {"title","content","center"};
		
		int x = 0;
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count (*) from notice where "+column_name[n]+" like '%"+searchKeyword+"%'");
			
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
   		
   		String[] column_name = {"title","content","center"};
   		
   		try
   		{
   			conn = getConnection();
   			
   			String sql = "select num,center,title,content,regDate,readCount,r "	
   						+ "from (select num,center,title,content,regDate,readCount,rownum r "
   						+"from (select num,center,title,content,regDate,readCount "
   						+"from notice order by num) where "+column_name[n]+" like '%"+searchKeyword+"%' order by num) where r >= ? and r <= ?";
   			
   			pstmt = conn.prepareStatement(sql);
   			pstmt.setInt(1, start);
   			pstmt.setInt(2,	end);
   			
   			rs = pstmt.executeQuery();
   			
   			if(rs.next())
   			{
   				articleList = new ArrayList(end);
   				
   				do{
   					NoticeDTO article = new NoticeDTO();
   					
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
    
}
