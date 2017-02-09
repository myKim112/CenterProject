package center.classApp;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import center.action.SuperAction;

public class AppSucAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {


		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("centerId");
		String classCode = request.getParameter("classCode");
		int num = Integer.parseInt(request.getParameter("num"));
		try {
			AppDTO dto = new AppDTO();
			dto.setNum(num);
			dto.setId(id);
			dto.setClassCode(classCode);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
        request.setAttribute("num", num);
		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);
		
		return "/classApp/appSuc.jsp";
	}
}

