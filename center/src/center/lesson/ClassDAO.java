package center.lesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Context env = (Context)ctx.lookup("java:cop/env");
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
				dto.setClassDate(rs.getInt("classDate"));
				dto.setClassTime(rs.getInt("classTime"));
				dto.setClassPay(rs.getInt("classPay"));
				dto.setPerson(rs.getInt("person"));
				dto.setLev(rs.getString("lev"));		
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
			pstmt=conn.prepareStatement("insert into class values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,dto.getNum());
			pstmt.setString(2,dto.getCenter());
			pstmt.setString(3,dto.getClassCode());
			pstmt.setString(4,dto.getClassName());
			pstmt.setString(5,dto.getTeacher());
			pstmt.setInt(6,dto.getClassDate());
			pstmt.setInt(7,dto.getClassTime());
			pstmt.setInt(8,dto.getClassPay());
			pstmt.setInt(9,dto.getPerson());
			pstmt.setString(10,dto.getLev());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt !=null)try{pstmt.close();}catch(SQLException e){}
			if(conn !=null)try{conn.close();}catch(SQLException e){}
		}
	}
}
