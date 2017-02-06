package center.cart;

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


public class CartDAO {
	private static CartDAO instance = new CartDAO();

	public static CartDAO getInstance() {
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

	public void insertCartActicle(CartDTO dto) throws Exception {

		String sql = "";

		try {
			conn = getConnection();
			sql = "insert into cart values(cart_seq.NEXTVAL,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getTnum());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getClassCode());
			pstmt.executeUpdate();

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
	}

	public int getArticleCount(int num) throws Exception {

		int x = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from class s ,cart t where s.classCode = t.classCode");// 코드가
																													// 같은
																												// 것을
																											// 보여달라
			rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
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
		return x;
	}

	public List<ClassDTO> getCartArticles(String id) throws Exception {

		List<ClassDTO> articleList = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select t.num tnum,c.num cnum,c.classCode,c.center,c.className,c.classDate,c.classTime,c.classPay,c.person,c.state from class c , cart t where c.classCode = t.classCode and  t.id=?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				articleList = new ArrayList<ClassDTO>();
				do {
					ClassDTO dto = new ClassDTO();
					CartDTO ddto = new CartDTO();
					ddto.setTnum(rs.getInt("tnum"));
					dto.setCnum(rs.getInt("cnum"));
					dto.setClassCode(rs.getString("classCode"));
					dto.setCenter(rs.getString("center"));
					dto.setClassName(rs.getString("className"));
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

	public int deleteCart(int tnum) throws Exception {

		int x = -1;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from cart where tnum =?");
			pstmt.setInt(1, tnum);
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
