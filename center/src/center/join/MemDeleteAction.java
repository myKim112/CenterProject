package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MemDeleteAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		return "/myPage/memDelete.jsp";
	}
}
