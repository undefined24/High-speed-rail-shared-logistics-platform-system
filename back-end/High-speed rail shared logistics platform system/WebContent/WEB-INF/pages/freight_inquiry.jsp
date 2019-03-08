<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>运费查询</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
	<link rel="stylesheet" href="css/senderreceiver.css">
	<script src="js/3.js"></script>
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid container">
			<div id="nav" class="navbar-header" style="height: 70px;">
	<!--            <a href="#"><img src="image/logo.png"  style="padding: 10px;"/></a>-->
				<img src="image/my_logo.jpg" style="padding: 12px; height: 100%" >
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
					<li id="crftag"><a href="register">快速登录/注册</a></li>
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
							<li id="crftag"><a href="gotoReceiver">我要接件</a></li>
							<li class="active" id="crftag"><a href="#">运费查询</a></li>
						</ul>
					</div>
				</div>
			</nav>
			<div class="container2" style="padding: 50px">
			<h4><strong>运费计算基于以下计费规则：</strong></h4>
				<p><strong>一、 体积重量计算方法</strong></p>
				<p>托寄物的计费重量取体积重量与实际重量两者之间的较大值，体积重量的计算方法为：<br>
					同城、省内件以及经济区域内互寄，体积重量=长(CM)×宽(CM)×高(CM)÷20000；<br>
					省外跨经济区域互寄，体积重量=长(CM)×宽(CM)×高(CM)÷10000；<br>
					(经济区域包含：京津冀区域，江浙沪皖区域,，川渝区域，黑吉辽区域)<br>
					其他产品计算方法请致电xxxxxxx。</p>
				<p><strong>二. 计费重量小数点进位处理方式</strong></p>
				<p>10KG以下，续重以0.5KG为计重单位，不足0.5kg，按0.5kg计；10KG及以上，四舍五入取整数。</p>
				<p><strong>三. 运费计算结果处理方式</strong></p>
				<p>1、运费计算结果按四舍五入取整数值；<br>
				   2、不同产品起始重量各有差异，不足起重的快件将按起重计费并显示。<br>
				   以上计费规则可能因服务（产品）或所在地区不同而有所差异，详情致电xxxxxxx。</p>
			
		</div>
        </div>
    </div>
	
</body>
</html>
