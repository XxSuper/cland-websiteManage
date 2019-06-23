<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script  src="${ctx}/js/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/news/addNews.js?"></script>
		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">新闻新增管理</c:when>
						<c:when test="${operate == 'edit'}">新闻编辑管理</c:when>
					</c:choose>
				</a>
			</li>

		</ul>
		

	
		<form:form id="news" class="form-horizontal" name="news" action="${ctx}/news/saveNewsInfo.htm"
			method="post" enctype="multipart/form-data">

			<input id="iType" name="iType" type="hidden" value="2" />

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
    			<label class="control-label" for="sTitle">标题</label>
  					  <div class="controls">
     					 <input  type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
    				</div>
 			 </div>
 			 <div class="control-group">
    			<label class="control-label" for="sTitle">标签</label>
  					  <div class="controls">
     					 <input  type="text" id="remark"  name="remark"  placeholder="" maxlength="50" value="${newsInfo.remark}">
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
    			<label class="control-label" for="visitCount">浏览次数</label>
  					  <div class="controls">
     					 <input  type="text" id="visitCount"  name="visitCount"  placeholder="" maxlength="100" value="${visitCount}">
    				</div>
 			 </div>
			
			<div class="control-group">
    			<label class="control-label" for="">banner图（选填）</label>
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
			    <label class="control-label" for="">介绍</label>
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