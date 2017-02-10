package center.classApp;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.lesson.ClassDTO;

public class AppSucProAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("centerId");
		String classCode = request.getParameter("classCode");
		int sum = Integer.parseInt(request.getParameter("sum"));
		int status = Integer.parseInt(request.getParameter("status"));
		int memberCount = Integer.parseInt(request.getParameter("memberCount"));

		
		try {
			AppDAO dao = AppDAO.getInstance();
			AppDTO dto = new AppDTO();
			dto.setId(id);
			dto.setClassCode(classCode);
			dto.setSum(sum);
			dto.setStatus(status);
			dto.setMemberCount(memberCount);
			dao.insertAppActicle(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);
		return "/classApp/appSucPro.jsp";
	}
}

