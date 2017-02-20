package center.myQnaPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MyQnaDeleteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		String num = request.getParameter("num");
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		
		return "/myQnaPost/myQnaDeleteForm.jsp";
	}

}
