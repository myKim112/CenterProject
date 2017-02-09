package center.calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class CalInputFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			
			int calNum = 0;
			
			if(request.getParameter("calNum") != null) {
				calNum = Integer.parseInt(request.getParameter("calNum"));
			}
			
			request.setAttribute("calNum", new Integer(calNum));
		} catch(Exception e) {
			e.printStackTrace();
		}		
		
		return "/calendar/calInputForm.jsp";
	}

}