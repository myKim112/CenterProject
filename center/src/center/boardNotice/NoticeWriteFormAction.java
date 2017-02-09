package center.boardNotice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class NoticeWriteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		//int num = Integer.parseInt(request.getParameter("num"));
		
		//request.setAttribute("num", new Integer(num));

		return "/boardNotice/noticeWriteForm.jsp";
	}

}
