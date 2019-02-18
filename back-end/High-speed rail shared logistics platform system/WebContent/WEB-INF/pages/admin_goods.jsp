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
    <link rel="stylesheet" href="../../css/1.css">
    <script src="js/1.js"></script>
    <link rel="stylesheet" href="css/staff&admin.css">
</head>
<body>
<div class="header"></div>
<div class="col-md-2 list">
    <div class="admin_info">
        <img class="center-block" src="../image/2089312254@chatroom_1486356859619_63.jpg" />
        <div class="text-center">
           <span>工号：</span><span>${login_admin.adminID}</span><br/>
            <span>${login_admin.adminname}</span><span>，欢迎你</span>
        </div>

    </div>
    <nav class="navbar navbar-inverse  m_nav text-center" role="navigation">
        <div class="container-fluid">
            <div>
                <ul class="nav navbar-nav navbar-inverse" >
                    <li class="active"><a href="adminstaff">员工管理</a></li>
                    <li ><a href="admingoods">寄件管理</a></li>
                    <li ><a href="adminvip">用户管理</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container col-md-8 col-md-offset-3">
    <div class="col-md-11">
		<form role="form" class="form-inline goods_search">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#add_goods">添加物品</button>
            <div class="form-group">
                <input class="form-control " type="text" placeholder="请输入需要查找的物品ID">
                <button class="form-control btn btn-default">搜索</button>
            </div>
        </form>
        <table class="table table-hover goods col-md-12 ">
            <thead>
            <tr>
                <th>物品ID</th>
                <th>类型</th>
                <th>重量</th>
                <th>高铁出发点（省份-站点）</th>
				<th>车次</th>
                <th>高铁出发时间（年-月-日-时-分）</th>
                <th>运费</th>
				<th>是否接单</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>000001</td>
                <td>食品</td>
                <td>1kg</td>
                <td>广东-江门东</td>
				<td>C71000</td>
                <td>2019-02-17-21-33</td>
                <td>5.40</td>
				<td>否</td>
				<td><span data-toggle="modal" data-target="#goods_edit">修改</span></td>
                <td><span data-toggle="modal" data-target="#goods_delete">删除</span></td>
            </tr>
            <tr>
                <td>000006</td>
                <td>文件</td>
                <td>0.1kg</td>
                <td>广东-江门东</td>
				<td>C71000</td>
                <td>2019-02-17-21-33</td>
                <td>15.40</td>
				<td>否</td>
				<td><span data-toggle="modal" data-target="#goods_edit">修改</span></td>
                <td><span data-toggle="modal" data-target="#goods_delete">删除</span></td>
            </tr>
            <tr>
                <td>000232</td>
                <td>饮料</td>
                <td>2kg</td>
                <td>广东-江门东</td>
				<td>C71000</td>
                <td>2019-02-17-21-33</td>
                <td>15.40</td>
				<td>是</td>
				<td><span data-toggle="modal" data-target="#goods_edit">修改</span></td>
                <td><span data-toggle="modal" data-target="#goods_delete">删除</span></td>
            </tr>
           
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3 pagination_m col-lg-7">
            <ul class="pagination center-block">
                <li><a href="#">&laquo;</a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&raquo;</a></li>
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
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="#" method="post">
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_id">物品ID</label>
                        <div class="col-md-8">
                            <input class="form-control" id="goods_id" value="" >
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_type">类型</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="goods_type">
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
                            <input class="form-control col-md-4 disabled" id="weight" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="start_pos">高铁出发点</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="start_pos" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="train_num">车次</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="train_num" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="start_time">高铁出发时间</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="start_time" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="fee">运费</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="fee" value="">
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="order">是否接单</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="order">
                                <option value="yes">是</option>
                                <option value="no">否</option>
                            </select>
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onClick="goods_editSub()">提交更改</button>
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
                <button type="button" class="btn btn-primary">是</button>
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
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="#" method="post">
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_id_1">物品ID</label>
                        <div class="col-md-8">
                            <input class="form-control" id="goods_id_1" value="" >
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="goods_type_1">类型</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="goods_type_1">
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
                            <input class="form-control col-md-4 disabled" id="weight_1" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="start_pos_1">高铁出发点</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="start_pos_1" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="train_num_1">车次</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="train_num_1" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="start_time_1">高铁出发时间</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="start_time_1" value="">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="fee_1">运费</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="fee_1" value="">
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="order_1">是否接单</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="order_1">
                                <option value="yes">是</option>
                                <option value="no">否</option>
                            </select>
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onClick="goods_addSub()">增加物品</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
