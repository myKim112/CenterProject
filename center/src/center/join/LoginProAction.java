package center.join;
import center.controller.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.join.*;

public class LoginProAction implements SuperAction {
	
	public String executeAction(HttpServletRequest request, HttpServletResponse response) { 
		String id = request.getParameter("id");
		String pw  = request.getParameter("pw"); 
		JoinDAO manager = JoinDAO.getInstance(); 
		try {
			int check= manager.userCheck(id,pw);
			if(check==1){ 
				
				HttpSession session = request.getSession(); 
				session.setAttribute("centerId",id);
			}	
			request.setAttribute("check", new Integer(check)); 
			
		
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return "/join/loginPro.jsp";
	}
}