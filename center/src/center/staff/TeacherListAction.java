package center.staff;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class TeacherListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		int pageSize=10;
		
//		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		
		List staffList = null;
		StaffDAO dbPro = StaffDAO.getInstance();
		
		try {
			count = dbPro.getTeacherCount();
			
			if(count > 0) {
				staffList = dbPro.getTeacherArticle(startRow, endRow);
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
//		request.setAttribute("num", new Integer(num));
		
		return "/teacherManage/teacherList.jsp";
	}
}
