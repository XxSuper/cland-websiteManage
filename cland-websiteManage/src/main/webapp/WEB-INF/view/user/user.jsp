<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">用户管理</a></li>
	</ul>
<div >
	<!-- header -->
	
	<div class="">
		<!-- search button -->
		<form class="form-search" action="${ctx}/user/userQuery.htm" method="post" onsubmit="return selectUser()">
			<div class="row-fluid" style="text-align: left;">
				
						用户名：<input class="input-small search-query" id="userName"
							name="suserName" type="text" value="${suserName}"> 手机号：<input
							class="input-medium search-query" id="sMobile" name="sMobile"
							type="text" value="${sMobile}">
			
				<shiro:hasPermission name="user:userQuery">
					<button type="submit" class="btn blue"><i class="icon-search icon-white"></i> 查找</button>
				</shiro:hasPermission>
				<shiro:hasPermission name="user:addUser">
					<a class="btn blue" href="javascript:void(0)" onclick="editUser()" ><i class="icon-plus"></i> 新增</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="user:operatorAudit">
					<a  class="btn blue" href="${ctx}/user/operatorAudit.htm"><i class="icon-user"></i> 待审核用户</a>
				</shiro:hasPermission>
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
						<tr id="${user.guid}">
							<td>${user.userNo }</td>
							<td>${user.userName }</td>
							<td>${user.mobile }</td>
							<td>${user.job }</td>
							<td>${user.phone}</td>
							<c:choose>
								<c:when test="${user.bisAdmin == '1'}">
									<td>是</td>
								</c:when>
								<c:otherwise>
									<td>否</td>
								</c:otherwise>
							</c:choose>
							<td><shiro:hasPermission name="user:editUser">
									<a href="javascript:void(0)" onclick="editUser('${user.guid}')"><i
										class="icon-pencil"></i></a>
								</shiro:hasPermission> <shiro:hasPermission name="user:deleteUser">
									<a href="javascript:void(0)"
										onclick="submitDeleteUser('${user.guid}')"><i
										class="icon-remove"></i></a>
								</shiro:hasPermission> <shiro:hasPermission name="user:assignRole">
									<a href="${ctx}/user/assignRole.htm?userId=${user.guid}">分配角色</a>
								</shiro:hasPermission> <shiro:hasPermission name="user:initPassword">
									<a href="javascript:void(0)"
										onclick="initPassword('${user.guid}')">初始化密码</a>
								</shiro:hasPermission>
								<shiro:hasPermission name="user:userFreeze">
									<c:if test="${user.bisFreeze == 1}">
										<a href="javascript:void(0)"
											onclick="userFreeze('${user.guid}','0')">禁用</a>
									</c:if>
									<c:if test="${user.bisFreeze != 1}">
										<a href="javascript:void(0)"
											onclick="userFreeze('${user.guid}','1')">启用</a>
									</c:if>
								</shiro:hasPermission>
								<a href="javascript:void(0)"
											onclick="getUserRole('${user.guid}','${user.userName }')">查看角色</a>
								</td>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
		<div class="pagination text-right">
			<ul>
				<c:if test="${page.hasPreviousPage ==false}">
					<li class="disabled"><a href="#">&#171; 上一页</a></li>
				</c:if>
				<c:if test="${page.hasPreviousPage}">
					<li><a
						href="${ctx}/user/userQuery.htm?pageNumber=${page.pageNumber-1}">&#171;
							上一页</a></li>
				</c:if>
				<c:forEach var="pageNum" items="${page.navigatePageNumbers}">
					<li
						<c:if test="${page.pageNumber == pageNum}">class="disabled"</c:if>>
						<a href="${ctx}/user/userQuery.htm?pageNumber=${pageNum}">${pageNum}</a>
					</li>
				</c:forEach>
				<c:if test="${page.hasNextPage ==false}">
					<li class="disabled"><a href="#">下一页 &#187;</a></li>
				</c:if>
				<c:if test="${page.hasNextPage}">
					<li><a
						href="${ctx}/user/userQuery.htm?pageNumber=${page.pageNumber+1}">下一页
							&#187;</a></li>
				</c:if>
				<li class="disabled controls"><a href="#"> 共 ${page.total }条</a></li>
			</ul>
			<div style="clear: both;"></div>
		</div>
	</div>
</div>
<div id="dialog" style='display: none'>
	<form id="inputForm" method="post" class='form-horizontal'>
		<input type="hidden" name="guid" id="guid" value="" />
		
		
		<div class="control-group" style='margin-top:30px;'>
			<label class="control-label">用户名：</label>
			<div class="controls">
				<input id="suserName" name="userName"  type="text"  class="m-wrap medium">
				<font color="red">*</font>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">真实姓名：</label>
			<div class="controls">
				<input id="realName" name="realName"  type="text"  class="m-wrap medium" >
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">手机号：</label>
			<div class="controls">
				<input name="mobile" id="mobile" type="text"  class="m-wrap medium" >
				<font color="red">*</font>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">Email：</label>
			<div class="controls">
				<input id="email"	name="email"  type="text"  class="m-wrap medium" >
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">职位：</label>
			<div class="controls">
				<input name="job" id="job"  type="text"  class="m-wrap medium" >
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">电话：</label>
			<div class="controls">
				<input name="phone" id="phone"  type="text"  class="m-wrap medium" >
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label"> </label>
			<div class="controls">
				<button type='button' id="btnSubmit" class='btn blue' onclick="save(event);"><i class="icon-ok"></i> 提交</button>&nbsp;
				<button type='button' id="btnCancel" class='btn' onclick="closeDialog('dialog')">取消</button> 
			
					<div class='help-inline'><font color="red">*为必填项</font></div>
			</div>
		</div>
		
		
		
		
	</form>
</div>

<div id="userRoleDialog" style='display: none; '>
<div class='userRoleDialog'>
	<table style='width:100%'>
		<tr>
			<td class='text-right' style='width:40%'><h5>用户名：</h5></td>
			<td><h4  id="suser"></h4></td>
		</tr>
		<tr>
			<td class='text-right'><h5>拥有的角色：</h5></td>
			<td><h4  id="role"></h4></td>
		</tr>
	</table>
	</div>
</div>
<script src="${ctx }/js/user/user.js?20160127"></script>
<script src="${ctx }/js/common/md5.js"></script>
<%@ include file="/include/footer.jsp"%>