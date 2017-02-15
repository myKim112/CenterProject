package center.boardCommunity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import center.action.SuperAction;
import center.boardReview.ReviewDAO;
import center.boardReview.ReviewDTO;

public class photoWriteProAction implements SuperAction{

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
				
				PhotoDTO article = new PhotoDTO();//单捞磐贸府 后
				
				article.setOrgName(multi.getOriginalFileName("save"));
				article.setSysName(multi.getFilesystemName("save"));
				
				article.setNum(Integer.parseInt(multi.getParameter("num")));
				article.setTitle(multi.getParameter("title"));
				article.setContent(multi.getParameter("content"));
				
		        PhotoDAO dbPro = PhotoDAO.getInstance();//DB贸府
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
		
		return "/boardCommunity/photoWritePro.jsp";
	}

}
