package center.cart;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.cart.CartDAO;

import center.action.SuperAction;

public class ClassCartListProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("centerId");
		String classCode = request.getParameter("classCode");

		try {
			CartDAO dao = CartDAO.getInstance();
			CartDTO dto = new CartDTO();
			dto.setId(id);
			dto.setClassCode(classCode);
			
			dao.insertCartActicle(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);

		return "/cart/classCartListPro.jsp";

	}

}
