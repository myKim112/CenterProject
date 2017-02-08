package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalInputProAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int calNum = Integer.parseInt(request.getParameter("calNum"));
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			CalendarDTO cal = new CalendarDTO();
			
			cal.setCalNum(Integer.parseInt(request.getParameter("calNum")));
			cal.setCalPw(request.getParameter("calPw"));
			cal.setMemoYear(request.getParameter("memoYear"));
			cal.setMemoMonth(request.getParameter("memoMonth"));
			cal.setMemoDate(request.getParameter("memoDate"));
			cal.setCalTitle(request.getParameter("calTitle"));
			cal.setCalContent(request.getParameter("calContent"));
			
			CalendarDAO dbPro = CalendarDAO.getInstance();
			dbPro.insertCal(cal);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("calNum", new Integer(calNum));
		
		return "/calendar/calInputPro.jsp";
	}
}
