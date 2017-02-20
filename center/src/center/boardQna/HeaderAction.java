package center.boardQna;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.power.PowerDTO;
import center.staff.StaffDAO;

public class HeaderAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		
		PowerDTO power = null;
		StaffDAO dao1 = StaffDAO.getInstance();
		
		try {
			power = dao1.getTeacherLev(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        request.setAttribute("id", id);
        request.setAttribute("power", power);
        System.out.println(power);
		
		return "/boardQna/header.jsp";
	}

}
