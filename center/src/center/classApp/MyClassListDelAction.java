package center.classApp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import center.action.SuperAction;
import center.cart.CartDAO;

public class MyClassListDelAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		String classCode = request.getParameter("classCode");
	
			AppDAO dao = AppDAO.getInstance();
		    try{
		    		dao.deleteApp(classCode);
		 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		return "/classApp/myAppListDel.jsp";

		}

	}
