package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class DeleteProAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		String pw  = request.getParameter("pw");
		
		try {
			JoinDAO dbPro = JoinDAO.getInstance();
			int check = dbPro.deleteMem(id, pw);
			
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);
			request.setAttribute("check", new Integer(check));
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		
		
		
		return "/join/deletePro.jsp";
	}
}
