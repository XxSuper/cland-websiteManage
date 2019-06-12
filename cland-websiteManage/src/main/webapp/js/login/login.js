$(function() {
	// 确保登录页面不在iframe里打开
	/*if (window.location.href.indexOf('login.htm') > 0
			&& top.location != self.location) {
		window.parent.location.href = window.location.href;
	}
	if(window.location.href.indexOf('login.htm') > 0){
		hideDiv();	
	}*/
	
});
function submitLogin(event) {
	//阻止冒泡
	ChkUtil.stopBubbleEvent(event);
	if (!checkParams()) {
		$("#password").val(hex_md5($("#password").val()));
		document.forms[0].submit();
	}

}

//function hideDiv() {
//	document.getElementById("error-mess").style.display = "none";
//	if (!ChkUtil.isNull(message)) {
//		if((message=='登录名不能为空' && ChkUtil.isNull($("#username").val()))||(message=='登录口令不能为空' && ChkUtil.isNull($("#password").val()))){
//		}else{
//			document.getElementById("error-mess").style.display = "block";
//			$("#error").html(message);
//		}
//		
//	}
//}

function refreshCaptcha() {
	
	$("#j_captcha").attr('disabled', false);
	$("#j_captcha").val('');
	$('#captchaImg').hide().attr("src",
			ctx + "/sys/captchaCode.htm?t=" + Math.random()).fadeIn();
}
// 倒计时
function countdown(time) {
	$("#send_sms").html(
			'<a href="javascript:#">重新发送(<em id="regSeconds">' + time
					+ '</em>)</a>');
	timer = setInterval('changeSecA()', 1000);
}
function changeSecA() {
	var sec = $('#regSeconds').html();
	var secNum = parseInt(sec);
	if (secNum <= 0) {
		clearInterval(timer);
		refreshCaptcha();
		$("#j_captcha").val('');
		$("#send_sms").html('<a  href="javascript:void(0)" onclick="sendSmsCode(event);">重新发送</a>');
	} else {
		secNum--;
		$('#regSeconds').html(secNum);
	}
}
// 发送短信验证码
function sendSmsCode(evt) {
	//阻止冒泡
	ChkUtil.stopBubbleEvent(evt);
	if (!checkParams()&&!checkCaptchaParams()) {
		$.ajax({
					url : ctx + "/sys/sendLoginSmsCode.htm",
					type : "post",
					data : {
						name : $("#username").val(),
						j_captcha:$("#j_captcha").val()
					},
					dataType : "json",
					cache : false,
					success : function(res) {
						if (res.flag == "1") {
							if (res.time != undefined) {
								$("#error").html('短信验证码已经发送至' + res.mobile);
								document.getElementById("error-mess").style.display = "block";
								countdown(res.time);
							}
						}else{
					      if(res.flag == 'false') {
							  $("#error").html('短信60s内只能发送一次！');
						   } else if(res.errorMessage!=undefined){
							  $("#error").html(res.errorMessage);
						   }else{
							  $("#error").html("图片验证码不正确，请重新输入！");
						  }
					      document.getElementById("error-mess").style.display = "block";
						  refreshCaptcha();  
						}
						
					},
					error : function() {
						alert('请求出错了');
					}
				});
	}

}
//校验普通参数
function checkParams() {
	var flag = false;
	var name = $("#username").val();
	var password = $("#password").val();
	if (ChkUtil.isNull(name)) {
		flag = true;
		$("#alert-error").empty();
		//$("#alert-error").html('登录名不能为空');
		document.getElementById("alert-error").style.display = "block";
		return flag;
	}
	if (ChkUtil.isNull(password)) {
		flag = true;
		$("#alert-error").empty();
	//	$("#alert-error").html('登录口令不能为空');
		document.getElementById("alert-error").style.display = "block";
		return flag;
	}
	return flag;
}
//校验图片验证码
function checkCaptchaParams() {
	var flag = false;
	var j_captcha = $("#j_captcha").val();
	if (ChkUtil.isNull(j_captcha)) {
		flag = true;
		$("#error").html('图片验证码不能为空');
		document.getElementById("error-mess").style.display = "block";
		return flag;
	}
	return flag;
}
//校验短信验证码
function checkSmsParams() {
	var flag = false;
	var j_smsCode = $("#j_smsCode").val();
	if (ChkUtil.isNull(j_smsCode)) {
		flag = true;
		$("#error").html('短信验证码不能为空');
		document.getElementById("error-mess").style.display = "block";
		return flag;
	}
	return flag;
}

function changeStyle(id,type) {
	var param = $("#" + id).val();
	if (ChkUtil.isNull(param)) {
		$("#error").html(type+'不能为空');
		$("#error-mess").show();
	} else {
		$("#error").html('');
		$("#error-mess").hide();
	}

}

// 提交修改密码
function submitUpdatePassword(event) {
	//阻止冒泡
	ChkUtil.stopBubbleEvent(event);
	if (checkUpdatePasswordParams()) {
		$.ajax({
			url : ctx + "/user/updatePassWordSubmit.htm",
			type : "post",
			data : $("#myForm").serialize(),
			dataType : "json",
			cache : false,
			success : function(res) {
				if (res.flag == "true") {
					alert('修改成功');
					window.location.href = ctx + "/sys/index.htm";
				} else if (res.flag == "0") {
					alert('密码输入错误');
				} else {
					alert('请求出错了');
				}
			},
			error : function() {
				alert('请求出错了');
			}
		});

	}
}
// 检查密码参数
function checkUpdatePasswordParams() {
	var flag = true;
	var oldPassWord = $("#oldPassWord").val();
	var passWord = $("#passWord").val();
	var repassWord = $("#repassWord").val();
	if (ChkUtil.isNull(oldPassWord)) {
		flag = false;
		alert("密码不能为空");
		return flag;
	}
	if (ChkUtil.isNull(passWord)) {
		flag = false;
		alert("新密码不能为空");
		return flag;
	}
	if (!ChkUtil.isPassword(passWord)) {
		flag = false;
		alert("密码必须是6-20位字母数字下划线组合！");
		return flag;
	}
	if (ChkUtil.isNull(repassWord)) {
		flag = false;
		alert("确认密码不能为空");
		return flag;
	}

	if (oldPassWord == passWord) {
		flag = false;
		alert("新密码和旧密码不能一致");
		return flag;
	}
	if (passWord != repassWord) {
		flag = false;
		alert("新密码和确认密码不一致");
		return flag;
	}
	$("#passWord").val(hex_md5(passWord));
	$("#oldPassWord").val(hex_md5(oldPassWord));
	$("#repassWord").val(hex_md5(repassWord));
	return flag;

}
