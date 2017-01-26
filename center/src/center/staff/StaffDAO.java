package center.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.lesson.ClassDTO;

public class StaffDAO {
	private static StaffDAO instance = new StaffDAO();
	
	public static StaffDAO getInstance(){
		return instance;
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection()throws Exception{
		Context ctx= new InitialContext();
		Context env = (Context)ctx.lookup("java:comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/orcl");
		
		return ds.getConnection();
	}
	
	public StaffDTO getTeacher(String id) throws Exception { // 입력받은 id에 해당하는 내용 가져오기
		StaffDTO teacher = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from staff where id =?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
		
			if(rs.next()){
				teacher=new StaffDTO();
					
				teacher.setId(rs.getString("id"));
				teacher.setPw(rs.getString("pw"));
				teacher.setBirth(rs.getInt("birth"));	
				teacher.setPhone(rs.getInt("phone"));
				teacher.setAddress(rs.getString("address"));  					
				teacher.setEmail(rs.getString("email"));
				teacher.setBankName(rs.getString("bankName"));
				teacher.setBankAccount(rs.getInt("bankAccount"));
				teacher.setLev(rs.getString("lev"));
				teacher.setRegDate(rs.getTimestamp("regDate"));
  				
  				pstmt.executeQuery();
  			}
  		} catch(Exception e){
  			e.printStackTrace();
  		} finally{
  			if(rs != null)try{rs.close();}catch(SQLException ex){}
  			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
  			if(conn != null)try{conn.close();}catch(SQLException ex){}
  		}
  		return teacher;
	}
	
	// 관리자
	public int getTeacherCount() throws Exception { // 전체 강사 수
		int x = 0;
			
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from staff");
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				x = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
			return x;
	}
		
	public ArrayList<StaffDTO> getTeacherArticle(int start, int end) throws Exception { // 전체 강사 목록 불러오기
		ArrayList<StaffDTO> staffList = null;
	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select id, pw, name, birth, phone, address, email, bankName, bankAccount, lev, regDate , r from"+
					"(select id, pw, name, birth, phone, address, email, bankName, bankAccount, lev, regDate, rownum r from"+ 
					"(select * from staff order by regDate asc) order by regDate asc) where r>=? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				staffList = new ArrayList(end);
					
				while(rs.next()) {
					StaffDTO article = new StaffDTO();
					
					article.setId(rs.getString("id"));
					article.setPw(rs.getString("pw"));
					article.setName(rs.getString("name"));
					article.setBirth(rs.getInt("birth"));
					article.setPhone(rs.getInt("phone"));
					article.setAddress(rs.getString("address"));
					article.setEmail(rs.getString("email"));
					article.setBankName(rs.getString("bankName"));
					article.setBankAccount(rs.getInt("bankAccount"));
					article.setLev(rs.getString("lev"));
					article.setRegDate(rs.getTimestamp("regDate"));
					staffList.add(article);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
		return staffList;
	}
	
	public int getTeacherClassCount(String id) throws Exception { // 해당 강사의 강좌 수
		int x = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
		return x;
	}
}
