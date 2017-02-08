package center.calendar;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalendarAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
	
		try {
			CalendarDAO dbPro = CalendarDAO.getInstance();
			ArrayList<CalendarDTO> calList = dbPro.getSchedule();
			
			request.setAttribute("calList", calList);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/calendar/calendar.jsp";
	}
}
