package center.boardReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ReviewContentAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
	
	      int num = Integer.parseInt(request.getParameter("num"));//해당 글번호
	        String pageNum = request.getParameter("pageNum");//해당 페이지 번호

	        ReviewDAO dbPro = ReviewDAO.getInstance();//DB처리
	        ReviewDTO article;
			try {
				article = dbPro.getArticle(num);
		        //해당 뷰에서 사용할 속성
		        request.setAttribute("num", new Integer(num));
		        request.setAttribute("pageNum", new Integer(pageNum));
		        request.setAttribute("article", article);
			} catch (Exception e) {
				e.printStackTrace();
			}//해당 글번호에 대한 해당 레코드
	  
		return "/boardReview/reviewContent.jsp";
	}

}
