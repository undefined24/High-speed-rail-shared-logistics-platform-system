<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>管理员登录</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />
</head>
<body>
	<script type="text/javascript">
		function mySub(){
			var adminName = document.getElementById("adminname").value;
			var adminpwd = document.getElementById("adminpwd").value;
			
			if (adminName == ""){
				//alert("请输入用户名！");
				return false;
			}
			
			else if (adminpwd == ""){
				//alert("请输入密码！");
				return false;
			}
			
			else{
				return true;
			}
		}
	</script>
    <div class="container">
            <div class="col-md-7 slogan" style="height: 400px">
                <span>Get Delivery Or Pickup In DFW With Sharing Platform Now.</span>
            </div>
            <div class="col-md-5">
                <div id="login">
                    <form class="form-horizontal" name="logform" action="adminlogin" role="form" method="post">
                        <div class="form-group">
                            <label class="control-label col-md-2 col-md-offset-1" for="name">Name</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="adminname" id="adminname" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2 col-md-offset-1" for="password">Password</label>
                            <div class="col-md-6">
                                <input type="password" class="form-control" name="adminpwd" id="adminpwd" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2 col-md-offset-1"> </label>
                            <div class="col-md-6">
                                <button type="submit" class="btn btn-default col-md-12 " onClick="mySub()">Login</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </div>
    <%--登录错误时提示--%>
    <%String adminlogin_msg=(String)request.getAttribute("admin-login-msg");
        if(adminlogin_msg!=null){%>
    <script type="text/javascript">
        alert("<%=adminlogin_msg%>");
    </script>
    <%}%>
</body>
</html>
