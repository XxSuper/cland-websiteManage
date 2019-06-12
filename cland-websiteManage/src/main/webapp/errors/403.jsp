<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>付融宝管理系统</title>
<link href="${ctx}/login/css/master.css" rel="stylesheet" type="text/css" />
<link rel="shortcut icon" href="${ctx}/images/favicon.ico" type="image/x-icon" /> 
<script language="javascript">
if(!( window.parent == window )) 
	window.parent.location.href=self.location.href;
function refreshCaptcha() {
	$('#captchaImg').hide().attr('src','${ctx}/sys/jcaptcha.xjpg?' + Math.floor(Math.random()*100)).fadeIn();
}
function doSubmit(){
	var form=document.getElementById("loginForm");
	if(form.j_username.value.length==0 || form.j_username.value==""){
		document.getElementById("testspan").innerText="用户名不能为空！";
		document.getElementById("testDiv").style.display="";
		return false;
	}
	if(form.j_password.value.length==0 || form.j_password.value==""){
		document.getElementById("testspan").innerText="密码不能为空！";
		document.getElementById("testDiv").style.display="";
		return false;
	}
	//alert(form.j_captcha.value.length);
	if(form.j_captcha.value.length==0 || form.j_captcha.value==""){
		document.getElementById("testspan").innerText="验证码不能为空！";
		document.getElementById("testDiv").style.display="";
		return false;
	}
	return true;
}
function hideDiv(){
	if('${_loginErrorMsg}'!="" && '${_loginErrorMsg}'!=null){
		document.getElementById("testspan").innerText='${_loginErrorMsg}';	
		document.getElementById("testDiv").style.display="";
	}else{
		document.getElementById("testDiv").style.display="none";
	}
	//alert('${error}');
}
</script>
<script src="${ctx}/common/jquery/jquery.hiAlerts.1.0/jquery-1.3.2.min.js" type="text/javascript"></script>
</head>     
<body onload="hideDiv()">
<div class="loginmain">   
<dl><dt><img src="${ctx}/login/images/dl.jpg" /></dt><dd><img src="${ctx}/login/images/dl-04.jpg" /></dd></dl>
<%
	String userName = request.getParameter("_loginUserName");
	if(userName!=null){
	}else{
		if(request.getAttribute("_loginUserName")!=null){
			userName=request.getAttribute("_loginUserName").toString();
		}else{
			userName = "";
		}
	}
%>
<ul>    
	<form id="loginForm" action="${ctx}/j_spring_security_check" method="post">
	<p><span>用户名：</span><span>
		<input type="text" name="j_username" class="input" id="j_username" value="<%=userName %>"/>
	</span>
	</p>    
	<p><span>密&nbsp;&nbsp;码：</span><span>
		<input type="password" name="j_password" class="input" id="j_password"/>
	</span>
	</p>
	<p>
	<span>验证码：</span>
		<span><input name="j_captcha" type="text" class="input" id="j_captcha"/></span>
	<span><a  class="loginspan" href="javascript:refreshCaptcha()">换一张</a></span><br>
	<span style="float:center;width:150px;padding-left:55px"><img id="captchaImg" src="${ctx}/sys/jcaptcha.xjpg" width="75" />
	<%
   		String error=request.getParameter("captchaerror");
   		if (null!=error && !error.equals("")){
  	%>
  		验证码不正确！
  	<%}else {%>
       
    <%} %>
	</span>
	<span style="float:left;width:150px;padding-left:55px">
		<input name="" type="image" src="${ctx}/login/images/dl_11.jpg" onclick="return doSubmit();"/>
	</span>
	  </p>
</form>
</ul>
<div style="clear:both"></div>
<div style="width:252px;border:1px solid #FF8080;background:#FFF2F2;margin-left:10px;padding:3px;display:none" id="testDiv">
<img src="${ctx}/login/images/msg_bg.gif" class="middle"></img>
<span class="middle" style="font-weight:bold;" id="testspan">
${_loginErrorMsg}
</span>
</div>
</body>
</html>
 --%>
 
 <!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" isErrorPage="true"%> 
<%@ page import="java.io.PrintWriter"%> 
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<html> 
<head> 
<title>error.jsp title</title> 
<link rel="shortcut icon" href="${ctx}/images/favicon.ico" type="image/x-icon" /> 
</head> 
<body> 
<%-- <h2>错误信息：</h2> 
<%= exception %> 
<br> 

<h2>问题如下：</h2><% exception.printStackTrace(new PrintWriter(out));%> 
<hr>  --%>
 出错了
</body> 
</html>