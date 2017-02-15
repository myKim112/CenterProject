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
		       String pageNum = request.getParameter("pageNum");//������ ��ȣ
		       
		        if (pageNum == null) {
		            pageNum = "1";
		        }
		        
		        int pageSize = 10;//�� �������� ���� ����
		        int currentPage = Integer.parseInt(pageNum);
		        int startRow = (currentPage - 1) * pageSize + 1;//�� �������� ���۱� ��ȣ
		        int endRow = currentPage * pageSize;//�� �������� ������ �۹�ȣ
		        int count = 0;
		        int number=0;

		        List articleList = null;
		        PhotoDAO dbPro = PhotoDAO.getInstance();//DB����

		        try{
			        if (count > 0) {
			    			articleList = dbPro.getArticles(startRow, endRow);
			        } else {
			            articleList = Collections.EMPTY_LIST;
			        }	        

						number=count-(currentPage-1)*pageSize;//�۸�Ͽ� ǥ���� �۹�ȣ
				        //�ش� �信�� ����� �Ӽ�
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
