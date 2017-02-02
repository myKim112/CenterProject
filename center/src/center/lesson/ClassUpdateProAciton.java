package center.lesson;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import center.action.SuperAction;
import center.lesson.ClassDAO;
import center.lesson.ClassDTO;

public class ClassUpdateProAciton implements SuperAction {// 입력된 글 처리

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		String path = request.getRealPath("classSave");
		int max = 1024 * 1024 * 10;
		String enc = "UTF-8";
		DefaultFileRenamePolicy df = new DefaultFileRenamePolicy();
		String pageNum=request.getParameter("pageNum");
		ClassDTO dto = null;

		try {
			ClassDAO dao = ClassDAO.getInstance();
			dto = new ClassDTO();
			MultipartRequest multi = new MultipartRequest(request, path, max, enc, df);

			int num = Integer.parseInt(multi.getParameter("num"));
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
			File classSave = multi.getFile("classSave");
			String ct = multi.getContentType("classSave"); 
			String org = multi.getOriginalFileName("classSave");
			String sys = multi.getFilesystemName("classSave");

			dto.setNum(Integer.parseInt(request.getParameter("num")));
			dto.setCenter(request.getParameter("center"));
			dto.setClassCode(request.getParameter("classCode"));
			dto.setClassName(request.getParameter("className"));
			dto.setTeacher(request.getParameter("teacher"));
			dto.setClassDate(request.getParameter("classDate"));
			dto.setClassTime(request.getParameter("classTime"));
			dto.setClassPay(request.getParameter("classPay"));
			dto.setPerson(Integer.parseInt(request.getParameter("person")));
			dto.setLev(request.getParameter("lev"));
			dto.setState(request.getParameter("state"));
			dto.setClassSummary(request.getParameter("classSummary"));
			dto.setClassPlan(request.getParameter("classPlan"));
			dto.setReference(request.getParameter("reference"));
			dto.setPw(request.getParameter("pw"));
			dto.setOrgName(request.getParameter("org"));
			dto.setSysName(request.getParameter("sys"));

			dao.updateClass(dto);

			request.setAttribute("sys", sys);
			request.setAttribute("pageNum", new Integer(pageNum));
			System.out.println(path);
			System.out.println(center);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/class/classUpdatePro.jsp";
	}
}
