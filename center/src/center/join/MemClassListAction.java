package center.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemClassListAction implements SuperAction {
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
		
		/*
		 *  ���� ���� �ҷ�����
		 *  
		 *  ��� �ϳİ��������..
		 */
		return "/memManage/memClassList.jsp";
	}
}
