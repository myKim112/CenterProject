package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.power.PowerDTO;

public class TeacherInfAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
//		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String id = request.getParameter("id");
				
		StaffDTO staff = null;
		PowerDTO power = null;
		
		try {
			response.setCharacterEncoding("UTF-8");
			
			StaffDAO dbPro = StaffDAO.getInstance();
			staff = dbPro.getTeacher(id);
			power = dbPro.getTeacherLev(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);		
//		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("staff", staff);
		request.setAttribute("power", power);
				
		return "/teacherManage/teacherInf.jsp";
	}
}