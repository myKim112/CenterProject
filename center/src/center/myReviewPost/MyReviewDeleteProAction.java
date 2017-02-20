package center.myReviewPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MyReviewDeleteProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
    	String num = request.getParameter("num");
    	
    	MyReviewDAO dao = MyReviewDAO.getInstance();
 //   	boolean result = dao.deleteId(num);
    	request.setAttribute("pageNum", pageNum);
//    	request.setAttribute("result", result);
		
    	return "/myReviewPost/myReviewDeletePro.jsp";
	}
}
