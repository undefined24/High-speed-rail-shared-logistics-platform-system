// JavaScript Document
function checkName(){
	var Name=document.getElementById("name").value;
	var divNameId=document.getElementById("name_prompt");
	divNameId.innerHTML="";
	if(Name==""){
		name.value="";
		divNameId.innerHTML="物品姓名不能为空！";
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

function checkSenderTel(){
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

function checkReceiverTel(){
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

function checkReceiverAddress2(){
	var add=document.getElementById("receiver_address2").value;
	var divAddId=document.getElementById("receiveradderss_prompt2");
	divAddId.innerHTML="";
	if(add==""){
		receiver_address.value="";
		divAddId.innerHTML="地址不能为空！";
		return false;
	}
	divAddId.innerHTML="";
	return true;
}

function on_submit1(){
	if(checkName() && checkSenderName() && checkSenderTel() && checkSenderAddress() && checkReceiverName() && checkReceiverTel() && checkReceiverAddress()){
		alert("提交成功！");
		return true;
	}
	else{
		alert("提交失败！");
		return false;
	}
}

function MySub1(){
	if (on_submit1()){
		document.sender.submit();
//		alert("添加成功！");
	}
	else{
//		alert("添加失败！");
	}
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

function checkArrivePos(){
	var pos=document.getElementById("arrive_pos").value;
	var divPosId=document.getElementById("arrivepos_prompt");
	divPosId.innerHTML="";
	if(pos==""){
		arrive_pos.value="";
		divPosId.innerHTML="高铁到达点不能为空！";
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

function on_submit2(){
	if(checkStartPos() && checkArrivePos() && checkTrainNum() && checkStartTime()){
		//alert("查询成功！");
		return true;
	}
	else{
		alert("查询失败！");
		return false;
	}
}

//function MySub2(){
//		if (on_submit2()){
//		document.receiver.submit();
////		alert("添加成功！");
//	}
//	else{
////		alert("添加失败！");
//	}
//}

$(function() {
    $( "#start_time" ).datetimepicker({ 
    	format: "yyyy-mm-dd hh:ii",
        todayBtn: true,
        autoclose: true,
        startView:2,
        minView: 0,//最低视图 小时视图
        maxView: 4, //最高视图 十年视图
        showSecond : true,
        showHours : true,
        minuteStep:1,
		minDate: 0,
		startDate:new Date()
    });
  });