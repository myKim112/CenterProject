package center.boardCommunity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class photoWriteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

	         //int num = Integer.parseInt(request.getParameter("num"));
	         //request.setAttribute("num", new Integer(num));
		
		return "/boardCommunity/photoWriteForm.jsp";
	}

}
