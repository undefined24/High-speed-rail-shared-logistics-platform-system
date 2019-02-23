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
	var staffPos = document.getElementById("staff_pos_1").value;
	var staffSex = document.getElementById("sex_1").value;
	var staffSalary = document.getElementById("salary_1").value;
	var staffCard = document.getElementById("card_1").value;
	var reg_num = /^\d+$/;

	console.log(!reg_num.test(staffCard) + "dick")
	if (staffName == ""){
		alert("员工姓名不能为空！");
		return false;
	}
	else if (staffName.length > 10){
		alert("员工姓名长度过长！");
		return false;
	}
	else if (staffPos == ""){
		alert("员工职务不能为空！");
		return false;
	}
	else if (staffPos.length > 10){
		alert("员工职务长度过长！");
		return false;
	}
	else if (staffSalary == ""){
		alert("员工薪水不能为空！");
		return false;
	}
	else if (staffCard == ""){
		alert("员工银行卡不能为空！");
		return false;
	}
	else if (!reg_num.test(staffSalary)){
		alert("员工工资不为整数！");
		return false;
	}
	else if (!reg_num.test(staffCard)){
		alert("员工卡号不正确！");
		return false;
	}
	else if (staffSalary.length > 10){
		alert("员工工资数目大于10！");
		return false;
	}
	else if (staffCard.length > 20){
		alert("员工卡号数目大于20！");
		return false;
	}
	else {
		alert("提交成功！");
		return true;
	}
}

function staff_editSub(){
	var staffName = document.getElementById("staff_name").value;
	var staffPos = document.getElementById("staff_pos").value;
	var staffSex = document.getElementById("sex").value;
	var staffSalary = document.getElementById("salary").value;
	var staffCard = document.getElementById("card").value;
	var reg_num = /^\d+$/;

	console.log(!reg_num.test(staffCard) + "dick")
	if (staffName == ""){
		alert("员工姓名不能为空！");
		return false;
	}
	else if (staffPos == ""){
		alert("员工职务不能为空！");
		return false;
	}
	else if (staffName.length > 10){
		alert("员工姓名长度过长！");
		return false;
	}
	else if (staffPos.length > 10){
		alert("员工职务长度过长！");
		return false;
	}
	else if (staffSalary == ""){
		alert("员工薪水不能为空！");
		return false;
	}
	else if (staffCard == ""){
		alert("员工银行卡不能为空！");
		return false;
	}
	else if (!reg_num.test(staffSalary)){
		alert("员工工资不为整数！");
		return false;
	}
	else if (!reg_num.test(staffCard)){
		alert("员工卡号不正确！");
		return false;
	}
	else if (staffSalary.length > 10){
		alert("员工工资数目大于10！");
		return false;
	}
	else if (staffCard.length > 20){
		alert("员工卡号数目大于20！");
		return false;
	}
	else {
		alert("提交成功！");
		return true;
	}
}

function goods_editSub(){
	var goodsID = document.getElementById("goods_id").value;
	var senderID = document.getElementById("sender_id").value;
	var receiverID = document.getElementById("receiver_id").value;
	var type = document.getElementById("goods_type").value;
	var trainNum = document.getElementById("train_num").value;
	var fee = document.getElementById("fee").value;
	var order = document.getElementById("order").value;
	var orderFinished = document.getElementById("order_finished").value;
	
	var reg_num = /^\d+$/;
	var reg_float = /^\d+(\.\d+)?$/;

	if (goodsID == ""){
		alert("物品ID不能为空！");
		return false;
	}
	else if (senderID == ""){
		alert("下单用户ID不能为空！");
		return false;
	}
	else if (!reg_num.test(senderID)){
		alert("下单用户ID不为整数！");
		return false;
	}
	else if (senderID.length > 10) {
		alert("下单用户ID长度大于10！");
		return false;
	}
	else if (receiverID == ""){
		alert("接单用户ID不能为空！");
		return false;
	}
	else if (!reg_num.test(receiverID)){
		alert("接单用户ID不为整数！");
		return false;
	}
	else if (receiverID.length > 10) {
		alert("接单用户ID长度大于10！");
		return false;
	}
	else if (trainNum == ""){
		alert("车次不能为空！");
		return false;
	}
	else if (trainNum.length > 10) {
		alert("车次长度大于10！");
		return false;
	}
	else if (fee == ""){
		alert("运费不能为空！");
		return false;
	}
	else if (!reg_float.test(fee)){
		alert("运费不为数字！");
		return false;
	}
	else if (fee.length > 10) {
		alert("车次长度大于10！");
		return false;
	}
	else{
		alert("提交成功！");
		return true;
	}
	
}

function goods_addSub(){
	var goodsID = document.getElementById("goods_id_1").value;
	var senderID = document.getElementById("sender_id_1").value;
	var receiverID = document.getElementById("receiver_id_1").value;
	var type = document.getElementById("goods_type_1").value;
	var trainNum = document.getElementById("train_num_1").value;
	var fee = document.getElementById("fee_1").value;
	var order = document.getElementById("order_1").value;
	var orderFinished = document.getElementById("order_finished_1").value;
	
	var reg_num = /^\d+$/;
	var reg_float = /^\d+(\.\d+)?$/;

	if (goodsID == ""){
		alert("物品ID不能为空！");
		return false;
	}
	else if (senderID == ""){
		alert("下单用户ID不能为空！");
		return false;
	}
	else if (!reg_num.test(senderID)){
		alert("下单用户ID不为整数！");
		return false;
	}
	else if (senderID.length > 10) {
		alert("下单用户ID长度大于10！");
		return false;
	}
	else if (receiverID == ""){
		alert("接单用户ID不能为空！");
		return false;
	}
	else if (!reg_num.test(receiverID)){
		alert("接单用户ID不为整数！");
		return false;
	}
	else if (receiverID.length > 10) {
		alert("接单用户ID长度大于10！");
		return false;
	}
	else if (trainNum == ""){
		alert("车次不能为空！");
		return false;
	}
	else if (trainNum.length > 10) {
		alert("车次长度大于10！");
		return false;
	}
	else if (fee == ""){
		alert("运费不能为空！");
		return false;
	}
	else if (!reg_float.test(fee)){
		alert("运费不为数字！");
		return false;
	}
	else if (fee.length > 10) {
		alert("车次长度大于10！");
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

	var reg_pin = /^\d{15}|\d{}18$/
	var reg_phone = /^1\d{10}$/
	
	if (vipID == ""){
		alert("用户ID不能为空！");
		return false;
	}
	else if (vipName == ""){
		alert("用户姓名不能为空！");
		return false;
	}
	else if (vipName.length > 10){
		alert("用户姓名过长！");
		return false;
	}
	else if (phoneNum == ""){
		alert("用户电话号码不能为空！");
		return false;
	}
	else if (!reg_phone.test(phoneNum)){
		alert("用户电话号码格式错误！");
		return false;
	}
	else if (pin == ""){
		alert("用户身份证号码不能为空！");
		return false;
	}
	else if (!reg_pin.test(pin)){
		alert("用户身份证号码格式错误！");
		return false;
	}
	else if (address == ""){
		alert("用户地址不能为空！");
		return false;
	}
	else if (address.length > 25){
		alert("用户地址大于25！");
		return false;
	}
	else{
		alert("提交成功！");
		return true;
	}
}

function My_Order_Sub(){
	orderNum = document.getElementById("order_num").value;
}