<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<link rel="stylesheet" href="${ctx}/js/common/editor/themes/default/default.css" />
<script  src="${ctx}/js/common/editor/kindeditor.js"></script>
<script type="text/javascript" src="${ctx}/js/commonpage/addCommonPage.js?"></script>

		<!--页面标题-->
		<h3 class="page-title"></h3>
		<!--面包屑导航-->
		<ul class="breadcrumb">
			<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
				<i class="icon-angle-right"></i></li>
			<li>
				<a href="javascript:void(0)">
					SEO关键字
				</a>
			</li>

		</ul>
	
		<form:form id="news" class="form-horizontal" action="${ctx}/commonPage/updateSeo.htm"
			method="post">
			<label class="control-label">关键字SEO</label>
		 	<div class="controls">
    			<input  type="text" id="keywords"  name="keywords"  placeholder="" maxlength="300" value="${seo.keywords }">
   			</div>
   			<br/>
			<label class="control-label">描述</label>
			<div class="controls">
				<input  type="text" id="description"  name="description"  placeholder="" maxlength="300" value="${seo.description }">
			</div>
			<div class="controls" style="margin-top: 20px;">
					<button type="submit" class="btn blue" id="aaa" onclick="return doSummit()"><i class="  icon-ok icon-white"> </i>保存</button>
			    </div>
		</form:form>
		
<%@ include file="/include/footer.jsp"%>