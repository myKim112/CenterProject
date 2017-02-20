package center.boardReview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.boardNotice.NoticeDTO;

public class ReviewDAO {

private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance(){
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
	
	//ReviewListAction.java
	public int getArticleCount() throws Exception {
		int x=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from review");
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
	

	public List getArticles(int start, int end) throws Exception {
		List articleList=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select num,center, writer,pw, title, content, regDate, readCount, orgName, sysName, ref, reStep, reLevel, r "
					+
					"from (select num,center, writer,pw, title, content, regDate, readCount, orgName, sysName, ref, reStep, reLevel, rownum r " +
					"from (select num,center, writer,pw, title, content, regDate, readCount, orgName, sysName, ref, reStep, reLevel " +
					"from review order by ref desc, reStep asc) order by ref desc, reStep asc ) where r >= ? and r <= ? ");
					pstmt.setInt(1, start); 
					pstmt.setInt(2, end); 

					rs = pstmt.executeQuery();
					if (rs.next()) {
						articleList = new ArrayList(end); 
						do{ 
							ReviewDTO article= new ReviewDTO();
							article.setNum(rs.getInt("num"));
							article.setCenter(rs.getString("center"));
							article.setWriter(rs.getString("writer"));
							article.setPw(rs.getString("pw"));
							article.setTitle(rs.getString("title"));
							article.setContent(rs.getString("content"));
							article.setRegDate(rs.getTimestamp("regDate"));
							article.setReadCount(rs.getInt("readCount"));
							article.setOrgName(rs.getString("orgName"));
							article.setSysName(rs.getString("sysName"));
							article.setRef(rs.getInt("ref"));
							article.setReStep(rs.getInt("reStep"));
							article.setReLevel(rs.getInt("reLevel"));
							
							articleList.add(article); 
						}while(rs.next());
					}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return articleList;
	}	
	
	public void insertArticle(ReviewDTO article) throws Exception {
		
		int num=article.getNum();
		int ref=article.getRef();
		int reStep=article.getReStep();
		int reLevel=article.getReLevel();
		int number=0;
		
		String sql="";
		
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement("select max(num) from review");
			rs = pstmt.executeQuery();
			if (rs.next()) 
				number=rs.getInt(1)+1;	
			else
				number=1; 
			if (num!=0) 
			{ 
				sql="update review set reStep=reStep+1 where ref= ? and reStep> ?";
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
 
			sql = "insert into review(num,center,writer,pw,title,content,regDate,orgName, sysName, ref,reStep,reLevel)"
					+ "values(seq_review.NEXTVAL,?,?,?,?,?,sysdate,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getCenter());
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getPw());
			pstmt.setString(4, article.getTitle());
			pstmt.setString(5, article.getContent());
			pstmt.setString(6, article.getOrgName());
			pstmt.setString(7, article.getSysName());
			pstmt.setInt(8, ref);
			pstmt.setInt(9, reStep);
			pstmt.setInt(10, reLevel);
			
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	
	public ReviewDTO getArticle(int num) throws Exception {
		ReviewDTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"update review set readCount=readCount+1 where num = ?"); 
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(
			"select * from review where num = ?"); 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new ReviewDTO();
				article.setNum(rs.getInt("num"));
				article.setCenter(rs.getString("center"));
				article.setWriter(rs.getString("writer"));
				article.setWriter(rs.getString("pw"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setRegDate(rs.getTimestamp("regDate"));
				article.setReadCount(rs.getInt("readCount"));
				article.setOrgName(rs.getString("orgName"));
				article.setSysName(rs.getString("sysName"));
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
	
	public ReviewDTO updateGetArticle(int num) throws Exception {
		ReviewDTO article=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"select * from review where num = ?"); 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				article = new ReviewDTO();
				article.setNum(rs.getInt("num"));
				article.setCenter(rs.getString("center"));
				article.setWriter(rs.getString("writer"));
				article.setPw(rs.getString("pw"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				article.setRegDate(rs.getTimestamp("regDate"));
				article.setReadCount(rs.getInt("readCount"));
				article.setOrgName(rs.getString("orgName"));
				article.setSysName(rs.getString("sysName"));
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
	
	public int updateArticle(ReviewDTO article) throws Exception {
		String dbpasswd="";
		String sql="";
		int x=-1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"select pw from review where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				dbpasswd= rs.getString("pw"); 
				if(dbpasswd.equals(article.getPw())){
					sql="update review set writer=?,center=?,title=?,pw=?";
					sql+=",content=? ,orgName=?, sysName=? where num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getCenter());
					pstmt.setString(3, article.getTitle());
					pstmt.setString(4, article.getPw());
					pstmt.setString(5, article.getContent());
					pstmt.setString(6, article.getOrgName());
					pstmt.setString(7, article.getSysName());
					pstmt.setInt(8, article.getNum());
					
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
	
	public int updateArticlePlus(ReviewDTO article) throws Exception {
		String dbpasswd="";
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"select pw from review where num = ?");
			pstmt.setInt(1, article.getNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				dbpasswd= rs.getString("pw"); 
				if(dbpasswd.equals(article.getPw())){
					sql = "update review set writer=?, content=?, center=?, title=?,pw=? where num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getWriter());
					pstmt.setString(2, article.getContent());
					pstmt.setString(3, article.getCenter());
					pstmt.setString(4, article.getTitle());
					pstmt.setString(5, article.getPw());
					pstmt.setInt(6, article.getNum());
			
					pstmt.executeUpdate();
					x = 1;
				}else{
					x = 0;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) {} }
			if(conn != null) { try { conn.close(); } catch(SQLException e) {} }
		}
		return x;
	}	

	public int deleteArticle(int num, String pw) throws Exception {
		String dbpasswd="";
		int x=-1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
			"select pw from review where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()){
				dbpasswd= rs.getString("pw");
				if(dbpasswd.equals(pw)){
					pstmt = conn.prepareStatement(
					"delete from review where num=?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x= 1; 
				}else
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
		
		String[] column_name = {"title","content","center", "writer"};
		
		int x = 0;
		
		try
		{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count (*) from review where "+column_name[n]+" like '%"+searchKeyword+"%'");
			
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
   		List articleList = null;
   		
   		String[] column_name = {"title","content","center", "writer"};
   		
   		try
   		{
   			conn = getConnection();
   			
   			String sql = "select num,center,writer,pw,title,content,regDate,readCount,ref,reStep,reLevel,r "	
   						+ "from (select num,center,writer,pw,title,content,regDate,readCount,ref,reStep,reLevel,rownum r "
   						+"from (select num,center,writer,pw,title,content,regDate,readCount,ref,reStep,reLevel "
   						+"from review order by ref desc, reStep asc) where "+column_name[n]+" like '%"+searchKeyword+"%' order by ref desc, reStep asc) where r >= ? and r <= ?";
   			
   			pstmt = conn.prepareStatement(sql);
   			pstmt.setInt(1, start);
   			pstmt.setInt(2,	end);
   			
   			rs = pstmt.executeQuery();
   			
   			if(rs.next())
   			{
   				articleList = new ArrayList(end);
   				
   				do{
   					ReviewDTO article = new ReviewDTO();
   					
   					article.setNum(rs.getInt("num"));
   					article.setCenter(rs.getString("center"));
   					article.setWriter(rs.getString("writer"));
   					article.setPw(rs.getString("pw"));
   					article.setTitle(rs.getString("title"));
   					article.setContent(rs.getString("content"));
   					article.setRegDate(rs.getTimestamp("regDate"));
   					article.setReadCount(rs.getInt("readCount"));
   					article.setRef(rs.getInt("ref"));
   					article.setReStep(rs.getInt("reStep"));
   					article.setReLevel(rs.getInt("reLevel"));
   					
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
