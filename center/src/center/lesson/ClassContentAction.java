package center.lesson;


import center.staff.StaffDAO;
import center.staff.StaffDTO;
import javax.servlet.http.*;
import center.action.SuperAction;

public class ClassContentAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("num")); // 해당글번호
		String pageNum = request.getParameter("pageNum"); //// 해당페이지번호
		String id = request.getParameter("id");

		ClassDAO dao = ClassDAO.getInstance(); // DB처리
		StaffDAO dao1 = StaffDAO.getInstance();	
		ClassDTO dto = null;
		StaffDTO staff =null;
		
		try {
			dto = dao.getClass(num);
			staff = dao1.getTeacher(id);
		
		} catch (Exception e) {
			e.printStackTrace();
		} // 해당글불러오는 DAO

		// 해당뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("dto", dto);
		request.setAttribute("id", id);
		request.setAttribute("staff", staff);

		return "/class/classContent.jsp";
	}
}
