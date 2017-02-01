package center.lesson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ClassWriterAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int num = 0;
		try {
			if (request.getParameter("num") != null) {
				num = Integer.parseInt(request.getParameter("num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("num", new Integer(num));

		return "/class/classWrite.jsp";
	}
}
