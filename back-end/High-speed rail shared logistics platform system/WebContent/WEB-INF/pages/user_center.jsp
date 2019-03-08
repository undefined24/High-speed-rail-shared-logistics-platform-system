<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>个人中心</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/02.css">
	<script src="js/2.js"></script>
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />

</head>
<body>
	<div id="back-up" onclick="goToWhere()"
        style=" height: 58px; width: 58px; position: fixed; cursor: pointer; right: 0px; bottom: 50px;">
		<img src="image/b1.png" height="58px" width="58px">
	</div>
	<div class="container container_user_center col-md-10 col-md-offset-1">
        <div class="back">
            <a href="main">回到首页</a>
            <a href="userLogout">注销</a>
        </div>
		<div class="user_info col-md-6 col-md-offset-3">
			<img class='user_icon' title='点击更换头像' style='border-radius: 50%;width: 150px;height: 150px; margin-bottom: 30px;' src=image/2089312254@chatroom_1486356859619_63.jpg onclick='#save' data-toggle='modal' data-target='#save'/>
			<br/>
            <span class="user_name">${user.nickname}<span class="user_name">，欢迎您</span></span>
            <br/>
		</div>
		<div class="col-md-8 col-md-offset-2 ">
            <div class="col-md-6">
                <a href="#revise_part" class="func_nav">修改资料</a>
            </div>
			<div class="col-md-6">
                <a href="#search_part" class="func_nav">物流查询</a>
            </div>
        </div>
		
		<div class="col-md-10 col-md-offset-1">
            <div class="revise" id="revise_part">
				<h3 class="col-md-10">资料修改</h4>
                <div class="line col-md-12  "></div>
                <br/>
                
                 <form class="form-horizontal col-md-10" id="user_center_edit" name="userInfoEdit" role="form" onSubmit="return on_submit()" method="post" action="changeprofile">
                     <div class="form-group"> 
                        <label class="control-label col-md-2" for="name">用户名</label>
                        <div class="col-md-6">
                            <input type="text" onblur="checkUser();checkName()" class="form-control" id="name" placeholder="请输入3-10位用户名" name="nickname" value="${user.nickname }">
                            <div id="name_prompt" style="color:red"></div>
						</div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2" for="tel">手机号</label>
                        <div class="col-md-6">
                            <input type="text" onblur="checkTel()" class="form-control" id="tel" placeholder="请输入手机号" name="userphone" value="${user.userphone }">
                            <div id="number_prompt" style="color:red"></div>
						</div>
                    </div>
                    
                    <div class="form-group">
                        <label class="control-label col-md-2" for="password">密码</label>
                        <div class="col-md-6">
                            <input type="password" onblur="CheckPassowrdStrength()" class="form-control" id="password" placeholder="请输入密码(不少于6位)" name="userpwd" value="${user.userpwd}">
                            <div id="pwd_prompt" style="color:red"></div>
						</div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2" for="password_confirm">确认密码</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="password_1" placeholder="请再次输入密码" name="re_userpwd" value="" onblur="CheckPassowrdStrength2()">
                        	<div id="pas_prompt1" style="color:red"></div>
                        </div>
                    </div>
					<div class="form-group">
                        <label class="control-label col-md-2" for="pin">身份证号</label>
                        <div class="col-md-6">
                            <input type="text" onblur="checkPin()" class="form-control" id="pin" placeholder="请输入身份证号" name="usernumber" value="${user.usernumber}">
							<div id="pin_prompt" style="color:red"></div>
                        </div>
                    </div>
					<div class="form-group">
	                    <label class="control-label col-md-2" for="card">银行卡号</label>
	                    <div class="col-md-6">
	                        <input type="text" class="form-control" name="card" id="card" placeholder="请输入银行卡号，用于转账" onblur="checkCard2()">
	                    	<div id="card_prompt" style="color:red"></div>
	                    </div>
	                </div>
					 <div class="form-group">
                        <label class="control-label col-md-2" for="address">常用住址</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="address" placeholder="请输入常用住址" name="useraddress"  onblur="checkAddress2()" value="${user.useraddress }">
                        	<div id="address_prompt" style="color:red"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2"> </label>
                        <button class="btn btn-default " type="submit" onClick="mySub()">保存</button>
                    </div>
                    
                </form>
		</div>
		</div>
		
		<div class="col-md-10 col-md-offset-1 search1">
			<div class="search" id="search_part">
				<h3 class="col-md-10">物流查询</h4>
                <div class="line col-md-12  "></div>
                <br/>
                <div class="line2 col-md-12  "></div>
                <div class="form-group " id="my_give_bill">
					<h4 class="col-md-10"><strong>我的寄件</strong></h4>
                    <table class="table col-md-12 kuang" style="margin-top: 30px;">
						<thead>
						<tr>
							<th>账单号</th>
							<th>物品id</th>
							<th>物品名称</th>
							<th>发送的地址</th>
							<th>接收的地址</th>
							<th>车次</th>
							<th>花费</th>
							<th>是否接单</th>
							<th>订单完成时间</th>
							<th></th>
						</tr>
						</thead>
						<tbody>
						 <c:forEach items="${sendlist}" var="send">
						<tr>
							<td>${send.trackingID}</td>
							<td>${send.goods.trackingID }</td>
							<td>${send.goods.name}</td>
							<td>${send.sendaddress}</td>
							<td>${send.arriveaddress}</td>
							<td>${send.trainnumber }</td>
							<td>${send.cost}</td>
							<c:if test="${send.acceptUserID!=0}">
							<td>是</td>
							</c:if>
							<c:if test="${send.acceptUserID==0}">
							<td>否</td>
							</c:if>
							<td>${send.completetime}</td>
							<c:if test="${send.completetime==null}">
							<td><span data-toggle="modal" data-target="#goods_delete" onclick="arrive(${send.trackingID})" >确认送达</span></td>
							</c:if>
							<c:if test="${send.completetime!=null}">
							<td></td>
							</c:if>
						</tr>
						</c:forEach>
						</tbody>
					</table>
            	</div>
				
				<div class="line1 col-md-12"></div>
				<div class="form-group" id="my_accept_bill">
					<h4 class="col-md-10"><strong>我的接件</strong></h4>
                    <table class="table col-md-12 kuang" style="margin-top: 30px;">
						<thead>
						<tr>
							<th>账单号</th>
							<th>物品id</th>
							<th>物品名称</th>
							<th>发送的地址</th>
							<th>接收的地址</th>
							<th>车次</th>
							<th>花费</th>
							<th>是否到达</th>
						</tr>
						</thead>
						<tbody>
						 <c:forEach items="${acceptlist}" var="accept">
						<tr height="50px">
							<td>${accept.trackingID}</td>
							<td>${accept.goods.trackingID}</td>
							<td>${accept.goods.name}</td>
							<td>${accept.sendaddress}</td>
							<td>${accept.arriveaddress}</td>
							<td>${accept.trainnumber}</td>
							<td>${accept.cost}</td>
							<c:if test="${accept.complete==false}">
							<td>否</td>
							</c:if>
							<c:if test="${accept.complete==true}">
							<td>是</td>
							</c:if>
						</tr>
						</c:forEach>
						</tbody>
					</table>
            	</div>
            	<div class="line3 col-md-12  "></div>
			</div>
		</div>
		
<!-- 模态框（Modal） -->
    <div class="modal fade" id="save" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close btn btn-default" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">修改头像</h4>
                </div>
                <div class="modal-body">
				<form  method="post" class="form-horizontal" action="#" enctype="multipart/form-data" role="form">
                 
			    <input type="file" id="file" name="file" >
				
				<div class="modal-footer">
				<input type="submit" class="btn btn-success save" value="保存"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
                <br />
                
                </form>
				</div>
                
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

<!-- 模态框（Modal）确认收获 -->
	<div class="modal fade" id="goods_delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title" id="delete1">确认收货</h4>
	            </div>
	            <div class="modal-body">
	                您已确认收货?
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-primary" data-dismiss="modal">否</button>
	                <a href="arriveConfirm"><button type="button" class="btn btn-info" >是</button></a>
	                </div>
	                <br />
	        </div><!-- /.modal-content -->
	    </div><!-- /.modal -->
	</div>
<%--修改用户详情成功时提示--%>
    <%String profile_msg=(String)request.getAttribute("profile-msg");
        if(profile_msg!=null){%>
    <script type="text/javascript">
        alert("<%=profile_msg%>");
    </script>
    <%}%>
   <%--确认送达时提示--%>
   <%String confirm_msg=(String)request.getAttribute("confirm-msg");
       if(confirm_msg!=null){%>
   <script type="text/javascript">
       alert("<%=confirm_msg%>");
   </script>
   <%}%>
<script type="text/javascript">
function arrive(id){
	$.ajax({
		type: "post",
		url: "gotoArriveConfirm",
		data: {
			"trackingID": id
		}
	});
}
function checkUser(){
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
    </script>
</body>
</html>
    