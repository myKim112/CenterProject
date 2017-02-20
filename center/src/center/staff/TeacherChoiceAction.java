package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherChoiceAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String classCode = request.getParameter("classCode");
		String id = request.getParameter("id");
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		request.setAttribute("classCode", classCode);
		request.setAttribute("id", id);
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		
		return "/teacher/teacherChoice.jsp";
	}
}
