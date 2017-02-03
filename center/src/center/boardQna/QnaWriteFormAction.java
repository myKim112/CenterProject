package center.boardQna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class QnaWriteFormAction implements SuperAction{

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

	    //제목글과 답변글의 구분
        int num=0,ref=1,reStep=0,reLevel=0; 
        try{ 
        	if(request.getParameter("num")!=null){
        		num=Integer.parseInt(request.getParameter("num"));
        		ref=Integer.parseInt(request.getParameter("ref"));
        		reStep=Integer.parseInt(request.getParameter("reStep"));
        		reLevel=Integer.parseInt(request.getParameter("reLevel"));
        	}
        }catch(Exception e){e.printStackTrace();}
			//해당 뷰에서 사용할 속성
			request.setAttribute("num", new Integer(num));
			request.setAttribute("ref", new Integer(ref));
			request.setAttribute("reStep", new Integer(reStep));
			request.setAttribute("reLevel", new Integer(reLevel));
		
			return "/boardQna/qnaWriteForm.jsp";
	}

}
