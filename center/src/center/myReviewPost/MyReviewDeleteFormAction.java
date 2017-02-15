package center.myReviewPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MyReviewDeleteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		String num = request.getParameter("num");
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		
		return "/myReviewPost/myReviewDeleteForm.jsp";
	}

}
