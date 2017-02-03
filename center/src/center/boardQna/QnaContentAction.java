package center.boardQna;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaContentAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		QnaDAO dao = QnaDAO.getInstance();
		
		QnaDTO article;
		try {
			article = dao.getArticle(num);
			request.setAttribute("num", num);
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article", article);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boardQna/qnaContent.jsp";
	}

}
