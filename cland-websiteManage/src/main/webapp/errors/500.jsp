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