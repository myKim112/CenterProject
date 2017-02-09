package center.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JoinDAO {
	private static JoinDAO instance = new JoinDAO();
	
	public static JoinDAO getInstance(){
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws Exception {
		Context ctx= new InitialContext();
		Context env = (Context)ctx.lookup("java:comp/env");
		DataSource ds = (DataSource)env.lookup("jdbc/orcl");
		
		return ds.getConnection();
	}
	
	public void insertJoin(JoinDTO dto) throws Exception { // 회원가입
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement("insert into join values(?,?,?,?,?,?,?,10,sysdate)");
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPw());
			pstmt.setString(3,dto.getName());
			pstmt.setInt(4,dto.getBirth());
			pstmt.setInt(5,dto.getPhone());
			pstmt.setString(6,dto.getAddress());
			pstmt.setString(7,dto.getEmail());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
			if(conn != null)try{conn.close();}catch(SQLException ex){}
		}
	}
	
	public JoinDTO getMember(String id)	throws Exception { // 입력받은 id에 해당하는 내용 가져오기
		JoinDTO dto = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from join where id =?");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
		
			if(rs.next()){
				dto=new JoinDTO();
					
				dto.setId(rs.getString("id"));
  				dto.setPw(rs.getString("pw"));
  				dto.setName(rs.getString("name"));
  				dto.setBirth(rs.getInt("birth"));	
  				dto.setPhone(rs.getInt("phone"));
  				dto.setAddress(rs.getString("address"));  					
  				dto.setEmail(rs.getString("email"));
  				dto.setRegDate(rs.getTimestamp("regDate"));
  				
  				pstmt.executeQuery();
  			}
  		} catch(Exception e){
  			e.printStackTrace();
  		} finally{
  			if(rs != null)try{rs.close();}catch(SQLException ex){}
  			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
  			if(conn != null)try{conn.close();}catch(SQLException ex){}
  		}
  		return dto;
	}
	
	public void updateJoin(JoinDTO dto) throws Exception { // 회원정보 수정
		
		try{
			conn=getConnection();
			pstmt=conn.prepareStatement("update join set pw=?, name=?, birth=?, phone=?, address=?, email=? where id=?");
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getBirth());
			pstmt.setInt(4, dto.getPhone());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getId());
			pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt != null)try{pstmt.close();}catch(SQLException ex){}
		 	if(conn != null)try{conn.close();}catch(SQLException ex){}
		}
	}	
	
	public int confirmId(String id) throws Exception { // 아이디 중복 확인
		int x = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select j.id jid,s.id sid from join j , staff s where s.id=? or j.id=?");
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				x=1;
			} else {
				x=-1;
			}
		} catch(Exception e) { 
			e.printStackTrace();	
		}
		finally {
			 if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			 if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			 if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
		return x;
	}
	
	public int deleteMem(String id, String pw) throws Exception { // 회원 탈퇴
		String dbpw ="";
		int check = -1;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from join where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dbpw=rs.getString("pw");
				
				if(dbpw.equals(pw)){
					pstmt=conn.prepareStatement("delete from join where id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					check = 1;
				}else{ 
					check = 0;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs !=null) try{rs.close();}catch(SQLException s){}
			if(pstmt !=null) try{pstmt.close();}catch(SQLException s){}
			if(conn !=null) try{conn.close();}catch(SQLException s){}
		}
		return check;
	}
	
	public int userCheck(String id, String pw) throws Exception { // 로그인시 id, pw 확인
		String dbpw_staff ="";
		String dbpw_join ="";
		int result = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select j.pw jpw,s.pw spw from join j , staff s where s.id=? or j.id=?");
			pstmt.setString(1, id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				dbpw_join = rs.getString("jpw");
				dbpw_staff = rs.getString("spw");
				if(dbpw_join.equals(pw)) {
					result = 1;
				} else if(dbpw_staff.equals(pw)) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch(Exception e) { e.printStackTrace(); }
		 finally {
			 if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			 if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			 if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
		return result;
	}
	
	// 관리자
	public int getMemberCount() throws Exception { // 전체 회원 수
		int x = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from join");
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
	
	public ArrayList<JoinDTO> getMemberArticle(int start, int end) throws Exception { // 전체 회원 목록 불러오기
		ArrayList<JoinDTO> articleList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(
					"select id, pw, name, birth, phone, address, email, lev, regDate , r from"+
					"(select id, pw, name, birth, phone, address, email, lev, regDate, rownum r from"+ 
					"(select * from join order by regDate asc) order by regDate asc) where r>=? and r<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				articleList = new ArrayList(end);
				
				do {
					JoinDTO article = new JoinDTO();
					
					article.setId(rs.getString("id"));
					article.setPw(rs.getString("pw"));
					article.setName(rs.getString("name"));
					article.setBirth(rs.getInt("birth"));
					article.setPhone(rs.getInt("phone"));
					article.setAddress(rs.getString("address"));
					article.setEmail(rs.getString("email"));
					article.setLev(rs.getInt("lev"));
					article.setRegDate(rs.getTimestamp("regDate"));
					articleList.add(article);
				}while(rs.next());
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) { try { rs.close(); } catch(SQLException s) { } }
			if(pstmt != null) { try { pstmt.close(); } catch(SQLException s) { } }
			if(conn != null) { try { conn.close(); } catch(SQLException s) { } }
		}
		return articleList;
	}

	public String idFind(String name,String phone) {
		String sql = null;
		String id =null;
		try {
			conn = getConnection();
			sql = "select id from join where name=? and phone=?"; 
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery(); // 실행
			if(rs.next()){
				id = rs.getString("id");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}


public String pwFind(String name,String phone,String id) {
	String sql = null;
	String pw =null;
	


	try {
		conn = getConnection();
		sql = "select id from join where id=? and name=? and phone=?"; 
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, phone);
		rs = pstmt.executeQuery(); // 실행
		if(rs.next()){
			pw = rs.getString("pw");
			pw = rs.getString("id");
			
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	return pw;
}
}







