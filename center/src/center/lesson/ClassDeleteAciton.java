package center.lesson;

import javax.servlet.http.HttpServletResponse;
import center.action.SuperAction;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;

public class ClassDeleteAciton implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String pw= request.getParameter("pw");
		
		int check = 0;
		ClassDAO dao = ClassDAO.getInstance();

		try {
			check = dao.deleteClass(num, pw);
		} catch (Exception e) {

			e.printStackTrace();
		}

		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("check", new Integer(check));

		return "/class/classDelete.jsp";

	}

}
