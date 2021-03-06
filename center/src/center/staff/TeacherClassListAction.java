package center.staff;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.staff.StaffDAO;

public class TeacherClassListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
//		int num = Integer.parseInt(request.getParameter("num"));
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		if(id == null) {
			HttpSession session = request.getSession();
			id = (String)session.getAttribute("centerId");
		}
				
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		
		List classList = null;
		StaffDAO dbPro = StaffDAO.getInstance();
		
		try {
			count = dbPro.getTeacherClassCount(id); // 해당 강사의 강좌 수

			
			if(count > 0) {
				classList = dbPro.getTeacherClassArticle(startRow, endRow, id); // 해당 강사의 강좌 목록
			} else {
				classList = Collections.EMPTY_LIST;
			}					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		number = count-(currentPage-1)*pageSize; //글 목록에 표시할 번호
		
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
//		request.setAttribute("num", new Integer(num));
		request.setAttribute("classList", classList);
		request.setAttribute("id", id);
		
		return "/teacherManage/teacherClassList.jsp";
	}
}
