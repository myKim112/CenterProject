package center.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class MemInfAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pageNum = request.getParameter("pageNum");
		
		JoinDAO dbPro = JoinDAO.getInstance();
		JoinDTO article = null;
		
		try{
			article = dbPro.getMember(id);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
		
		return "/memManage/memInf.jsp";
	}
}