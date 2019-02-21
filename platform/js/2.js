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

function  checkSenderTel(){
	var tel1=document.getElementById("sender_tel").value;
	var DivTelId=document.getElementById("sendernumber_prompt");
	DivTelId.innerHTML="";
	var reg=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
	if(reg.test(tel1)==false){
		sender_tel.value="";
		DivTelId.innerHTML="手机号输入错误，请重新输入";
		return false;
	}
	DivTelId.innerHTML="";
	return true;
}

function  checkReceiverTel(){
	var tel1=document.getElementById("receiver_tel").value;
	var DivTelId=document.getElementById("receivernumber_prompt");
	DivTelId.innerHTML="";
	var reg=/^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\d{8}$/;
	if(reg.test(tel1)==false){
		receiver_tel.value="";
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

function checkSenderName(){
	var name=document.getElementById("sender_name").value;
	var divNameId=document.getElementById("sendername_prompt");
	divNameId.innerHTML="";
	if(name==""){
		sender_name.value="";
		divNameId.innerHTML="姓名不能为空！";
		return false;
	}
	divNameId.innerHTML="";
	return true;
}

function checkReceiverName(){
	var name=document.getElementById("receiver_name").value;
	var divNameId=document.getElementById("receivername_prompt");
	divNameId.innerHTML="";
	if(name==""){
		receiver_name.value="";
		divNameId.innerHTML="姓名不能为空！";
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
	if(userpin.length != 18){
		pin.value="";
		divPinId.innerHTML="身份证号格式不正确，请重新输入";
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

//地址
function checkSenderAddress(){
	var add=document.getElementById("sender_address").value;
	var divAddId=document.getElementById("senderadderss_prompt");
	divAddId.innerHTML="";
	if(add==""){
		sender_address.value="";
		divAddId.innerHTML="地址不能为空！";
		return false;
	}
	divAddId.innerHTML="";
	return true;
}

function checkReceiverAddress(){
	var add=document.getElementById("receiver_address").value;
	var divAddId=document.getElementById("receiveradderss_prompt");
	divAddId.innerHTML="";
	if(add==""){
		receiver_address.value="";
		divAddId.innerHTML="地址不能为空！";
		return false;
	}
	divAddId.innerHTML="";
	return true;
}

function checkStartPos(){
	var pos=document.getElementById("start_pos").value;
	var divPosId=document.getElementById("startpos_prompt");
	divPosId.innerHTML="";
	if(pos==""){
		start_pos.value="";
		divPosId.innerHTML="高铁出发点不能为空！";
		return false;
	}
	divPosId.innerHTML="";
	return true;
}

function checkTrainNum(){
	var num=document.getElementById("train_num").value;
	var divNumId=document.getElementById("trainnum_prompt");
	divNumId.innerHTML="";
	if(num==""){
		train_num.value="";
		divNumId.innerHTML="车次不能为空！";
		return false;
	}
	divNumId.innerHTML="";
	return true;
}

function checkStartTime(){
	var time=document.getElementById("start_time").value;
	var divTimeId=document.getElementById("starttime_prompt");
	divTimeId.innerHTML="";
	if(time==""){
		start_time.value="";
		divTimeId.innerHTML="高铁出发时间不能为空！";
		return false;
	}
	divTimeId.innerHTML="";
	return true;
}

function MySub(){
	var name=document.getElementById("name").value;
	var tel=document.getElementById("tel").value;
	var pwd=document.getElementById("password").value;
	var pwd1=document.getElementById("password_1").value;
	var pin=document.getElementById("pin").value;
	var add=document.getElementById("address").value;
}

function MySub1(){
	var type=document.getElementById("type").value;
	var weight=document.getElementById("weight").value;
	var senderName=document.getElementById("sender_name").value;
	var senderTel=document.getElementById("sender_tel").value;
	var senderAdd=document.getElementById("sender_address").value;
	var receiverName=document.getElementById("receiver_name").value;
	var receiverTel=document.getElementById("receiver_tel").value;
	var receiverAddress=document.getElementById("receiver_address").value;
}

function MySub2(){
	var startPos=document.getElementById("start_pos").value;
	var trainNum=document.getElementById("train_num").value;
	var startTime=document.getElementById("start_time").value;
}

function goToWhere(){
	document.body.scrollTop = document.documentElement.scrollTop = 0;
}