package center.lesson;


import center.staff.StaffDAO;
import center.staff.StaffDTO;
import javax.servlet.http.*;
import center.action.SuperAction;

public class ClassContentAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		int num = Integer.parseInt(request.getParameter("num")); // �ش�۹�ȣ
		String pageNum = request.getParameter("pageNum"); //// �ش���������ȣ
		String id = request.getParameter("id");

		ClassDAO dao = ClassDAO.getInstance(); // DBó��
		StaffDAO dao1 = StaffDAO.getInstance();	
		ClassDTO dto = null;
		StaffDTO staff =null;
		
		try {
			dto = dao.getClass(num);
			staff = dao1.getTeacher(id);
		
		} catch (Exception e) {
			e.printStackTrace();
		} // �ش�ۺҷ����� DAO

		// �ش�信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("dto", dto);
		request.setAttribute("id", id);
		request.setAttribute("staff", staff);

		return "/class/classContent.jsp";
	}
}
