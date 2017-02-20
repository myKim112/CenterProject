package center.classApp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

public class AppListAction implements SuperAction {
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
		String [] classCode = request.getParameterValues("classCode");
		AppDAO dao = AppDAO.getInstance();
		ClassDTO dto =null;
		
		List<ClassDTO> classList = new ArrayList<ClassDTO>();
		try {
			if(classCode.length == 1){
				count = dao.getArticleCount(classCode[0]);
				if (count > 0) {
						ClassDAO cdao = ClassDAO.getInstance();
						classList.add(cdao.getClassCode(classCode[0]));		
				}
			}else{
				for(String cc : classCode){
					count = dao.getArticleCount(cc);
					if (count > 0) {
							ClassDAO cdao = ClassDAO.getInstance();
							classList.add(cdao.getClassCode(cc));
					}
				}
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
		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);
		request.setAttribute("classList", classList);
		//System.out.println(classCode);		
		request.setAttribute("classListCount", classList.size());
		

		
		return "/classApp/appList.jsp";
	}
}

