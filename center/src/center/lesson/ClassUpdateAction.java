package center.lesson;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ClassUpdateAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		ClassDAO dao = ClassDAO.getInstance();
		
		try {
			
			ClassDTO dto = dao.updateGetClass(num);
			request.setAttribute("dto", dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", pageNum);
		
		
		
		return "/class/classUpdate.jsp";
		
	}
}
