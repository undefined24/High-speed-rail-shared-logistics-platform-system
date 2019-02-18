<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>admin_staff</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/1.css">
    <script src="js/1.js"></script>
    <link rel="stylesheet" href="css/staff&admin.css">
</head>
<body>
<script>
	
</script>
<div class="header"></div>
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
        <form role="form" class="form-inline staff_search">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#staff_add">添加员工</button>
            <div class="form-group">
                <input class="form-control " type="text" placeholder="请输入需要查找的员工姓名">
                <button class="form-control btn btn-default">搜索</button>
            </div>
        </form>
        <table class="table table-hover staff col-md-12">
            <thead>
            <tr>
                <th>员工工号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>职务</th>
                <th>工资</th>
                <th>卡号</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${workerlist}" var="worker">
            <tr>
            <td>${worker.workerID}</td>
            <td>${worker.workername}</td>
            <td>${worker.workersex}</td>
            <td>${worker.workersalary}</td>
            <td>${worker.workercheckcard}</td>
            <td><span data-toggle="modal" data-target="#myModal">修改</span></td>
            <td><span data-toggle="modal" data-target="#staff_delete">删除</span></td>
            </tr>
            </c:forEach>
            <!-- <tr>
                <td>352132</td>
                <td>fying</td>
                <td>女</td>
                <td>客服</td>
                <td>5300</td>
                <td>123456789101112</td>
                <td><span data-toggle="modal" data-target="#myModal">修改</span></td>
                <td><span data-toggle="modal" data-target="#staff_delete">删除</span></td>
            </tr>
            <tr>
                <td>236135</td>
                <td>pujess</td>
                <td>男</td>
                <td>客服</td>
                <td>5300</td>
                <td>123456789101112</td>
                <td><span data-toggle="modal" data-target="#myModal">修改</span></td>
                <td><span data-toggle="modal" data-target="#staff_delete">删除</span></td>
            </tr> -->
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3 pagination_m">
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
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">员工信息修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="#" method="post">
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_name">员工姓名</label>
                        <div class="col-md-8">
                            <input class="form-control"  id="staff_name" value="fyw" >
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_id">员工工号</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="staff_id" value="123456">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_pos">职务</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="staff_pos" >
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sex">性别</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4"  id="sex">
                                <option value="male">男</option>
                                <option value="female">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="salary">工资</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="salary" >
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="card">卡号</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="card" >
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onClick="staff_editSub()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 模态框（Modal）确认删除 -->
<div class="modal fade" id="staff_delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel3">删除员工</h4>
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
<div class="modal fade" id="staff_add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="add">添加员工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" action="addworker" method="post">
                    <span style="color:red;margin-left:45px"><%=request.getAttribute("addworker-msg")==null?"":request.getAttribute("addworker-msg") %></span>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_name_1">员工姓名</label>
                        <div class="col-md-8">
                            <input class="form-control" id="staff_name_1" name="workername" >
                        </div>
                    </div>
                    <!-- <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_id_1">员工工号</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="workernumber" id="staff_id_1" value="">
                        </div>
                    </div> -->
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_pos_1">职务</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="workerposition" id="staff_pos_1">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sex_1">性别</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" name="workersex" id="sex_1">
                                <option value="male">男</option>
                                <option value="female">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="salary_1">工资</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="workersalary" id="salary_1">
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="card_1">卡号</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="workercheckcard" id="card_1">
                        </div>
                    </div>


                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" onClick="staff_addSub()">增加员工</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
