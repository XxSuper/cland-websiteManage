<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<meta name="author" content="http://maiyaloan.com/"/>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10,IE=11" />
<meta http-equiv="Expires" content="0">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Cache-Control" content="no-store">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="shortcut icon" href="${ctx}/css/images/favicon.ico" type="image/x-icon" /> 
<!--<link rel="stylesheet" type="text/css" href="${ctx }/css/main.css?20160115"> 
<link href="${ctx }/js/bootstrap/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>-->
<link href="${ctx }/js/bootstrap/media/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/js/bootstrap/media/css/datepicker.css" rel="stylesheet"/>
<link href="${ctx }/js/bootstrap/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/js/bootstrap/media/css/font-awesome.min.css" rel="stylesheet" type="text/css" />

<link href="${ctx }/js/bootstrap/media/css/style-metro.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/js/bootstrap/media/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/js/bootstrap/media/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/js/bootstrap/media/css/default.css" rel="stylesheet" type="text/css" id="style_color" />
<link href="${ctx }/js/bootstrap/media/css/uniform.default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="${ctx}/js/common/jquery/ui/jquery-ui.css"></link>
<link rel="stylesheet" href="${ctx}/css/upload/jquery.fileuploader.css" type="text/css">

<script type="text/javascript">
	var ctx = "${ctx}";
</script>

<script src="${ctx }/js/bootstrap/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

<%-- <script src="${ctx }/js/bootstrap/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script> --%>

<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${ctx}/js/bootstrap/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrap/media/js/bootstrap.min.js" type="text/javascript"></script>
<!--[if lt IE 9]>
<script src="${ctx}/js/bootstrap/media/js/excanvas.min.js"></script>
<script src="${ctx}/js/bootstrap/media/js/respond.min.js"></script>  
<![endif]-->

<script src="${ctx }/js/bootstrap/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx }/js/bootstrap/media/js/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx }/js/bootstrap/media/js/jquery.cookie.min.js" type="text/javascript"></script>
<script src="${ctx }/js/bootstrap/media/js/jquery.uniform.min.js" type="text/javascript"></script>
<%-- <script src="${ctx}/js/bootstrap/media/js/bootstrap-datepicker.js"></script> --%>
<%-- <script src="${ctx }/js/upload/jquery.fileuploader.js"></script> --%>
<script src="${ctx }/js/upload/bootstrap-dialog.js"></script>

<!-- END CORE PLUGINS -->



<%-- <script src="${ctx }/js/bootstrap/media/js/app.js"></script> --%>
<script>
	jQuery(document).ready(function() {
// 		App.init();
	});
</script>
<script src="${ctx}/js/common/common.js"></script>
<title>博荣官网管理系统</title>
<body class="page-header-fixed page-footer-fixed">
<div class="header navbar navbar-inverse navbar-fixed-top">

			<!-- BEGIN TOP NAVIGATION BAR -->

			<div class="navbar-inner">

				<div class="container-fluid">

					<!-- BEGIN LOGO -->

					<a class="brand" href="${ctx}/sys/index.htm">

<%-- 						<img src="${ctx }/borong/images/logo2.png" alt="" style=' height:30px' />  --%>

					</a>

					<!-- END LOGO -->

					<!-- BEGIN RESPONSIVE MENU TOGGLER -->

					<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">

						<img src="${ctx }/js/bootstrap/media/image/menu-toggler.png" alt=""  />

					</a>

					<!-- END RESPONSIVE MENU TOGGLER -->

					<!-- BEGIN TOP NAVIGATION MENU -->

				<ul class="nav pull-right" style="margin-right: 45px;">
             	   <li class="dropdown user" style="line-height:32px;">
						

							<a href="#" class="dropdown-toggle" data-toggle="dropdown">

								<span class="username">你好！${currentUser.userName }</span>

								<i class="icon-angle-down"></i>

							</a>

							<ul class="dropdown-menu">

								<li>
									<a id="drop3" href="javascript:logout()"><i class="icon-key"></i>安全退出</a>
								</li>

							</ul>

						</li>

						<!-- END USER LOGIN DROPDOWN -->

					</ul>
					
					<div class="color-panel hidden-phone">
					<div class="color-mode-icons icon-color"></div>
					<div class="color-mode-icons icon-color-close"></div>
					<div class="color-mode">
						<p>THEME COLOR</p>
						<ul class="inline">
							<li class="color-black current color-default" data-style="default"></li>
							<li class="color-blue" data-style="blue"></li>
							<li class="color-brown" data-style="brown"></li>
							<li class="color-purple" data-style="purple"></li>
							<li class="color-grey" data-style="grey"></li>
							<li class="color-white color-light" data-style="light"></li>
						</ul>
						<label> <span>Layout</span> <select
							class="layout-option m-wrap small">
								<option value="fluid" selected>Fluid</option>
								<option value="boxed">Boxed</option>
						</select>
						</label> <label> <span>Header</span> <select
							class="header-option m-wrap small">
								<option value="fixed" selected>Fixed</option>
								<option value="default">Default</option>
						</select>
						</label> <label> <span>Sidebar</span> <select
							class="sidebar-option m-wrap small">
								<option value="fixed">Fixed</option>
								<option value="default" selected>Default</option>
						</select>
						</label> <label> <span>Footer</span> <select
							class="footer-option m-wrap small">
								<option value="fixed">Fixed</option>
								<option value="default" selected>Default</option>
						</select>
						</label>
					</div>
				</div>

					<!-- END TOP NAVIGATION MENU -->

				</div>

			</div>

			<!-- END TOP NAVIGATION BAR -->

		</div>
			
		
	<div class="page-container row-fluid">	
	

