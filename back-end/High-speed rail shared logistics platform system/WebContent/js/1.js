$("document").ready(function () {
   $(".cart_button").mouseover(function () {
       $(".cart").slideDown();
   });
    $(".cart").mouseleave(function () {
        $(".cart").slideUp()
    })
});

function staff_addSub(){
	var staffName = document.getElementById("staff_name_1").value;
	var staffID = document.getElementById("staff_id_1").value;
	var staffPos = document.getElementById("staff_pos_1").value;
	var staffSex = document.getElementById("sex_1").value;
	var staffSalary = document.getElementById("salary_1").value;
	var staffCard = document.getElementById("card_1").value;
	
	if (staffName == ""){
		alert("员工姓名不能为空！");
		return false;
	}
	else if (staffID == ""){
		alert("员工工号不能为空！");
		return false;
	}
	else if (staffPos == ""){
		alert("员工职务不能为空！");
		return false;
	}
	else {
		alert("提交成功！");
		return true;
	}
}

function staff_editSub(){
	var staffName = document.getElementById("staff_name").value;
//	var staffID = document.getElementById("staff_id").value;
	var staffPos = document.getElementById("staff_pos").value;
	var staffSex = document.getElementById("sex").value;
	var staffSalary = document.getElementById("salary").value;
	var staffCard = document.getElementById("card").value;
	
	if (staffName == ""){
		alert("员工姓名不能为空！");
		return false;
	}
	else if (staffID == ""){
		alert("员工工号不能为空！");
		return false;
	}
	else if (staffPos == ""){
		alert("员工职务不能为空！");
		return false;
	}
	else {
		alert("提交成功！");
		return true;
	}
}

function goods_editSub(){
	var goodsID = document.getElementById("goods_id").value;
	var type = document.getElementById("goods_type").value;
	var startPos = document.getElementById("start_pos").value;
	var trainNum = document.getElementById("train_num").value;
	var startTime = document.getElementById("start_time").value;
	var fee = document.getElementById("fee").value;
	var order = document.getElementById("order").value;
	
	if (goodsID == ""){
		alert("物品ID不能为空！");
		return false;
	}
	
	else if (startPos == ""){
		alert("高铁出发时间不能为空！");
		return false;
	}
	
	else if (trainNum == ""){
		alert("车次不能为空！");
		return false;
	}
	
	else if (startTime == ""){
		alert("出发时间不能为空！");
		return false;
	}
	
	else if (fee == ""){
		alert("运费不能为空！");
		return false;
	}
	
	else{
		alert("提交成功！");
		return true;
	}
	
}

function goods_addSub(){
	var goodsID = document.getElementById("goods_id_1").value;
	var type = document.getElementById("goods_type_1").value;
	var startPos = document.getElementById("start_pos_1").value;
	var trainNum = document.getElementById("train_num_1").value;
	var startTime = document.getElementById("start_time_1").value;
	var fee = document.getElementById("fee_1").value;
	var order = document.getElementById("order_1").value;
	
	if (goodsID == ""){
		alert("物品ID不能为空！");
		return false;
	}
	
	else if (startPos == ""){
		alert("高铁出发时间不能为空！");
		return false;
	}
	
	else if (trainNum == ""){
		alert("车次不能为空！");
		return false;
	}
	
	else if (startTime == ""){
		alert("出发时间不能为空！");
		return false;
	}
	
	else if (fee == ""){
		alert("运费不能为空！");
		return false;
	}
	
	else{
		alert("提交成功！");
		return true;
	}
	
}

function vip_editSub(){
	var vipID = document.getElementById("vip_ID").value;
	var vipName = document.getElementById("vip_name").value;
	var sex = document.getElementById("sex").value;
	var phoneNum = document.getElementById("phone_num").value;
	var pin = document.getElementById("pin").value;
	var address = document.getElementById("address").value;
	
	if (vipID == ""){
		alert("用户ID不能为空！");
		return false;
	}
	
	else if (vipName == ""){
		alert("用户姓名不能为空！");
		return false;
	}
	
	else if (phoneNum == ""){
		alert("用户电话号码不能为空！");
		return false;
	}
	
	else if (pin == ""){
		alert("用户身份证号码不能为空！");
		return false;
	}
	
	else if (address == ""){
		alert("用户地址不能为空！");
		return false;
	}
	
	else{
		alert("提交成功！");
		return true;
	}
}