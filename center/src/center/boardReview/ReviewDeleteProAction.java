package center.boardReview;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;

import center.action.SuperAction;

public class ReviewDeleteProAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
		
        try {
				request.setCharacterEncoding("UTF-8");
				int num = Integer.parseInt(request.getParameter("num"));
		        String pageNum = request.getParameter("pageNum");
		        String pw = request.getParameter("pw");
			    System.out.println(pw);
		       
			    ReviewDTO article = new ReviewDTO();
			    String path = request.getRealPath("save");
			    String sysName = request.getParameter("sysName");
			    System.out.println(sysName);
			    
		        ReviewDAO dbPro = ReviewDAO.getInstance();
				try {
					int check = dbPro.deleteArticle(num, pw);
					System.out.println(check);
			        //해당 뷰에서 사용할 속성
			        request.setAttribute("pageNum", new Integer(pageNum));
			        request.setAttribute("check", new Integer(check));	
			        
					File f = new File(path+"\\"+sysName);
					if(f.exists()) {
						f.delete();
					}
			        
				} catch (Exception e) {
					e.printStackTrace();
				}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return "/boardReview/reviewDeletePro.jsp";
	}

}
