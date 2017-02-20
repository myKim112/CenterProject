package center.boardReview;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import center.action.SuperAction;

public class ReviewUpdateProAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		//String pageNum = request.getParameter("pageNum");
		//String num = request.geMulti("num");	
		//System.out.println("num = " + num);
		
		String path = request.getRealPath("save");
		int max = 1024*1024*10;
		String enc = "UTF-8";
		DefaultFileRenamePolicy df = new DefaultFileRenamePolicy();		
		
	       try {
			request.setCharacterEncoding("UTF-8");
			MultipartRequest multi;
			try {
				multi = new MultipartRequest(request, path, max, enc, df);
			ReviewDTO article = new ReviewDTO();
		        
				String orgName = multi.getOriginalFileName("save");
				String sysName =multi.getFilesystemName("save");	
				
				String pageNum = multi.getParameter("pageNum");
				int num = Integer.parseInt(multi.getParameter("num"));
				String writer = multi.getParameter("writer");
				String center = multi.getParameter("center");
				String title = multi.getParameter("title");
				String content = multi.getParameter("content");
				String pw = multi.getParameter("pw");
			    
				article.setNum(num);
				article.setWriter(writer);
				article.setCenter(center);
				article.setTitle(title);
				article.setContent(content);
				article.setPw(pw);
				article.setOrgName(orgName);
				article.setSysName(sysName);

				request.setAttribute("num", new Integer(num));   
				request.setAttribute("pageNum", new Integer(pageNum));				
				
				try {
				ReviewDAO dbPro = ReviewDAO.getInstance();
		        int check;
					if(sysName != null){
						check = dbPro.updateArticle(article);
						request.setAttribute("check", new Integer(check));						
					}else if(sysName == null){
						check = dbPro.updateArticlePlus(article);
						request.setAttribute("check", new Integer(check));						
					}

				} catch (Exception e) {
					e.printStackTrace();
				}				
	
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			
	       
		return "/boardReview/reviewUpdatePro.jsp";
	}

}
