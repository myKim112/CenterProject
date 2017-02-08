package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalUpdateFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int calNum = Integer.parseInt(request.getParameter("calNum"));
		CalendarDTO cal = null;
		try {
			CalendarDAO dbPro = CalendarDAO.getInstance();
			cal = dbPro.getCal(calNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("cal", cal);
		request.setAttribute("calNum", calNum);
		
		return "/calendar/calUpdateForm.jsp";
	}
}
