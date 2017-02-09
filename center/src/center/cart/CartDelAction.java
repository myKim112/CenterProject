package center.cart;

	import javax.servlet.http.HttpServletResponse;
	import center.action.SuperAction;


	import javax.servlet.http.HttpServletRequest;

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

