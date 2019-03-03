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
	var tel1=document.getElementById("tel").value;
	var DivTelId=document.getElementById("number_prompt");
	DivTelId.innerHTML="";
	var reg=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
	if(reg.test(tel1)==false){
		tel.value="";
		DivTelId.innerHTML="手机号输入错误，请重新输入";
		return false;
	}
	DivTelId.innerHTML="";
	return true;
}

//名字
function checkName(){
	var userName=document.getElementById("name").value;
	var divNameId=document.getElementById("name_prompt");
	divNameId.innerHTML="";
	if(userName.length<3 || userName.length>6){
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
function checkPwd(){
	var pwd=document.getElementById("password").value;
	var divPwdId=document.getElementById("pwd_prompt");
	divPwdId.innerHTML="";
	if(pwd.length < 6){
		password.value="";
		divPwdId.innerHTML="密码格式不正确，请重新输入";
		return false;
	}
	divPwdId.innerHTML="";
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

function goToWhere(){
	document.body.scrollTop = document.documentElement.scrollTop = 0;
}