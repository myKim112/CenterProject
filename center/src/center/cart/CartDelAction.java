package center.cart;

	import javax.servlet.http.HttpServletResponse;
	import center.action.SuperAction;


	import javax.servlet.http.HttpServletRequest;

	public class CartDelAction implements SuperAction {
		public String executeAction(HttpServletRequest request, HttpServletResponse response) {

			int tnum = Integer.parseInt(request.getParameter("tnum"));
			String pageNum = request.getParameter("pageNum");
		
				CartDAO dao = CartDAO.getInstance();
			    try{
				dao.deleteCart(tnum);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			request.setAttribute("pageNum", new Integer(pageNum));
	
			return "/classCart/cartDel.jsp";

		}

	}

