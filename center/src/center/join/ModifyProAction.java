package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class ModifyProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
				
		try {
			JoinDTO dto= new JoinDTO();
			JoinDAO dao = JoinDAO.getInstance();
			
			dto.setId(request.getParameter("id"));
	        dto.setPw(request.getParameter("pw"));
	        dto.setName(request.getParameter("name"));
	        dto.setBirth(Integer.parseInt(request.getParameter("birth")));
	        dto.setPhone(Integer.parseInt(request.getParameter("phone")));
	        dto.setEmail(request.getParameter("email"));
	        dto.setLev(request.getParameter("lev"));
	        
	        dao.updateJoin(dto);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/myPage/modifyPro.jsp";
	}
}
