package center.lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import center.power.PowerDTO;

public class ClassDAO {
	private static ClassDAO instance = new ClassDAO();

	public static ClassDAO getInstance() {
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

	public ClassDTO getClass(int num) throws Exception { 
		ClassDTO dto = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from class where num=?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new ClassDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCenter(rs.getString("center"));
				dto.setClassCode(rs.getString("classCode"));
				dto.setClassName(rs.getString("className"));
				dto.setTeacher(rs.getString("teacher"));
				dto.setClassDate(rs.getString("classDate"));
				dto.setClassTime(rs.getString("classTime"));
				dto.setClassPay(rs.getString("classPay"));
				dto.setPerson(rs.getInt("person"));
				dto.setLev(rs.getString("lev"));
				dto.setState(rs.getString("state"));
				dto.setClassSummary(rs.getString("classSummary"));
				dto.setClassPlan(rs.getString("classPlan"));
				dto.setReference(rs.getString("reference"));
				dto.setPw(rs.getString("pw"));
				dto.setOrgName(rs.getString("orgName"));
				dto.setSysName(rs.getString("sysName"));
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


	public ClassDTO getClassCode(String classCode) throws Exception { 
		ClassDTO dto = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from class where classCode=?");
			pstmt.setString(1, classCode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ClassDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCenter(rs.getString("center"));
				dto.setClassCode(rs.getString("classCode"));
				dto.setClassName(rs.getString("className"));
				dto.setTeacher(rs.getString("teacher"));
				dto.setClassDate(rs.getString("classDate"));
				dto.setClassTime(rs.getString("classTime"));
				dto.setClassPay(rs.getString("classPay"));
				dto.setPerson(rs.getInt("person"));
				dto.setLev(rs.getString("lev"));
				dto.setState(rs.getString("state"));
				dto.setClassSummary(rs.getString("classSummary"));
				dto.setClassPlan(rs.getString("classPlan"));
				dto.setReference(rs.getString("reference"));
				dto.setPw(rs.getString("pw"));
				dto.setOrgName(rs.getString("orgName"));
				dto.setSysName(rs.getString("sysName"));
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
	
	
	public void insertClass(ClassDTO dto) throws Exception { 
		
		int num = dto.getNum();
		String sql = "";
		try {
			conn = getConnection();
			sql = "insert into class values(class_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCenter());
			pstmt.setString(2, dto.getClassCode());
			pstmt.setString(3, dto.getClassName());
			pstmt.setString(4, dto.getTeacher());
			pstmt.setString(5, dto.getClassDate());
			pstmt.setString(6, dto.getClassTime());
			pstmt.setString(7, dto.getClassPay());
			pstmt.setInt(8, dto.getPerson());
			pstmt.setString(9, dto.getLev());
			pstmt.setString(10, dto.getState());
			pstmt.setString(11, dto.getClassSummary());
			pstmt.setString(12, dto.getClassPlan());
			pstmt.setString(13, dto.getReference());
			pstmt.setString(14, dto.getPw());
			pstmt.setString(15, dto.getOrgName());
			pstmt.setString(16, dto.getSysName());
			pstmt.setString(17, dto.getTeacherId());
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

	public int getArticleCount() throws Exception {
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class");
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
	
	public int getArticleCont(int n, String searchKeyword) throws Exception { // 검색시 강좌 수 
		String[] column_name = {"teacher", "className", "center"};
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class where "+column_name[n]+" like '%"+searchKeyword+"%'");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException ex){}
			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return x;
	}

	public List<ClassDTO> getArticles(int start, int end) throws Exception {

		List<ClassDTO> articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,state,classSummary,classPlan,reference,pw,orgName,sysName, r "
							+ "from (select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,state,classSummary,classPlan,reference,pw,orgName,sysName, rownum r "
							+ "from (select * from class order by num desc)) where r >= ? and r <= ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList<ClassDTO>(end);
				do {
					ClassDTO dto = new ClassDTO();
					dto.setNum(rs.getInt("num"));
					dto.setCenter(rs.getString("center"));
					dto.setClassCode(rs.getString("classCode"));
					dto.setClassName(rs.getString("className"));
					dto.setTeacher(rs.getString("teacher"));
					dto.setClassDate(rs.getString("classDate"));
					dto.setClassTime(rs.getString("classTime"));
					dto.setClassPay(rs.getString("classPay"));
					dto.setPerson(rs.getInt("person"));
					dto.setLev(rs.getString("lev"));
					dto.setState(rs.getString("state"));
					dto.setClassSummary(rs.getString("classSummary"));
					dto.setClassPlan(rs.getString("classPlan"));
					dto.setReference(rs.getString("reference"));
					dto.setPw(rs.getString("pw"));
					dto.setOrgName(rs.getString("orgName"));
					dto.setSysName(rs.getString("sysName"));
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
	
	public List<ClassDTO> getArticles(int start, int end, int n, String searchKeyword) throws Exception {
		List<ClassDTO> articleList = null;
		String[] column_name = {"teacher", "className", "center"};
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,state,classSummary,classPlan,reference,pw,orgName,sysName, r "
					+ "from (select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,state,classSummary,classPlan,reference,pw,orgName,sysName, rownum r "
					+ "from (select * from class order by num desc)where "+column_name[n]+" like '%"+searchKeyword+"%' order by num desc) where r >= ? and r <= ?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList(end);
				do {
					ClassDTO lesson = new ClassDTO();
					
					lesson.setNum(rs.getInt("num"));
					lesson.setCenter(rs.getString("center"));
					lesson.setClassCode(rs.getString("classCode"));
					lesson.setClassName(rs.getString("className"));
					lesson.setTeacher(rs.getString("teacher"));
					lesson.setClassTime(rs.getString("classTime"));
					lesson.setClassPay(rs.getString("classPay"));
					lesson.setPerson(rs.getInt("person"));
					lesson.setLev(rs.getString("lev"));
					lesson.setState(rs.getString("state"));
					lesson.setClassSummary(rs.getString("classSummary"));
					lesson.setClassPlan(rs.getString("clasSPlan"));
					lesson.setReference(rs.getString("reference"));
					lesson.setPw(rs.getString("pw"));
					lesson.setOrgName(rs.getString("orgName"));
					lesson.setSysName(rs.getString("sysName"));
					articleList.add(lesson);
				} while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException ex){}
   			if(pstmt != null) try {pstmt.close();} catch(SQLException ex){}
   			if(conn != null) try {conn.close();} catch(SQLException ex){}
		}
		return articleList;
	}

	public ClassDTO updateGetClass(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClassDTO dto = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from class where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ClassDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCenter(rs.getString("center"));
				dto.setClassCode(rs.getString("classCode"));
				dto.setClassName(rs.getString("className"));
				dto.setTeacher(rs.getString("teacher"));
				dto.setClassDate(rs.getString("classDate"));
				dto.setClassTime(rs.getString("classTime"));
				dto.setClassPay(rs.getString("classPay"));
				dto.setPerson(rs.getInt("person"));
				dto.setLev(rs.getString("lev"));
				dto.setState(rs.getString("state"));
				dto.setClassSummary(rs.getString("classSummary"));
				dto.setClassPlan(rs.getString("classPlan"));
				dto.setReference(rs.getString("reference"));
				dto.setPw(rs.getString("pw"));
				dto.setOrgName(rs.getString("orgName"));
				dto.setSysName(rs.getString("sysName"));
				dto.setTeacherId(rs.getString("teacherId"));

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

		return dto;
	}

	public int updateClass(ClassDTO dto) throws Exception {

		String dbpw = "";
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pw from class where num = ?");
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString("pw");
				if (dbpw.equals(dto.getPw())) {
					sql = "update class set center=?,classCode=?,className=?,teacher=?,classDate=?,classTime=?,classPay=?,person=?,lev=?,state=?,classSummary=?,classPlan=?,reference=?,orgName=?,sysName=?,teacherId=? where num=?";

					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, dto.getCenter());
					pstmt.setString(2, dto.getClassCode());
					pstmt.setString(3, dto.getClassName());
					pstmt.setString(4, dto.getTeacher());
					pstmt.setString(5, dto.getClassDate());
					pstmt.setString(6, dto.getClassTime());
					pstmt.setString(7, dto.getClassPay());
					pstmt.setInt(8, dto.getPerson());
					pstmt.setString(9, dto.getLev());
					pstmt.setString(10, dto.getState());
					pstmt.setString(11, dto.getClassSummary());
					pstmt.setString(12, dto.getClassPlan());
					pstmt.setString(13, dto.getReference());
					pstmt.setString(14, dto.getOrgName());
					pstmt.setString(15, dto.getSysName());
					pstmt.setString(16, dto.getTeacherId());
					pstmt.setInt(17, dto.getNum());
					pstmt.executeUpdate();

					x = 1;
				} else {
					x = 0;
				}
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

	public int updateClass2(ClassDTO dto) throws Exception {

		String dbpw = "";
		String sql = "";
		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pw from class where num = ?");
			pstmt.setInt(1, dto.getNum());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString("pw");
				if (dbpw.equals(dto.getPw())) {
					sql = "update class set center=?,classCode=?,className=?,teacher=?,classDate=?,classTime=?,classPay=?,person=?,lev=?,state=?,classSummary=?,classPlan=?,reference=?,pw=?,teacherId=? where num=?";

					pstmt = conn.prepareStatement(sql);

					pstmt.setString(1, dto.getCenter());
					pstmt.setString(2, dto.getClassCode());
					pstmt.setString(3, dto.getClassName());
					pstmt.setString(4, dto.getTeacher());
					pstmt.setString(5, dto.getClassDate());
					pstmt.setString(6, dto.getClassTime());
					pstmt.setString(7, dto.getClassPay());
					pstmt.setInt(8, dto.getPerson());
					pstmt.setString(9, dto.getLev());
					pstmt.setString(10, dto.getState());
					pstmt.setString(11, dto.getClassSummary());
					pstmt.setString(12, dto.getClassPlan());
					pstmt.setString(13, dto.getReference());
					pstmt.setString(14, dto.getPw());
					pstmt.setString(15, dto.getTeacherId());
					pstmt.setInt(16, dto.getNum());
					pstmt.executeUpdate();

					x = 1;
				} else {
					x = 0;
				}
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
	public int deleteClass(int num, String pw) throws Exception {

		String dbpw = "";
		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select pw from class where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dbpw = rs.getString("pw");
				if (dbpw.equals(pw)) {
					pstmt = conn.prepareStatement("delete from class where num =?");
					pstmt.setInt(1, num);
					pstmt.executeUpdate();
					x = 1;
				} else
					x = 0;
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
}
