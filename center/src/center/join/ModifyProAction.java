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
			request.setCharacterEncoding("UTF-8");
			
			JoinDTO dto= new JoinDTO();
						
			dto.setPw(request.getParameter("pw"));
	        dto.setName(request.getParameter("name"));
	        dto.setBirth(Integer.parseInt(request.getParameter("birth")));
	        dto.setPhone(Integer.parseInt(request.getParameter("phone")));
	        dto.setEmail(request.getParameter("email"));
	        dto.setAddress(request.getParameter("addresS"));
	        
	        JoinDAO dao = JoinDAO.getInstance();
	        dao.updateJoin(dto);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/myPage/modifyPro.jsp";
	}
}
