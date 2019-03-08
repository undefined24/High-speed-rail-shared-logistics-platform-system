<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>欢迎</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />
</head>
<body>
<div class="header">
	<div class="back">
        <button class="btn btn-primary logout"><a href="register">注册</a></button>
        <button class="btn btn-default"><a href="main">回到首页</a></button>
    </div>
</div>
    <div class="container">

        <div class="col-md-8 col-md-offset-2 title"> Welcome to the <br/>High Speed Rail Logistics <br/>Sharing Platform</div>
        <div class="col-md-8 col-md-offset-2 text-center" id="identity" >
            <div class="col-md-4">
                <a href="login">
                    <span class="glyphicon glyphicon-user"></span>
                    <h3><a href="login">USER</a></h3>
                </a>
            </div>
            <div class="col-md-4">
                <a href="#">
                    <span class="glyphicon glyphicon-user"></span>
                    <h3><a href="#">CUSTOMER</a></h3>
                </a>
            </div>
            <div class="col-md-4">
                <a href="adminlogin">
                    <span class="glyphicon glyphicon-user"></span>
                    <h3><a href="adminlogin">ADMIN</a></h3>
                </a>
            </div>
        </div>
    </div>
</body>
</html>