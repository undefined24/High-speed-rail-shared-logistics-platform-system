<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>register</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
</head>
<body>
	<script type="text/javascript">
		function mySub(){
			var userName = document.getElementById("name").value;
			var sex = document.getElementById("sex").value;
			var tel = document.getElementById("tel").value;
			var password = document.getElementById("password").value;
			var password_1 = document.getElementById("password_1").value;
			var pin = document.getElementById("pin").value;
			var address = document.getElementById("address").value;
			
			if (password != password_1){
				alert("两次输入密码需一致");
				return false;
			}

			if (userName.length<3 || userName.length>6){
				alert("用户名必须为3-6位");
				return false;
			}

			var tag = isName(userName);
			if (tag){
				document.getElementById("isCan").innerHTML = "用户名已存在";
				return false;
			}else{
				document.getElementById("isCan").innerHTML = "";
			}
			if (password.length < 6){
				alert("密码必须大于6位");
				return false;
			}

			return true;
		}
		
		//判断用户名，参数为判断的用户名
        function isName(str){
        	for(var i=0;i<names.length;i++){
				if(names[i] == str){
					return true;
				}
			}
			return false;
		}
		
	</script>
	
	
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" name="regform" id="register" role="form" action="register" method="post">
                <span style="color:red;margin-left:120px"><%=request.getAttribute("check-name-msg")==null?"":request.getAttribute("check-name-msg") %></span>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="name">用户名</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="nickname" id="name" placeholder="请输入3-6位用户名" onblur="checkUser()">
                    	<span id="isCan" style="color: red;"></span>
					</div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="sex">性别</label>
                    <div class="col-md-6">
                        <select class="form-control" name="usersex" id="sex" >
                            <option value="male">男</option>
                            <option value="female">女</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="tel">手机号</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="userphone" id="tel" placeholder="请输入手机号">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="password">密码</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="userpwd" id="password" placeholder="请输入密码">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="password_1">确认密码</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="password_1" id="password_1" placeholder="请再次输入密码">
                    </div>
                </div>
				<div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="pin">身份证号</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="usernumber" id="pin" placeholder="请输入身份证号">
                    </div>
                </div>
				<div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="address">常用住址</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="useraddress" id="address" placeholder="请输入常用住址">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1"> </label>
                    <div class="col-md-6">
                        <button type="submit" class="btn btn-default col-md-12 " onClick="mySub()">注册</button>
                    </div>

                </div>


            </form>
        </div>
    </div>
<%--用户注册时提示--%>
    <%String register_msg=(String)request.getAttribute("register-msg");
        if(register_msg!=null){%>
    <script type="text/javascript">
        alert("<%=register_msg%>");
    </script>
    <%}%>	
    <script type="text/javascript">
    function checkUser(){
    	$.ajax({
    		type: "post",
    		url: "checkuser",
    		data: {
    			"nickname": ${"nickname"}.val()
    		},
    		success: function(data){
    			${"check-name-msg"}.text(data);
    		}
    	});
    }
    </script>
</body>
</html>