package center.calendar;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalUpdateFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int calNum = Integer.parseInt(request.getParameter("calNum"));
		CalendarDTO cal = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			CalendarDAO dbPro = CalendarDAO.getInstance();
			cal = dbPro.getCal(calNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("cal", cal);
		request.setAttribute("calNum", calNum);
		request.setAttribute("sdf", sdf);
		
		return "/calendar/calUpdateForm.jsp";
	}
}
