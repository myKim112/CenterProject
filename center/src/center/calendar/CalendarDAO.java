package center.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.staff.StaffDTO;

public class CalendarDAO {
private static CalendarDAO instance = new CalendarDAO();
	
	public static CalendarDAO getInstance(){
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
	
	public void insertTeacher(CalendarDTO cal) throws Exception { // 직원 등록
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into calendar values(?,?,?,?,?,?,?,?,?,20,sysdate)");
			pstmt.setString(1, cal.getCalPw());
			pstmt.setTimestamp(2, cal.get);
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
			if(conn != null)try{conn.close();}catch(SQLException ex){}
		}
	}
}