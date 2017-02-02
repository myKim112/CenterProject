package center.lesson;

import center.staff.*;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import center.action.SuperAction;
import center.lesson.ClassDAO;

public  class ClassListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response){
	
		
		String id = request.getParameter("id");
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
		
		StaffDTO staff = null;
		List<ClassDTO> articleList=null;
		ClassDAO dao = ClassDAO.getInstance();
		StaffDAO dao1 = StaffDAO.getInstance();
		try {
			count = dao.getArticleCount();
			staff =  dao1.getTeacher(id);
			if(count > 0){
				articleList = dao.getArticles(startRow, endRow);
			}else{
				articleList =Collections.emptyList();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}number= count-(currentPage-1)*pageSize;
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
        request.setAttribute("id", id);
        request.setAttribute("staff", staff);
        
		return "/class/classList.jsp";
		}
	}
	

