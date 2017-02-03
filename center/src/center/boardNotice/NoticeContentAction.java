package center.boardNotice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class NoticeContentAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
	
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		NoticeDTO article;
		try {
			article = dao.getArticle(num);
			request.setAttribute("num", new Integer(num));
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article", article);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boardNotice/noticeContent.jsp";
	}

	
	
}
