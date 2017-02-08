package center.boardQna;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaWriteProAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		
			try {
				request.setCharacterEncoding("UTF-8");
				QnaDTO article = new QnaDTO();
				article.setNum(Integer.parseInt(request.getParameter("num")));			
				article.setWriter(request.getParameter("writer"));
				article.setTitle(request.getParameter("title"));
				article.setCenter(request.getParameter("center"));
				article.setContent(request.getParameter("content"));
				article.setRegDate(new Timestamp(System.currentTimeMillis()));
				article.setPw(request.getParameter("pw"));
				article.setRef(Integer.parseInt(request.getParameter("ref")));
				article.setReStep(Integer.parseInt(request.getParameter("reStep")));
				article.setReLevel(Integer.parseInt(request.getParameter("reLevel")));			
				
				try {
					QnaDAO dao = QnaDAO.getInstance();
					dao.insertArticle(article);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			return "/boardQna/qnaWritePro.jsp";
	}

}
