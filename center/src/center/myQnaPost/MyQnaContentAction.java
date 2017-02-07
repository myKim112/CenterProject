package center.myQnaPost;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MyQnaContentAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		MyQnaDAO dao = MyQnaDAO.getInstance();
		
		MyQnaDTO article;
		try {
			article = dao.getArticle(num);
			request.setAttribute("num", num);
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("article", article);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/myQnaPost/myQnaContent.jsp";
	}

}
