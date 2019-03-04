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
    <script src="js/bootstrap-datetimepicker.fr.js"></script>
    <script src="js/bootstrap-datetimepicker.js"></script>
    <link rel="stylesheet" href="css/1.css">
	<link rel="stylesheet" href="css/senderreceiver.css">
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
	<link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
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
						<input class="form-control col-md-4" onblur="checkArrivePos()" name="arrivepoint" placeholder="请输入高铁到达点" id="arrive_pos" value="">
						<div id="arrivepos_prompt"></div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-2 col-md-offset-1"> </label>
					<div class="col-md-6">
						<button type="button" class="btn btn-default col-md-12 " onClick="getList();mySub2()">查询</button>
					</div>
				</div>
            </form>
        </div>
    </div>
    <div class="container3">
	</div>
	<div class="container">
		<table class="table table-hover goods col-md-12 recieve_search" id="tbl">
            <thead>
            <tr>
                <th>物品ID</th>
				<th>下单用户ID</th>
                <th>类型</th>
                <th>重量(500g)</th>
                <th>运费(元)</th>
            </tr>
            </thead>
            <tbody id="add_tr">
            <%--  <c:forEach items="${ablegoodslist}" var="bill">
            <tr>
                <td>${bill.trackingID}</td>
				<td>${bill.giveUserID}</td>
				<td>${bill.acceptUserID}</td>
                <td>${bill.goods.type}</td>
                <td>${bill.goods.weight}</td>
				<td>${bill.trainnumber}</td>
                <td>${bill.cost}</td>
                <td><button class="btn btn-default" data-toggle="modal" data-target="#goods_take">接单</button>
            </tr>
            </c:forEach> --%>
           
            </tbody>
        </table>
	</div>
<!-- 模态框（Modal） -->
	<div class="modal fade" id="goods_take" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="take">物品接单</h4>
				</div>
				<div class="modal-body">
					您是否确定要接单？
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">否</button>
					<button type="button" class="btn btn-primary onclick="confirm()">是</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>	
     <script type="text/javascript">
     var count = 0;
     var last_length = 0;
	function getList(){
		$.ajax({
			type : "post",
			url : "receive",
			data : {
				"startpoint": $("#start_pos").val(),
				"trainnumber": $("#train_num").val(),
				"traintime": $("#start_time").val(),
				"arrivepoint": $("#arrive_pos").val()
			},
			success : function(data) {
				if(data.length==0){
					/*  window.location.reload(); */
					 alert("没有适合您接件的物品");
					/*  return; */
				}
				if(count!=0){
					for(var i=0;i<last_length;i++){
						var add_tr = document.getElementById("add_tr");
						var mark = document.getElementById("mark");
						add_tr.removeChild(mark);
					}
				}
				for(var i=0;i<data.length;i++){
					var tr = document.createElement("tr");
					tr.setAttribute('id','mark');
					var td1 = document.createElement("td");
					td1.innerText = data[i].trackingID;
					td1.setAttribute('id',"trackingID"+i);
					tr.appendChild(td1);
					var td2 = document.createElement("td");
					td2.innerText = data[i].giveUserID;
					tr.appendChild(td2);
					var td4 = document.createElement("td");
					td4.innerText = data[i].goods.type;
					tr.appendChild(td4);
					var td5 = document.createElement("td");
					td5.innerText = data[i].goods.weight;
					tr.appendChild(td5);
					var td6 = document.createElement("td");
					td6.innerText = data[i].cost;
					tr.appendChild(td6);
					var td7 = document.createElement("td");
					td7.innerText = data[i].goods.name;
					tr.appendChild(td7);
					var td8 = document.createElement("td");
					td8.innerHTML = "<button class=\"btn btn-default\" data-toggle=\"modal\" id=\"recbtn\" data-target=\"#goods_take\">接单</button>"
					tr.appendChild(td8);
					document.getElementById("add_tr").appendChild(tr);
					var rec_btn=document.getElementById("recbtn")
					rec_btn.onclick=function(){
						alert(1);
					}
				}
				count += 1;
				last_length=data.length;
			}
		});
	}
</script>
</body>
</html>
