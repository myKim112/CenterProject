package center.lesson;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ClassManageAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			String pageNum = request.getParameter("pageNum");
			
			if(pageNum == null){
				pageNum="1";
			}
			
			String searchContent = request.getParameter("searchContent");
			int search = 0;
			int pageSize= 10;
			int currentPage = Integer.parseInt(pageNum);
			int startRow = (currentPage -1) * pageSize;
			int endRow = currentPage * pageSize;
			int count = 0;
			int number= 0;
			
			
			if(searchContent == null) {
				searchContent = "";
			} else {
				search = Integer.parseInt(request.getParameter("search"));
			}
			
			ClassDAO dao = ClassDAO.getInstance();
			List<ClassDTO> articleList = null;
			
			if(searchContent.equals("") || searchContent == null) {
				count = dao.getArticleCount();
			} else {
				count = dao.getArticleCont(search, searchContent);
			}
			
			if(count > 0){
				if(searchContent.equals("") || searchContent == null) {
					articleList = dao.getArticles(startRow, endRow);
				} else {
					articleList = dao.getArticles(startRow, endRow, search, searchContent);
				}
			}else{
				articleList =Collections.emptyList();
			}
			
			number= count-(currentPage-1)*pageSize;
			
			request.setAttribute("currentPage", new Integer(currentPage));
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("articleList", articleList);
			request.setAttribute("pageNum", pageNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "/teacherManage/classManage.jsp";
	}
}
