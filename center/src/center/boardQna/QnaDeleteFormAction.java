package center.boardQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaDeleteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		String num = request.getParameter("num");
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("num", num);
		
		return "/boardQna/qnaDeleteForm.jsp";
	}

}
