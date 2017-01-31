package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.join.JoinDTO;

public class TeacherLevelProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			response.setCharacterEncoding("UTF-8");
			
			StaffDTO staff = new StaffDTO();
			
			staff.setLev(Integer.parseInt(request.getParameter("lev")));
			
			StaffDAO dbPro = StaffDAO.getInstance();
			dbPro.updateTeacherLev(staff);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		request.setAttribute("id", id);
		
		return "/teacherManage/teacherLevelPro.kiki";
	}
}
