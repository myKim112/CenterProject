package center.boardQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaDeleteProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
    	String pw = request.getParameter("pw");
    	int num = Integer.parseInt(request.getParameter("num"));
    	
    	System.out.println(num);
    	
    	QnaDAO dao = QnaDAO.getInstance();
    	int result = dao.deleteId(num, pw);
    	System.out.println(result);
    	
    	request.setAttribute("pageNum", pageNum);
    	request.setAttribute("result", new Integer(result));
		
    	return "/boardQna/qnaDeletePro.jsp";
	}

}
