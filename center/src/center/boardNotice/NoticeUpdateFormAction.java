package center.boardNotice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class NoticeUpdateFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));

        NoticeDAO dbPro = NoticeDAO.getInstance();
       
        try {
			NoticeDTO article =  dbPro.updateGetArticle(num);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("num", num);
	        request.setAttribute("article", article);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return "/boardNotice/noticeUpdateForm.jsp";
	}

}
