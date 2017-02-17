package center.join;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.classApp.AppDAO;
import center.classApp.AppDTO;

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
		String id = request.getParameter("id");
		
		List<AppDTO> articleList = null;
		AppDAO dbPro = AppDAO.getInstance();
		
		try {
			articleList = dbPro.getAppList(id);
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
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("articleList", articleList);
		

		return "/memManage/memClassList.jsp";
	}
}
