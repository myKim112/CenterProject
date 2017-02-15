package center.staff;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MemberCheckAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		String classCode = request.getParameter("classCode");
		String id = request.getParameter("id");
		int count = 0;
		List memberList = null;
//		List statusList = null;
		
		try {
			StaffDAO dbPro = StaffDAO.getInstance();
			
			count = dbPro.getMemberCount(classCode);	// ���ǿ� �ش��ϴ� ȸ�� �� 

			if(count > 0) {
				memberList = dbPro.getMemberArticles(classCode);	// ���ǿ� �ش��ϴ� ȸ�� ���
//				statusList = dbPro.getMemberStatus(classCode);
			} else {
				memberList = Collections.EMPTY_LIST;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("memberList", memberList);
		request.setAttribute("id", id);
//		request.setAttribute("statusList", statusList);
		
		return "/teacher/memberCheck.jsp";
	}
}
