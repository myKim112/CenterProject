package center.calendar;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalInputProAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			CalendarDTO cal = new CalendarDTO();
			
			cal.setCalPw(request.getParameter("calPW"));
			cal.setCalDate(Timestamp.valueOf(request.getParameter("memoYear")));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/calendar/calInputPro.jsp";
	}
}
