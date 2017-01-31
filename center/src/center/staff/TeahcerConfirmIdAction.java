package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeahcerConfirmIdAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int check = 0;
		String id = request.getParameter("id");
		
		try {
			request.setCharacterEncoding("UTF-8");
						
			StaffDAO manager = StaffDAO.getInstance();
			check = manager.teacherConfirmId(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		request.setAttribute("check", new Integer(check));
		
		return "/teacherManage/teacherConfirmId.jsp";
	}
}
