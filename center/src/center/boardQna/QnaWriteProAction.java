package center.boardQna;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaWriteProAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		
		
			try {
				int num=Integer.parseInt(request.getParameter("num"));
        		int ref=Integer.parseInt(request.getParameter("ref"));
        		int reStep=Integer.parseInt(request.getParameter("reStep"));
        		int reLevel=Integer.parseInt(request.getParameter("reLevel"));
        		
				request.setCharacterEncoding("UTF-8");
				QnaDTO article = new QnaDTO();
				article.setNum(num);			
				article.setWriter(request.getParameter("writer"));
				article.setTitle(request.getParameter("title"));
				article.setCenter(request.getParameter("center"));
				article.setContent(request.getParameter("content"));
				article.setRegDate(new Timestamp(System.currentTimeMillis()));
				article.setPw(request.getParameter("pw"));
				article.setRef(ref);
				article.setReStep(reStep);
				article.setReLevel(reLevel);	
				
				
				
				
				QnaDAO dao = QnaDAO.getInstance();
				dao.insertArticle(article);
								
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return "/boardQna/qnaWritePro.jsp";
	}

}
