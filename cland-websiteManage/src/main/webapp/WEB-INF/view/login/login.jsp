<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>

<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<meta name="author" content="http://maiyaloan.com/" />
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10,,IE=11" />
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<link rel="shortcut icon" href="${ctx}/images/favicon.ico"	type="image/x-icon" />
	<link href="${ctx }/js/bootstrap/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx }/js/bootstrap/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx }/js/bootstrap/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx }/js/bootstrap/media/css/style-metro.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx }/js/bootstrap/media/css/style.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx }/js/bootstrap/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

	<link href="${ctx }/js/bootstrap/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

	<link href="${ctx }/js/bootstrap/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->

	<link href="${ctx }/js/bootstrap/media/css/login-soft.css" rel="stylesheet" type="text/css"/>





<script src="${ctx}/js/bootstrap/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

	<script src="${ctx}/js/bootstrap/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

	<script src="${ctx}/js/bootstrap/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

	<script src="${ctx}/js/bootstrap/media/js/bootstrap.min.js" type="text/javascript"></script>

	<!--[if lt IE 9]>

	<script src="${ctx}/js/bootstrap/media/js/excanvas.min.js"></script>

	<script src="${ctx}/js/bootstrap/media/js/respond.min.js"></script>  

	<![endif]-->   

	<script src="${ctx}/js/bootstrap/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

	<script src="${ctx}/js/bootstrap/media/js/jquery.blockui.min.js" type="text/javascript"></script>  

	<script src="${ctx}/js/bootstrap/media/js/jquery.cookie.min.js" type="text/javascript"></script>

	<script src="${ctx}/js/bootstrap/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->

	<script src="${ctx}/js/bootstrap/media/js/jquery.validate.min.js" type="text/javascript"></script>

	<script src="${ctx}/js/bootstrap/media/js/jquery.backstretch.min.js" type="text/javascript"></script>

	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${ctx}/js/bootstrap/media/js/app.js" type="text/javascript"></script>

	<script src="${ctx}/js/bootstrap/media/js/login-soft.js" type="text/javascript"></script>      

	<!-- END PAGE LEVEL SCRIPTS --> 



<script src="${ctx }/js/common/common.js"></script>
<script src="${ctx }/js/common/md5.js"></script>

<script type="text/javascript">
	var type = "${kickout}";
	var message = '';
	if (type == 'true') {
		message= "<font size='1px'>此账户他人正在使用!</font>";
	}else{
	    message = "${message_login}";
	}
	var ctx = "${ctx}";
</script>

<!-- <link type="text/css" rel="stylesheet" href="${ctx }/css/login.css" />
 -->
<title>博融官网管理系统</title>
</head>
<body class="login">
<style>
.login .content p, .login .content label {
    color: #b94a48;padding-right:5px
}
</style>
	<div class="logo" style='padding-bottom:20px'>

<%-- 		<img src="${ctx }/borong/images/logo2.png" alt="" style='' />  --%>

	</div>

	<div class="content">

		<form class="form-vertical login-form" action="${ctx}/sys/dologin.htm" method="post" name="myForm">

			<h3 class="form-title">博融官网管理系统</h3>
			<c:choose>
				<c:when test="${not empty message_login}">
					<div class="alert alert-error show" id='alert-error' style='padding:2px 5px 2px 14px'>${message_login}</div>
				</c:when>
				<c:otherwise>
					<div class="alert alert-error hide" id='alert-error' style='padding:2px 5px 2px 14px'></div>
				</c:otherwise>
			</c:choose>
			<div class="control-group" >
				<label class="control-label visible-ie8 visible-ie9">登录名</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i>
						<input type="text"  placeholder="登录名" tabindex="1" id="username"
							class="m-wrap placeholder-no-fix" value="${j_username}" name="j_username">
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i>						
							<input id="password" name="j_password"  
							tabindex="2" class="m-wrap placeholder-no-fix" 
							placeholder="口令" class="pass-word" type="password" 
							value="${j_password}"
 							id="password" autocomplete="off" />
					</div>
				</div>

			</div>
			<div class="form-actions">
				<button type='submit' style="width:292px" class="btn blue " onclick="return submitLogin(event);">登 录 
					<i class="m-icon-swapright m-icon-white"></i>
				</button>  
			</div>
		
		</form>

	</div>
	<script>

		jQuery(document).ready(function() {     

		  App.init();

		  Login.init();

		});

	</script>
	<script src="${ctx }/js/login/login.js"></script>
</body>
</html>
