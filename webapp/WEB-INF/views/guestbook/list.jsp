<%@ page contentType="text/html;charset=UTF-8"
	%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
	pageContext.setAttribute("newLineChar", "\n");
%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/WEB-INF/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite3/guestbook/insert" method="post">
					<input type="hidden" name="a" value="insert">

					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
				
					<li>
					<c:forEach items="${list }" var="vo" varStatus="status">
							<table>
								<tr>
								<td>[${vo.no}]</td>
								<td>${vo.name}</td>
								<td>${vo.reg_date}</td>
								<td><a href="/mysite3/guestbook/delete?no=${vo.no}">삭제</a></td>

								</tr>
								<tr>
									<td colspan=4>${fn:replace(vo.message, newLineChar, "<br>"
										) }</td>
								</tr>
							</table>
							<br>
						</c:forEach> <br></li>
				</ul>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/WEB-INF/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>