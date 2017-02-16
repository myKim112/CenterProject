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

import center.boardQna.QnaDTO;
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
				dto.setSum(rs.getString("sum"));
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
			sql = "insert into app values(app_seq.NEXTVAL,?,?,?,0,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2, dto.getClassCode());
			pstmt.setString(3,dto.getSum());
			pstmt.setInt(4,dto.getMemberCount());
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

	public int getArticleCount(String classCode) throws Exception {
		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class where classCode = ?");  //코드가 같은것을 보여달라
			pstmt.setString(1, classCode);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				x = rs.getInt(1);
			}
			
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
		return x;
	}

	 public List<AppDTO> getAppList(String id)throws Exception{
		 List<AppDTO> articleList = null;
		 try {
			 conn = getConnection();
	 		 pstmt= conn.prepareStatement("select a.num ,c.center, c.classcode,c.className, c.teacher,c.classDate,c.classTime,a.sum,a.memberCount,a.reg_Date,a.status from class c ,app a where c.classcode = a.classcode and a.id=? order by a.reg_Date desc");
	 		 pstmt.setString(1, id);
	 	     rs= pstmt.executeQuery(); 
	 	     articleList = new ArrayList<AppDTO>();
	 				
	 					while(rs.next()){
	 						AppDTO dto = new AppDTO();
	 					    dto.setNum(rs.getInt("num"));
	 						dto.setCenter(rs.getString("center"));
	 						dto.setClassCode(rs.getString("classCode"));
	 						dto.setClassName(rs.getString("className"));
	 						dto.setTeacher(rs.getString("teacher"));
	 						dto.setClassDate(rs.getString("classDate"));
	 						dto.setClassTime(rs.getString("classTime"));
	 						dto.setSum(rs.getString("sum"));
	 						dto.setMemberCount(rs.getInt("memberCount"));
	 						dto.setStatus(rs.getInt("status"));
	 			
	 						articleList.add(dto);
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

	 public List<AppDTO> getAppListId(String id)throws Exception{
		 List<AppDTO> articleList = null;
		 try {
			 conn = getConnection();
	 		 pstmt= conn.prepareStatement("select * from app where id=?");
	 		 pstmt.setString(1, id);
	 	     rs= pstmt.executeQuery(); 
	 	     articleList = new ArrayList<AppDTO>();
	 				
	 					while(rs.next()){
	 						AppDTO dto = new AppDTO();
	 						dto.setNum(rs.getInt("num"));
	 						dto.setId(rs.getString("id"));
	 						dto.setClassCode(rs.getString("classCode"));
	 						dto.setSum(rs.getString("sum"));
	 						dto.setStatus(rs.getInt("status"));
	 						dto.setMemberCount(rs.getInt("memberCount"));
	 						articleList.add(dto);
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
		 
	 public int deleteApp(String classCode) throws Exception {

			int x = -1;
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement("delete from App where classCode =?");
				pstmt.setString(1, classCode);
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
	}
