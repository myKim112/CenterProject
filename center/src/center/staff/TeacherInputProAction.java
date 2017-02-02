package center.staff;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherInputProAction implements SuperAction {
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
			staff.setBankAccount(request.getParameter("bankAccount"));
			staff.setRegDate(new Timestamp(System.currentTimeMillis()));
			
			StaffDAO manager = StaffDAO.getInstance();
			manager.insertTeacher(staff);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/teacherManage/teacherInputPro.jsp";
	}
}
