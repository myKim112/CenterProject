package center.lesson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ClassUpdateAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response){
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		ClassDTO dto = null;
		
		try {
			ClassDAO dao = ClassDAO.getInstance();
			dto = dao.updateGetClass(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("dto", dto);
		
		
		return "/class/classUpdate.jsp";
		
	}
}
