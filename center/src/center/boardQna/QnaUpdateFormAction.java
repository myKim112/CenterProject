package center.boardQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaUpdateFormAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
        int num = Integer.parseInt(request.getParameter("num"));
        String pageNum = request.getParameter("pageNum");

		try {
			QnaDAO dbPro = QnaDAO.getInstance();
			QnaDTO article = dbPro.updateGetArticle(num);

			//해당 뷰에서 사용할 속성
		        request.setAttribute("pageNum", pageNum);
		        request.setAttribute("article", article);
		        request.setAttribute("num", new Integer(num));
		        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/boardQna/qnaUpdateForm.jsp";
	}

}
