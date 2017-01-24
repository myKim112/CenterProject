package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class ModifyAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		
		JoinDAO dao = JoinDAO.getInstance();
		JoinDTO dto = null;
		
		try {
			dto = dao.getMember(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("dto", dto);
		
		return "/myPage/modify.jsp";
	}
}
