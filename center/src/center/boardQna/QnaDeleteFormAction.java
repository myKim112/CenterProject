package center.boardQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaDeleteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", new Integer(num));
		
		return "/boardQna/qnaDeleteForm.jsp";
	}

}
