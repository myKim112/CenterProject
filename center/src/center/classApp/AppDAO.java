package center.classApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.lesson.ClassDTO;

public class AppDAO {
	
	private static AppDAO instance = new AppDAO();

	public static AppDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private Connection getConnection() throws Exception {
		Context ctx = new InitialContext();
		Context env = (Context) ctx.lookup("java:comp/env");
		DataSource ds = (DataSource) env.lookup("jdbc/orcl");

		return ds.getConnection();
	}

	public AppDTO getApp(int num) throws Exception { 
		AppDTO dto = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from app where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new AppDTO();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setClassCode(rs.getString("classCode"));
				dto.setSum(rs.getInt("sum"));
				dto.setStatus(rs.getInt("status"));
				dto.setMemberCount(rs.getInt("memberCount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return dto;
	}


	public void insertAppActicle(AppDTO dto) throws Exception { 
	
		String sql = "";
		try {
			conn = getConnection();
			sql = "insert into app values(app_seq.NEXTVAL,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2, dto.getClassCode());
			pstmt.setInt(3,dto.getSum());
			pstmt.setInt(4,dto.getStatus());
			pstmt.setInt(5,dto.getMemberCount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
	}

	public int getArticleCount(int num) throws Exception {
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class s ,app a where s.classCode = a.classCode");  //�ڵ尡 �������� �����޶�
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return x;
	}

	public List<ClassDTO> getAppArticles(String id) throws Exception {

		List<ClassDTO> articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select a.num anum,c.num cnum,c.classCode,c.center,c.className,"
					+ "c.teacher,c.classDate,c.classTime,c.classPay,c.person,c.state from class c , app a where c.classCode = a.classCode and  a.id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();			
			if (rs.next()) {
				articleList = new ArrayList<ClassDTO>();
				do {
					ClassDTO dto = new ClassDTO();
					dto.setAnum(rs.getInt("anum"));
					dto.setCnum(rs.getInt("cnum"));
					dto.setClassCode(rs.getString("classCode"));
					dto.setCenter(rs.getString("center"));
					dto.setClassName(rs.getString("className"));
					dto.setTeacher(rs.getString("teacher"));
					dto.setClassDate(rs.getString("classDate"));
					dto.setClassTime(rs.getString("classTime"));
					dto.setClassPay(rs.getString("classPay"));
					dto.setPerson(rs.getInt("person"));
					dto.setState(rs.getString("state"));
					articleList.add(dto);
				} while (rs.next());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return articleList;
	}
	
	public int deleteCart(int num) throws Exception {

		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from app where num =?");
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return x;

	}
	public int getCartsum(String id) throws Exception{
	      int sum=0;
	       try{
	          conn=getConnection();
	          pstmt=conn.prepareStatement("select sum(classPay * num ) from app where id=? ");
	          pstmt.setString(1, id);
	          rs=pstmt.executeQuery();
	       if(rs.next()){
	   
	       sum = rs.getInt(1);
	   }
	   }catch(Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	        if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	        if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	    }
	   return sum;
	}
	   
	   
}
