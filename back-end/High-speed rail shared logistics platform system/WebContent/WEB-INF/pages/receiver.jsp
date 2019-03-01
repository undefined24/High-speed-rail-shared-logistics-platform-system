<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>receiver</title>
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

					<li class="active" id="crftag"><a href="main">首页</a></li>
					<li id="crftag"><a href="#">服务支持</a></li>
					<li id="crftag"><a href="#">金融</a></li>
					<li id="crftag"><a href="#">加盟合作</a></li>
					<li id="crftag"><a href="#">招聘</a></li>
					<li id="crftag"><a href="#">关于我们</a></li>
				</ul>
			</div>
			<div>
				<ul class="nav navbar-nav navbar-right">
					<li id="crftag"><a href="login">快速登录/注册</a></li>
					<li id="crftag"><a href="gotoUserCenter">个人中心</a></li>
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
							<li id="crftag"><a href="gotoSender">我要寄件</a></li>
							<li class="active" id="crftag"><a href="#">我要收件</a></li>
							<li id="crftag"><a href="#">服务支持</a></li>
						</ul>
					</div>
				</div>
			</nav>
			
            <form class="form-horizontal" name="receiver" id="receive" role="form" action="receive" method="post" onSubmit="return on_submit2()">
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="start_pos">高铁出发点</label>
					<div class="col-md-6">
						<input class="form-control col-md-4 disabled" onblur="checkStartPos()" name="startpoint" placeholder="请输入高铁出发点" id="start_pos" value="">
						<div id="startpos_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="train_num">车次</label>
					<div class="col-md-6">
						<input class="form-control col-md-4 disabled" onblur="checkTrainNum()" name="trainnumber" placeholder="请输入车次" id="train_num" value="">
						<div id="trainnum_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="start_time">高铁出发时间</label>
					<div class="col-md-6">
						<input class="form-control col-md-4" onblur="checkStartTime()" name="traintime" placeholder="请输入高铁出发时间" id="start_time" value="">
						<div id="starttime_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1" for="arrive_pos">高铁到达点</label>
					<div class="col-md-6">
						<input class="form-control col-md-4" onblur="" name="arrivepoint" placeholder="请输入高铁到达点" id="arrive_pos" value="">
						<div id="arrivepos_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1"> </label>
					<div class="col-md-6">
						<button type="submit" class="btn btn-default col-md-12 " onClick="mySub2()">查询</button>
					</div>
				</div>
            </form>
        </div>
    </div>
	
</body>
</html>
