<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://localhost/jsp_prj/common/css/main.css" />
<title>캘린더</title>
<style type="text/css">
#wrap {
	width: 800px;
	height: 700px;
	margin: 0px auto;
}

#header {
	width: 800px;
	height: 80px;
	background-color: #00375E;
	text-align: right;
	font-size: 13px;
	font-weight: bold;
	color: #FFFFFF;
	border-bottom: 5px solid #6FB9E6;
}

#content {
	width: 800px;
	height: 535px;
}

#footer {
	width: 800px;
	height: 80px;
	background: URL(http://localhost/jsp_prj/common/images/footer.png);
	font-weight: bold;
	text-align: right;
	vertical-align: bottom;
}
/*------------------diary css 시작------------------------------- */
/* #= id , . = class*/
#diaryTitle {
	width: 800px;
	text-align: center;
	margin-top: 5px
}

#diaryContent {
	width: 800px;
	text-align: center
}

.dTable {
	border: 1px solid #E1E6F6;
	border-spacing: 0px
}

th {
	width: 120px;
	border: 1px solid #E1E6F6;
}

.sunTitle {
	background-color: #FF0000;
	font-weight: bold;
	color: #FFFFFF
}

.setTitle {
	background-color: #0000FF;
	font-weight: bold;
	color: #FFFFFF
}

#dayTitle {
	font-size: 20px;
	font-family: 돋움;
	font-weight: bold;
	vertical-align: top;
}

td {
	width: 120px;
	height: 50px;
	border: 1px solid #E6E6E7;
	text-align: left;
	vertical-align: top;
	padding-left: 3px;
	padding-top: 2px
}

.blank {
	background-color: #F1F1F1
}

.sun {
	color: #FF1049;
	font-weight: bold;
}

.sat {
	color: #003CFF;
	font-weight: bold;
}

.week {
	color: #333333;
}

#toDay {
	border: 2px solid #0099FF;
	background-color: #E8F2FE;
}
/*------------------diary css 끝------------------------------- */
</style>

<script type="text/javascript">
</script>
</head>

<body>
	<div id="wrap">
		<div id="header"></div>
		<div id="content">
			<!--   <input type="date"/> //달력기능 -->

<%!//선언

	//시작일을 저장하는 constant
	public static final int START_DATE = 1;%>
	<%
	Calendar cal = Calendar.getInstance();
	//Calendar cal1 = new GregorianCalendar();

	//오늘을 저장하기위한 변수
	StringBuilder today = new StringBuilder();
	today.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH) + 1);

	int nowYear = 0;
	int nowMonth = 0;
	int nowDay = cal.get(Calendar.DAY_OF_MONTH);

	//파라미터 값 받기
	String param_month = request.getParameter("param_month");
	//out.println(param_month);

	////
	//31일인 경우에는 이전월 또는 다음월로 이동했을 때 그 월에 31일이 없기때문에
	//자동으로 다음달로 변경된다. 
	cal.set(Calendar.DAY_OF_MONTH, 1);
	////

	//파라메터 값이 있을 때 달력의 월을 변경한다.
	if (param_month != null) {
		cal.set(Calendar.MONTH, Integer.parseInt(param_month) - 1); //자바에서는0부터라서-1더해줘야대
	}
	//변경된 월을 얻는다, 파라메터가 없으면 cal객체가 생성된 현재 월을 얻는다.
	nowMonth = cal.get(Calendar.MONTH) + 1;
	//연도 정보 받기
	String param_year = request.getParameter("param_year");
	if (param_year != null) { //파라미터가 존재할떄 달력의 년도를 설정합니다.
		cal.set(Calendar.YEAR, Integer.parseInt(param_year));
	}
	//설정된 년도를 얻는다. 파라메터가 없으면 cal객체가 생성된 현재 년도를 얻는다.
	nowYear = cal.get(Calendar.YEAR);

	StringBuilder paramDay = new StringBuilder();
	paramDay.append(nowYear).append(nowMonth);

	//기본값 : false(부정) //오늘을 표현하기 위한 기준변수
	boolean todayFlag = false;

	// == : 힙의 주소가 같을때  ,  .equals()
	//문자열의 내용 비교 toString을이용
	if (today.toString().equals(paramDay.toString())) {
		todayFlag = true;
		//out.println("오늘");
	}
	%>
	<div id="diaryTitle">
	
		<a href="calendar.kiki?param_month=<%=nowMonth - 1 == 0 ? 12 : nowMonth - 1%>&param_year=<%=nowMonth - 1 == 0 ? nowYear - 1 : nowYear%> ">◀</a> <!-- 이전달 --> 
		<span id="dayTitle"><%=nowYear%>.<%=nowMonth%></span>
		<a href="calendar.kiki?param_month=<%=nowMonth + 1 == 13 ? 1 : nowMonth + 1%>&param_year=<%=nowMonth + 1 == 13 ? nowYear + 1 : nowYear%>">▶</a> <!-- 다음달 -->
		&nbsp;&nbsp;
		<!-- 파라미터에 값이 없으므로 if를 타지 않고 현재년과 월이 나온다 -->
		<a href="calendar.kiki">오늘</a>
	</div>
	
	<div id="diaryContent">
		<table class="dTable">
			<thead>
				<tr>
					<th class="sunTitle">일</th>
					<th>월</th>
					<th>화</th>
					<th>수</th>
					<th>목</th>
					<th>금</th>
					<th class="setTitle">토</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<%
					String dayCss = "";//일자별 글자의 색
					String todayCss = "";//오늘을 강조하여 보여주는 css를 저장하기 위한 변수

					for (int tempDay = 1;; tempDay++) {
					//증가하는 임시날짜를 달력객체 설정
						cal.set(Calendar.DAY_OF_MONTH, tempDay);
						
						if (tempDay != cal.get(Calendar.DAY_OF_MONTH)) {
						//설정된 날짜와 임시날짜가 다르다면 끝 일이므로 
						//반복문을 빠져나간다.

						//끝의공백추가
						// 뒷부분 공백처리
							for (int i = cal.get(Calendar.DAY_OF_WEEK); i <= 7; i++) {
								if (cal.get(Calendar.DAY_OF_WEEK) == 1) { //밑에 남는 칸들 제거됨
									break;
								}
				%>
						<td class="blank">&nbsp;</td>
				<%
							}
							break;
						} //end if
						switch (tempDay) {
							case START_DATE: //가독성을 높인당 constant
							//1일을 출력하기 전에 공백을 출력한다.
								int week = cal.get(Calendar.DAY_OF_WEEK);

								for (int blank = 1; blank < week; blank++) {
				%>
						<td class="blank">&nbsp;</td>
				<%
								} //end for
						}//end switch

						//요일별 글자색 설정
						switch (cal.get(Calendar.DAY_OF_WEEK)) {//요일별숫자 일:1 월:2 ..
							case Calendar.SUNDAY:
								dayCss = "sun";
								break;
							case Calendar.SATURDAY:
								dayCss = "sat";
								break;
							default:
								dayCss = "week";
						}

						if (todayFlag) { //오늘만 나타나게 할라면 flag변수가지고 결정
						//오늘을 보여주기위한 css 설정 -> tempDay랑 nowDay랑
							if (tempDay == nowDay) {
								todayCss = "id='toDay'"; //오늘인 경우
							} else { //그렇지 않을 경우에는 널
								todayCss = "";
							}
						}
				%>
						<td <%=todayCss%>><span class="<%=dayCss%>"><%=tempDay%></span>
							<c:set value="<%=nowYear%>" var="nowYear"/>
							<c:set value="<%=nowMonth%>" var="nowMonth"/>
							<c:set value="<%=tempDay%>" var="tempDay"/>
							<table>
								<c:forEach var="cal" items="${calList}">
									<c:if test="${cal.memoYear == nowYear && cal.memoMonth == nowMonth && cal.memoDate == tempDay }">
										<tr>
											<td>
												<a href="calContent.kiki?calNum=${cal.calNum}">${cal.calTitle}</a>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</table>
						</td>
				<%
						//설정된 일자가 토요일이면 행을 변경한다.
						switch (cal.get(Calendar.DAY_OF_WEEK)) {
							case Calendar.SATURDAY:
				%>
					</tr>
					<tr>
				<%
						}	
					} //end for
				%>
				
					</tbody>
				</table>
				<c:if test="${staff.lev >= 500}">
				<table class="dTable" width="800">
					<tr>
						<td align="right">
							<input type="button" value="일정 등록" onclick="window.location='calInputForm.kiki'" />
						</td>
					</tr>						
				</table>
				</c:if>
			</div>
		</div>
		<div id="footer"></div>
	</div>
</body>
</html>