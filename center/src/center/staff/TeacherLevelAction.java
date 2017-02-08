package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.power.PowerDTO;

public class TeacherLevelAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		StaffDTO staff = null;
		PowerDTO power = null;
		
		try {
			response.setCharacterEncoding("UTF-8");
			
			StaffDAO dbPro = StaffDAO.getInstance();
			staff = dbPro.getTeacher(id);
			power = dbPro.getTeacherLev(id);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		request.setAttribute("staff", staff);
		request.setAttribute("power", power);
		request.setAttribute("pageNum", pageNum);
		
		return "/teacherManage/teacherLevel.jsp";
	}
}