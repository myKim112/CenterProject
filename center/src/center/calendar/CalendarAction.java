package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalendarAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		return "/calendar/calendar.jsp";
	}
}
