package center.boardReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ReviewDeleteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");

		//해당 뷰에서 사용할 속성
		request.setAttribute("num", new Integer(num));
        request.setAttribute("pageNum", new Integer(pageNum));		
		
		return "/boardReview/reviewDeleteForm.jsp";
	}

}
