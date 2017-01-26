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

public class ClassDAO {
	private static ClassDAO instance = new ClassDAO();
	
	public static ClassDAO getInstance(){
		return instance;
	}
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection()throws Exception{
		Context ctx =new InitialContext();
		Context env = (Context)ctx.lookup("java:comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/orcl");
		
		return ds.getConnection();
	}
	
	public ClassDTO getClass(int num)throws Exception { // 강좌 불러오기
		ClassDTO dto=null;
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("select * from class where num=?");
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				dto=new ClassDTO();
				dto.setNum(rs.getInt("num"));
				dto.setCenter(rs.getString("center"));
				dto.setClassCode(rs.getString("classCode"));
				dto.setClassName(rs.getString("classname"));
				dto.setTeacher(rs.getString("teacher"));
				dto.setClassDate(rs.getString("classDate"));
				dto.setClassTime(rs.getString("classTime"));
				dto.setClassPay(rs.getInt("classPay"));
				dto.setPerson(rs.getInt("person"));
				dto.setLev(rs.getString("lev"));	
				dto.setAsk(rs.getString("ask"));	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null)try{conn.close();}catch(SQLException ex){}
		}return dto;
	}
	
	// 관리자	
	public void insertClass(ClassDTO dto) throws Exception { // 강좌 개설
		try{
			conn = getConnection();
			pstmt=conn.prepareStatement("insert into class values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,dto.getNum());
			pstmt.setString(2,dto.getCenter());
			pstmt.setString(3,dto.getClassCode());
			pstmt.setString(4,dto.getClassName());
			pstmt.setString(5,dto.getTeacher());
			pstmt.setString(6,dto.getClassDate());
			pstmt.setString(7,dto.getClassTime());
			pstmt.setInt(8,dto.getClassPay());
			pstmt.setInt(9,dto.getPerson());
			pstmt.setString(10,dto.getLev());
			pstmt.setString(11,dto.getAsk());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt !=null)try{pstmt.close();}catch(SQLException e){}
			if(conn !=null)try{conn.close();}catch(SQLException e){}
		}
	}
	
	public int getArticleCount() throws Exception{  //강좌수
		
		int x=0;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x= rs.getInt(1); 
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if (rs != null) try { rs.close(); } catch(SQLException e) {}
			if (pstmt != null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn != null) try { conn.close(); } catch(SQLException e) {}
		}
		return x;
	}
	public List getArticles(int start, int end) throws Exception {//목록시작끝
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ClassDTO> articleList=null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,ask, r "
					+
					"from (select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,ask,rownum r " 
					+
					"from (select num,center,classCode,className,teacher,classDate,classTime,classPay,person,lev,ask " 
					+
					"from class where r >= ? and r <= ?");
					pstmt.setInt(1, start); 
					pstmt.setInt(2, end); 

					rs = pstmt.executeQuery();
					if (rs.next()) {
						articleList = new ArrayList<ClassDTO>(end); 
						do{ 
							ClassDTO dto= new ClassDTO();
							dto.setNum(rs.getInt("num"));
							dto.setCenter(rs.getString("center"));
							dto.setClassCode(rs.getString("classCode"));
							dto.setClassName(rs.getString("className"));
							dto.setTeacher(rs.getString("teacher"));
							dto.setClassDate(rs.getString("classDate"));
							dto.setClassTime(rs.getString("classTime"));
							dto.setClassPay(rs.getInt("classPay"));
							dto.setPerson(rs.getInt("person"));
							dto.setLev(rs.getString("lev"));	
							dto.setAsk(rs.getString("ask"));
							articleList.add(dto); 
						}while(rs.next());
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
}

