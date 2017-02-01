package center.lesson;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

public class ClassWriteProAction implements SuperAction {// 涝仿等 臂 贸府

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} // 茄臂 牢内爹

		ClassDTO dto = new ClassDTO();// 单捞磐贸府 后
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setCenter(request.getParameter("center"));
		dto.setClassCode(request.getParameter("classCode"));
		dto.setClassName(request.getParameter("classname"));
		dto.setTeacher(request.getParameter("teacher"));
		dto.setClassDate(request.getParameter("classDate"));
		dto.setClassTime(request.getParameter("classTime"));
		dto.setClassPay(Integer.parseInt(request.getParameter("classPay")));
		dto.setPerson(Integer.parseInt(request.getParameter("person")));
		dto.setLev(request.getParameter("lev"));
		dto.setState(request.getParameter("state"));
		dto.setClassSummary(request.getParameter("ClassSummary"));
		dto.setClassPlan(request.getParameter("ClassPlan"));
		dto.setReference(request.getParameter("reference"));

		ClassDAO dao = ClassDAO.getInstance();// DB贸府
		try {
			dao.insertClass(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/class/classWritePro.kiki";
	}
}
