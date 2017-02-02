package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class TeacherUpdateProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try{
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			
/*			if(id == null) {
				HttpSession session = request.getSession();
				id = (String)session.getAttribute("centerId");
			}
*/			
			System.out.println(id);
			
			StaffDTO staff = new StaffDTO();
			
			staff.setId(id);
			staff.setPw(request.getParameter("pw"));
			staff.setName(request.getParameter("name"));
			staff.setBirth(Integer.parseInt(request.getParameter("birth")));
			staff.setPhone(Integer.parseInt(request.getParameter("phone")));
			staff.setAddress(request.getParameter("address"));
			staff.setEmail(request.getParameter("email"));
			staff.setBankName(request.getParameter("bankName"));
			staff.setBankAccount(request.getParameter("bankAccount"));
			
			StaffDAO dbPro = StaffDAO.getInstance();
			dbPro.updateTeacher(staff);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/teacher/teacherUpdatePro.jsp";
	}
}
