package center.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
	
	// ������
	public int getTeacherCount() throws Exception { // ��ü ���� ��
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
		
	public ArrayList<StaffDTO> getTeacherArticle(int start, int end) throws Exception { // ��ü ���� ��� �ҷ�����
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
}
