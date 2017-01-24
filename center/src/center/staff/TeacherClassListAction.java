package center.staff;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.lesson.ClassDAO;

public class TeacherClassListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		int num = Integer.parseInt(request.getParameter("num"));
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		
		List staffList = null;
		ClassDAO dbPro = ClassDAO.getInstance();
		
		try {
//			count = dbPro.getTeacherClassCount(); // 해당 강사의 강좌 수
			// 해당 강사의 아이디를 입력 받은 것으로 검색 해야한다.
			
			if(count > 0) {
//				staffList = dbPro.getTeacherClassArticle(); // 해당 강사의 강의 목록
			} else {
				staffList = Collections.EMPTY_LIST;
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
		request.setAttribute("num", new Integer(num));
		request.setAttribute("staffList", staffList);
		request.setAttribute("id", id);
		
		return "/teacherManage/teacherClassList.jsp";
	}
}
