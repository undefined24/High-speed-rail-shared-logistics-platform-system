<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>index</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
    <script src="js/1.js"></script>
    <link rel="stylesheet" href="css/user.css">
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
				
                <li id="crftag"><a href="gotoHomepage">快速登录/注册</a></li>
				<li id="crftag"><a href="gotoUserCenter">个人中心</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="left col-md-9 ads">
        <div id="myCarousel" class="carousel slide ">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="image/test1.jpg" alt="First slide">
                </div>
                <div class="item">
                    <img src="image/test2.jpg" alt="Second slide">
                </div>
				<div class="item">
                    <img src="image/test3.jpg" alt="Second slide">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel" data-slide="prev">
                <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span>
            </a>
            <a class="carousel-control right" href="#myCarousel" data-slide="next">
                <span _ngcontent-c3="" aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
            </a>
        </div>
		
		<hr class="featurette-divider">
		
		<div class="row">
        <div class="col-lg-4 content">
          <img class="img-circle" src="image/mail_send.png" width="140" height="140">
			<p><a class="btn btn-default content-button" href="#" role="button"> 我要寄件 &raquo;</a></p>
		  <hr class="featurette-divider">
          <p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>
			<hr class="featurette-divider">
			
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4 content">
          <img class="img-circle" src="image/mail_receive.png" alt="Generic placeholder image" width="140" height="140" >
			<p><a class="btn btn-default content-button"  href="#" role="button"> 我要接件 &raquo;</a></p>
			<hr class="featurette-divider">
          <p>Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Cras mattis consectetur purus sit amet fermentum. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh.</p>
          <hr class="featurette-divider">
			
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4 content">
          <img class="img-circle" src="image/find.png" alt="Generic placeholder image" width="140" height="140">
          <p><a class="btn btn-default content-button" onclick='#search' data-toggle='modal' data-target='#search' role="button"> 订单查询 &raquo;</a></p>
			<hr class="featurette-divider">
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
			<hr class="featurette-divider">
        </div><!-- /.col-lg-4 -->
      </div>
       
	<hr class="featurette-divider">
		
    </div>
    <div id="well_sold" class="col-md-3">
        <table class="table table-hover">
            <caption>新闻动态</caption>
            <tbody>
            <tr>
                <td><a href="#">xxx董事长赴浙江温台地区多个网点调研</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">国家邮政局政策法规司调研组到云南省管理中心调研并座谈</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">xxx董事长赴上海多个网点调研</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">xxx董事长赴广州多个网点调研</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">xxx董事长赴哈尔滨多个网点调研</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">xxx董事长赴海南多个网点调研</td>
                <td>2019-02-18</td>
            </tr>
            </tbody>
        </table>
		
		<table class="table table-hover">
            <caption>行业新闻</caption>
            <tbody>
            <tr>
                <td><a href="#">全国两会即将召开，寄递保障工作要这么做！</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">国家邮政局政策法规司调研组到云南省管理中心调研并座谈</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">国家邮政局部署春运后半程寄递服务和安全保障工作</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">国家邮政局再次部署春节期间寄递服务保障工作</a></td>
                <td>2019-02-18</td>
            </tr>
            <tr>
                <td><a href="#">国家邮政局下发通知，要求做好春节期间寄递服务保障工作</a></td>
                <td>2019-02-15</td>
            </tr>
            <tr>
                <td><a href="#">最新快递发展指数来了！</a></td>
                <td>2019-02-14</td>
            </tr>
            </tbody>
        </table>
    </div>
	<h1 style="color: #0084ff" align="center"><strong>优惠活动</strong></h2>
	<h4 style="color: #0084ff" align="center">第一时间分享，最新促销活动</h4>
	<hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading" align="center">开门红 新客有新礼</h2>
		  <h4 class="featurette-heading" align="center" style="color: red">活动时间：2019-01-02 - 2019-03-30</h4>
		  <h4 class="featurette-heading" align="center" style="color: red">活动范围：中国内地</h4>
		  <a href="#">
		  	<button class="btn btn-default" style="display:block;margin:0 auto">View details &raquo;</button>
		  </a>
          <p class="lead"></p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block"  src="image/act1.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7 col-md-push-5">
          <h2 class="featurette-heading" align="center">1分钱寄快递优惠活动</span></h2>
		  <h4 class="featurette-heading" align="center" style="color: red">活动时间：2019-01-02 - 2019-03-30</h4>
		  <h4 class="featurette-heading" align="center" style="color: red">活动范围：中国内地</h4>
		  <a href="#">
		  	<button class="btn btn-default" style="display:block;margin:0 auto">View details &raquo;</button>
		  </a>
          <p class="lead"></p>
        </div>
        <div class="col-md-5 col-md-pull-7">
          <img class="featurette-image img-responsive center-block" src="image/act2.png" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 align="center" class="featurette-heading">物流停了，优惠不停！</h2>
		  <h4 class="featurette-heading" align="center" style="color: red">活动时间：2019-01-02 - 2019-03-30</h4>
		  <h4 class="featurette-heading" align="center" style="color: red">活动范围：中国内地</h4>
		  <a href="#">
		  	<button class="btn btn-default" style="display:block;margin:0 auto">View details &raquo;</button>
			</a> 
          <p class="lead"></p>
        </div>
        <div class="col-md-5">
          <img class="featurette-image img-responsive center-block" src="image/act3.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
        </div>
      </div>

      <hr class="featurette-divider">
	<!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2019 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
	</footer>
</div>
<!-- 模态框（Modal） -->
    <div class="modal fade" id="search" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">订单查询</h4>
                </div>
                <div class="modal-body">
					<form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="#" method="post">
						<div class="form-group col-md-12">
							<label class="control-label col-md-4" for="order_num">订单号</label>
							<div class="col-md-8">
								<input class="form-control" id="order_num" value="" >
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary" onClick="My_Order_Sub()">查询</button>
						</div>
					</form>
<!--					<div></div> 显示查询结果-->
					<div class="modal-footer"></div>
				</div>
			</div>
		</div><!-- /.modal-content -->
</div><!-- /.modal -->
</body>
</html>