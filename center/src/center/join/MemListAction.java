package center.action;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.flowers.JoinDAO;

public class MemListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int pageSize=10;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		List articleList = null;
		int num = Integer.parseInt(request.getParameter("num"));
		
		JoinDAO dbPro = JoinDAO.getInstance();
		
		try {
			count = dbPro.getMemberCount();
			
			if(count > 0) {
				articleList = dbPro.getMemberArticle(startRow, endRow);
			} else {
				articleList = Collections.EMPTY_LIST;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		number = count-(currentPage-1)*pageSize;
		
		request.setAttribute("currentPage", new Integer(currentPage));
        request.setAttribute("startRow", new Integer(startRow));
        request.setAttribute("endRow", new Integer(endRow));
        request.setAttribute("count", new Integer(count));
        request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
        request.setAttribute("articleList", articleList);
        request.setAttribute("num", new Integer(num));
		
		return "/memManage/memList.jsp";
	}
}
