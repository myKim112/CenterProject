package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class FindIdFormAction implements SuperAction {
	public String executeAction (HttpServletRequest request, HttpServletResponse response) {
	
		return "/join/findIdForm.jsp";
	}
}

