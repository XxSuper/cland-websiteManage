<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<script src="${ctx}/js/industry/addIndustry.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					<c:choose>
						<c:when test="${operate == 'add'}">博荣产业新增管理</c:when>
						<c:when test="${operate == 'edit'}">博荣产业编辑管理</c:when>
					</c:choose>
				</a>
			</li>
		</ul>
		
		<form:form id="industry" class="form-horizontal" name="industry" action="${ctx}/industry/saveIndustry.htm"
			method="post" >
			<input id="iType" name="iType" type="hidden" value="11" />
			<input id="operate" name="operate" type="hidden" value="${operate}" />
			<input id="sNewsNo" name="sNewsNo" type="hidden" value="${newsInfo.sNewsNo}" />
			<div class="control-group">
    			<label class="control-label" for="sTitle">标题</label>
  					  <div class="controls">
     					 <input type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="100" value="${newsInfo.sTitle}">
    				</div>
 			 </div>
			
			<div class="control-group">
    			<label class="control-label" for="">链接</label>
  					  <div class="controls" >
  					 	<input class="checkURL" type="text" id="sLinkUrl" name="sLinkUrl"  maxlength="200" value="${newsInfo.sLinkUrl}"/>
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