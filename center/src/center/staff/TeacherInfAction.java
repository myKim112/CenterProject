package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.join.JoinDAO;
import center.join.JoinDTO;

public class TeacherInfAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String id = request.getParameter("id");
		
		JoinDAO dbPro = JoinDAO.getInstance();
		JoinDTO staff = null;
		
		try {
			staff = dbPro.getMember(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("staff", staff);
				
		return "/teacherManage/teacherInf.jsp";
	}
}
