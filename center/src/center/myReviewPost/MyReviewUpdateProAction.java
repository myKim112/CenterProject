package center.myReviewPost;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import center.boardReview.*;
import center.action.SuperAction;

public class MyReviewUpdateProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
        try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

        String pageNum = request.getParameter("pageNum");
        //int ref = Integer.parseInt(request.getParameter("ref"));
       // System.out.println(ref);
        //int reLevel = Integer.parseInt(request.getParameter("reLevel"));
        //int reStep = Integer.parseInt(request.getParameter("reStep"));

        ReviewDTO article = new ReviewDTO();
        article.setNum(Integer.parseInt(request.getParameter("num")));
        article.setWriter(request.getParameter("writer"));
        article.setCenter(request.getParameter("center"));
        article.setTitle(request.getParameter("title"));
        article.setContent(request.getParameter("content"));
        article.setPw(request.getParameter("pw"));
        //article.setRef(Integer.parseInt(request.getParameter("ref")));
        //article.setReLevel(Integer.parseInt(request.getParameter("reLevel")));
        //article.setReStep(Integer.parseInt(request.getParameter("reStep")));
   
        ReviewDAO dbPro = ReviewDAO.getInstance();
        int check;
		try {
			check = dbPro.updateArticle(article);

	        request.setAttribute("pageNum", new Integer(pageNum));
	        request.setAttribute("check", new Integer(check));
	        //request.setAttribute("ref", new Integer(ref));
	        //request.setAttribute("reLevel", new Integer(reLevel));
	        //request.setAttribute("reStep", new Integer(reStep));
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/myReviewPost/myReviewUpdatePro.jsp";
	}

}