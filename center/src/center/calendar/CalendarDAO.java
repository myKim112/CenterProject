package center.calendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public CalendarDTO getCal(int calNum) throws Exception { // 저장된 일정 가져오기 - 날짜를 String 형식으로 변환
		CalendarDTO cal = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from calendar where calNum = ?");
			pstmt.setInt(1, calNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// DB의 일정 정보 -> 년, 월, 일 문자열로 자른다.
				String work = rs.getDate("calDate").toString();
				String memoYear = work.substring(0, 4);
				String memoMonth = work.substring(5, 7);
				String memoDate = work.substring(8, 10);
				
				// DTO에 정보를 담는다.
				cal = new CalendarDTO();
				
				cal.setCalNum(rs.getInt("calNum"));
				cal.setCalPw(rs.getString("calPw"));
				cal.setMemoYear(memoYear);
				cal.setMemoMonth(memoMonth);
				cal.setMemoDate(memoDate);
				cal.setCalDate(rs.getTimestamp("calDate"));
				cal.setMemoDate(rs.getString("calDate"));
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
	
	public int updateCal(CalendarDTO cal) throws Exception { // 일정 수정하기
		String dbpw = "";
		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select calPw from calendar where calNum = ?");
			pstmt.setInt(1, cal.getCalNum());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpw = rs.getString("calPw");
				if(dbpw.equals(cal.getCalPw())) {
					pstmt = conn.prepareStatement("update calendar set calPw=?, calDate=TO_DATE(?, 'yyyy-MM-dd'), calTitle=?, calContent=? where calNum=?");
					pstmt.setString(1, cal.getCalPw());
					pstmt.setString(2, cal.getMemoYear()+"-"+cal.getMemoMonth()+"-"+cal.getMemoDate());
					pstmt.setString(3, cal.getCalTitle());
					pstmt.setString(4, cal.getCalContent());
					pstmt.setInt(5, cal.getCalNum());
					pstmt.executeUpdate();
					x = 1;
				} else {
					x = 0;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return x;
	}
	
	public ArrayList<CalendarDTO> getSchedule() throws Exception { // 저장된 일정 불러오기
		ArrayList<CalendarDTO> calList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from calendar");
			rs = pstmt.executeQuery();
			calList = new ArrayList<CalendarDTO>();
			
			while(rs.next()) {
				// DB의 일정 정보 -> 년, 월, 일 문자열로 자른다.
				String work = rs.getDate("calDate").toString();
				String memoYear = work.substring(0, 4);
				String memoMonth = work.substring(5, 7);
				String memoDate = work.substring(8, 10);
				
				CalendarDTO cal = new CalendarDTO();
				
				cal.setCalNum(rs.getInt("calNum"));
				cal.setCalPw(rs.getString("calPw"));
				cal.setMemoYear(memoYear);
				cal.setMemoMonth(memoMonth);
				cal.setMemoDate(memoDate);
				cal.setCalDate(rs.getTimestamp("calDate"));
				cal.setCalTitle(rs.getString("calTitle"));
				cal.setCalContent(rs.getString("calContent"));
				
				calList.add(cal);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return calList;
	}
	
	public int deleteCal(int calNum, String calPw) { //일정 삭제
		int result = -1;
		String dbpw = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select calPw from calendar where calNum = ?");
			pstmt.setInt(1, calNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpw = rs.getString("calPw");
				if(dbpw.equals(calPw)) {
					pstmt = conn.prepareStatement("delete from calendar where calNum = ?");
					pstmt.setInt(1, calNum);
					pstmt.executeUpdate();
					result = 1;
				} else {
					result = 0;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		}
		return result;
	}
}