//用于记住编辑之前的mobile
var oldMobile = "";
$(function() {
	$("#dialog").dialog({
		autoOpen : false,// 该选项默认是true，设置为false则需要事件触发才能弹出对话框
		title : '新增/修改用户',// 对话框的标题
		width : 570,// 默认是300
		height : 500,
		modal : true,
		overlay : {
			backgroundColor : '#358',
			opacity : 1
		}
	});
	$("#userRoleDialog").dialog({
		autoOpen : false,// 该选项默认是true，设置为false则需要事件触发才能弹出对话框
		title : '用户角色',// 对话框的标题
		width : 400,// 默认是300
		height : 200,
		modal : true,
		overlay : {
			backgroundColor : '#358',
			opacity : 1
		}
	});
	$("#operatorAuditDialog").dialog({
		autoOpen : false,// 该选项默认是true，设置为false则需要事件触发才能弹出对话框
		title : '审核用户',// 对话框的标题
		width : 500,// 默认是300
		height : 270,
		modal : true,
		overlay : {
			backgroundColor : '#358',
			opacity : 1
		},
		buttons : {
			'确定' : function() {
				$(this).addClass("btn"); 
				var approvel = $("#approvel").val();
				if (ChkUtil.isNull(approvel) || '-1' == approvel) {
					return;
				}
				$("#approvel").prop("selectedIndex", 0);
				$(this).dialog("close");

				submitAudit(approvel);
			},
			'取消' : function() {
				$("#approvel").prop("selectedIndex", 0);
				$(this).dialog("close");

			}
		}
	});
});

function closeDialog(id) {
	$('#' + id).dialog('close');

}
function submitAudit(approvel) {
	var id = $("#guid").val();
	$.ajax({
		url : ctx + '/user/submitAudit.htm',
		type : 'post',
		data : {
			sGuid : id,
			approvel : approvel
		},
		dataType : 'json',
		success : function(res) {
			if (res.flag == '1') {
				confirm("提交审核成功!");
				$("#" + id).remove();
			} else {
				alert('提交审核失败!');
			}
		}
	});
}

function editUser() {
	$("#guid").val('');
	$("#suserName").val('');
	$("#realName").val('');
	$("#mobile").val('');
	$("#email").val('');
	$("#job").val('');
	$("#phone").val('');
	if (arguments[0] != undefined && !ChkUtil.isNull(arguments[0])) {
		$.ajax({
			url : ctx + '/user/getUser.htm',
			type : 'post',
			data : {
				guid : arguments[0]
			},
			dataType : 'json',
			success : function(res) {
				if (res.flag == '1' && null != res.user) {
					$("#guid").val(res.user.guid);
					$("#suserName").val(res.user.userName);
					$("#realName").val(res.user.realName);
					$("#mobile").val(res.user.mobile);
					$("#email").val(res.user.email);
					$("#job").val(res.user.job);
					$("#phone").val(res.user.phone);
					oldMobile = res.user.mobile;// 记录修改之前的mobile
					oldName = res.user.userName;// 记录修改之前的name
				}
			}
		});
	} else {
		oldMobile = "";
		oldName = "";
	}
	$("#dialog").dialog('open');// 设置为‘open’时将显示对话框
}

function showOperatorAuditDialog(id, name) {
	$("#approvelName").val(name);
	$("#guid").val(id);
	$("#operatorAuditDialog").dialog('open');// 设置为‘open’时将显示对话框
}

function selectUser() {
	var name = $("#userName").val();
	var sMobile = $("#sMobile").val();
	if (ChkUtil.isNull(name) && ChkUtil.isNull(sMobile)) {
		alert('请填写用户名或者手机号');
		return false;
	}
	if (!ChkUtil.isNull(sMobile)) {
		if (!ChkUtil.isMobile(sMobile)) {
			alert('手机号格式不正确!');
			return false;
		}

	}
	return true;
}
function save(event) {
	// 阻止冒泡
	ChkUtil.stopBubbleEvent(event);
	if (checkForm() && checkUniqueUserName() && checkUniqueMobile()) {
		$.ajax({
			url : ctx + "/user/editUser.htm",
			type : "post",
			data : $("#inputForm").serialize(),
			dataType : "json",
			cache : false,
			success : function(res) {
				if (res.flag == '1') {
					confirm("提交成功!");
					window.location.href = ctx + "/user/userQuery.htm";
				} else {
					$("#guid").val('');
					$("#suserName").val('');
					$("#realName").val('');
					$("#mobile").val('');
					$("#email").val('');
					$("#job").val('');
					$("#phone").val('');
					$('#dialog').dialog('close');
					if (res.failReason != undefined) {
						alert(res.failReason);
					} else {
						alert('请求出错了');
					}

				}
			},
			error : function() {
				alert('请求出错了');
			}

		});
	}
};
// 检查用户名是否唯一
function checkUniqueUserName() {
	var flag = false;
	var name = $("#suserName").val();
	if (name != oldName) {
		$.ajax({
			url : ctx + '/user/checkUniqueUserName.htm',
			type : 'post',
			data : {
				userName : name
			},
			dataType : 'json',
			async : false,
			success : function(res) {
				if (res.flag == '1' && res.count < 1) {
					flag = true;
				} else {
					alert('用户名已经注册过了，请换个名称');
				}
			}

		});
	} else {
		flag = true;
	}
	return flag;
}
// 检查手机号是否唯一
function checkUniqueMobile() {
	var flag = false;
	var mobile = $("#mobile").val();
	if (mobile != oldMobile) {
		$.ajax({
			url : ctx + '/user/checkUniqueMobile.htm',
			type : 'post',
			data : {
				mobile : mobile
			},
			dataType : 'json',
			async : false,
			success : function(res) {
				if (res.flag == '1' && res.count < 1) {
					flag = true;
				} else {
					alert('手机号已经注册过了，请换个手机号');
				}
			}

		});
	} else {
		flag = true;
	}
	return flag;
}
function checkForm() {
	var flag = false;
	var name = $("#suserName").val();
	if (ChkUtil.isNull(name)) {
		alert('用户名不能为空!');
		return flag;
	}
	var realName = $("#realName").val();
	if (ChkUtil.isNull(realName)) {
		alert('真实姓名名不能为空!');
		return flag;
	}
	var mobile = $("#mobile").val();
	if (ChkUtil.isNull(mobile)) {
		alert('手机号不能为空!');
		return flag;
	}
	if (!ChkUtil.isMobile(mobile)) {
		alert('手机号格式不正确!');
		return flag;
	}
	var email = $("#email").val();
	if (!ChkUtil.isNull(email)) {
		if (!ChkUtil.isEmail(email)) {
			alert('邮箱格式不正确!');
			return flag;
		}
		;
	}
	return true;
}
function deleteUser(id, userName) {
	$.ajax({
		url : ctx + '/user/getUserTaskCount.htm',
		type : 'post',
		data : {
			userName : encodeURI(userName)
		},
		dataType : 'json',
		success : function(res) {
			if (res.flag == '1') {
				if (res.count > 0) {
					alert('该用户尚有未结束的任务，暂时无法删除!');
				} else {
					submitDeleteUser(id);
				}
			} else {
				alert('请求出错了!');
			}
		}
	});

}
function submitDeleteUser(id) {
	var a = window.confirm('确定删除？');
	if (a) {
		$.ajax({
			url : ctx + '/user/deleteUser.htm',
			type : 'post',
			data : {
				id : id,
			},
			dataType : 'json',
			success : function(res) {
				if (res.flag == '1') {
					$("#" + id).remove();
				}
				;
			}
		});
	}
	;
}
// 初始化密码
function initPassword(sguid) {

	var a = window.confirm('确定初始化密码？');
	if (a) {
		$.ajax({
			url : ctx + '/user/initPassword.htm',
			type : 'post',
			data : {
				id : sguid,
			},
			dataType : 'json',
			success : function(res) {
				if (res.flag == '1') {
					alert("初始化密码成功！");
				}
				;

			}
		});
	}

}
// 初始化密码
function userFreeze(sguid, type) {
	var str = "";
	if (0 == type) {
		str = "确定将用户状态改为禁用吗?";
	} else {
		str = "确定将用户状态改为启用吗?";
	}
	var a = window.confirm(str);
	if (a) {
		$.ajax({
			url : ctx + '/user/userFreeze.htm',
			type : 'post',
			data : {
				id : sguid,
				type : type,
			},
			dataType : 'json',
			success : function(res) {
				if (res.flag == '1') {
					alert("操作成功！");
					var obj = $("#" + sguid).find("td:last a:last");
					if (0 == type) {
						obj.attr("href",
								"javascript:userFreeze('" + sguid + "','1')")
								.html('启用');
					} else {
						obj.attr("href",
								"javascript:userFreeze('" + sguid + "','0')")
								.html('禁用');
					}
				}
			}
		});
	}

}

function getUserRole(id,name){
	$("#suser").html(name);
	$.ajax({
		url : ctx + '/user/getUserRole.htm',
		type : 'post',
		data : {
			id :id,
		},
		dataType : 'json',
		success : function(res) {
			if(res.flag=='1'){
				$("#role").html(res.role);
			}
			$("#userRoleDialog").dialog('open');// 设置为‘open’时将显示对话框
		}
	});
}

// 提交分页查询
function goPage(page) {
	$("#pageNumber").val(page);
	// 默认第一个表单提交
	document.forms[0].submit();
};