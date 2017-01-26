package center.lesson;


import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.lesson.ClassDAO;

public class ClassListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response){
	
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null){
			pageNum="1";
		}
		int pageSize= 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1) * pageSize;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number= 0;
		
		List articleList=null;
		ClassDAO dao = ClassDAO.getInstance();
		try {
			count = dao.getArticleCount();
			if(count > 0){
				articleList = dao.getArticles(startRow, endRow);
			}else{
				articleList =Collections.EMPTY_LIST;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}number= count-(currentPage-1)*pageSize;
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
        
		return "/class/classList.jsp";
		}
	}

