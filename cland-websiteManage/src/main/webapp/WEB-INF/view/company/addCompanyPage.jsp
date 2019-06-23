<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script  src="${ctx}/js/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/company/addCompany.js?"></script>
<!--页面标题-->
<h3 class="page-title"></h3>
<!--面包屑导航-->
<ul class="breadcrumb">
	<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
		<i class="icon-angle-right"></i></li>
	<li>
		<a href="javascript:void(0)">
			<c:choose>
				<c:when test="${operate == 'add'}">页脚新增管理</c:when>
				<c:when test="${operate == 'edit'}">页脚编辑管理</c:when>
			</c:choose>
		</a>
	</li>

</ul>



<form:form id="company" class="form-horizontal" name="company" action="${ctx}/company/saveCompanyInfo.htm"
		   method="post" enctype="multipart/form-data">

	<input id="operate" name="operate" type="hidden" value="${operate}" />

	<input id="sGuid" name="sGuid" type="hidden" value="${companyInfo.sGuid}" />

	<input id="isAbout" name="isAbout" type="hidden" value="${isAbout}" />

	<c:if test="${isAbout == 0}">
		<div class="control-group">
			<label class="control-label" for="sCulture">企业文化</label>
			<div class="controls">
				<input  type="text" id="sCulture"  name="sCulture"  placeholder="" maxlength="50" value="${companyInfo.sCulture}">
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sPhone">电话</label>
			<div class="controls">
				<input type="text" name="sPhone" id="sPhone"
					   class="input-xlarge search-query" value="${companyInfo.sPhone }" required>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sMailBox">咨询</label>
			<div class="controls">
				<input type="text" name="sMailBox" id="sMailBox" class="input-xlarge search-query"
					   value="${companyInfo.sMailBox }">
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sAddress">地址</label>
			<div class="controls">
				<input type="text" name="sAddress" id="sAddress" class="input-xlarge search-query"
					   value="${companyInfo.sAddress }">
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sQrCode">二维码</label>
			<div class="controls" >
				<input type="hidden" id="sQrCode" name="sQrCode" value="${companyInfo.sQrCode}" >
				<input type="file" id="sQrCodeFile" name="sQrCodeFile">
			</div>
		</div>
		<div class="control-group">
			<label  class="control-label">预览图：</label>
			<c:if test="${not empty companyInfo.sQrCode}">
				<img alt="" src="${companyInfo.sQrCode}" style="width:400px;" id="yl_image">
			</c:if>
			<c:if test="${empty companyInfo.sQrCode}">
				<img alt="" src="" style="width:400px;" id="yl_image">
			</c:if>
		</div>

		<div class="control-group">
			<label class="control-label" for="sCopyRight">著作权</label>
			<div class="controls">
				<textarea rows="4" cols="" style="width: 800px; " id="sCopyRight" name="sCopyRight">${companyInfo.sCopyRight}</textarea>
			</div>
		</div>
	</c:if>

	<c:if test="${isAbout == 1}">
		<div class="control-group">
			<label class="control-label" for="sAboutUsPhone">电话</label>
			<div class="controls">
				<input  type="text" id="sAboutUsPhone"  name="sAboutUsPhone"  placeholder="" maxlength="50" value="${companyInfo.sAboutUsPhone}">
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sAboutUsMail">邮箱</label>
			<div class="controls">
				<input type="text" name="sAboutUsMail" id="sAboutUsMail"
					   class="input-xlarge search-query" value="${companyInfo.sAboutUsMail }" required>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sWeChat">微信</label>
			<div class="controls">
				<input type="text" name="sWeChat" id="sWeChat" class="input-xlarge search-query"
					   value="${companyInfo.sWeChat }">
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sAboutUsAdress">地址</label>
			<div class="controls">
				<input type="text" name="sAboutUsAdress" id="sAboutUsAdress" class="input-xlarge search-query"
					   value="${companyInfo.sAboutUsAdress }">
			</div>
		</div>

		<div class="control-group">
			<label class="control-label" for="sRoute">路线</label>
			<div class="controls">
				<input type="text" name="sRoute" id="sRoute" class="input-xlarge search-query"
					   value="${companyInfo.sRoute }">
			</div>
		</div>
	</c:if>

	<style>
		.fileuploader{ width:500px; margin:0;}
	</style>

	<div class="control-group">
		<label class="control-label" for=""> </label>
		<div class="controls">
			<button type="submit" class="btn blue" id="aaa" onclick="return doSummit()"><i class="  icon-ok icon-white"> </i>保存</button>
			<input id="show" name="show" type="hidden" value="1" />
		</div>
	</div>
</form:form>

<%@ include file="/include/footer.jsp"%>