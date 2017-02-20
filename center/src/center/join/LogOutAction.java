package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class LogOutAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
	
		
		HttpSession session = request.getSession();
		session.invalidate();
	
		return "/join/logOut.jsp";
	}
}
