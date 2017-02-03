package center.boardQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaDeleteProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
    	String pw = request.getParameter("pw");
    	String num = request.getParameter("num");
    	
    	System.out.println(num);
    	
    	QnaDAO dao = QnaDAO.getInstance();
    	boolean result = dao.deleteId(num, pw);
    	request.setAttribute("pageNum", pageNum);
    	request.setAttribute("result", result);
		
    	return "/boardQna/qnaDeletePro.jsp";
	}

}
