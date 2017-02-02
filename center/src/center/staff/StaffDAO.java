package center.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.power.PowerDTO;

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
				teacher.setName(rs.getString("name"));
				teacher.setBirth(rs.getInt("birth"));	
				teacher.setPhone(rs.getInt("phone"));
				teacher.setAddress(rs.getString("address"));  					
				teacher.setEmail(rs.getString("email"));
				teacher.setBankName(rs.getString("bankName"));
				teacher.setBankAccount(rs.getString("bankAccount"));
				teacher.setLev(rs.getInt("lev"));
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
	
	public void updateTeacher(StaffDTO staff) throws Exception { // 정보 수정
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update staff set pw=?, name=?, birth=?, phone=?, address=?, email=?, bankName=?, bankAccount=? where id=?");
			pstmt.setString(1, staff.getPw());
			pstmt.setString(2, staff.getName());
			pstmt.setInt(3, staff.getBirth());
			pstmt.setInt(4, staff.getPhone());
			pstmt.setString(5, staff.getAddress());
			pstmt.setString(6, staff.getEmail());
			pstmt.setString(7, staff.getBankName());
			pstmt.setString(8, staff.getBankAccount());
			pstmt.setString(9, staff.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException e) { } }
			if(conn != null) { try { conn.close(); } catch(SQLException e) { } }
		}
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
					"(select * from staff order by regDate desc) order by regDate desc) where r>=? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
				staffList = new ArrayList(end);
					
				do {
					StaffDTO article = new StaffDTO();
					
					article.setId(rs.getString("id"));
					article.setPw(rs.getString("pw"));
					article.setName(rs.getString("name"));
					article.setBirth(rs.getInt("birth"));
					article.setPhone(rs.getInt("phone"));
					article.setAddress(rs.getString("address"));
					article.setEmail(rs.getString("email"));
					article.setBankName(rs.getString("bankName"));
					article.setBankAccount(rs.getString("bankAccount"));
					article.setLev(rs.getInt("lev"));
					article.setRegDate(rs.getTimestamp("regDate"));
					staffList.add(article);
				} while(rs.next());
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
			pstmt = conn.prepareStatement("select count(*) from class where teacher=?");
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
	
	public void updateTeacherLev(StaffDTO staff) throws Exception { // 권한 수정하기
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update staff set lev=? where id=?");
			pstmt.setInt(1, staff.getLev());
			pstmt.setString(2, staff.getId());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
		 	if(conn != null)try{conn.close();}catch(SQLException ex){}
		}
	}
	
	public PowerDTO getTeacherLev(String id) throws Exception { // 해당하는 아이디의 권한 보기
		PowerDTO power = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select s.lev, p.position, s.id from power p, staff s where s.id=? and p.lev = s.lev");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				power = new PowerDTO();
				
				power.setLev(rs.getInt("lev"));
				power.setPosition(rs.getString("position"));
				
				pstmt.executeQuery();
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
		return power;
	}
	
	public void insertTeacher(StaffDTO staff) throws Exception { // 직원 등록
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?,?,20,sysdate)");
			pstmt.setString(1, staff.getId());
			pstmt.setString(2, staff.getPw());
			pstmt.setString(3, staff.getName());
			pstmt.setInt(4, staff.getBirth());
			pstmt.setInt(5, staff.getPhone());
			pstmt.setString(6, staff.getAddress());
			pstmt.setString(7, staff.getEmail());
			pstmt.setString(8, staff.getBankName());
			pstmt.setString(9, staff.getBankAccount());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
			if(conn != null)try{conn.close();}catch(SQLException ex){}
		}
	}
}
