<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>员工管理</title>
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/1.css">
    <script src="js/1.js"></script>
    <link rel="stylesheet" href="css/staff&admin.css">
    <link rel="shortcut  icon" href="image/favicon.ico" type="image/x-icon" />
</head>
<body>
<div class="header">
	<div class="back">
        <button class="btn btn-primary logout"><a href="adminlogout">注销</a></button>
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
        <form role="form" class="form-inline staff_search" action="searchWorker">
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#staff_add">添加员工</button>
            <div class="form-group">
                <input class="form-control" name="search" type="text" placeholder="请输入需要查找的员工姓名或ID">
                <button type="submit" class="form-control btn btn-default">搜索</button>
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
            <c:forEach items="${workerlist.list}" var="worker">
            <tr>
            <td>${worker.workerID}</td>
            <td>${worker.workername}</td>
            <td>${worker.workersex}</td>
            <td>${worker.workerposition}</td>
            <td>${worker.workersalary}</td>
            <td>${worker.workercheckcard}</td>
            <td><span onclick="edit(${worker.workerID})" data-toggle="modal" data-target="#myModal" class="change_button">修改</span></td>
            <td><span onclick="deleteworker(${worker.workerID})" data-toggle="modal" data-target="#staff_delete" class="change_button">删除</span></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3 pagination_m">
            <ul class="pagination center-block">
            <c:if test="${workerlist.hasPreviousPage}">
                <li><a href="${requestScope.page}?pn=${workerlist.prePage}&search=${requestScope.search}">&laquo;</a></li>
            </c:if>
            <c:forEach items="${workerlist.navigatepageNums}" var="page">
            <c:if test="${page==workerlist.pageNum}">
                <li class="active"><a href="${requestScope.page}?pn=${page}&search=${requestScope.search}">${page}</a></li>
            </c:if>
            <c:if test="${page!=workerlist.pageNum}">
            	<li><a href="${requestScope.page}?pn=${page}&search=${requestScope.search}">${page}</a></li>
            </c:if>
            </c:forEach>
            <c:if test="${workerlist.hasNextPage}">
                <li><a href="${requestScope.page}?pn=${workerlist.nextPage}&search=${requestScope.search}">&raquo;</a></li>
            </c:if>
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
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" name="staff_edit" action="editworker" method="post" onsubmit="return staff_editSub()">
                     <input type="hidden" name="hidden_edit_workerID" id="hidden_edit_input"/>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_name">员工姓名</label>
                        <div class="col-md-8">
                            <input class="form-control" id="staff_name" name="edit_worker_name" onBlur="checkStaffName()">
							<div id="staffname_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_pos">职务</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="edit_worker_position" id="staff_pos" onBlur="checkStaffPos()" >
							<div id="staffpos_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sex">性别</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="sex" name="edit_worker_sex">
                                <option value="male">男</option>
                                <option value="female">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="salary">工资</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="salary" name="edit_worker_salary" onBlur="checkSalary()">
							<div id="salary_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="card">卡号</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" id="card" name="edit_worker_checkcard" onBlur="checkCard()" >
							<div id="card_prompt"></div>
                        </div>
                    </div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" onClick="staff_editForm()">提交更改</button>
					</div>

                </form>
            </div>
            <div class="modal-footer">
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
                <a href="adminstaff?pn=${workerlist.pageNum}"><button type="button" class="btn btn-default" data-dismiss="modal">否</button></a>
                <a href="deleteworker?pn=${workerlist.pageNum}"><button type="button" class="btn btn-primary">是</button></a>
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
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" name="staff_add" action="addworker" method="post" onsubmit="return staff_addSub()">
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_name_1">员工姓名</label>
                        <div class="col-md-8">
                            <input class="form-control" name="workername" id="staff_name_1" onBlur="checkStaffName1()"  >
							<div id="staffname1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="staff_pos_1">职务</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" id="staff_pos_1" name="workerposition" onBlur="checkStaffPos1()" >
							<div id="staffpos1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sex_1" >性别</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" id="sex_1" name="workersex">
                                <option value="male">男</option>
                                <option value="female">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="salary_1">工资</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="workersalary" id="salary_1" onBlur="checkSalary1()">
							<div id="salary1_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="card_1">卡号</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="workercheckcard" id="card_1" onBlur="checkCard1()">
							<div id="card1_prompt"></div>
                        </div>
                    </div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" onClick="staff_addsubForm();">增加员工</button>
					</div>

                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--添加员工时提示--%>
    <%String addworker_msg=(String)request.getAttribute("addworker-msg");
        if(addworker_msg!=null){%>
    <script type="text/javascript">
        alert("<%=addworker_msg%>");
    </script>
    <%}%>
</body>
<%--修改员工时提示--%>
    <%String editworker_msg=(String)request.getAttribute("editworker-msg");
        if(editworker_msg!=null){%>
    <script type="text/javascript">
        alert("<%=editworker_msg%>");
    </script>
    <%}%>
<%--删除员工时提示--%>
    <%String deleteworker_msg=(String)request.getAttribute("deleteworker-msg");
        if(deleteworker_msg!=null){%>
    <script type="text/javascript">
        alert("<%=deleteworker_msg%>");
    </script>
    <%}%>
    <script type="text/javascript">
    var hidden_input = document.getElementById("hidden_input");
    function deleteworker(workerID){
    	$.ajax({
    		type: "post",
    		url: "gotodeleteworker",
    		data: {
    			"workerID": workerID
    		}
    	});
    }
    function edit(workerID){
    	$.ajax({
    		type: "post",
    		url: "showEditWorker",
    		data: {
    			workerID: workerID
    		},
    		success: function(data){
    			$("#staff_name").val(data.workername);
    			$("#staff_pos").val(data.workerposition);
    			$("#sex").val(data.workersex);
    			$("#salary").val(data.workersalary);
    			$("#card").val(data.workercheckcard);
    			$("#hidden_edit_input").val(data.workerID);
    		},
    		error: function(data){
    			alert('error');
    		}
    	});
    }
    </script>
</body>
</html>
