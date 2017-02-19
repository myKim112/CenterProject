package center.boardQna;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaListAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response){
		
		try {
			request.setCharacterEncoding("UTF-8");
			String pageNum = request.getParameter("pageNum");
			
			if(pageNum == null) {
				pageNum = "1";
			}
			
			int pageSize = 10;//한 페이지의 글의 개수
			int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//한 페이지의 시작글 번호
	        int endRow = currentPage * pageSize;//한 페이지의 마지막 글번호
	        int count=0;
	        int number=0;
	        
	        List articleList = null;
	        
	        String search = request.getParameter("search");
	        int searchn = 0;
	        
	        if(search == null) {
	        	search = "";
	        } else {
	        	searchn = Integer.parseInt(request.getParameter("searchn"));
	        }
	        
	        QnaDAO dao = QnaDAO.getInstance();
	        
	        if(search.equals("") || search == null) {
	        	count = dao.getArticleCount();
	        } else {
	        	count = dao.getArticleCount(searchn ,search);
	        }
	        
	        if (count > 0) {
	        	if(search.equals("") || search ==null) {
	        		articleList = dao.getArticles(startRow, endRow);
	        	} else {
	        		articleList = dao.getArticles(startRow, endRow, searchn, search);
	        	}
		    } else {
			     articleList = Collections.EMPTY_LIST;
			}
				
			number = count - (currentPage - 1)*pageSize;	//글목록에 표시할 글번호
			        
			request.setAttribute("pageNum", new Integer(pageNum));
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("startRow", new Integer(startRow));
			request.setAttribute("endRow", new Integer(endRow));
			request.setAttribute("count", new Integer(count));
			request.setAttribute("pageSize", new Integer(pageSize));
			request.setAttribute("number", new Integer(number));
			request.setAttribute("articleList", articleList); 	
						        
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/boardQna/qnaList.jsp";
	}

}
