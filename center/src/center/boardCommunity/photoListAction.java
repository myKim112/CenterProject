package center.boardCommunity;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;
import center.boardReview.ReviewDAO;

public class photoListAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		       String pageNum = request.getParameter("pageNum");//페이지 번호
		       
		        if (pageNum == null) {
		            pageNum = "1";
		        }
		        
		        int pageSize = 10;//한 페이지의 글의 개수
		        int currentPage = Integer.parseInt(pageNum);
		        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
		        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
		        int count = 0;
		        int number=0;

		        List articleList = null;
		        PhotoDAO dbPro = PhotoDAO.getInstance();//DB연동

		        try{
			        if (count > 0) {
			    			articleList = dbPro.getArticles(startRow, endRow);
			        } else {
			            articleList = Collections.EMPTY_LIST;
			        }	        

						number=count-(currentPage-1)*pageSize;//글목록에 표시할 글번호
				        //해당 뷰에서 사용할 속성
				        request.setAttribute("currentPage", new Integer(currentPage));
				        request.setAttribute("startRow", new Integer(startRow));
				        request.setAttribute("endRow", new Integer(endRow));
				        request.setAttribute("count", new Integer(count));
				        request.setAttribute("pageSize", new Integer(pageSize));
						request.setAttribute("number", new Integer(number));
				        request.setAttribute("articleList", articleList);
		        
		        }catch(Exception e){}				
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}		
		
		return "/boardCommunity/photoList.jsp";
	}

}
