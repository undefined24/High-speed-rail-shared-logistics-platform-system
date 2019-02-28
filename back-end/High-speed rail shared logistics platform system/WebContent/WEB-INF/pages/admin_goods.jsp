<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>admin_goods</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
    <script src="js/1.js"></script>
    <link rel="stylesheet" href="css/staff&admin.css">
</head>
<body>
<div class="header">
	<div class="back">
        <a href="adminlogout">注销</a>
    </div>
</div>
<div class="col-md-2 list">
    <div class="admin_info">
        <img class="center-block" src="image/2089312254@chatroom_1486356859619_63.jpg" />
        <div class="text-center">
           <span>工号：</span><span>${login_admin.adminID}</span><br/>
            <span>${login_admin.adminname}</span><span>，欢迎你</span>
        </div>

    </div>
    <nav class="navbar navbar-inverse  m_nav text-center" role="navigation">
        <div class="container-fluid">
            <div>
                <ul class="nav navbar-nav navbar-inverse" >
                    <li ><a href="adminstaff">员工管理</a></li>
                    <li class="active"><a href="admingoods">寄件管理</a></li>
                    <li ><a href="adminvip">用户管理</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container col-md-8 col-md-offset-3">
    <div class="col-md-11">
		<form role="form" class="form-inline goods_search" action="searchGoods">
			<!-- 取消物品添加功能 -->
            <!-- <button type="button" class="btn btn-default" data-toggle="modal" data-target="#add_goods">添加物品</button> -->
            <div class="form-group">
                <input class="form-control " type="text" name="search" placeholder="请输入需要查找的物品ID">
                <button class="form-control btn btn-default">搜索</button>
            </div>
        </form>
        <table class="table table-hover goods col-md-12 ">
            <thead>
            <tr>
                <th>物品ID</th>
                <th>名称</th>
                <th>下单用户ID</th>
				<th>接单用户ID</th>
                <th>类型</th>
                <th>重量</th>
				<th>车次</th>
                <th>运费</th>
				<th>是否接单</th>
				<th>是否完成订单</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${goodslist.list}" var="goods">
            <tr>
                <td>${goods.trackingID}</td>
                <td>${goods.name}</td>
                <td>${goods.bill.giveUserID}</td>
                <td>${goods.bill.acceptUserID}</td>
				<td>${goods.type}</td>
                <td>${goods.weight}</td>
                <td>${goods.bill.trainnumber}</td>
                <td>${goods.bill.cost}</td>
                <c:if test="${goods.bill.acceptUserID!=null}">
				<td>是</td>
				</c:if>
				<c:if test="${goods.bill.acceptUserID==null}">
				<td>否</td>
				</c:if>
				<c:if test="${goods.bill.complete==false}">
				<td>否</td>
				</c:if>
				<c:if test="${goods.bill.complete==true}">
				<td>是</td>
				</c:if>
				<td><a data-toggle="modal" data-target="#goods_edit" href="gotoEditGoods?edit_trackingID=${goods.trackingID}">修改</a></td>
                <td><a data-toggle="modal" data-target="#goods_delete" href="gotoDeleteGoods?delete_trackingID=${goods.trackingID}">删除</a></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3 pagination_m col-lg-7">
            <ul class="pagination center-block">
             	<c:if test="${goodslist.hasPreviousPage}">
                <li><a href="${requestScope.page}?pn=${goodslist.prePage}&search=${requestScope.search}">&laquo;</a></li>
                </c:if>
                 <c:forEach items="${goodslist.navigatepageNums}" var="page">
                  <c:if test="${page==goodslist.pageNum}">
                <li class="active"><a href="${requestScope.page}?pn=${page}&search=${requestScope.search}">${page}</a></li>
                </c:if>
                <c:if test="${page!=goodslist.pageNum}">
                <li><a href="${requestScope.page}?pn=${page}&search=${requestScope.search}">${page}</a></li>
                </c:if>
                </c:forEach>
                <c:if test="${goodslist.hasNextPage}">
                <li><a href="${requestScope.page}?pn=${goodslist.nextPage}&search=${requestScope.search}">&raquo;</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>

<!-- 模态框（Modal）修改 -->
<div class="modal fade" id="goods_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="edit">物品信息修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="editgoods" method="post" name="goods_edit" onsubmit="return goods_editSub()">
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_name">名称</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="name" id="goods_name" onBlur="checkGoodName()" value="">
							<div id="name_prompt"></div>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sender_id">下单用户ID</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="sender_id" name="giveUserID" onBlur="checkSenderid()" value="<c:out value='${edit_goods.bill.giveUserID}'/>">
							<div id="senderid_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="receiver_id">接单用户ID</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="receiver_id" name="acceptUserID" onBlur="checkReceiverid()" value=${edit_goods.bill.acceptUserID}>
							<div id="receiverid_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_type">类型</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="goods_type" name="type">
                                <option value="1">文件</option>
                                <option value="2">数码产品</option>
								<option value="3">生活用品</option>
                                <option value="4">服饰</option>
								<option value="5">食品</option>
                                <option value="6">其他</option>
                            </select>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="weight">重量</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="weight" name="weight" onBlur="checkWeight()" value=${edit_goods.weight}>
							<div id="weight_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="train_num">车次</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="train_num" name="trainnumber" onBlur="checkTrainnum()" value=${edit_goods.bill.trainnumber}>
							<div id="trainnum_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="fee">运费</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="fee" name="cost" onBlur="checkFee()" value=${edit_goods.bill.cost}>
							<div id="fee_prompt"></div>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="order">是否接单</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="order">
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="order_finished">是否完成订单</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="order_finished" name="complete">
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" onClick="goods_editForm()">提交更改</button>
					</div>

                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>	

<!-- 模态框（Modal）确认删除 -->
<div class="modal fade" id="goods_delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="delete">删除物品</h4>
            </div>
            <div class="modal-body">
                您是否确定要删除？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <a href="deletegoods?pn=${goodslist.pageNum}"><button type="button" class="btn btn-primary">是</button></a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
	
<!-- 模态框（Modal）添加 -->
<div class="modal fade" id="add_goods" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="add">添加物品</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="addgoods" method="post">
                	<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_name">名称</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="name" id="goods_name_1" onBlur="checkGoodName1()" value="">
							<div id="name_prompt"></div>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sender_id_1">下单用户ID</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="giveUserID" id="sender_id_1" onBlur="checkSenderid1()" value="">
							<div id="sederid1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="receiver_id_1">接单用户ID</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="acceptUserID" id="receiver_id_1" onBlur="checkReceiverid1()" value="">
							<div id="receiverid1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_type_1">类型</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" name="type" id="goods_type_1">
                                <option value="1">文件</option>
                                <option value="2">数码产品</option>
								<option value="3">生活用品</option>
                                <option value="4">服饰</option>
								<option value="5">食品</option>
                                <option value="6">其他</option>
                            </select>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="weight_1">重量</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="weight" id="weight_1" onBlur="checkWeight1()" value="">
							<div id="weight1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="train_num_1">车次</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="trainnumber" id="train_num_1" onBlur="checkTrainnum1()" value="">
							<div id="trainnum1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="fee_1">运费</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="fee_1" name="cost" onBlur="checkFee1()" value="">
							<div id="fee1_prompt"></div>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="order_1">是否接单</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="order_1" >
                                <option value="ture">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="order_finished_1">是否完成订单</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="order_finished_1" name="complete">
                                <option value="true">是</option>
                                <option value="false">否</option>
                            </select>
                        </div>
                    </div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" onClick="goods_addSub()">增加物品</button>
					</div>

                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--添加物品时提示--%>
    <%String addgoods_msg=(String)request.getAttribute("addgoods-msg");
        if(addgoods_msg!=null){%>
    <script type="text/javascript">
        alert("<%=addgoods_msg%>");
    </script>
    <%}%>
</body>
<%--修改物品时提示--%>
    <%String editgoods_msg=(String)request.getAttribute("editgoods-msg");
        if(editgoods_msg!=null){%>
    <script type="text/javascript">
        alert("<%=editgoods_msg%>");
    </script>
    <%}%>
<%--删除物品时提示--%>
    <%String deletegoods_msg=(String)request.getAttribute("deletegoods-msg");
        if(deletegoods_msg!=null){%>
    <script type="text/javascript">
        alert("<%=deletegoods_msg%>");
    </script>
    <%}%>
</body>
</html>