package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ConfirmIdAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		request.setAttribute("id", id);
		return "/join/confirmId.jsp";
	}
}
