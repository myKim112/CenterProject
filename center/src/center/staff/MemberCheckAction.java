package center.staff;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;

public class MemberCheckAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("centerId");
		int num = Integer.parseInt(request.getParameter("num"));
		int count = 0;
		List memberList = null;
		
		try {
			StaffDAO dbPro = StaffDAO.getInstance();
//			count = dbPro.getMemberCount();
			// ���ǿ� �ش��ϴ� ȸ�� �� 
			
			if(count > 0) {
//				memberList = dbPro.getMemberArticles();
				// ���ǿ� �ش��ϴ� ȸ�� ���
			} else {
				memberList = Collections.EMPTY_LIST;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("id", id);
		request.setAttribute("num", new Integer(num));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("memberList", memberList);
		
		return "/teacher/memberCheck.jsp";
	}
}
