<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script  src="${ctx}/js/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/commonpage/addCommonPage.js?"></script>
<c:if test="${iType == 1}">
	<c:set var="pageName" value="核心行业"></c:set>
	<c:set var="titleName" value="行业名称"></c:set>
</c:if>
<c:if test="${iType == 4}">
	<c:set var="pageName" value="团队介绍"></c:set>
	<c:set var="titleName" value="姓名"></c:set>
	<c:set var="remarkName" value="职位"></c:set>
</c:if>
<c:if test="${iType == 7 || iType == 12}">
	<c:set var="pageName" value="服务案例"></c:set>
	<c:set var="titleName" value="服务对象"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
</c:if>
<c:if test="${iType == 8}">
	<c:set var="pageName" value="服务概述"></c:set>
	<c:set var="titleName" value="标题"></c:set>
</c:if>
<c:if test="${iType == 9}">
	<c:set var="pageName" value="主要模块"></c:set>
	<c:set var="titleName" value="中文标题"></c:set>
	<c:set var="remarkName" value="英文标题"></c:set>
</c:if>
<c:if test="${iType == 10}">
	<c:set var="pageName" value="应用领域"></c:set>
	<c:set var="titleName" value="应用领域"></c:set>
</c:if>
<c:if test="${iType == 11}">
	<c:set var="pageName" value="核心能力"></c:set>
	<c:set var="titleName" value="核心能力"></c:set>
</c:if>
<c:if test="${iType == 13}">
	<c:set var="pageName" value="博融招聘"></c:set>
	<c:set var="titleName" value="职位"></c:set>
	<c:set var="remarkName" value="招聘标签"></c:set>
</c:if>
<c:if test="${iType == 14}">
	<c:set var="pageName" value="博融生活"></c:set>
	<c:set var="titleName" value="标题"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
</c:if>
<c:if test="${iType == 15}">
	<c:set var="pageName" value="友情链接"></c:set>
	<c:set var="titleName" value="链接名称"></c:set>
	<c:set var="remarkName" value="链接地址"></c:set>
</c:if>
<c:if test="${iType == 16}">
	<c:set var="pageName" value="博融观点"></c:set>
	<c:set var="titleName" value="标题"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
</c:if>
<c:if test="${iType == 17}">
	<c:set var="pageName" value="理论本土化"></c:set>
	<c:set var="titleName" value="标题"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
</c:if>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">${pageName}新增管理</c:when>
						<c:when test="${operate == 'edit'}">${pageName}编辑管理</c:when>
					</c:choose>
				</a>
			</li>

		</ul>
		

	
		<form:form id="news" class="form-horizontal" name="news" action="${ctx}/commonPage/saveCommonPageInfo.htm"
			method="post" enctype="multipart/form-data">

			<input id="iType" name="iType" type="hidden" value="${iType }" />

			<input id="operate" name="operate" type="hidden" value="${operate}" />

			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			
			<c:choose>
				<c:when test="${newsInfo.iHomeDisplay == 1}">
					<input id="iHomeDisplay" name="iHomeDisplay" type="hidden" value="${newsInfo.iHomeDisplay}" />
				</c:when>
				<c:otherwise>
					<input id="iHomeDisplay" name="iHomeDisplay" type="hidden" value="0" />
				</c:otherwise>
			</c:choose>
			
			
			<div class="control-group">
    			<label class="control-label" for="sTitle">${titleName}</label>
  					  <div class="controls">
     					 <input  type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
    				</div>
 			 </div>
 			 
 			 <c:if test="${iType == 7 || iType == 12 || iType == 14}">
 			 	<div class="control-group">
	    			<label class="control-label" for="sWriter">作者</label>
	  					  <div class="controls">
	     					 <input  type="text" id="sWriter"  name="sWriter"  placeholder="" maxlength="100" value="${newsInfo.sWriter}">
	    				</div>
	 			 </div>
 			 </c:if>
<!--  			 团队介绍不包含时间 -->
 			 <c:if test="${iType == 2}">
	 			 <div class="control-group">
	    			<label class="control-label" for="dPublishDate">发布时间</label>
	  					  <div class="controls">
	     					<div class="input-group input-medium date-picker input-daterange dateRange" data-date-format="yyyy-mm-dd">
							    <input id="dPublishDate" name="dPublishDate" style='text-align: left;' 
							    	class="form-control dateSelect" required today  type="text"	value="${newsInfo.dPublishDate}">
							</div>
	    				</div>
	 			 </div>
			</c:if>
			<c:if test="${iType == 4 || iType == 7 || iType == 12 || iType == 9 || iType == 13 || iType == 14 || iType == 15 || iType == 16 || iType == 17}">
				<div class="control-group">
	    			<label class="control-label" for="sTitle">${remarkName }</label>
  					  <div class="controls">
     					 <input  type="text" id="remark"  name="remark"  placeholder="" maxlength="100" value="${newsInfo.remark}">
    				</div>
	 			 </div>
			</c:if>
			<c:if test="${iType == 1 || iType == 2 || iType == 4 || iType == 7 || iType == 12 || iType == 8 || iType == 9 || iType == 10 || iType == 11 || iType == 13 || iType == 14 || iType == 16 || iType == 17}">
				<div class="control-group">
	    			<label class="control-label" for="">banner图</label>
	  					  <div class="controls" >
	     					<input type="hidden" id="sBannerImage" name="sBannerImage" value="${newsInfo.sBannerImage}" >
							<input type="file" id="sBannerImageFile" name="sBannerImageFile">
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
				
				<style>
				.fileuploader{ width:500px; margin:0;}
				</style>
				
				
				
				<div class="control-group">
				    <label class="control-label" for="">简介</label>
				    <div class="controls">
							<textarea rows="4" cols="" style="width: 800px; " id="sIntroduce" name="sIntroduce">${newsInfo.sIntroduce}</textarea>
				    </div>
				</div>
			
				  
				<div class="control-group">
				    <label class="control-label" for="sNewContent">编辑内容</label>
				    <div class="controls">
							<textarea id="sNewContent" name="sNewContent"
								style="width: 800px; height: 50%;" maxlength="2">
								${newsInfo.sNewContent}
							</textarea>
							<p>
								您当前输入了 <span class="word_count1">0</span> 个文字。（字数统计包含HTML代码。）<br />
								您当前输入了 <span class="word_count2">0</span>
								个文字。（字数统计包含纯文本、IMG、EMBED，不包含换行符，IMG和EMBED算一个文字。）
				    </div>
				</div>
			</c:if>
			  
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