package center.boardQna;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.staff.StaffDAO;
import center.staff.StaffDTO;

public class QnaContentAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
				
		
		QnaDTO article;
		try {
			QnaDAO dao = QnaDAO.getInstance();
			StaffDAO manage = StaffDAO.getInstance();
			StaffDTO staff = manage.getLev(id);
			
			article = dao.getArticle(num);
			request.setAttribute("num", num);
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article", article);
			request.setAttribute("id", id);
			request.setAttribute("staff", staff);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boardQna/qnaContent.jsp";
	}

}
