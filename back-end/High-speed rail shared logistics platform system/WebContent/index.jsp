<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>test</title>
  <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
	</head>
	<body>
		<form action="register" method="post">
		<h2>用户名</h2>
		<input type="text" name="username" id="userName" placeholder="请输入用户名" />
		<h2>手机</h2>
		<input type="text" name="userphone" id="userPhone" placeholder="请输入手机号码" />
		<h2>身份证</h2>
		<input type="text" name="usernumber" id="userNumber" placeholder="请输入身份证" /><br />
		性别：<input type="radio" name="usersex" value="man" checked="checked"/>男
       <input type="radio" name="usersex" value="woman"  />女 <br/>
       <button type="submit" >注册</button>
       </form>
	</body>
</html>