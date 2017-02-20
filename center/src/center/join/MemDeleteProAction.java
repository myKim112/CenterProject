package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class MemDeleteProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		String pw = request.getParameter("pw");
		int check = -1;
		
		try {
			request.setCharacterEncoding("UTF-8");
				        
	        JoinDAO dao = JoinDAO.getInstance();
	        check = dao.deleteMem(id, pw);
	        
	        session.invalidate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("check", new Integer(check));
		
		return "/myPage/memDeletePro.jsp";
	}
}
