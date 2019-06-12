<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${ctx}/js/common/jquery/ui/jquery-ui.css"></link>

<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">待审核用户</a></li>
	</ul>
<div class="">
	<!-- header -->
	
	<div class="">
		<!-- search button -->
		<form class="form-search" action="${ctx}/user/operatorAudit.htm"
			method="post" onsubmit="return selectUser()">
			<div class="row-fluid" style="text-align: left;">
				
						用户名：<input class="input-small search-query" id="userName" name="suserName"
							type="text">
							手机号：<input class="input-medium search-query" id="sMobile" name="sMobile"
							type="text">
				
				<button type="submit" class="btn blue"><i class="icon-search icon-white"></i>查找</button>
				<a  class="btn blue" href="${ctx}/user/userQuery.htm" >返回</a>		
			</div> 
			
		</form>
	</div>
	
	<div class="">
		<!-- table -->
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>用户名</th>
					<th>手机号</th>
					<th>职位</th>
					<th>电话</th>
					<th>是否管理员</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty page.list}">
					<c:forEach items="${page.list}" var="user" varStatus="varStatus">
						<tr id="${user.guid}" >
							<td>${user.userNo }</td>
							<td>${user.userName }</td>
							<td>${user.mobile }</td>
							<td>${user.job }</td>
							<td>${user.phone}</td>
							<c:choose>
							   <c:when test="${user.bisAdmin == '1'}"><td>是</td></c:when>
							   <c:otherwise><td>否</td></c:otherwise>
							</c:choose>
							<td>
								<a href="javascript:showOperatorAuditDialog('${user.guid}','${user.userName }')">审核</a>
								</td>
						
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination text-right">
			<ul>
				 <c:if test="${page.hasPreviousPage ==false}"><li class="disabled"><a href="#">&#171; 上一页</a></li></c:if>
				  <c:if test="${page.hasPreviousPage}"><li> <a href="${ctx}/user/operatorAudit.htm?pageNumber=${page.pageNumber-1}">&#171; 上一页</a></li></c:if>
				 <c:forEach var="pageNum" items="${page.navigatePageNumbers}">
					<li <c:if test="${page.pageNumber == pageNum}">class="disabled"</c:if>>
				     	<a href="${ctx}/user/operatorAudit.htm?pageNumber=${pageNum}">${pageNum}</a>
				     </li>
				</c:forEach>
				  <c:if test="${page.hasNextPage ==false}"><li class="disabled"><a href="#">下一页 &#187;</a></li></c:if>
				  <c:if test="${page.hasNextPage}"><li> <a href="${ctx}/user/operatorAudit.htm?pageNumber=${page.pageNumber+1}">下一页 &#187;</a></li></c:if>
				<li class="disabled controls"><a href="#"> 共 ${page.total }条</a></li>
			</ul>
			<div style="clear: both;"></div>
		</div>
	</div>
</div>
<div id="operatorAuditDialog" style='display: none'>
	<form:form id="inputForm" method="post" class='form-horizontal'>
		<input type="hidden" name="guid" id="guid" value="" />
		<div class="control-group">
			<label class="control-label">用户名：</label>
			<div class="controls"><input id="approvelName" type="text" placeholder="" class="m-wrap small" disabled></div>
		</div>
		<div class="control-group">	
			<label class="control-label"> </label>
			<div class="controls">
					<select class="small m-wrap" name="approvel" id="approvel">
							<option value="-1">请选择审核结果</option>
							<option value="10">审核通过</option>
							<option value="20">审核拒绝</option>
					</select>
					<font color="red">*为必填项</font>	
			</div>		
		</div>
	</form:form>
</div>
<script src="${ctx }/js/user/user.js?d"></script>
<script src="${ctx }/js/common/md5.js"></script>
<%@ include file="/include/footer.jsp"%>