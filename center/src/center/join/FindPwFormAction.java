package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class FindPwFormAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
	
		return "/join/findPwForm.jsp";
	}
}

