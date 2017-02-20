package center.boardReview;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import center.action.SuperAction;

public class ReviewWriteProAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

			String path = request.getRealPath("save");
			int max = 1024*1024*10;
			String enc = "UTF-8";
			DefaultFileRenamePolicy df = new DefaultFileRenamePolicy();
			
			System.out.println(path);
		
	       try {
			request.setCharacterEncoding("UTF-8");
			
				try {
					MultipartRequest multi = new MultipartRequest(request, path, max, enc, df);
					
					ReviewDTO article = new ReviewDTO();//单捞磐贸府 后
					
					article.setOrgName(multi.getOriginalFileName("save"));
					article.setSysName(multi.getFilesystemName("save"));
					
					article.setNum(Integer.parseInt(multi.getParameter("num")));
					article.setCenter(multi.getParameter("center"));
					article.setWriter(multi.getParameter("writer"));
					article.setPw(multi.getParameter("pw"));
					article.setTitle(multi.getParameter("title"));
					article.setContent(multi.getParameter("content"));
					article.setRegDate(new Timestamp(System.currentTimeMillis()));
					article.setRef(Integer.parseInt(multi.getParameter("ref")));
					article.setReStep(Integer.parseInt(multi.getParameter("reStep")));
					article.setReLevel(Integer.parseInt(multi.getParameter("reLevel")));
					
					//article.setNum(Integer.parseInt(request.getParameter("num")));
					//article.setCenter(request.getParameter("center"));
			        //article.setWriter(request.getParameter("writer"));
			        //article.setPw(request.getParameter("pw"));
			        //article.setTitle(request.getParameter("title"));
			        //article.setContent(request.getParameter("content"));
			        //article.setRegDate(new Timestamp(System.currentTimeMillis()));
					//article.setRef(Integer.parseInt(request.getParameter("ref")));
					//article.setReStep(Integer.parseInt(request.getParameter("reStep")));
					//article.setReLevel(Integer.parseInt(request.getParameter("reLevel")));

			        ReviewDAO dbPro = ReviewDAO.getInstance();//DB贸府
			        try {
						dbPro.insertArticle(article);
					} catch (Exception e) {
						e.printStackTrace();
					}		
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}//茄臂 牢内爹
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		return "/boardReview/reviewWritePro.jsp";
	}

}
