<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script  src="${ctx}/js/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/column/addColumn.js?"></script>
<!--页面标题-->
<h3 class="page-title"></h3>
<!--面包屑导航-->
<ul class="breadcrumb">
	<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
		<i class="icon-angle-right"></i></li>
	<li>
		<a href="javascript:void(0)">
			<c:choose>
				<c:when test="${operate == 'add'}">栏目新增管理</c:when>
				<c:when test="${operate == 'edit'}">栏目编辑管理</c:when>
			</c:choose>
		</a>
	</li>

</ul>



<form:form id="column" class="form-horizontal" name="column" action="${ctx}/column/saveColumnInfo.htm"
		   method="post" enctype="multipart/form-data">

	<input id="operate" name="operate" type="hidden" value="${operate}" />

	<input id="sColumnNo" name="sColumnNo" type="hidden" value="${columnInfo.sColumnNo}" />


	<div class="control-group">
		<label class="control-label" for="sFatherNo">上级栏目</label>
		<div class="controls">
			<select name="sFatherNo" class="input-xlarge"  id="sFatherNo">
				<option value="">请选择上级菜单</option>
				<c:if test="${not empty columnList}">
					<c:forEach items="${columnList}" var="columnMap">
						<option value="${columnMap.sGuid}"
							<c:if test="${sFatherNo ==columnMap.sGuid}">selected="selected"</c:if>>${columnMap.sName }
						</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label" for="sName">栏目名称</label>
		<div class="controls">
			<input  type="text" id="sName"  name="sName"  placeholder="" maxlength="50" value="${columnInfo.sName}">
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label" for="sTitle">标题</label>
		<div class="controls">
			<input  type="text" id="sTitle"  name="sTitle"  placeholder="" maxlength="50" value="${columnInfo.sTitle}">
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label" for="sTitleEn">英文标题</label>
		<div class="controls">
			<input  type="text" id="sTitleEn"  name="sTitleEn"  placeholder="" maxlength="50" value="${columnInfo.sTitleEn}">
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="iSortNum">排序</label>
		<div class="controls">
			<input type="text" name="iSortNum" id="iSortNum"
				   class="input-xlarge search-query" value="${columnInfo.iSortNum }" required>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="sSeoTitle">栏目SEO标题</label>
		<div class="controls">
			<input type="text" name="sSeoTitle" id="sSeoTitle" class="input-xlarge search-query"
				   value="${columnInfo.sSeoTitle }">
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="sSeoKeyWords">栏目SEO关键字</label>
		<div class="controls">
			<input type="text" name="sSeoKeyWords" id="sSeoKeyWords" class="input-xlarge search-query"
				   value="${columnInfo.sSeoKeyWords }">
		</div>
	</div>
	
	<div class="control-group">
		<label class="control-label" for="sSeoDesc">栏目SEO描述</label>
		<div class="controls">
			<input type="text" name="sSeoDesc" id="sSeoDesc" class="input-xlarge search-query"
				   value="${columnInfo.sSeoDesc }">
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="sLink">栏目链接</label>
		<div class="controls">
			<input type="text" name="sLink" id="sLink" class="input-xlarge search-query"
				   value="${columnInfo.sLink }">
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" for="sBannerImage">缩略图（选填）</label>
		<div class="controls" >
			<input type="hidden" id="sBannerImage" name="sBannerImage" value="${columnInfo.sBannerImage}" >
			<input type="file" id="sBannerImageFile" name="sBannerImageFile">
		</div>
	</div>
	<div class="control-group">
		<label  class="control-label">预览图：</label>
		<c:if test="${not empty columnInfo.sBannerImage}">
			<img alt="" src="${columnInfo.sBannerImage}" style="width:400px;" id="yl_image">
		</c:if>
		<c:if test="${empty columnInfo.sBannerImage}">
			<img alt="" src="" style="width:400px;" id="yl_image">
		</c:if>
	</div>
	<style>
		.fileuploader{ width:500px; margin:0;}
	</style>



	<div class="control-group">
		<label class="control-label" for="sProfile">介绍</label>
		<div class="controls">
			<textarea rows="4" cols="" style="width: 800px; " id="sProfile" name="sProfile">${columnInfo.sProfile}</textarea>
		</div>
	</div>



	<div class="control-group">
		<label class="control-label" for=""> </label>
		<div class="controls">
			<button type="submit" class="btn blue" id="aaa" onclick="return doSummit()"><i class="  icon-ok icon-white"> </i>保存</button>
			<input id="show" name="show" type="hidden" value="1" />
		</div>
	</div>
</form:form>

<%@ include file="/include/footer.jsp"%>