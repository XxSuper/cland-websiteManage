<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">角色管理</a></li>
	</ul>
<div> 
   
    <div >
        <!-- search button -->
        <form class="form-search" action="${ctx}/role/role.htm" method="post" onsubmit="return selectRole()">
          
                
                    名称：<input class="input-medium search-query" id="roleName" name="sroleName" type="text">
            
            <shiro:hasPermission name="role:role"><button type="submit" class="btn blue" ><i class="icon-search icon-white"></i> 查找</button></shiro:hasPermission>
             <shiro:hasPermission name="role:addUI"><a class="btn blue" href="${ctx}/role/editUI.htm"><i class="icon-plus icon-white"></i> 新增</a></shiro:hasPermission>
        </form>
    </div>
        <div class="">
        <!-- table -->
        <table class="table table-striped table-bordered table-hover">
            <thead>
                <tr>
                    <th>编号</th>
                    <th>名称</th>
                    <th>描述</th>
                    <th>操作</th>
                </tr>
            </thead>
            <tbody>
              <c:if test="${not empty roleList}">
              	<c:forEach items="${roleList}" var="role" varStatus="varStatus">
                <tr id="${role.sguid}"   >
                    <td>${role.sroleNo }</td>
                    <td>${role.sroleName }</td>
                    <td>${role.sroleDesc }</td>
                    <td>
                        <shiro:hasPermission name="role:editUI"> <a href="${ctx}/role/editUI.htm?roleId=${role.sguid}"><i class="icon-pencil"></i></a></shiro:hasPermission>
                       <shiro:hasPermission name="role:deleteRole">  <a href="javascript:void(0)" onclick="deleteRole('${role.sguid}',event)"><i class="icon-remove"></i></a></shiro:hasPermission>.
                       <shiro:hasPermission name="permission:setPermissionUI">  <a href="${ctx}/permission/setPermissionUI.htm?roleId=${role.sguid}">分配权限</a></shiro:hasPermission>
                    </td>
                </tr>
                </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
<script>
function selectRole(){
	var name = $("#roleName").val();
	if(ChkUtil.isNull(name)){
		alert('名称不能为空!');
		return false;
	}
	return true;
}

function deleteRole(id,event){
	//阻止冒泡
	ChkUtil.stopBubbleEvent(event);
	var a =window.confirm('确定删除？');
	if(a){
		$.ajax({
		url:'${ctx}/role/deleteRole.htm',
		type:'post',
		data:{
			id:id
		},
		dataType:'json',
		success:function(res){
		  if(res.flag=='1'){
			 $("#"+id).remove();
		  }
		}
	})
	}
	
}
</script>
<%@ include file="/include/footer.jsp"%>
