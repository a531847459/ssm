<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	request.setCharacterEncoding("UTF-8");
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	String login_url = basePath + "loginForm.action" ;
%>
<html>
<head>
<base href="<%=basePath%>" />
<title>WEB开发</title>
</head>
<body> 
<h1>${error}</h1>
<h1>
	<c:if test="${error == org.apache.shiro.authc.UnknownAccountException }">
		登录帐号错误！
	</c:if>
</h1>

<form action="<%=login_url%>" method="post">
	用户名：<input type="text" name="mid" id="mid"/><br/>
	密码：<input type="password" name="password" id="password"/><br/>
	验证码:<input type="text" name="code" id="code"><img src="image.jsp"><br/>
	记住我<input type="checkbox" name="rememberMe" id="rememberMe"/><br/>
	<input type="submit" value="登录"/>
</form>
</body>
</html>