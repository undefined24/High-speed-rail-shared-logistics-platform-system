<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>sender</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
	<link rel="stylesheet" href="css/senderreceiver.css">
	<script src="js/3.js"></script>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid container">
			<div id="nav" class="navbar-header" style="height: 70px;">
	<!--            <a href="#"><img src="image/logo.png"  style="padding: 10px;"/></a>-->
				<img src="image/logo.jpg" style="height: 100%" >
			</div>
			<div>
				<ul class="nav navbar-nav ">

					<li class="active" id="crftag"><a href="#">首页</a></li>
					<li id="crftag"><a href="#">服务支持</a></li>
					<li id="crftag"><a href="#">金融</a></li>
					<li id="crftag"><a href="#">加盟合作</a></li>
					<li id="crftag"><a href="#">招聘</a></li>
					<li id="crftag"><a href="#">关于我们</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<li id="crftag"><a href="#">快速登录/注册</a></li>
					<li id="crftag"><a href="#">个人中心</a></li>
				</ul>
			</div>
		</div>
	</nav>
    <div class="container">
        <div class="col-md-8 col-md-offset-2">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid container2">
					<div id="nav" class="navbar-header" style="height: 70px;">
					</div>
					<div>
						<ul class="nav navbar-nav navbar-right">
							<li class="active" id="crftag"><a href="#">我要寄件</a></li>
							<li id="crftag"><a href="#">我要收件</a></li>
							<li id="crftag"><a href="#">服务支持</a></li>
						</ul>
					</div>
				</div>
			</nav>
			
            <form class="form-horizontal" name="sender" id="send" role="form" onSubmit="return on_submit1()">
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="type">物品类型</label>
                    <div class="col-md-6">
						<select class="form-control select1" id="type">
							<option value="1" style="color: black">文件</option>
                            <option value="2" style="color: black">数码产品</option>
							<option value="3" style="color: black">生活用品</option>
                            <option value="4" style="color: black">服饰</option>
							<option value="5" style="color: black">食品</option>
                            <option value="6" style="color: black">其他</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1" for="weight">物品估重</label>
                    <div class="col-md-6">
						<select class="form-control select1" id="weight">
							<option value="1" style="color: black">小于1kg</option>
                            <option value="2" style="color: black">1kg</option>
							<option value="3" style="color: black">2kg</option>
                            <option value="4" style="color: black">3kg</option>
							<option value="5" style="color: black">4kg</option>
                            <option value="6" style="color: black">大于4kg</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="sender_name">寄件人姓名</label>
					<div class="col-md-6">
						<input type="text" onblur="checkSenderName()" class="form-control" id="sender_name" placeholder="请输入寄件人姓名" name="sendername">
						<div id="sendername_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="sender_tel">寄件人手机号</label>
					<div class="col-md-6">
						<input type="text" onblur="checkSenderTel()" class="form-control" id="sender_tel" placeholder="请输入寄件人手机号" name="senderphone">
						<div id="sendernumber_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="sender_address">寄件人地址</label>
					<div class="col-md-6">
						<input type="text" onblur="checkSenderAddress()" class="form-control" id="sender_address" placeholder="请输入寄件人地址" name="senderaddress" >
						<div id="senderadderss_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="receiver_name">收件人姓名</label>
					<div class="col-md-6">
						<input type="text" onblur="checkReceiverName()" class="form-control" id="receiver_name" placeholder="请输入收件人姓名" name="receivername">
						<div id="receivername_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="receiver_tel">收件人手机号</label>
					<div class="col-md-6">
						<input type="text" onblur="checkReceiverTel()" class="form-control" id="receiver_tel" placeholder="请输入寄件人手机号" name="receiverphone">
						<div id="receivernumber_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="receiver_address">收件人地址</label>
					<div class="col-md-6">
						<input type="text" onblur="checkReceiverAddress()" class="form-control" id="receiver_address" placeholder="请输入寄件人地址" name="receiveraddress" >
						<div id="receiveradderss_prompt"></div>
					</div>
				</div>
				<div class="form-group">
                    <label class="control-label col-md-2 col-md-offset-1"> </label>
                    <div class="col-md-6">
                        <button type="submit" class="btn btn-default col-md-12 " onClick="mySub1()">提交</button>
                    </div>

                </div>
            </form>
        </div>
    </div>
	
</body>
</html>
