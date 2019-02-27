$("document").ready(function () {
   $(".cart_button").mouseover(function () {
       $(".cart").slideDown();
   });
    $(".cart").mouseleave(function () {
        $(".cart").slideUp()
    })
});

function checkStaffName(){
	var staffName=document.getElementById("staff_name").value;
	var divStaffName=document.getElementById("staffname_prompt");
	
	divStaffName.innerHTML="";
	if (staffName == ""){
		staff_name.value = "";
		divStaffName.innerHTML="员工姓名不能为空！";
		return false;
	}
	else if (staffName.length > 10){
		staff_name.value = "";
		divStaffName.innerHTML="员工姓名长度过长！";
		return false;
	}
	divStaffName.innerHTML="";
	return true;
}

function checkStaffPos(){
	var staffPos=document.getElementById("staff_pos").value;
	var divStaffPos=document.getElementById("staffpos_prompt");
	
	divStaffPos.innerHTML="";
	if (staffPos == ""){
		staff_pos.value = "";
		divStaffPos.innerHTML="员工职务不能为空！";
		return false;
	}
	else if (staffPos.length > 10){
		staff_pos.value = "";
		divStaffPos.innerHTML="员工职务长度过长！";
		return false;
	}
	divStaffPos.innerHTML="";
	return true;
}

function checkSalary(){
	var staffSalary=document.getElementById("salary").value;
	var divStaffSalary=document.getElementById("salary_prompt");
	var reg_num = /^\d+$/;
	
	divStaffSalary.innerHTML="";
	if (staffSalary == ""){
		salary.value = "";
		divStaffSalary.innerHTML="员工工资不能为空！";
		return false;
	}
	else if (staffSalary.length > 10){
		salary.value = "";
		divStaffSalary.innerHTML="员工工资长度过长！";
		return false;
	}
	else if (!reg_num.test(staffSalary)){
		salary.value = "";
		divStaffSalary.innerHTML="员工工资不为整数！";
		return false;
	}
	divStaffSalary.innerHTML="";
	return true;
}

function checkCard(){
	var staffCard=document.getElementById("card").value;
	var divStaffCard=document.getElementById("card_prompt");
	var reg_num = /^\d+$/;
	
	divStaffCard.innerHTML="";
	if (staffCard == ""){
		card.value = "";
		divStaffCard.innerHTML="员工卡号不能为空！";
		return false;
	}
	else if (staffCard.length > 20){
		card.value = "";
		divStaffCard.innerHTML="员工卡号长度过长！";
		return false;
	}
	else if (!reg_num.test(staffCard)){
		card.value = "";
		divStaffCard.innerHTML="员工卡号不为整数！";
		return false;
	}
	divStaffCard.innerHTML="";
	return true;
}

function staff_editSub(){
	if(checkStaffName() && checkStaffPos() && checkSalary() && checkCard()){
		return true;
	}
	else{
		return false;
	}
}

function staff_editForm(){
	if (staff_editSub()){
		document.staff_edit.submit();
		//alert("修改成功！");
	}
	else{
		alert("修改失败！");
	}
}

function checkStaffName1(){
	var staffName=document.getElementById("staff_name_1").value;
	var divStaffName=document.getElementById("staffname1_prompt");
	
	divStaffName.innerHTML="";
	if (staffName == ""){
		staff_name_1.value = "";
		divStaffName.innerHTML="员工姓名不能为空！";
		return false;
	}
	else if (staffName.length > 10){
		staff_name_1.value = "";
		divStaffName.innerHTML="员工姓名长度过长！";
		return false;
	}
	divStaffName.innerHTML="";
	return true;
}

function checkStaffPos1(){
	var staffPos=document.getElementById("staff_pos_1").value;
	var divStaffPos=document.getElementById("staffpos1_prompt");
	
	divStaffPos.innerHTML="";
	if (staffPos == ""){
		staff_pos_1.value = "";
		divStaffPos.innerHTML="员工职务不能为空！";
		return false;
	}
	else if (staffPos.length > 10){
		staff_pos_1.value = "";
		divStaffPos.innerHTML="员工职务长度过长！";
		return false;
	}
	divStaffPos.innerHTML="";
	return true;
}

function checkSalary1(){
	var staffSalary=document.getElementById("salary_1").value;
	var divStaffSalary=document.getElementById("salary1_prompt");
	var reg_num = /^\d+$/;
	
	divStaffSalary.innerHTML="";
	if (staffSalary == ""){
		salary_1.value = "";
		divStaffSalary.innerHTML="员工工资不能为空！";
		return false;
	}
	else if (staffSalary.length > 10){
		salary_1.value = "";
		divStaffSalary.innerHTML="员工工资长度过长！";
		return false;
	}
	else if (!reg_num.test(staffSalary)){
		salary_1.value = "";
		divStaffSalary.innerHTML="员工工资不为整数！";
		return false;
	}
	divStaffSalary.innerHTML="";
	return true;
}

function checkCard1(){
	var staffCard=document.getElementById("card_1").value;
	var divStaffCard=document.getElementById("card1_prompt");
	var reg_num = /^\d+$/;
	
	divStaffCard.innerHTML="";
	if (staffCard == ""){
		card_1.value = "";
		divStaffCard.innerHTML="员工卡号不能为空！";
		return false;
	}
	else if (staffCard.length > 20){
		card_1.value = "";
		divStaffCard.innerHTML="员工卡号长度过长！";
		return false;
	}
	else if (!reg_num.test(staffCard)){
		card_1.value = "";
		divStaffCard.innerHTML="员工卡号不为整数！";
		return false;
	}
	divStaffCard.innerHTML="";
	return true;
}

function staff_addSub(){
	if(checkStaffName1() && checkStaffPos1() && checkSalary1() && checkCard1()){
		return true;
	}
	else{
		return false;
	}
}

function staff_addsubForm(){
	if (staff_addSub()){
		document.staff_add.submit();
		alert("添加成功！");
	}
	else{
		alert("添加失败！");
	}
	
}

function checkGoodName(){
	var goodName = document.getElementById("goods_name").value;
	var divGoodName=document.getElementById("name_prompt");
	divGoodName.innerHTML = "";
	if(goodName == ""){
		goods_name.value = "";
		divGoodName.innerHTML = "物品名不能为空";
		return false;
	}
	else if(goodName.length > 20){
		goods_name.value = "";
		divGoodName.innerHTML = "物品名长度不能大于20";
		return false;
	}
	divGoodName.innerHTML = "";
	return true;
}

function checkSenderid(){
	var senderID=document.getElementById("sender_id").value;
	var divSenderID=document.getElementById("senderid_prompt");
	var reg_num = /^[1-9]\d*$/;
	divSenderID.innerHTML="";
	if (senderID == ""){
		sender_id.value = "";
		divSenderID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(senderID)){
		sender_id.value = "";
		divSenderID.innerHTML = "下单用户ID不为正数！"
		return false;
	}
	else if (senderID.length > 10) {
		sender_id.value = "";
		divSenderID.innerHTML = "下单用户ID长度大于10！"
		return false;
	}
	divSenderID.innerHTML="";
	return true;
}

function checkReceiverid(){
	var receiverID=document.getElementById("receiver_id").value;
	var divReceiverID=document.getElementById("receiverid_prompt");
	var reg_num = /^[1-9]\d*$/;
	divReceiverID.innerHTML="";
	if (receiverID == ""){
		receiver_id.value = "";
		divReceiverID.innerHTML = "接单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(receiverID)){
		receiver_id.value = "";
		divReceiverID.innerHTML = "接单用户ID不为正数！"
		return false;
	}
	else if (receiverID.length > 10) {
		receiver_id.value = "";
		divReceiverID.innerHTML = "接单用户ID长度大于10！"
		return false;
	}
	divReceiverID.innerHTML="";
	return true;
}

function checkWeight(){
	var Weight=document.getElementById("weight").value;
	var divWeight=document.getElementById("weight_prompt");
	var reg_float = /^\d+(\.\d+)?$/;
	divWeight.innerHTML="";
	if (Weight == ""){
		weight.value = "";
		divWeight.innerHTML = "重量不能为空！"
		return false;
	}
	else if (!reg_float.test(Weight)){
		weight.value = "";
		divWeight.innerHTML = "重量不为数字！"
		return false;
	}
	else if (Weight.length > 10) {
		weight.value = "";
		divWeight.innerHTML = "重量长度大于10！"
		return false;
	}
	divWeight.innerHTML="";
	return true;
}

function checkTrainnum(){
	var trainNum=document.getElementById("train_num").value;
	var divTrainNum=document.getElementById("trainnum_prompt");
	
	divTrainNum.innerHTML="";
	if (trainNum == ""){
		train_num.value = "";
		divTrainNum.innerHTML = "车次不能为空！"
		return false;
	}
	
	else if (trainNum.length > 10) {
		train_num.value = "";
		divTrainNum.innerHTML = "车次长度大于10！"
		return false;
	}
	divTrainNum.innerHTML="";
	return true;
}

function checkFee(){
	var Fee=document.getElementById("fee").value;
	var divFee=document.getElementById("fee_prompt");
	var reg_float = /^\d+(\.\d+)?$/;
	divFee.innerHTML="";
	if (Fee == ""){
		fee.value = "";
		divFee.innerHTML = "运费不能为空！"
		return false;
	}
	else if (!reg_float.test(Fee)){
		fee.value = "";
		divFee.innerHTML = "运费不为数字！"
		return false;
	}
	else if (Fee.length > 10) {
		fee.value = "";
		divFee.innerHTML = "运费长度大于10！"
		return false;
	}
	divFee.innerHTML="";
	return true;
}

function goods_editSub(){
	if(checkSenderid() && checkReceiverid() && checkWeight() && checkTrainnum() && checkFee() && checkGoodName()){
		return true;
	}
	else{
		return false;
	}
}

function goods_editForm(){
	if (goods_editSub()){
		document.goods_edit.submit();
		//alert("修改成功！");
	}
	else{
		alert("修改失败！");
	}
}

function checkSenderid1(){
	var senderID=document.getElementById("sender_id_1").value;
	var divSenderID=document.getElementById("sederid1_prompt");
	var reg_num = /^[1-9]\d*$/;
	divSenderID.innerHTML="";
	if (senderID == ""){
		sender_id_1.value = "";
		divSenderID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(senderID)){
		sender_id_1.value = "";
		divSenderID.innerHTML = "下单用户ID不为正数！"
		return false;
	}
	else if (senderID.length > 10) {
		sender_id_1.value = "";
		divSenderID.innerHTML = "下单用户ID长度大于10！"
		return false;
	}
	divSenderID.innerHTML="";
	return true;
}

function checkReceiverid1(){
	var receiverID=document.getElementById("receiver_id_1").value;
	var divReceiverID=document.getElementById("receiverid1_prompt");
	var reg_num = /^[1-9]\d*$/;
	divReceiverID.innerHTML="";
	if (receiverID == ""){
		receiver_id_1.value = "";
		divReceiverID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(receiverID)){
		receiver_id_1.value = "";
		divReceiverID.innerHTML = "下单用户ID不为正数！"
		return false;
	}
	else if (receiverID.length > 10) {
		receiver_id_1.value = "";
		divReceiverID.innerHTML = "下单用户ID长度大于10！"
		return false;
	}
	divReceiverID.innerHTML="";
	return true;
}

function checkWeight1(){
	var Weight=document.getElementById("weight_1").value;
	var divWeight=document.getElementById("weight1_prompt");
	var reg_float = /^\d+(\.\d+)?$/;
	divWeight.innerHTML="";
	if (Weight == ""){
		weight_1.value = "";
		divWeight.innerHTML = "重量不能为空！"
		return false;
	}
	else if (!reg_float.test(Weight)){
		weight_1.value = "";
		divWeight.innerHTML = "重量不为数字！"
		return false;
	}
	else if (Weight.length > 10) {
		weight_1.value = "";
		divWeight.innerHTML = "重量长度大于10！"
		return false;
	}
	divWeight.innerHTML="";
	return true;
}

function checkTrainnum1(){
	var trainNum=document.getElementById("train_num_1").value;
	var divTrainNum=document.getElementById("trainnum1_prompt");
	
	divTrainNum.innerHTML="";
	if (trainNum == ""){
		train_num_1.value = "";
		divTrainNum.innerHTML = "车次不能为空！"
		return false;
	}
	
	else if (trainNum.length > 10) {
		train_num_1.value = "";
		divTrainNum.innerHTML = "车次长度大于10！"
		return false;
	}
	divTrainNum.innerHTML="";
	return true;
}

function checkFee1(){
	var Fee=document.getElementById("fee_1").value;
	var divFee=document.getElementById("fee1_prompt");
	var reg_float = /^\d+(\.\d+)?$/;
	divFee.innerHTML="";
	if (Fee == ""){
		fee_1.value = "";
		divFee.innerHTML = "运费不能为空！"
		return false;
	}
	else if (!reg_float.test(Fee)){
		fee_1.value = "";
		divFee.innerHTML = "运费不为数字！"
		return false;
	}
	else if (Fee.length > 10) {
		fee_1.value = "";
		divFee.innerHTML = "运费长度大于10！"
		return false;
	}
	divFee.innerHTML="";
	return true;
}

function checkGoodName1(){
	var goodName = document.getElementById("goods_name_1").value;
	var divGoodName=document.getElementById("name_prompt");
	divGoodName.innerHTML = "";
	if(goodName == ""){
		goods_name_1.value = "";
		divGoodName.innerHTML = "物品名不能为空";
		return false;
	}
	else if(goodName.length > 20){
		goods_name_1.value = "";
		divGoodName.innerHTML = "物品名长度不能大于20";
		return false;
	}
	divGoodName.innerHTML = "";
	return true;
}

function goods_addSub(){
	if(checkSenderid1() && checkReceiverid1() && checkWeight1() && checkTrainnum1() && checkFee1() && checkGoodName1()){
		return true;
	}
	else{
		return false;
	}
}

function goods_addForm(){
	if (goods_addSub()){
		document.goods_add.submit();
		alert("添加成功！");
	}
	else{
		alert("添加失败！");
	}
}

function checkVipID(){
	var vipID = document.getElementById("vip_ID").value;
	var divVipID=document.getElementById("vipid_prompt");
	divVipID.innerHTML="";
	if (vipID == ""){
		vip_ID.value = "";
		divVipID.innerHTML = "用户ID不能为空！"
		return false;
	}
	divVipID.innerHTML="";
	return true;
}

function checkVipName(){
	var vipName = document.getElementById("vip_name").value;
	var divVipName=document.getElementById("vipname_prompt");
	
	divVipName.innerHTML="";
	if (vipName == ""){
		vip_name.value = "";
		divVipName.innerHTML = "用户姓名不能为空！"
		return false;
	}
	else if (vipName.length > 10) {
		vip_name.value = "";
		divVipName.innerHTML = "用户姓名长度大于10！"
		return false;
	}
	divVipName.innerHTML="";
	return true;
}

function checkPhoneNum(){
	var phoneNum = document.getElementById("phone_num").value;
	var divPhoneNum=document.getElementById("phonenum_prompt");
	
	var reg_phone = /^1\d{10}$/
	divPhoneNum.innerHTML="";
	if (phoneNum == ""){
		phone_num.value = "";
		divPhoneNum.innerHTML = "用户电话号码不能为空！"
		return false;
	}
	else if (!reg_phone.test(phoneNum)){
		phone_num.value = "";
		divPhoneNum.innerHTML = "用户电话号码格式错误！"
		return false;
	}
	divPhoneNum.innerHTML="";
	return true;
}

function checkPin(){
	var Pin = document.getElementById("pin").value;
	var divPin=document.getElementById("pin_prompt");
	
	var reg_pin = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
	divPin.innerHTML="";
	if (Pin == ""){
		pin.value = "";
		divPin.innerHTML = "用户身份证号码不能为空！"
		return false;
	}
	else if (!reg_pin.test(Pin)){
		pin.value = "";
		divPin.innerHTML = "用户身份证号码格式错误！"
		return false;
	}
	divPin.innerHTML="";
	return true;
}

function checkAddress(){
	var Address = document.getElementById("address").value;
	var divAdd=document.getElementById("add_prompt");
	
	divAdd.innerHTML="";
	if (Address == ""){
		address.value = "";
		divAdd.innerHTML = "用户地址不能为空！"
		return false;
	}
	else if (Address.length > 25) {
		address.value = "";
		divAdd.innerHTML = "用户地址大于25！"
		return false;
	}
	divAdd.innerHTML="";
	return true;
}

function vip_editSub(){
	if(checkVipName() && checkPhoneNum() && checkPin() && checkAddress()){
		return true;
	}
	else{
		return false;
	}
}

function vip_editForm(){
	if (vip_editSub()){
		document.vip_edit.submit();
		//alert("修改成功！");
	}
	else{
		alert("修改失败！");
	}
}

function My_Order_Sub(){
	orderNum = document.getElementById("order_num").value;
}
// 注册页面
function checkPhoneNum3(){
	var phoneNum = document.getElementById("tel").value;
	var divPhoneNum=document.getElementById("phone_prompt");
	
	var reg_phone = /^1\d{10}$/
	divPhoneNum.innerHTML="";
	if (phoneNum == ""){
		tel.value = "";
		divPhoneNum.innerHTML = "用户电话号码不能为空！"
		return false;
	}
	else if (!reg_phone.test(phoneNum)){
		tel.value = "";
		divPhoneNum.innerHTML = "用户电话号码格式错误！"
		return false;
	}
	divPhoneNum.innerHTML="";
	return true;
}
// 校验注册页面的密码强度
function CheckPassowrdStrength(){
	var patrn=/^(\w){6,20}$/;
	var Password = document.getElementById("password").value;
	var divPassword=document.getElementById("pas_prompt");
	
	divPassword.innerHTML="";
	if (Password == ""){
		password.value = "";
		divPassword.innerHTML = "用户密码不能为空！"
		return false;
	}
	else if (!patrn.test(Password)) {
		password.value = "";
		divPassword.innerHTML = "只能输入6-20个字母、数字、下划线 ！"
		return false;
	}
	divPassword.innerHTML="";
	return true;
}

function CheckPassowrdStrength2(){
	var patrn=/^(\w){6,20}$/;
	var Password = document.getElementById("password_1").value;
	var Password2 = document.getElementById("password").value;
	
	var divPassword=document.getElementById("pas_prompt1");
	
	divPassword.innerHTML="";
	if (Password == ""){
		password_1.value = "";
		divPassword.innerHTML = "用户密码不能为空！"
		return false;
	}
	else if (!patrn.test(Password)) {
		password_1.value = "";
		divPassword.innerHTML = "只能输入6-20个字母、数字、下划线 ！"
		return false;
	}
	else if (Password != Password2){
		password_1.value = "";
		divPassword.innerHTML = "两次密码输入不一致！"
		return false;
	}
	divPassword.innerHTML="";
	return true;
}


function checkPin2(){
	var Pin = document.getElementById("pin").value;
	var divPin=document.getElementById("pin_prompt");
	
	var reg_pin = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
	divPin.innerHTML="";
	if (Pin == ""){
		pin.value = "";
		divPin.innerHTML = "用户身份证号码不能为空！"
		return false;
	}
	else if (!reg_pin.test(Pin)){
		pin.value = "";
		divPin.innerHTML = "用户身份证号码格式错误！"
		return false;
	}
	divPin.innerHTML="";
	return true;
}

function checkAddress2(){
	var Address = document.getElementById("address").value;
	var divAdd=document.getElementById("address_prompt");
	
	divAdd.innerHTML="";
	if (Address == ""){
		address.value = "";
		divAdd.innerHTML = "用户地址不能为空！"
		return false;
	}
	else if (Address.length > 25) {
		address.value = "";
		divAdd.innerHTML = "用户地址大于25！"
		return false;
	}
	divAdd.innerHTML="";
	return true;
}

function checkName2(){
	var vipName = document.getElementById("name").value;
	var divVipName=document.getElementById("name_prompt");
	
	divVipName.innerHTML="";
	if (vipName == ""){
		name.value = "";
		divVipName.innerHTML = "用户姓名不能为空！"
		return false;
	}
	else if (vipName.length > 10 || vipName.length < 3) {
		name.value = "";
		divVipName.innerHTML = "用户姓名长度要为3~10位！"
		return false;
	}
	divVipName.innerHTML="";
	return true;
}


function registerSub(){
	if(checkPhoneNum3() && CheckPassowrdStrength() && CheckPassowrdStrength2() && checkPin2() && checkAddress2() && checkName2()){
		return true;
	}
	else{
		return false;
	}
}

function registerForm(){
	if (registerSub()){
		document.register.submit();
		alert("注册成功！");
	}
	else{
		alert("注册失败！");
	}
}
