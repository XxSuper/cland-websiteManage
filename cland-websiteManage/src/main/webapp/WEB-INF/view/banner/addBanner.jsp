<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<script src="${ctx}/js/banner/addBanner.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">banner新增管理</c:when>
						<c:when test="${operate == 'edit'}">banner编辑管理</c:when>
					</c:choose>
				</a>
			</li>

		</ul>
		

	
		<form:form id="banner" class="form-horizontal" name="banner" action="${ctx}/banner/saveBanner.htm"
			method="post" >

			<input id="iType" name="iType" type="hidden" value="3" />

			<input id="operate" name="operate" type="hidden" value="${operate}" />

			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			
			<div class="control-group">
    			<label class="control-label" for="">图片</label>
  					  <div class="controls" >
     					<input type="hidden" id="sBannerImage" name="sBannerImage" value="${newsInfo.sBannerImage}" >
						<input type="file" id="sBannerImageFile" name="sBannerImageFile">
    				</div>
 			 </div>
 			<style>
				.fileuploader{ width:500px; margin:0;}
			</style>
			<div class="control-group">
    			<label class="control-label" for="">链接</label>
  					  <div class="controls" >
  					 	<input type="text" id="sLinkUrl" name="sLinkUrl"  maxlength="200" value="${newsInfo.sLinkUrl}"/>
    				</div>
 			 </div>  
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
			    <label class="control-label" for=""> </label>
			    <div class="controls">
					<button type="submit" class="btn blue" id="aaa" onclick="return doSummit()"><i class="  icon-ok icon-white"> </i>保存</button>
					<!-- 	<a class="btn blue" onclick="preview()"><i class=" icon-eye-open icon-white"></i> 预览</a> -->
					<input id="show" name="show" type="hidden" value="1" />
			    </div>
			 </div>
		</form:form>
		
<%@ include file="/include/footer.jsp"%>