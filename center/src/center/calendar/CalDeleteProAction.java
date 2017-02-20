package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalDeleteProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int calNum = Integer.parseInt(request.getParameter("calNum"));
		String calPw = request.getParameter("calPw");

		CalendarDAO dbPro = CalendarDAO.getInstance();
		int result = dbPro.deleteCal(calNum, calPw);
			
//		request.setAttribute("calNum", calNum);
		request.setAttribute("result", new Integer(result));
		
		return "/calendar/calDeletePro.jsp";
	}
}
