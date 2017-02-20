package center.classApp;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import center.action.SuperAction;
import center.cart.CartDAO;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

public class AppSucAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("centerId");
		
		String [] classCode = request.getParameterValues("classCode");
		String [] sum =request.getParameterValues("classPay");
		String [] memberCount = request.getParameterValues("memberCount");
		
    	try{
		
        AppDAO dao = AppDAO.getInstance();
	    AppDTO dto = new AppDTO();   
	    CartDAO cdao= CartDAO.getInstance();
	    for(int a = 0 ; a < classCode.length; a++){
			dto.setId(id);
			dto.setClassCode(classCode[a]);
		    dto.setSum(sum[a]);
			dto.setStatus(1);
			dto.setMemberCount(Integer.parseInt(memberCount[a]));
			dto.setReg_date(new Timestamp(System.currentTimeMillis()));
			dao.insertAppActicle(dto);

			cdao.deleteCart(classCode[a]);
	    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("id", id);
		request.setAttribute("classCode", classCode);
		

		return "/classApp/appSuc.jsp";
	}
}

