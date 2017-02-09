package center.lesson;

	import javax.servlet.http.HttpServletResponse;
	import center.action.SuperAction;


	import javax.servlet.http.HttpServletRequest;

	public class ClassDeleteProAction  implements SuperAction {
		public String executeAction(HttpServletRequest request, HttpServletResponse response) {

			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			String pw= request.getParameter("pw");
		
				ClassDAO dao = ClassDAO.getInstance();
				int check=0;
				try {
					check = dao.deleteClass(num,pw);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("check", new Integer(check));
            
			return "/class/classDeletePro.jsp";

		}

	}
