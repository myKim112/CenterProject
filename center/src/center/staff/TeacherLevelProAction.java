package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.join.JoinDTO;

public class TeacherLevelProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		StaffDTO staff = null;
		try {
			response.setCharacterEncoding("UTF-8");
			
			staff = new StaffDTO();
			
			staff.setLev(Integer.parseInt(request.getParameter("lev")));
			staff.setId(id);
			
			StaffDAO dbPro = StaffDAO.getInstance();
			dbPro.updateTeacherLev(staff);
			
			System.out.println(id);
		} catch(Exception e) {
			e.printStackTrace();
		}		
		request.setAttribute("id", id);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("staff", staff);
		
		return "/teacherManage/teacherLevelPro.jsp";
	}
}
