package center.lesson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ClassManageDeleteAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String classCode = request.getParameter("classCode");
		String pageNum = request.getParameter("pageNum");
		
		try {
			ClassDAO dbPro = ClassDAO.getInstance();
			dbPro.classManageDelete(classCode);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("pageNum", pageNum);
		return "/teacherManage/classManageDelete.jsp";
	}
}
