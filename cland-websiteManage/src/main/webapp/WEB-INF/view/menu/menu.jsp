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
		<li><a href="javascript:void(0)">菜单中心</a></li>
	</ul>


<div>

	<div style='margin-bottom:20px'>
		<shiro:hasPermission name="menu:addUI"><a href="${ctx}/menu/editUI.htm?parentMenuId=${parentMenuId}"  class="btn blue" ><i class="icon-plus icon-white"></i> 新增</a></shiro:hasPermission>
		<c:if test="${level eq '1'}">
			<span class="btn">
				  <a href="${ctx}/menu/menu.htm">返回上一级</a>
			</span>
		</c:if>
	</div>
	<div >
		<!-- table -->
		<table  class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th>编号</th>
					<th>菜单名称</th>
					<th>访问路径</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty menuList}">
					<c:forEach items="${menuList}" var="menu" varStatus="varStatus" >
						<tr id="${menu.guid}" >
							<td><c:choose>
									<c:when test="${level eq '1'}">
										<a href="${ctx}/permission/menuPermission.htm?id=${menu.guid}&parentMenuId=${parentMenuId}">${menu.menuNo }</a>
									</c:when>
									<c:otherwise>
										<a href="${ctx}/menu/childrenMenu.htm?id=${menu.guid}">${menu.menuNo }</a>
									</c:otherwise>
								</c:choose> 

							</td>
							<td>${menu.name }</td>
							<td>${menu.url }</td>
							<td><shiro:hasPermission name="menu:editUI"><a href="${ctx}/menu/editUI.htm?menuId=${menu.guid}&parentMenuId=${parentMenuId}"><i class="icon-pencil"></i></a></shiro:hasPermission><shiro:hasPermission name="menu:delete"> <a
								href="javascript:void(0)" onclick="deleteMenu('${menu.guid}',event)"><i
									class="icon-remove"></i></a></shiro:hasPermission></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<script>
	function deleteMenu(id,event) {
		//阻止冒泡
		ChkUtil.stopBubbleEvent(event);
		var a = window.confirm('确定删除菜单及其子菜单？');
		if (a) {
			$.ajax({
				url : '${ctx}/menu/delete.htm',
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