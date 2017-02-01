package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherInfAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
//		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String id = request.getParameter("id");
		
		StaffDAO dbPro = StaffDAO.getInstance();
		StaffDTO staff = null;
		
		try {
			response.setCharacterEncoding("UTF-8");
			
			staff = dbPro.getTeacher(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);		
//		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("staff", staff);
				
		return "/teacherManage/teacherInf.jsp";
	}
}