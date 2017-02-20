package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import center.join.JoinDAO;

import center.action.SuperAction;

public class FindIdProAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
	
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		JoinDAO manager = JoinDAO.getInstance(); 
		
		
		try {
			String id= manager.idFind(name,phone);
			request.setAttribute("id", new String(id));
			request.setAttribute("name", name);
		
		} 
	
	
		catch (Exception e) {
				
				e.printStackTrace();
			}
			
		return "/join/findIdPro.jsp";
			}
	}

	
	
		
	