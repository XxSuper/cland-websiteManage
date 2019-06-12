<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<script src="${ctx}/js/brand/addBrand.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">旗下品牌新增管理</c:when>
						<c:when test="${operate == 'edit'}">旗下品牌编辑管理</c:when>
					</c:choose>
				</a>
			</li>
		</ul>
		<form:form id="brand" class="form-horizontal" name="brand" action="${ctx}/brand/saveBrand.htm"
			method="post" >
			<input id="iType" name="iType" type="hidden" value="8" />
			<input id="operate" name="operate" type="hidden" value="${operate}" />
			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			<input id="sMediaImage" name="sMediaImage" type="hidden" value="${newsInfo.sMediaImage}" />
			<c:set value="${fn:split(newsInfo.sMediaImage,'|')}" var="imgs"></c:set>
			<div class="control-group">
    			<label class="control-label" for="">logo</label>
  					  <div class="controls" >
     					<input type="hidden" id="sLogo" name="sLogo" value="${imgs[0]}" >
						<input type="file" id="sLogoFile" name="sLogoFile">
    				</div>
 			 </div>
 			<style>
				.fileuploader{ width:500px; margin:0;}
			</style>
			<div class="control-group">
    			<label class="control-label" for="">logo的hover状态</label>
  					  <div class="controls" >
     					<input type="hidden" id="sLogoHover" name="sLogoHover" value="${imgs[1]}" >
						<input type="file" id="sLogoHoverFile" name="sLogoHoverFile">
    				</div>
 			 </div>
 			<div class="control-group">
    			<label class="control-label" for="">链接</label>
  					  <div class="controls" >
  					 	<input class="required checkURL" type="text" id="sLinkUrl" name="sLinkUrl"  maxlength="200" value="${newsInfo.sLinkUrl}"/>
    				</div>
 			 </div>
			<div class="control-group">
			    <label class="control-label" for="">介绍</label>
			    <div class="controls">
						<textarea rows="4" cols="" style="width: 800px; " id="sNewContent" name="sNewContent" maxlength="5000">${newsInfo.sNewContent}</textarea>
			    </div>
			</div>
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