package center.lesson;

	import javax.servlet.http.HttpServletResponse;
	import center.action.SuperAction;

import java.io.File;
import java.io.UnsupportedEncodingException;
	import javax.servlet.http.HttpServletRequest;

	public class ClassDeleteAction  implements SuperAction {
		public String executeAction(HttpServletRequest request, HttpServletResponse response) {

			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			

			request.setAttribute("num", new Integer(num));
			request.setAttribute("pageNum", new Integer(pageNum));
		

			return "/class/classDelete.jsp";

		}

	}