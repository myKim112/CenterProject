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
			sql = "insert into app values(app_seq.NEXTVAL,?,?,?,0,sysdate,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getId());
			pstmt.setString(2, dto.getClassCode());
			pstmt.setInt(3,dto.getSum());
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
			pstmt = conn.prepareStatement("select count(*) from app where classCode = ?");  //코드가 같은것을 보여달라
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

	/*public List<ClassDTO> getAppArticles(String id) throws Exception {

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
	
public List getArticles(int num) throws Exception{
		
		List articleList = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select num, id, classCode, sum, status, reg_date, memberCount, r  " +
		            "from (select  num, id, classCode, sum, status, reg_date, memberCount,rownum r " +
		            "from (select * " +
		            "from app order by reg_date desc)) where r >= ? and r <= ? ");
			pstmt.setInt(1, num);
		
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				articleList = new ArrayList(end);
				do{
					AppDTO dto = new AppDTO();
					dto.setNum(rs.getInt("num"));
					dto.setId(rs.getString("id"));
					dto.setClassCode(rs.getString("classCode"));
					dto.setSum(rs.getInt("sum"));
					dto.setStatus(rs.getInt("status"));
					dto.setMemberCount(rs.getInt("memberCount"));
					
					articleList.add(dto);
					
				}while(rs.next());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
	           if (rs != null) try { rs.close(); } catch(SQLException ex) {}
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}			
		}
		return articleList;
	}
	*/
	 public List<AppDTO> meminfo(String id)throws Exception{
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
	 						dto.setSum(rs.getInt("sum"));
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
	/* public void buyPage(AppDTO dto) throws Exception{
				 
			try{
		  		conn=getConnection();
		        pstmt = conn.prepareStatement("insert into app("num classCode,center,className,teacher,classDate,classTime,classPay,person,state) 
		        		values(?,?,?,?,?,?,?,?,?,?,?,?)");
		        pstmt.setString(1, mem.getId());
		        pstmt.setString(2, mem.getName());
		        pstmt.setString(3, mem.getPhone());
		        pstmt.setString(4, mem.getPhone2());
		        pstmt.setString(5, mem.getPhone3());
		        pstmt.setString(6, mem.getAddress());
		        pstmt.setString(7, mem.getAddress2());
		        pstmt.setString(8, mem.getMemo());
		        pstmt.setInt(9, mem.getItem_amount());
		        pstmt.setString(10, mem.getGaveman());
		        pstmt.setString(11, mem.getZipcode());
		        pstmt.setInt(12, mem.getItem_num());
		        pstmt.executeUpdate();
		  	
			
		  	}catch(Exception e){
				e.printStackTrace();
			}finally{
				 if (rs != null) try { rs.close(); } catch(SQLException e) {}
				if(pstmt !=null){try{pstmt.close();}catch(SQLException e){}}
				if(conn !=null){try{conn.close();}catch(SQLException e){}}
			}
} */
		 
	
	public int deleteApp(int num) throws Exception {

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
}

