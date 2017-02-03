package center.boardNotice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class NoticeDeleteProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
    	String num = request.getParameter("num");
    	
    	NoticeDAO dao = NoticeDAO.getInstance();
    	boolean result = dao.deleteId(num);
    	request.setAttribute("pageNum", pageNum);
    	request.setAttribute("result", result);
		
    	return "/boardNotice/noticeDeletePro.jsp";
	}
}
