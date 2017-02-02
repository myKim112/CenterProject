package center.join;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MembershipProAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			JoinDTO dto = new JoinDTO();
			
			dto.setId(request.getParameter("id"));
			dto.setPw(request.getParameter("pw"));
			dto.setName(request.getParameter("name"));
			dto.setBirth(Integer.parseInt(request.getParameter("birth")));
			dto.setPhone(Integer.parseInt(request.getParameter("phone")));
			dto.setAddress(request.getParameter("address"));
			dto.setEmail(request.getParameter("email"));
			dto.setRegDate(new Timestamp(System.currentTimeMillis()));
			
			JoinDAO manager = JoinDAO.getInstance();
			manager.insertJoin(dto);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/join/membershipPro.jsp";
	}
}
