<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script  src="${ctx}/js/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/mercy/addMercy.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">公益慈善新增管理</c:when>
						<c:when test="${operate == 'edit'}">公益慈善编辑管理</c:when>
					</c:choose>
				</a>
			</li>

		</ul>
		

	
		<form:form id="news" class="form-horizontal" name="news" action="${ctx}/mercy/saveMercy.htm"
			method="post" >

			<input id="iType" name="iType" type="hidden" value="1" />

			<input id="operate" name="operate" type="hidden" value="${operate}" />

			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			
			
			<div class="control-group">
    			<label class="control-label" for="sTitle">标题</label>
  					  <div class="controls">
     					 <input type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
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
    			<label class="control-label" for="">首页图片（选填）</label>
  					  <div class="controls" >
     					<input type="hidden" id="sBannerImage" name="sBannerImage" value="${newsInfo.sBannerImage}" >
						<input type="file" id="sBannerImageFile" name="sBannerImageFile">
    				</div>
 			 </div>
 			<style>
				.fileuploader{ width:500px; margin:0;}
			</style>
 			<div class="control-group">
    			<label class="control-label" for="">列表图片</label>
  					  <div class="controls" >
     					<input type="hidden" id="sMediaImage" name="sMediaImage" value="${newsInfo.sMediaImage}" >
						<input type="file" id="sMediaImageFile" name="sMediaImageFile">
    				</div>
 			 </div>
			
			<div class="control-group">
			    <label class="control-label" for="">介绍</label>
			    <div class="controls">
						<textarea rows="4" cols="" style="width: 800px; " id="sIntroduce" name="sIntroduce" maxlength="200">${newsInfo.sIntroduce}</textarea>
			    </div>
			</div>
		
			  
			<div class="control-group">
			    <label class="control-label" for="sNewContent">编辑内容</label>
			    <div class="controls">
						<textarea id="sNewContent" name="sNewContent"
							style="width: 800px; height: 50%;" maxlength="5000">
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