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
			
			int pageSize = 10;//�� �������� ���� ����
			int currentPage = Integer.parseInt(pageNum);
	        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
	        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
	        int count=0;
	        int number=0;
	        
	        List articleList = null;
	        QnaDAO dao = QnaDAO.getInstance();
	        
			try {
				count = dao.getArticleCount();
		        if (count > 0) {
			    			try {
								articleList = dao.getArticles(startRow, endRow);
							} catch (Exception e) {
								e.printStackTrace();
							}
			        } else {
			            articleList = Collections.EMPTY_LIST;
			        }
				
			        number = count - (currentPage - 1)*pageSize;	//�۸�Ͽ� ǥ���� �۹�ȣ
			        
			        request.setAttribute("pageNum", new Integer(pageNum));
			        request.setAttribute("currentPage", currentPage);
			        request.setAttribute("startRow", new Integer(startRow));
			        request.setAttribute("endRow", new Integer(endRow));
			        request.setAttribute("count", new Integer(count));
			        request.setAttribute("pageSize", new Integer(pageSize));
			        request.setAttribute("number", new Integer(number));
			        request.setAttribute("articleList", articleList); 	
				} catch (Exception e1) {
					e1.printStackTrace();
				}  
		        
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "/boardQna/qnaList.jsp";
	}

}
