package center.lesson;

import center.staff.*;
import center.power.*;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.lesson.ClassDAO;

public  class ClassListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response){
		try{
			request.setCharacterEncoding("UTF-8");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		String pageNum = request.getParameter("pageNum");
		String searchContent = request.getParameter("searchContent");
		int search = 0;
		
		if(pageNum == null){
			pageNum="1";
		}
		
		if(searchContent == null) {
			searchContent = "";
		} else {
			search = Integer.parseInt(request.getParameter("search"));
		}
		int pageSize= 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1) * pageSize;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number= 0;
		
		StaffDTO staff = null;
		PowerDTO power = null;
		List<ClassDTO> articleList=null;
		ClassDAO dao = ClassDAO.getInstance();
		StaffDAO dao1 = StaffDAO.getInstance();
		
		try {
			power = dao1.getTeacherLev(id);

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
		}catch (Exception e) {
			e.printStackTrace();
		}
		number= count-(currentPage-1)*pageSize;
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
        request.setAttribute("id", id);
        request.setAttribute("staff", staff);
        request.setAttribute("power", power);
        request.setAttribute("pageNum", pageNum);
        
		return "/class/classList.jsp";
		}
	}
	

