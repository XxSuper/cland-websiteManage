<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<script src="${ctx}/js/model/addModel.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">员工活动模块新增管理</c:when>
						<c:when test="${operate == 'edit'}">员工活动模块编辑管理</c:when>
					</c:choose>
				</a>
			</li>
		</ul>
		
		<form:form id="model" class="form-horizontal" name="model" action="${ctx}/model/saveModel.htm"
			method="post" >
			<input id="operate" name="operate" type="hidden" value="${operate}" />
			<input id="id" name="id" type="hidden" value="${modelInfo.id}" />
			<div class="control-group">
    			<label class="control-label" for="sTitle">名称</label>
  					  <div class="controls">
     					 <input type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${modelInfo.sTitle}">
    				</div>
 			 </div>
			<div class="control-group">
    			<label class="control-label" for="">活动模块图片</label>
  					  <div class="controls" >
     					<input type="hidden" id="sMediaImage" name="sMediaImage" value="${modelInfo.sMediaImage}" >
						<input type="file" id="sMediaImageFile" name="sMediaImageFile">
    				</div>
 			 </div>
 			<style>
				.fileuploader{ width:500px; margin:0;}
			</style>
			<div class="control-group">
			    <label class="control-label" for=""> </label>
			    <div class="controls">
					<button type="button" class="btn blue" id="aaa" onclick="return doSummit()"><i class="  icon-ok icon-white"> </i>保存</button>
					<!-- 	<a class="btn blue" onclick="preview()"><i class=" icon-eye-open icon-white"></i> 预览</a> -->
					<input id="show" name="show" type="hidden" value="1" />
			    </div>
			 </div>
		</form:form>
		
<%@ include file="/include/footer.jsp"%>