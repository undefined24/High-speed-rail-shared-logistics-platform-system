// JavaScript Document

function on_submit(){
	var pwd=document.getElementById("password");
	var repwd=document.getElementById("password_1");
	
	if(pwd.value!=repwd.value){
		alert("两次密码不一致");
		pwd.value="";
		repwd.value="";
		pwd.focus();
		return false;
	}
	else if((pwd.value==repwd.value) && checkName() && checkTel() && checkPwd() && checkPin()){
		//alert("修改成功！");
		return true;
	}
	else{
		alert("修改失败！");
		return false;
	}
}

//手机号码验证
function  checkTel(){
	var phoneNum = document.getElementById("tel").value;
	var divPhoneNum=document.getElementById("number_prompt");
	
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

//名字
function checkName(){
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

//身份证
function checkPin(){
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

//密码

function CheckPassowrdStrength(){
	var patrn=/^([a-zA-Z0-9]|[.]){3,20}$/;
	var Password = document.getElementById("password").value;
	var divPassword=document.getElementById("pwd_prompt");
	console.log(patrn.test("Dickdick20."));
	
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
	var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/; ;
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

function MySub(){
	if (on_submit()){
		document.userInfoEdit.submit();
//		alert("添加成功！");
	}
	else{
//		alert("添加失败！");
	}
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

function goToWhere(){
	document.body.scrollTop = document.documentElement.scrollTop = 0;
}