package center.boardNotice;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class NoticeWriteProAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			NoticeDTO article = new NoticeDTO();
			article.setTitle(request.getParameter("title"));
			article.setCenter(request.getParameter("center"));
			article.setContent(request.getParameter("content"));
			article.setRegDate(new Timestamp(System.currentTimeMillis()));
			
			NoticeDAO dao = NoticeDAO.getInstance();
			try {
				dao.insertArticle(article);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "/boardNotice/noticeWritePro.jsp";
	}

}
