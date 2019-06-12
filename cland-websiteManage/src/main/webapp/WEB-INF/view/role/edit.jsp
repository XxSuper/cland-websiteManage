<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>


	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">新增/修改角色</a></li>
	</ul>


<div >
	<!-- header -->
	
	<div >
		<!-- edit form -->
		<form id="tab" action="${ctx}/role/edit.htm" method="POST" class="form-horizontal">
			<input type="hidden" name="sguid" class="input-xlarge"
				value="${role.sguid}"> 
				
				<div class="control-group">
    			<label class="control-label" for="sroleName">名称</label>
  					  <div class="controls">
     					 <input type="text"
				name="sroleName" id="sroleName" class="input-xlarge search-query"
				value="${role.sroleName}" required> 
    				</div>
 			 </div>
				
				
			
				<div class="control-group">
    			<label class="control-label" for="">描述</label>
  					  <div class="controls">
     					<input
				type="text" name="sroleDesc" class="input-xlarge search-query"
				value="${role.sroleDesc}">
    				</div>
 			 </div>
 			 
 			 
 			 <div class="control-group">
    			<label class="control-label" for=""></label>
  					  <div class="controls">
  					  <button type="button"  class="btn blue" onclick="save(event)"><i class="icon-ok"></i> 提交</button>
  					 
		<input type="button" class="btn"
			onclick="javascript:history.go(-1)" value="取消"></input>
    				</div>
 			 </div>
				
				
				
				
		</form>
		
	</div>
</div>
<script>
	function save(event) {
		//阻止冒泡
		ChkUtil.stopBubbleEvent(event);
		if (checkName()) {
			$("#tab").submit();
		}
	}
	function checkName() {
		var name = $("#sroleName").val();
		if (ChkUtil.isNull(name)) {
			alert("角色名称不能为空!");
			return false;
		} else {
			return true;
		}

	}
</script>
<%@ include file="/include/footer.jsp"%>