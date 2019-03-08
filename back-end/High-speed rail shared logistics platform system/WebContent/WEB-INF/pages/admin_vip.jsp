<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no">
    <title>用户管理</title>
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
                    <li><a href="adminstaff">员工管理</a></li>
                    <li ><a href="admingoods">寄件管理</a></li>
                    <li class="active"><a href="adminvip">用户管理</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container col-md-8 col-md-offset-3">
    <div class="col-md-11">
        <form role="form" class="form-inline vip_search" action="searchUser">

            <div class="form-group">
                <input class="form-control " name="userSearch" type="text" placeholder="请输入需要查找的会员ID">
                <button type="submit" class="form-control btn btn-default">搜索</button>
            </div>
        </form>
        <table class="table table-hover staff col-md-12" style="margin-top: 30px;">
            <thead>
            <tr>
                <th>用户ID</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话号码</th>
				<th>身份证号码</th>
				<th>常用住址</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userlist.list}" var="user">
            <tr>
                <td>${user.userID}</td>
                <td>${user.nickname }</td>
                <td>${user.usersex }</td>
                <td>${user.userphone}</td>
				<td>${user.usernumber}</td>
				<td>${user.useraddress}</td>
				<td><span onclick="edit(${user.userID})" data-toggle="modal" data-target="#vip_edit" class="change_button">修改</span></td>
                <td><span onclick="deleteuser(${user.userID})" data-toggle="modal" data-target="#vip_delete" class="change_button">删除</span></td>
            </tr>
			</c:forEach>
            </tbody>
        </table>
        <div class="col-md-6 col-md-offset-3 pagination_m">
            <ul class="pagination center-block">
           		<c:if test="${userlist.hasPreviousPage}">
                <li><a href="${requestScope.page}?pn=${userlist.prePage}&userSearch=${requestScope.userSearch}">&laquo;</a></li>
                </c:if>
                <c:forEach items="${userlist.navigatepageNums}" var="page">
                <c:if test="${page==userlist.pageNum}">
                <li class="active"><a href="${requestScope.page}?pn=${page}&userSearch=${requestScope.userSearch}">${page}</a></li>
                </c:if>
                <c:if test="${page!=userlist.pageNum}">
                <li><a href="${requestScope.page}?pn=${page}&userSearch=${requestScope.userSearch}">${page }</a></li>
                </c:if>
                </c:forEach>
                <c:if test="${userlist.hasNextPage}">
                <li><a href="${requestScope.page}?pn=${userlist.nextPage}&userSearch=${requestScope.userSearch}">&raquo;</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<!-- 模态框（Modal）修改 -->
<div class="modal fade" id="vip_edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="edit1">用户信息修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal col-md-10 col-md-offset-1" role="form" name="vip_edit" action="editUser" method="post" onsubmit="return vip_editSub()">
                    <input type="hidden" name="hidden_edit_userID" id="hidden_edit_input"/>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="vip_name">姓名</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4 disabled" name="nickname" id="vip_name" onBlur="checkVipName()" >
                            <div id="vipname_prompt"></div>
                    	</div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="sex">性别</label>
                        <div class="col-md-8">
                            <select class="form-control col-md-4" name="usersex" id="sex">
                                <option value="male">男</option>
                                <option value="female">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="phone_num">电话号码</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="userphone" id="phone_num" onBlur="checkPhoneNum()">
                        	<div id="phonenum_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="pin">身份证号码</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="usernumber" id="pin" onBlur="checkPin()">
                        	<div id="pin_prompt"></div>
                        </div>
                    </div>
					<div class="form-group col-md-12">
                        <label class="control-label col-md-4" for="address">常用住址</label>
                        <div class="col-md-8">
                            <input class="form-control col-md-4" name="useraddress" id="address" onBlur="checkAddress()">
                        	<div id="add_prompt"></div>
                        </div>
                    </div>
                    <div class="form-group col-md-12">
                   	 	<label class="control-label col-md-4" for="idcard">身份证</label>
	                    	<div class="col-md-8">
	                            <img height="153px" width="243px" src="" id="idcard">
                        </div>
                    </div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary" onClick="vip_editForm();">提交更改</button>
						
					</div>
	
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 模态框（Modal）确认删除 -->
<div class="modal fade" id="vip_delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="delete1">删除员工</h4>
            </div>
            <div class="modal-body">
                您是否确定要删除？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">否</button>
                <a href="deleteUser"><button type="button" class="btn btn-primary">是</button></a>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<%--修改用户时提示--%>
    <%String edituser_msg=(String)request.getAttribute("edituser-msg");
        if(edituser_msg!=null){%>
    <script type="text/javascript">
        alert("<%=edituser_msg%>");
    </script>
    <%}%>
<%--删除用户时提示--%>
    <%String deleteuser_msg=(String)request.getAttribute("deleteuser-msg");
        if(deleteuser_msg!=null){%>
    <script type="text/javascript">
        alert("<%=deleteuser_msg%>");
    </script>
    <%}%>
    <script type="text/javascript">
    function edit(userID){
    	$.ajax({
    		type: "post",
    		url: "showEditUser",
    		data: {
    			"userID": userID
    		},
    		success:function(data){
    			$("#vip_name").val(data.nickname);
    			$("#sex").val(data.usersex);
    			$("#phone_num").val(data.userphone);
    			$("#pin").val(data.usernumber);
    			$("#address").val(data.useraddress);
    			$("#hidden_edit_input").val(data.userID);
    			$("#idcard").attr('src',data.picture);
    		},
    		error:function(data){
    			alert('error');
    		}
    	});
    }
    function deleteuser(userID){
    	$.ajax({
    		type: "post",
    		url: "gotodeleteuser",
    		data: {
    			"userID": userID
    		}
    	});
    }
    </script>
</body>
</html>