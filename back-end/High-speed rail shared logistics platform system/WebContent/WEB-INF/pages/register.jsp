<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="multipart/form-data;         charset=utf-8" />
    <title>注册</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/file-upload-with-preview.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    
    <link rel="stylesheet" href="css/1.css">
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />
    <script src="js/1.js"></script>
</head>
<body>
	<div class="header">
	<div class="back">
        <button class="btn btn-default"><a href="main">回到首页</a></button>
    </div>
</div>	
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" name="regform" id="register" role="form" action="register" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="name">用户名</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="nickname" id="name" placeholder="请输入3-10位用户名" onblur="checkUser()">
                    	<span id="isCan" style="color: red;"></span>
                    	<div id="name_prompt" style="color:red"></div>
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
                        <input type="text" class="form-control" name="userphone" id="tel" placeholder="请输入手机号" onblur="checkPhoneNum3()">
						<div id="phone_prompt" style="color:red"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="password">密码</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" name="userpwd" id="password" placeholder="请输入密码" onblur="CheckPassowrdStrength()">
                        <div id="pas_prompt" style="color:red"></div>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="password_1">确认密码</label>
                    <div class="col-md-6">
                        <input type="password" class="form-control" name="password_1" id="password_1" placeholder="请再次输入密码" onblur="CheckPassowrdStrength2()">
                    	<div id="pas_prompt1" style="color:red"></div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="truename">真实姓名</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="username" id="truename" placeholder="请输入真实姓名" onblur="checkTrueName()">
                    	<div id="truename_prompt" style="color:red"></div>
                    </div>
                </div>
				<div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="pin">身份证号</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="usernumber" id="pin" placeholder="请输入身份证号" onblur="checkNumber()">
                        <div id="pin_prompt" style="color:red"></div>
                    </div>
                    
                </div>
				<div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="card">银行卡号</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="card" id="card" placeholder="请输入银行卡号，用于转账" onblur="checkCard2()">
                    	<div id="card_prompt" style="color:red"></div>
                    </div>
                </div>
				<div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="address">常用住址</label>
                    <div class="col-md-6">
                        <input type="text" class="form-control" name="useraddress" id="address" placeholder="请输入常用住址" onblur="checkAddress2()">
                    	<div id="address_prompt" style="color:red"></div>
                    </div>
                </div>
                
                <div class="form-group">
					<div class="custom-file-container" data-upload-id="myUniqueUploadId">
						 <label class="control-label col-md-2 col-md-offset-1" for="idcard">上传身份证
						 	<a href="javascript:void(0)" class="custom-file-container__image-clear" title="Clear Image"></a>
						 </label> 
						 <div class="col-md-6">
						 <label class="custom-file-container__custom-file"> 
						 <input type="file" name="idphoto" class="custom-file-container__custom-file__custom-file-input" accept="*" multiple> 
						 <span class="custom-file-container__custom-file__custom-file-control" style="width: 320px;" ></span>
						</label>
						</div>
						<div class="custom-file-container__image-preview"
							style="height: 120px; width: 150px; position:absolute; margin-top: -30px; margin-left: 590px "></div>
					</div>

					<script src="js/file-upload-with-preview.min.js"></script>
					<script>
						var upload = new FileUploadWithPreview('myUniqueUploadId')
					</script>
				</div>
            
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1"> </label>
                    <div class="col-md-6">
                        <button type="submit" class="btn btn-default col-md-12 " style="width:300px; margin-top: 20px;"  onClick="registerForm()">注册</button>
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
    	if(!checkName2()) return;
    	$.ajax({
    		type: "post",
    		url: "checkuser",
    		data: {
    			"nickname": $("#name").val()
    		},
    		success: function(data){
    			$("#name_prompt").text(data);
    		},
    		error: function(data){
    			console.log('error');
    		}
    	});
    }
    function checkNumber(){
    	if(!checkPin2()) return;
    	$.ajax({
    		type: "post",
    		url: "checknumber",
    		data: {
    			"usernumber": $("#pin").val()
    		},
    		success: function(data){
    			$("#pin_prompt").text(data);
    		},
    		error: function(data){
    			console.log('error');
    		}
    	});
    }
    </script>
</body>
</html>