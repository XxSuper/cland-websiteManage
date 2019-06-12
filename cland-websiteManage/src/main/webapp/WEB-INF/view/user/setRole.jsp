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
		<li><a href="javascript:void(0)">正在为${user.userName }分配角色</a></li>
	</ul>


<div class="">

	<div class="" style='padding-left:50px;'>
		<form class="form-search" action="${ctx}/user/editUserRole.htm" method="post"  onsubmit="return checkIds()">
		     <c:if test="${not empty userRoleIds}">
		          <input type="hidden" name="type" value="edit"/>
		     </c:if>
		    <table cellpadding="0" cellspacing="0" class="mainForm">
			<tr>
				<!-- <td width="100">角色设置</td> -->
				<td><select name="roleIdList" multiple="true" size="10"  id="roleIdList"
					class="SelectStyle" style=' width:320px;'>
						<c:forEach items="${allRoleList}" var="allRoleMap">
							<option value="${allRoleMap.sguid}">${allRoleMap.sroleName }</option>
						</c:forEach>
				</select> 按住Ctrl键可以多选或取消选择</td>
			</tr>
			<tr>
				
			</tr>
		</table>
		    <input type="hidden" name="sUserId" value="${user.guid }"/>
			<button type="submit" class="btn  blue" style="margin-top: 20px"><i class="icon-ok icon-white"> </i> 提交</button>
			<input type="button" class="btn "
			onclick="javascript:history.go(-1)" value="取消" style="margin-top: 20px"></input>
			
		</form>
	</div>
	</div>
</div>
<script>
	$(function() {
		var initRoleIds = new Array();   
		initRoleIds = "${userRoleIds}".replace('[','').replace(']','').split(',');
		var options = $("option");
		for (var a = 0; a < initRoleIds.length; a++) {
			for (var b = 0; b < options.length; b++) {
				if (initRoleIds[a].replace(/(^\s*)|(\s*$)/g, "") == $(options[b]).val()) {
					$(options[b]).attr("selected", "selected");
				}
			}
		}

	});
	
	function checkIds(){
		var ids = $("#roleIdList").val();
		if(ids==null||ChkUtil.isNull(ids)){
			alert('请选择角色后提交！');
			return false;
		}
		return true;
	}
</script>
<%@ include file="/include/footer.jsp"%>
