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
	var staffName = document.getElementById("staff_name").value;
	var staffPos = document.getElementById("staff_pos").value;
	var staffSex = document.getElementById("sex").value;
	var staffSalary = document.getElementById("salary").value;
	var staffCard = document.getElementById("card").value;
	var reg_num = /^\d+$/;

	console.log(!reg_num.test(staffCard) + "dick")
	if (staffName == ""){
		return false;
	}
	else if (staffPos == ""){
		return false;
	}
	else if (staffName.length > 10){
		return false;
	}
	else if (staffPos.length > 10){
		return false;
	}
	else if (staffSalary == ""){
		return false;
	}
	else if (staffCard == ""){
		return false;
	}
	else if (!reg_num.test(staffSalary)){
		return false;
	}
	else if (!reg_num.test(staffCard)){
		return false;
	}
	else if (staffSalary.length > 10){
		return false;
	}
	else if (staffCard.length > 20){
		return false;
	}
	else {
		//alert("提交成功！");
		return true;
	}
}


function staff_editForm(){
	if(checkStaffName() && checkStaffPos() && checkSalary() && checkCard()){
		return true;
	}
	else{
		return false;
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
	var staffName = document.getElementById("staff_name_1").value;
	var staffPos = document.getElementById("staff_pos_1").value;
	var staffSex = document.getElementById("sex_1").value;
	var staffSalary = document.getElementById("salary_1").value;
	var staffCard = document.getElementById("card_1").value;
	var reg_num = /^\d+$/;

	console.log(!reg_num.test(staffCard) + "dick")
	if (staffName == ""){
		return false;
	}
	else if (staffName.length > 10){
		return false;
	}
	else if (staffPos == ""){
		return false;
	}
	else if (staffPos.length > 10){
		return false;
	}
	else if (staffSalary == ""){
		return false;
	}
	else if (!reg_num.test(staffSalary)){
		return false;
	}
	else if (staffSalary.length > 10){
		return false;
	}
	else if (staffCard == ""){
		return false;
	}
	else if (!reg_num.test(staffCard)){
		return false;
	}
	else if (staffCard.length > 20){
		return false;
	}
	else {
		//alert("提交成功！");
		return true;
	}
}


function staff_addsubForm(){
	if(checkStaffName1() && checkStaffPos1() && checkSalary1() && checkCard1()){
		return true;
	}
	else{
		return false;
	}
}


function checkSenderid(){
	var senderID=document.getElementById("sender_id").value;
	var divSenderID=document.getElementById("senderid_prompt");
	var reg_num = /^\d+$/;
	divSenderID.innerHTML="";
	if (senderID == ""){
		sender_id.value = "";
		divSenderID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(senderID)){
		sender_id.value = "";
		divSenderID.innerHTML = "下单用户ID不为整数！"
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
	var reg_num = /^\d+$/;
	divReceiverID.innerHTML="";
	if (receiverID == ""){
		receiver_id.value = "";
		divReceiverID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(receiverID)){
		receiver_id.value = "";
		divReceiverID.innerHTML = "下单用户ID不为整数！"
		return false;
	}
	else if (receiverID.length > 10) {
		receiver_id.value = "";
		divReceiverID.innerHTML = "下单用户ID长度大于10！"
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
	var senderID = document.getElementById("sender_id").value;
	var receiverID = document.getElementById("receiver_id").value;
	var type = document.getElementById("goods_type").value;
	var weight = document.getElementById("weight").value;
	var trainNum = document.getElementById("train_num").value;
	var fee = document.getElementById("fee").value;
	var order = document.getElementById("order").value;
	var orderFinished = document.getElementById("order_finished").value;
	
	var reg_num = /^\d+$/;
	var reg_float = /^\d+(\.\d+)?$/;

	if (senderID == ""){
		return false;
	}
	else if (!reg_num.test(senderID)){
		return false;
	}
	else if (senderID.length > 10) {
		return false;
	}
	else if (receiverID == ""){
		return false;
	}
	else if (!reg_num.test(receiverID)){
		return false;
	}
	else if (receiverID.length > 10) {
		return false;
	}
	else if (weight == ""){
		return false;
	}
	else if (weight.length > 10){
		return false;
	}
	else if (!reg_float.test(weight)){
		return false;
	}
	else if (trainNum == ""){
		return false;
	}
	else if (trainNum.length > 10) {
		return false;
	}
	else if (fee == ""){
		return false;
	}
	else if (!reg_float.test(fee)){
		return false;
	}
	else if (fee.length > 10) {
		return false;
	}
	else{
		alert("提交成功！");
		return true;
	}
	
}


function goods_editForm(){
	if(checkSenderid() && checkReceiverid() && checkWeight() && checkTrainnum() && checkFee()){
		return true;
	}
	else{
		return false;
	}
} 


function checkSenderid1(){
	var senderID=document.getElementById("sender_id_1").value;
	var divSenderID=document.getElementById("sederid1_prompt");
	var reg_num = /^\d+$/;
	divSenderID.innerHTML="";
	if (senderID == ""){
		sender_id_1.value = "";
		divSenderID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(senderID)){
		sender_id_1.value = "";
		divSenderID.innerHTML = "下单用户ID不为整数！"
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
	var reg_num = /^\d+$/;
	divReceiverID.innerHTML="";
	if (receiverID == ""){
		receiver_id_1.value = "";
		divReceiverID.innerHTML = "下单用户ID不能为空！"
		return false;
	}
	else if (!reg_num.test(receiverID)){
		receiver_id_1.value = "";
		divReceiverID.innerHTML = "下单用户ID不为整数！"
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

function goods_addSub(){
	var senderID = document.getElementById("sender_id_1").value;
	var receiverID = document.getElementById("receiver_id_1").value;
	var weight = document.getElementById("weight_1").value;
	var type = document.getElementById("goods_type_1").value;
	var trainNum = document.getElementById("train_num_1").value;
	var fee = document.getElementById("fee_1").value;
	var order = document.getElementById("order_1").value;
	var orderFinished = document.getElementById("order_finished_1").value;
	
	var reg_num = /^\d+$/;
	var reg_float = /^\d+(\.\d+)?$/;
	
	if (senderID == ""){
		return false;
	}
	else if (!reg_num.test(senderID)){
		return false;
	}
	else if (senderID.length > 10) {
		return false;
	}
	else if (receiverID == ""){
		return false;
	}
	else if (!reg_num.test(receiverID)){
		return false;
	}
	else if (receiverID.length > 10) {
		return false;
	}
	else if (weight == ""){
		return false;
	}
	else if (weight.length > 10){
		return false;
	}
	else if (!reg_float.test(weight)){
		return false;
	}
	else if (trainNum == ""){
		return false;
	}
	else if (trainNum.length > 10) {
		return false;
	}
	else if (fee == ""){
		return false;
	}
	else if (!reg_float.test(fee)){
		return false;
	}
	else if (fee.length > 10) {
		return false;
	}
	else{
		alert("提交成功！");
		return true;
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
		divVipName.innerHTML = "用户姓名大于10！"
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
	
	var reg_pin = /^\d{15}|\d{}18$/
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
	var vipID = document.getElementById("vip_ID").value;
	var vipName = document.getElementById("vip_name").value;
	var sex = document.getElementById("sex").value;
	var phoneNum = document.getElementById("phone_num").value;
	var pin = document.getElementById("pin").value;
	var address = document.getElementById("address").value;

	var reg_pin = /^\d{15}|\d{}18$/
	var reg_phone = /^1\d{10}$/
	
	if (vipID == ""){
		return false;
	}
	else if (vipName == ""){
		return false;
	}
	else if (vipName.length > 10){
		return false;
	}
	else if (phoneNum == ""){
		return false;
	}
	else if (!reg_phone.test(phoneNum)){
		return false;
	}
	else if (pin == ""){
		return false;
	}
	else if (!reg_pin.test(pin)){
		return false;
	}
	else if (address == ""){
		return false;
	}
	else if (address.length > 25){
		return false;
	}
	else{
		alert("提交成功！");
		return true;
	}
}


function vip_editForm(){
	if(checkVipID() && checkVipName() && checkPhoneNum() && checkPin() && checkAddress()){
		return true;
	}
	else{
		return false;
	}
} 


function My_Order_Sub(){
	orderNum = document.getElementById("order_num").value;
}



//名字
function checkName2(){
	var userName=document.getElementById("name").value;
	var divNameId=document.getElementById("name_prompt");
	divNameId.innerHTML="";
	if(userName.length<3 || userName.length>10){
		name.value="";
		divNameId.innerHTML="用户名格式不正确，请重新输入";
		return false;
	}
	divNameId.innerHTML="";
	return true;
}

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
	else if (!patrn.test(Password)){
		password.value = "";
		divPassword.innerHTML = "用户密码要为6到20位由数字或字母组成！"
		return false;
	}
	divPassword.innerHTML="";
	return true;
}

function CheckPassowrdStrength2(){
	var patrn=/^(\w){6,20}$/;  
	var Password = document.getElementById("password_1").value;
	var Password1 = document.getElementById("password").value;
	var divPassword=document.getElementById("pas_prompt1");
	
	divPassword.innerHTML="";
	if (Password == ""){
		password_1.value = "";
		divPassword.innerHTML = "用户密码不能为空！"
		return false;
	}
	else if (!patrn.test(Password)){
		password_1.value = "";
		divPassword.innerHTML = "用户密码要为6到20位由数字或字母组成！"
		return false;
	}
	else if(Password != Password1){
		password_1.value = "";
		divPassword.innerHTML = "前后两次密码不一致"
		return false;
	}
	divPassword.innerHTML="";
	return true;
}

function checkTrueName(){
	var phoneNum = document.getElementById("truename").value;
	var divPhoneNum=document.getElementById("truename_prompt");
	
	divPhoneNum.innerHTML="";
	if (phoneNum == ""){
		tel.value = "";
		divPhoneNum.innerHTML = "用户真实姓名不能为空！"
		return false;
	}
	else if (phoneNum.length > 8){
		tel.value = "";
		divPhoneNum.innerHTML = "用户真实姓名不能大于8位！"
		return false;
	}
	divPhoneNum.innerHTML="";
	return true;
}


//身份证
function checkPin2(){
	var userpin=document.getElementById("pin").value;
	var divPinId=document.getElementById("pin_prompt");
	divPinId.innerHTML="";
	var reg_pin = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	
	if (userpin == ""){
		pin.value = "";
		divPinId.innerHTML = "用户身份证号码不能为空！"
		return false;
	}
	else if (!reg_pin.test(userpin)){
		pin.value = "";
		divPinId.innerHTML = "用户身份证号码格式错误！"
		return false;
	}
	divPinId.innerHTML="";
	return true;
}

function checkAddress2(){
	var phoneNum = document.getElementById("address").value;
	var divPhoneNum=document.getElementById("address_prompt");
	
	divPhoneNum.innerHTML="";
	if (phoneNum == ""){
		address.value = "";
		divPhoneNum.innerHTML = "用户地址不能为空！"
		return false;
	}
	else if (phoneNum.length > 20){
		address.value = "";
		divPhoneNum.innerHTML = "用户地址不能大于20位！"
		return false;
	}
	divPhoneNum.innerHTML="";
	return true;
}

function checkCard2(){
	var cardNum = document.getElementById("card").value;
	var divCardNum=document.getElementById("card_prompt");
	var pattern = /^([1-9]{1})(\d{14}|\d{18})$/;
	divCardNum.innerHTML="";
	if (cardNum == ""){
		card.value = "";
		divCardNum.innerHTML = "用户银行卡号不能为空！"
		return false;
	}
	else if (!pattern.test(cardNum)){
		card.value = "";
		divCardNum.innerHTML = "用户银行卡号应为15或19位整数！"
		return false;
	}
	divPhoneNum.innerHTML="";
	return true;
}


function showHideCode(){
	$("#hidden").toggle();
}