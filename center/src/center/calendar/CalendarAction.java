package center.calendar;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import center.action.SuperAction;
import center.staff.StaffDAO;
import center.staff.StaffDTO;

public class CalendarAction implements SuperAction{
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("centerId");
					
			CalendarDAO dbPro = CalendarDAO.getInstance();
			StaffDAO manage = StaffDAO.getInstance();
			
			StaffDTO staff = new StaffDTO();
			ArrayList<CalendarDTO> calList = dbPro.getSchedule();
			
			staff = manage.getLev(id);
			
			request.setAttribute("calList", calList);
			request.setAttribute("staff", staff);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "/calendar/calendar.jsp";
	}
}
