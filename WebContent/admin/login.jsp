<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hx.bean.User"%>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>长江大学电信学院后台管理</title>
<link href="./css/reset.css" rel="stylesheet" type="text/css" />
<link href="./css/base.css" rel="stylesheet" type="text/css" />
<link href="./css/menu.css" rel="stylesheet" type="text/css" />
<link href="./css/applyEdit.css" rel="stylesheet" type="text/css" />
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background: url('/img/bg_login.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}

.login-form {
	width: 30%;
	max-width: 300px;
	margin: 0 auto;
	padding: 250px 10%;
	position: relative;
}

.login-form input {
	padding: 4%;
	width: 92%;
	margin-top: 5%;
	display: block;
	background: rgba(255, 255, 255, 0.89);
	border: 1px solid #fff;
	font-size: 1.5em;
	font-weight: bold;
	font-size: 1.5em;
}

.login-form .submit {
	margin-top: 5%;
	border-radius: 4px;
	border: 1px solid rgba(255, 255, 255, 0.56);
	position: relative;
	width: 100%;
	color: #444;
	background: rgba(255, 255, 255, 0.77);
}

.color_faded {
	width: 100%;
	height: 7em;
	background: -webkit-linear-gradient(rgba(255, 255, 255, 0),
		rgba(255, 255, 255, 255)); /* Safari 5.1 - 6.0 */
	background: -o-linear-gradient(rgba(255, 255, 255, 0),
		rgba(255, 255, 255, 255)); /* Opera 11.1 - 12.0 */
	background: -moz-linear-gradient(rgba(255, 255, 255, 0),
		rgba(255, 255, 255, 255)); /* Firefox 3.6 - 15 */
	background: linear-gradient(rgba(255, 255, 255, 0), rgb(255, 255, 255));
}
</style>
</head>

<body>

	<form class="login-form" action="/login" method="post">
		<input class="name" type="text" value="admin" required name="name" placeholder="用户名"
			id=""> <input type="password" class="pass" required
			name="pass" placeholder="密码" value="admin"> <input type="submit"
			class="submit" value="登陆">

	</form>
	<div class="color_faded"></div>

</body>

</html>


