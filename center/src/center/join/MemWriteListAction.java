package center.join;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MemWriteListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null) {
			pageNum = "1";
		}
		
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		int count = 0;
		int number = 0;
		
		List articleList = null;
		/* 해당 회원의 전체 글 보기 
		 * 
		 *  이제 해야해...*/
		
		return "/memManage/memWriteList.jsp";
	}
}
