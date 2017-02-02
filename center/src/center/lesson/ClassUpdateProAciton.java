package center.lesson;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import center.action.SuperAction;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

public class ClassUpdateProAciton implements SuperAction {// �Էµ� �� ó��

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		String pageNum = request.getParameter("pageNum");
		String num = request.getParameter("num");
		String path = request.getRealPath("classSave");
		int max = 1024 * 1024 * 10;
		String enc = "UTF-8";
		DefaultFileRenamePolicy df = new DefaultFileRenamePolicy();
		


		try {
			
			request.setCharacterEncoding("UTF-8");
			MultipartRequest multi = new MultipartRequest(request, path, max, enc, df);
			ClassDTO dto = new ClassDTO();

			int number = Integer.parseInt(multi.getParameter("num"));
			String center = multi.getParameter("center");
			String classCode = multi.getParameter("classCode");
			String className = multi.getParameter("className");
			String teacher = multi.getParameter("teacher");
			String classDate = multi.getParameter("classDate");
			String classTime = multi.getParameter("classTime");
			String classPay = multi.getParameter("classpay");
			int person = Integer.parseInt(multi.getParameter("person"));
			String lev = multi.getParameter("lev");
			String state = multi.getParameter("state");
			String classSummary = multi.getParameter("classSummary");
			String classPlan = multi.getParameter("classPlan");
			String reference = multi.getParameter("reference");
			String pw = multi.getParameter("pw");
			File classSave = multi.getFile("save");
			String ct = multi.getContentType("save"); 
			String org = multi.getOriginalFileName("save");
			String sys = multi.getFilesystemName("save");

			dto.setNum(number);
			dto.setCenter(center);
			dto.setClassCode(classCode);
			dto.setClassName(className);
			dto.setTeacher(teacher);
			dto.setClassDate(classDate);
			dto.setClassTime(classTime);
			dto.setClassPay(classPay);
			dto.setPerson(person);
			dto.setLev(lev);
			dto.setState(state);
			dto.setClassSummary(classSummary);
			dto.setClassPlan(classPlan);
			dto.setReference(reference);
			dto.setPw(request.getParameter("pw"));
			dto.setOrgName(org);
			dto.setSysName(sys);

			ClassDAO dao = ClassDAO.getInstance();
			if(sys !=null){
			dao.updateClass(dto);
			}else if(sys == null){
				dao.updateClass(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("num", num);
		request.setAttribute("pageNum", new Integer(pageNum));
		
		return "/class/classUpdatePro.jsp";
	}
}

