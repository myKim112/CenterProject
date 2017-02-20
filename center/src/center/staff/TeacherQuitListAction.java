package center.staff;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherQuitListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int pageSize=10;
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		
		List staffList = null;
		
		try {
			StaffDAO dbPro = StaffDAO.getInstance();
			
			count = dbPro.getTeacherQuitCount();
			
			if(count > 0) {
				staffList = dbPro.getTeacherQuitArticle(startRow, endRow);
			} else {
				staffList = Collections.EMPTY_LIST;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		number = count-(currentPage-1)*pageSize;
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("number", new Integer(number));
		request.setAttribute("staffList", staffList);
		request.setAttribute("pageNum", pageNum);
		
		return "/teacherManage/teacherQuitList.jsp";
	}
}
