package center.boardReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ReviewUpdateFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

	            int num = Integer.parseInt(request.getParameter("num"));
	            String pageNum = request.getParameter("pageNum");

	            ReviewDAO dbPro = ReviewDAO.getInstance();
	            ReviewDTO article;
				try {
					article = dbPro.updateGetArticle(num);
		    		//�ش� �信�� ����� �Ӽ�
		            request.setAttribute("pageNum", new Integer(pageNum));
		            request.setAttribute("article", article);					
				} catch (Exception e) {
					e.printStackTrace();
				}

		return "/boardReview/reviewUpdateForm.jsp";
	}

}
