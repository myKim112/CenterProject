package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class TeacherUpdateFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		if(id == null) {
			HttpSession session = request.getSession();
			id = (String)session.getAttribute("centerId");
		}
		
		StaffDTO staff = null;
		
		try {
			StaffDAO manage = StaffDAO.getInstance();
			staff = manage.getTeacher(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("staff", staff);
		request.setAttribute("id", id);
		
		return "/teacher/teacherUpdateForm.jsp";
	}
}
