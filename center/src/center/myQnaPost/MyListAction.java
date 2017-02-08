package center.myQnaPost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import center.action.SuperAction;

public class MyListAction implements SuperAction {

	public String executeAction(HttpServletRequest request, HttpServletResponse response) {

    	return "/myQnaPost/myPostList.jsp";
	}
}

