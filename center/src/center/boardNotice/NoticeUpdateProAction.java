package center.boardNotice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class NoticeUpdateProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
        try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

        String pageNum = request.getParameter("pageNum");

        NoticeDTO article = new NoticeDTO();
        article.setNum(Integer.parseInt(request.getParameter("num")));
        article.setCenter(request.getParameter("center"));
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
   
        NoticeDAO dbPro = NoticeDAO.getInstance();
        int check;
		try {
			check = dbPro.updateArticle(article);
	        request.setAttribute("pageNum", new Integer(pageNum));
	        request.setAttribute("check", new Integer(check));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boardNotice/noticeUpdatePro.jsp";
	}

}
