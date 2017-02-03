package center.boardReview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class ReviewContentAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {
	
	      int num = Integer.parseInt(request.getParameter("num"));//�ش� �۹�ȣ
	        String pageNum = request.getParameter("pageNum");//�ش� ������ ��ȣ

	        ReviewDAO dbPro = ReviewDAO.getInstance();//DBó��
	        ReviewDTO article;
			try {
				article = dbPro.getArticle(num);
		        //�ش� �信�� ����� �Ӽ�
		        request.setAttribute("num", new Integer(num));
		        request.setAttribute("pageNum", new Integer(pageNum));
		        request.setAttribute("article", article);
			} catch (Exception e) {
				e.printStackTrace();
			}//�ش� �۹�ȣ�� ���� �ش� ���ڵ�
	  
		return "/boardReview/reviewContent.jsp";
	}

}
