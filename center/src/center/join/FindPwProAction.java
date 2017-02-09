package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import center.join.JoinDAO;

import center.action.SuperAction;

public class FindPwProAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
	
		String name =request.getParameter("name");
		String phone =request.getParameter("phone");
		String id =request.getParameter("id");
		JoinDAO manager = JoinDAO.getInstance(); 
		
		
		try {
			String pw= manager.pwFind(name,phone,id);
			request.setAttribute("pw", new String(pw));
			request.setAttribute("name",new String(name));
			request.setAttribute("id",new String(id));
		
		} 
	
	
		catch (Exception e) {
				
				e.printStackTrace();
			}
			
		return "/join/findPwPro.jsp";
			}
	}

	