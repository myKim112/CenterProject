package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalDeleteFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int calNum = Integer.parseInt(request.getParameter("calNum"));
		
		request.setAttribute("calNum", new Integer(calNum));
		
		return "/calendar/calDeleteForm.jsp";
	}
}
