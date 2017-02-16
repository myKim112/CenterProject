package center.join;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import center.action.SuperAction;
import center.classApp.AppDAO;
import center.classApp.AppDTO;


public class MyClassListAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
	

			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("centerId");
			int number =0;
			String pageNum = request.getParameter("pageNum"); 
			AppDAO dao = AppDAO.getInstance();
			String classCode = request.getParameter("classCode");
			
			if(pageNum == null) {
				pageNum = "1";
			}
			
			List<AppDTO> articleList = null;
			articleList = dao.getAppList(id);
			System.out.println(id);
			
			
			request.setAttribute("articleList",articleList);
			request.setAttribute("count",articleList.size());
			request.setAttribute("classCode", classCode);
		    request.setAttribute("number",number);
		    request.setAttribute("pageNum", pageNum);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
			return"/myPage/myClassList.jsp";
		
	}
}


