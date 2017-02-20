package center.staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class TeacherInputFormAction implements SuperAction {
	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
	
		return "/teacherManage/teacherInputForm.jsp";
	}
}
