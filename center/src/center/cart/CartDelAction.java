package center.cart;

import javax.servlet.http.HttpServletResponse;
import center.action.SuperAction;
import javax.servlet.http.HttpServletRequest;



public class CartDelAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		String [] classCodes = request.getParameterValues("classCode");
	
			CartDAO dao = CartDAO.getInstance();
		    try{
		    	for(String cc : classCodes){  //String형식으로 변수 n선언
		    		String classCode = cc;
		    		dao.deleteCart(classCode);
		       	}
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		return "/cart/cartDel.jsp";

	}

}
