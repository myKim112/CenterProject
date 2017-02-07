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
	
	public void insertCal(CalendarDTO cal) throws Exception { // 일정 등록
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into calendar values(calendar_seq.NEXTVAL, ?, TO_DATE(?, 'yyyy-MM-dd'), ?, ?)");
			pstmt.setString(1, cal.getCalPw());
			pstmt.setString(2, cal.getMemoYear()+"-"+cal.getMemoMonth()+"-"+cal.getMemoDate());
			pstmt.setString(3, cal.getCalTitle());
			pstmt.setString(4, cal.getCalContent());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
			if(conn != null)try{conn.close();}catch(SQLException ex){}
		}
	}
	
	public CalendarDTO getCal(int calNum) throws Exception { // 저장된 일정 가져오기
		CalendarDTO cal = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select calNum, calPw, TO_CHAR(calDate, 'yyyy-MM-dd'), calTitle, calContent from calendar where calNum = ?");
			pstmt.setInt(1, calNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cal = new CalendarDTO();
				
				cal.setCalNum(rs.getInt("calNum"));
				cal.setCalPw(rs.getString("calPw"));
				cal.setCalDate(rs.getString("calDate"));
				cal.setCalTitle(rs.getString("calTitle"));
				cal.setCalContent(rs.getString("calContent"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return cal;
	}
}