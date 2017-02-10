package center.cart;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.lesson.ClassDTO;

public class ClassCartListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "1";
		}
		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int count = 0;
		int number = 0;
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("centerId");
		String classCode = null;
		List<ClassDTO> articleList = null;
		CartDAO dao = CartDAO.getInstance();

		try {
			count = dao.getArticleCount(number);

			if (count > 0) {
				articleList = dao.getCartArticles(id);
			} else {
				articleList = Collections.emptyList();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		number = count - (currentPage - 1) * pageSize;

		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);

		return "/cart/classCartList.jsp";
	}
}
