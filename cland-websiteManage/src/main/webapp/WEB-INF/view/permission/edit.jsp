<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">正在为【${menu.name}】添加/修改权限</a></li>
	</ul>

	
	<div class="">
		<!-- edit form -->
		<form id="tab" action="${ctx}/permission/edit.htm" method="POST" class='form-horizontal'>
		    <input type="hidden" name="guid" id="guid" class="input-xlarge" value="${permission.guid}">
		    
		    
		    
		    		
			<div class="control-group">
    			<label class="control-label" for="permissionName">权限名称：</label>
  				 <div class="controls">
  				 	<input type="text" name="permissionName" id="permissionName"  
  				 	class="input-xlarge search-query" value="${permission.permissionName}" required> 
				 </div>
 			 </div>
 			 
 			 
 			 <div class="control-group">
    			<label class="control-label" for="permissionUrl">访问路径：</label>
  				 <div class="controls">
  				 	<input type="text"  name="permissionUrl" id="permissionUrl"	 
  				 	class="input-xlarge search-query"  value="${permission.permissionUrl}" required> 
				 </div>
 			 </div>
		     <div class="control-group">
    			<label class="control-label" for="permissionCode">权限码：</label>
  				 <div class="controls">
  				 	<input type="text"   name="permissionCode" id="permissionCode"		 
  				 	class="input-xlarge search-query"  value="${permission.permissionCode}" required> 
				 </div>
 			 </div>
		    
		    <!-- 
		    
		    <label>权限名称：</label> <input type="text" name="permissionName" id="permissionName" 
		    class="input-xlarge"  value="${permission.permissionName}" required>
		    
			<label>访问路径：</label> <input type="text" name="permissionUrl" id="permissionUrl"	
			class="input-xlarge" value="${permission.permissionUrl}" required>
			
			<label>权限码：</label> <input type="text" name="permissionCode" id="permissionCode"	
			class="input-xlarge" value="${permission.permissionCode}" required>
			 -->
			 <input type="hidden" name="parentId"	class="input-xlarge" value="${menu.guid}">
			 
			 
			  <div class="control-group">
    			<label class="control-label" for=""> </label>
  				 <div class="controls">
  				 	<button type="button" class="btn blue" onclick="save(event)" >提交</button>
  				 	<a class="btn" href="${ctx}/permission/menuPermission.htm?id=${menu.guid}&parentMenuId=${menu.parentId}">返回</a>
				 </div>
 			 </div>
		
		
		
		
		</form>
		
	</div>

<script>
	function save(event) {
		//阻止冒泡
		ChkUtil.stopBubbleEvent(event);
		if (check()) {
			$("#tab").submit();
		}
	}
	function check() {
		var permissionName = $("#permissionName").val();
		var permissionUrl = $("#permissionUrl").val();
		var permissionCode = $("#permissionCode").val();
		if (ChkUtil.isNull(permissionName)) {
			alert("权限名称不能为空!");
			return false;
		} 
		if (ChkUtil.isNull(permissionUrl)) {
			alert("访问路径不能为空!");
			return false;
		}
		if (ChkUtil.isNull(permissionCode)) {
			alert("权限码不能为空!");
			return false;
		} 
		return true;

	}
</script>
<%@ include file="/include/footer.jsp"%>