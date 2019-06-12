<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<script type="text/javascript" src="${ctx}/js/impress/addImpress.js?"></script>
		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">印象博荣新增管理</c:when>
						<c:when test="${operate == 'edit'}">印象博荣编辑管理</c:when>
					</c:choose>
				</a>
			</li>

		</ul>
	
		<form:form id="news" class="form-horizontal" name="news" action="${ctx}/impress/saveImpressInfo.htm"
			method="post" enctype="multipart/form-data">

			<input id="iType" name="iType" type="hidden" value="4" />

			<input id="operate" name="operate" type="hidden" value="${operate}" />

			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			
			
			<div class="control-group">
    			<label class="control-label" for="sTitle">期数</label>
  					  <div class="controls">
  					  	 <c:choose>
							<c:when test="${operate == 'add'}">
								<input type="text" id="sTitle" readonly="readonly" name="sTitle"  placeholder="" maxlength="100" value="第${periods}期">
								<input id="iSortNum" name="iSortNum" type="hidden" value="${periods}" />
							</c:when>
							<c:when test="${operate == 'edit'}">
								<input type="text" id="sTitle" readonly="readonly" name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
							</c:when>
						</c:choose>
    				</div>
 			</div>
 			 
 			<div class="control-group">
    			<label class="control-label" for="dPublishDate">发布时间</label>
  					  <div class="controls">
     					<div class="input-group input-medium date-picker input-daterange dateRange" data-date-format="yyyy-mm-dd">
						    <input id="dPublishDate" name="dPublishDate" style='text-align: left;' 
						    	class="form-control dateSelect" required today  type="text"	value="${newsInfo.dPublishDate}">
						</div>
    				</div>
 			 </div>
 			 
			<div class="control-group">
    			<label class="control-label" for="">封面图</label>
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
			    <div class="controls">
						<input type="text" style="width: 750px; " id="sLinkUrl" name="sLinkUrl" value="${newsInfo.sLinkUrl}"></input>
			    </div>
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