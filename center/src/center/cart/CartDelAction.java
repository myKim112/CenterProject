package center.cart;

	import javax.servlet.http.HttpServletResponse;
	import center.action.SuperAction;
import center.classApp.AppDAO;
import center.classApp.AppDTO;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

	/*public class CartDelAction implements SuperAction {
		public String executeAction(HttpServletRequest request, HttpServletResponse response) {

			String [] classCode = request.getParameterValues("classCode");
			int count= 0;
			CartDAO dao = CartDAO.getInstance();
			CartDTO dto =  null;
			
			List<ClassDTO> classList = new ArrayList<ClassDTO>();
			try {
				if(classCode.length == 1){
					count = dao.getClassCodeCount(classCode[0]);
					if (count > 0){
						dao.deleteCart(classCode[0]);		
					}
				}else{
					for(String cc : classCode){
						count = dao.getClassCodeCount(cc);
						if (count > 0){
							dao.deleteCart(cc);
							}
						}
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			return "/cart/cartDel.jsp";
		}//method
	}//class
					*/
				
			/*	
			try{
				
				for(String cc: classCode){
				dto.getClassCode(classCode);
				dao.deleteCart(classCode);

				} catch (Exception e) {
					
					e.printStackTrace();
				}
	
			return "/cart/cartDel.jsp";

		}

	}*/
	
	/*
	
	public class CartDelAction implements SuperAction {
		public String executeAction(HttpServletRequest request, HttpServletResponse response) {

			String [] nums = request.getParameterValues("num");
		
				CartDAO dao = CartDAO.getInstance();
			    try{
			    	for(String n : nums){  //String형식으로 변수 n선언
			    		int num = Integer.parseInt(n);
			    		dao.deleteCart(num);
			    	}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	
			return "/cart/cartDel.jsp";

		}

	}
*/

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
