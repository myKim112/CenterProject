package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import center.join.*;
import center.action.SuperAction;

public class FindIdProAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		JoinDAO resercher = JoinDAO.getInstance(); 
		
		try {
			String reserch= resercher.idFind(name,phone);
				if(name != null){
				
						
			}
				} catch (Exception e) {
		
			e.printStackTrace();
		}
		
	
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);

		return "/join/findIdPro.jsp";
	}
}

