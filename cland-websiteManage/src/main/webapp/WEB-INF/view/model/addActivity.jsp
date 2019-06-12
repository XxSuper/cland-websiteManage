<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<script src="${ctx}/js/model/addActivity.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">员工活动新增管理</c:when>
						<c:when test="${operate == 'edit'}">员工活动编辑管理</c:when>
					</c:choose>
				</a>
			</li>
		</ul>
		<form:form id="activity" class="form-horizontal" name="activity" action="${ctx}/activity/saveActivity.htm"
			method="post" >
			<input id="iType" name="iType" type="hidden" value="7" />
			<input id="sModularId" name="sModularId" type="hidden" value="${sModularId}" />
			<input id="operate" name="operate" type="hidden" value="${operate}" />
			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			<input id="sMediaImage" name="sMediaImage" type="hidden" value="${newsInfo.sMediaImage}" />
			<c:set value="${fn:split(newsInfo.sMediaImage,'|')}" var="imgs"></c:set>
			<div class="control-group">
    			<label class="control-label" for="">图片1</label>
  					  <div class="controls" >
     					<input type="hidden" id="pic1" name="pic1" value="${imgs[0]}" >
						<input type="file" id="pic1File" name="pic1File">
    				</div>
 			 </div>
 			<style>
				.fileuploader{ width:500px; margin:0;}
			</style>
			<div class="control-group">
    			<label class="control-label" for="">图片2(选填)</label>
  					  <div class="controls" >
     					<input type="hidden" id="pic2" name="pic2" value="${imgs[1]}" >
						<input type="file" id="pic2File" name="pic2File">
    				</div>
 			 </div>
 			<div class="control-group">
    			<label class="control-label" for="">图片3(选填)</label>
  					  <div class="controls" >
     					<input type="hidden" id="pic3" name="pic3" value="${imgs[2]}" >
						<input type="file" id="pic3File" name="pic3File">
    				</div>
 			 </div>
 			 <div class="control-group">
    			<label class="control-label" for="sTitle">标题</label>
  					  <div class="controls">
     					 <input type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
    				</div>
 			 </div>
 			<div class="control-group">
			    <label class="control-label" for="sNewContent">内容</label>
			    <div class="controls">
						<textarea id="sNewContent" name="sNewContent"
							style="width: 800px; height: 50%;" maxlength="5000">
							${newsInfo.sNewContent}
						</textarea>
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