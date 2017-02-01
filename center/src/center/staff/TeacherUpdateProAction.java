package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherUpdateProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			StaffDTO staff = new StaffDTO();
			
			staff.setId(request.getParameter("id"));
			staff.setPw(request.getParameter("pw"));
			staff.setName(request.getParameter("name"));
			staff.setBirth(Integer.parseInt(request.getParameter("birth")));
			staff.setPhone(Integer.parseInt(request.getParameter("phone")));
			staff.setAddress(request.getParameter("address"));
			staff.setEmail(request.getParameter("email"));
			staff.setBankName(request.getParameter("bankName"));
			staff.setBankAccount(Integer.parseInt(request.getParameter("bankAccount")));
			
			StaffDAO manage = StaffDAO.getInstance();
			manage.updateTeacher(staff);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/teacher/teacherUpdatePro.jsp";
	}
}
