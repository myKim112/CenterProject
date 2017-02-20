package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MemberDeleteAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		try {
			JoinDAO dbPro = JoinDAO.getInstance();
			dbPro.memberDelete(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/memManage/memberDelete.jsp";
	}
}
