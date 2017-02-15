package center.boardCommunity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.boardReview.ReviewDTO;

public class PhotoDAO {
	
	private static PhotoDAO instance = new PhotoDAO();
	
	public static PhotoDAO getInstance(){
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
	
	public void insertArticle(PhotoDTO article) throws Exception {
		
		int num=article.getNum();
		int number=0;
		
		String sql="";
		
		try {
			conn = getConnection(); 
			pstmt = conn.prepareStatement("select max(num) from community");
			rs = pstmt.executeQuery();
			if (rs.next()) 
				number=rs.getInt(1)+1;	
			else
				number=1; 
 
			sql = "insert into community(num,title,content,orgName, sysName)"
					+ "values(seq_community.NEXTVAL,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getOrgName());
			pstmt.setString(4, article.getSysName());
			
			pstmt.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
			if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
	}
	
	public List getArticles(int start, int end) throws Exception {
		List articleList=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select num,title,content,orgName,sysName,r "+
					"from (select num,title,content,orgName,sysName, rownum r " +
					"from (select num,title,content,orgName,sysName" +
					"from community order by num asc ) order by num asc ) where r >= ? and r <= ? ");
					pstmt.setInt(1, start); 
					pstmt.setInt(2, end); 

					rs = pstmt.executeQuery();
					if (rs.next()) {
						articleList = new ArrayList(end); 
						do{ 
							ReviewDTO article= new ReviewDTO();
							article.setNum(rs.getInt("num"));
							article.setTitle(rs.getString("title"));
							article.setContent(rs.getString("content"));
							article.setOrgName(rs.getString("orgName"));
							article.setSysName(rs.getString("sysName"));
							
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

}
