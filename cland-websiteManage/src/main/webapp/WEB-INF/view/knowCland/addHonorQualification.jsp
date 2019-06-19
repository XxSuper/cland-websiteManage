<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script type="text/javascript" src="${ctx}/js/knowCland/addChairmanSpeech.js"></script>
<script type="text/javascript" src="${ctx}/js/knowCland/honorQualification.js?20171018"></script>
		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">荣誉资质新增管理</c:when>
						<c:when test="${operate == 'edit'}">荣誉资质编辑管理</c:when>
					</c:choose>
				</a>
			</li>

		</ul>
		
		<form:form id="news" class="form-horizontal" name="news" action="${ctx}/knowCland/saveHonorQualification.htm"
			method="post" enctype="multipart/form-data">

			<input id="iType" name="iType" type="hidden" value="6" />

			<input id="operate" name="operate" type="hidden" value="${operate}" />

			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			
			<div class="control-group">
    			<label class="control-label" for="sTitle">奖项名称</label>
  					  <div class="controls">
     					 <input  type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
    				</div>
 			 </div>
 			 
			<div class="control-group">
    			<label class="control-label" for="">图片</label>
  					  <div class="controls" >
     					<input type="hidden" id="sMediaImage" name="sMediaImage" value="${newsInfo.sMediaImage}" >
						<input type="file" id="sMediaImageFile" name="sMediaImageFile">
    				</div>
 			 </div>
 			 
			
			<style>
			.fileuploader{ width:500px; margin:0;}
			</style>
			<div class="control-group">
	 			 	<label  class="control-label">预览图：</label>
	 			 	<c:if test="${not empty newsInfo.sBannerImage}">
	 			 		<img alt="" src="${newsInfo.sBannerImage}" style="width:400px;" id="yl_image">
	 			 	</c:if>
	 			 	<c:if test="${empty newsInfo.sBannerImage}">
	 			 		<img alt="" src="" style="width:400px;" id="yl_image">
	 			 	</c:if>
	 			 </div>
			
			
			<div class="control-group">
			    <label class="control-label" for="">介绍</label>
			    <div class="controls">
						<textarea rows="4" cols="" style="width: 800px; " id="sIntroduce" name="sIntroduce">${newsInfo.sIntroduce}</textarea>
			    </div>
			</div>

			<div class="control-group">
			    <label class="control-label" for=""> </label>
			    <div class="controls">
					<button type="button" class="btn blue" id="aaa" onclick="doSummitHonorQualification()"><i class="  icon-ok icon-white"> </i>保存</button>
					<!-- 	<a class="btn blue" onclick="preview()"><i class=" icon-eye-open icon-white"></i> 预览</a> -->
					<input id="show" name="show" type="hidden" value="1" />
			    </div>
			 </div>
		</form:form>
		
<%@ include file="/include/footer.jsp"%>