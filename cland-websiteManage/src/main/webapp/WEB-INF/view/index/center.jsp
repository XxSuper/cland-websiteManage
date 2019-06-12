<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/taglib.jsp"%>
<style>

</style>
<div class="content2"> 
    <!-- header -->
    <div class="header">
        <h1 class="page-title"></h1>
    </div>
    <!-- highchat show -->
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
</div>
<script>
  var count ="${count}";
  if(count<=1){
	  alert("密码太简单，请及时修改密码！");
  }
</script>