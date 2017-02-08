<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.Calendar" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%
	int action = 0; //up(1) down(0)
	int currYear = 0;
	int currMonth = 0;
	String boxSize = "70";
	
	Calendar c = Calendar.getInstance();
	Calendar cal = Calendar.getInstance();
	
	if(request.getParameter("action") == null) {
		currMonth = c.get(Calendar.MONTH);
		currYear = c.get(Calendar.YEAR);
		cal.set(currYear, currMonth, 1);
	} else {
		if(request.getParameter("action") != null) {
			 currMonth = Integer.parseInt(request.getParameter("month"));
	         currYear = Integer.parseInt(request.getParameter("year"));
	         
	        if(Integer.parseInt(request.getParameter("action")) == 1) {
				cal.set(currYear, currMonth, 1);
				cal.add(Calendar.MONTH, 1); // 다음달
				currMonth = cal.get(Calendar.MONTH);
				currYear = cal.get(Calendar.YEAR);
	        } else {
	        	cal.set(currYear, currMonth, 1);
	        	cal.add(Calendar.MONDAY, -1); // 이전달
	        	currMonth = cal.get(Calendar.MONTH);
	        	currYear = cal.get(Calendar.YEAR);
	        }
		}
	}
	System.out.println(currYear);
	System.out.println(currMonth);
%>

<%!
	public boolean isDate(int y, int m, int d) {
		m -= 1;
		Calendar c = Calendar.getInstance();
		c.setLenient(false);
		
		try {
			c.set(y, m, d);
			Date dt = c.getTime();
		} catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}
%>

<%!
	public String getTitle(Calendar cal) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월");
		return sdf.format(cal.getTime());
	}
%>

<head>
<title>캘린더</title>
</head>

<body>
<table border="1" width="521" align="center">
	<tr>
	<td width="150" align="right" valign="middle" border="1">
		<a href='calendar.jsp?month=<%=currMonth%>&year=<%=currYear%>&action=0'>
		<font size="2">이전달</font></a>
	</td>
	<td width="260" align="center" valign="middle">
	<b><%=getTitle(cal) %></b>
	</td>
	<td width="173" align="left" valign="middle">
	<a href='calendar.jsp?month=<%=currMonth%>&year=<%=currYear%>&action=1'>
	<font size="2">다음달</font></a>
	</td>
	</tr>
</table>

<table border="1" align="center">
	<tr>
	<td width="100%">
		<table id="calendarTable">
			<tr>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>일</b></font></td>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>월</b></font></td>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>화</b></font></td>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>수</b></font></td>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>목</b></font></td>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>금</b></font></td>
				<td align="center" bgcolor="#666666"><font color="#FFFFFF"><b>토</b></font></td>
	</tr>
<%

	//  calendar loop
	
	int currDay;
	String todayColor;
	int count = 1;
	int dispDay = 1;
	
	for(int w = 1; w < 7; w++) {
%>
	<tr>
<%
		for(int d = 1; d < 8; d++) {
			if(!(count >= cal.get(Calendar.DAY_OF_WEEK)))
			{
%>
	
	<td width="<%=boxSize%>" height="<%=boxSize%>" bgcolor="lightgray">&nbsp;</td>
<%
				count += 1;
			} else {
				if(isDate (currYear, currMonth+1, dispDay))
				{
					//오늘
					if(dispDay == c.get(Calendar.DAY_OF_MONTH) &&
						c.get(Calendar.MONTH) == cal.get(Calendar.MONTH) &&
						c.get(Calendar.YEAR) == cal.get(Calendar.YEAR)) 
					{
						todayColor = "#6C7EAA";
					} else {
						todayColor = "#ffffff";
					}
%>
	<td bgcolor="<%=todayColor%>" width="<%=boxSize%>" height="<%=boxSize%>" valign="top" align="left"><%=dispDay %><br>
	<c:set value="<%=dispDay%>" var="dispDay"/>
		<table>
			<c:forEach var="cal" items="${calList}">
			<c:if test="${cal.calDate.date == dispDay}">
			<tr>
				<td>
					<a href="calContent.kiki?calNum=${cal.calNum}" >${cal.calTitle}</a>
				</td>
			</tr>
			</c:if>	
			</c:forEach>
		</table>
	</td>
<%
			count += 1;
			dispDay += 1;
				} else {
%>
	<td width="<%=boxSize%>" height="<%=boxSize%>" bgcolor="lightgray">&nbsp;</td>
<%
				}
			}
		}
%>
	</tr>
<%
	}
%>
	</table>
	</td></tr>
</table>

<table align="center" width="521" border="1">
	<tr>
	<td align="right">
		<input type="button" value="메인" onclick="window.location='mian.kiki'" />
	</td></tr>
	<tr>
	<td align="right">
		<input type="button" value="일정등록" onclick="window.location='calInputForm.kiki'" />
	</td></tr>		
</table>
</body>