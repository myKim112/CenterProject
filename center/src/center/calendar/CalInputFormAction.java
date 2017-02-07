package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalInputFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int calNum = 0;
		
		try {
			if(request.getParameter("calNum") != null) {
				calNum = Integer.parseInt(request.getParameter("calNum"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("calNum", new Integer(calNum));
		
		return "/calendar/calInputForm.jsp";
	}

}