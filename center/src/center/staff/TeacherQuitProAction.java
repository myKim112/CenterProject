package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherQuitProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			StaffDAO dbPro = StaffDAO.getInstance();
			dbPro.teacherQuit(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/teacherManage/teacherQuitPro.jsp";
	}
}
