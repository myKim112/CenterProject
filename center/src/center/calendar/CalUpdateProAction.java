package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalUpdateProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			int calNum = Integer.parseInt(request.getParameter("calNum"));
			int check = -1;
			
			CalendarDTO cal = new CalendarDTO();
			cal.setCalNum(calNum);
			cal.setCalPw(request.getParameter("calPw"));
			cal.setMemoYear(request.getParameter("memoYear"));
			cal.setMemoMonth(request.getParameter("memoMonth"));
			cal.setMemoDate(request.getParameter("memoDate"));
			cal.setCalTitle(request.getParameter("calTitle"));
			cal.setCalContent(request.getParameter("calContent"));
			
			CalendarDAO dbPro = CalendarDAO.getInstance();
			check = dbPro.updateCal(cal);

			request.setAttribute("check", new Integer(check));
			request.setAttribute("calNum", new Integer(calNum));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/calendar/calUpdatePro.jsp";
	}
}
