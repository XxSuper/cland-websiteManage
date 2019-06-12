<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">页面管理</a></li>
	</ul>
<div class="">
	<!-- header -->
	
	<div  style='padding-bottom:20px;'>
		<a class="btn blue" href="${ctx}/permission/editUI.htm?menuId=${menuId}"><i class="icon-plus icon-white"></i> 新增</a>
			
				<a class="btn" href="${ctx}/menu/childrenMenu.htm?id=${parentMenuId}">返回上一级</a>
			
	</div>
	<div class="">
		<!-- table -->
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>权限编号</th>
					<th>权限名称</th>
					<th>权限码</th>
					<th>访问路径</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty permissionList}">
					<c:forEach items="${permissionList}" var="permission" varStatus="varStatus">
						<tr id="${permission.guid}" <c:choose><c:when test="${varStatus.index % 5==1}">class="info"</c:when><c:when test="${varStatus.index % 5==2}">class="success"</c:when><c:when test="${varStatus.index % 5==3}">class="error"</c:when><c:when test="${varStatus.index % 5==4}">class="warning"</c:when></c:choose>>
							<td>
							${permission.permissionNo }
							</td>
							<td>${permission.permissionName }</td>
							<td>${permission.permissionCode }</td>
							<td>${permission.permissionUrl }</td>
							<td><a href="${ctx}/permission/editUI.htm?menuId=${menuId}&guid=${permission.guid}"><i class="icon-pencil"></i></a> <a
								href="javascript:void(0)" onclick="deletePermission('${permission.guid}',event)"><i
									class="icon-remove"></i></a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<script>
	function deletePermission(id,event) {
		//阻止冒泡
		ChkUtil.stopBubbleEvent(event);
		var a = window.confirm('确定删除此权限吗？');
		if (a) {
			$.ajax({
				url : '${ctx}/permission/delete.htm',
				type : 'post',
				data : {
					id : id
				},
				dataType : 'json',
				success : function(res) {
					if (res.flag == '1') {
						$("#" + id).remove();
					}
				}
			})
		}
	}
</script>
<%@ include file="/include/footer.jsp"%>