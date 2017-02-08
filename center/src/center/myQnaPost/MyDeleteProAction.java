package center.myQnaPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MyDeleteProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
    	String num = request.getParameter("num");
    	
    	MyQnaDAO dao = MyQnaDAO.getInstance();
    	boolean result = dao.deleteId(num);
    	request.setAttribute("pageNum", pageNum);
    	request.setAttribute("result", result);
		
    	return "/myPost/myDeletePro.jsp";
	}
}
