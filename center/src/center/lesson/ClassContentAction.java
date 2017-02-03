package center.lesson;


import center.staff.StaffDAO;
import center.staff.StaffDTO;
import javax.servlet.http.*;
import center.action.SuperAction;
import center.power.PowerDTO;

public class ClassContentAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		int num = Integer.parseInt(request.getParameter("num")); 
		String pageNum = request.getParameter("pageNum"); 


		ClassDAO dao = ClassDAO.getInstance(); 
		StaffDAO dao1 = StaffDAO.getInstance();	
		ClassDTO dto = null;
		StaffDTO staff =null;
		PowerDTO power = null;
		
		try {
			dto = dao.getClass(num);
			power = dao1.getTeacherLev(id);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("dto", dto);
		request.setAttribute("id", id);
		request.setAttribute("staff", staff);
		request.setAttribute("power", power);

		return "/class/classContent.jsp";
	}
}
