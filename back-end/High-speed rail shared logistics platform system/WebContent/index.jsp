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
		<h2>昵称</h2>
		<input type="text" name="nickname" id="nickName" placeholder="请输入昵称" />
		<h2>密码</h2>
		<input type="text" name="userpwd" id="userPwd" placeholder="请输入密码" />
		<h2>地址</h2>
		<input type="text" name="useraddress" id="userAddress" placeholder="请输入地址" /><br />
		性别：<input type="radio" name="usersex" value="man" checked="checked"/>男
       <input type="radio" name="usersex" value="woman"  />女 <br/>
       <button type="submit" >注册</button>
       </form>
	</body>
</html>