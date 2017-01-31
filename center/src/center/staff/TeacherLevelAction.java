package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherLevelAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		StaffDTO staff = null;
		
		try {
			response.setCharacterEncoding("UTF-8");
			
			StaffDAO dbPro = StaffDAO.getInstance();
			staff = dbPro.getTeacher(id);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		request.setAttribute("staff", staff);
		
		return "/teacherManage/teacherLevel.jsp";
	}
}
