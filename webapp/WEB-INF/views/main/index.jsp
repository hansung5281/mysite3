      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>  

<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite3</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="assets/css/main.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp">
			</c:import>
			


		</div>
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile"
						src="http://mimgnews2.naver.net/image/022/2015/04/02/20150402000803_0_99_20150402100507.jpg?type=w540">
					<h2>아니아니, 저 마음에 안들죠? </h2>
				</div>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
			</c:import>



		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp">
			</c:import>

		</div>
	</div>
</body>
</html>