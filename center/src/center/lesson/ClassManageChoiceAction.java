package center.lesson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ClassManageChoiceAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String classCode = request.getParameter("classCode");
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("classCode", classCode);
		
		return "/teacherManage/classManageChoice.jsp";
	}
}
