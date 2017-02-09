package center.calendar;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalUpdateFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			int calNum = Integer.parseInt(request.getParameter("calNum"));
			CalendarDTO cal = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd");
			CalendarDAO dbPro = CalendarDAO.getInstance();
			cal = dbPro.getCal(calNum);

			request.setAttribute("cal", cal);
			request.setAttribute("calNum", calNum);
			request.setAttribute("sdf", sdf);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "/calendar/calUpdateForm.jsp";
	}
}
