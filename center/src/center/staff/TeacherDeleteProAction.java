package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherDeleteProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			StaffDAO dbPro = StaffDAO.getInstance();
			dbPro.teacherDelete(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/teacherManage/teacherDeletePro.jsp";
	}
}
