package center.classApp;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

public class AppListProAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String num [] = request.getParameterValues("num");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("centerId");
		String classCode = request.getParameter("classCode");
		ClassDTO dto = null;
		try {
			ClassDAO dao = ClassDAO.getInstance();
			dto = dao.getClassCode(classCode);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);
		request.setAttribute("dto", dto);
		/*
		for(int i=0; i<num.length; i++){
			
			request.setAttribute("num[i]", num[i]);
			System.out.println(num[i]);
		}
		*/
		
	

		return "/classApp/appListPro.jsp";

	}
}
