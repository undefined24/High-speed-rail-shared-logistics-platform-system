<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>用户登录</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />
</head>
<body>
	<script type="text/javascript">
		function mySub(){
			var userName = document.getElementById("name").value;
			var password = document.getElementById("password").value;
			
			if (userName == ""){
				//alert("请输入用户名！");
				//document.getElementById("wrong").innerText = "请输入用户名！";
				return false;
			}
			
			else if (password == ""){
				//document.getElementById("wrong").innerText = "请输入密码！";
				//alert("请输入密码！");
				return false;
			}
			
			else{
				document.getElementById("wrong").innerText = "登陆成功";
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
                    <form class="form-horizontal" name="logform" action="login" role="form" method="post">
                    <span id = "wrong" style="color:red;margin-left:45px"><%=request.getAttribute("login-msg")==null?"":request.getAttribute("login-msg") %></span>
                        <div class="form-group">
                            <label class="control-label col-md-2 col-md-offset-1" for="name">Name</label>
                            <div class="col-md-6">
                                <input type="text" class="form-control" name="nickname" id="name" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-2 col-md-offset-1" for="password">Password</label>
                            <div class="col-md-6">
                                <input type="password" class="form-control" name="userpwd" id="password" placeholder="请输入密码">
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
    <%String register_msg=(String)request.getAttribute("register-msg");
        if(register_msg!=null){%>
    <script type="text/javascript">
        alert("<%=register_msg%>");
    </script>
    <%}%>
</body>
</body>
</html>
