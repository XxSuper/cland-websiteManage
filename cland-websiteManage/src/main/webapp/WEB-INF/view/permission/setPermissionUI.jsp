<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header3.jsp"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>

<%-- <script src="${ctx }/js/common/jquery/jquery_treeview/jquery.js"></script> --%>
<script src="${ctx }/js/common/jquery/jquery.hiAlerts.1.0/jquery-1.7.1.min.js"></script>
 


<script src="${ctx }/js/common/jquery/jquery_treeview/jquery.treeview.js"></script>
<link type="text/css" rel="stylesheet" href="${ctx }/css/file.css" />
<link type="text/css" rel="stylesheet" href="${ctx }/js/common/jquery/jquery_treeview/jquery.treeview.css" />
<link type="text/css" rel="stylesheet" href="${ctx }/css/pageCommon.css" />
<script src="${ctx }/js/common/common.js"></script>
<%-- <link rel="stylesheet" type="text/css" href="${ctx }/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx }/js/bootstrap/css/bootstrap-responsive.min.css"> --%>
<script type="text/javascript">
		function logout(){
			  window.location.href=ctx+"/sys/logout.htm";
		}
 		// 选择所有
    	function selectAll(checkedValue){
    		$("input[type=checkbox][name=resourceIdList]").attr("checked", checkedValue);
    	}
    	
    	function doChecked( liID, checkedValue ){
			// 当前点击的checkbox元素所在的li元素
    		var jLi = $("#" + liID);

    		// 选中所有的直属下级。（children()方法是筛选下一级，find()是筛选所有后代）
    		jLi.children("ul").find("input[type=checkbox]").attr("checked", checkedValue);
    		
    		// 选中或取消选中直属上级
    		if( checkedValue ){ // checkedValue是boolean型，表示是否选中了当前复选框
    			// 如果当前是选中，则选中所有的直属上级
				jLi.parents("li").children("input[type=checkbox]").attr("checked", checkedValue);
			}else{
				// 如果当前是取消选中，并且同级中没有被选中的项，则也取消上级的选中状态
				var jCheckedSibingCB = jLi.siblings("li").children("input[type=checkbox]:checked");
				if(jCheckedSibingCB.size() == 0){
					var jCheckboxInput = jLi.parent("ul").prev("label").prev("input[type=checkbox]");
					jCheckboxInput.attr("checked", checkedValue);
					
					// 递归操作每一层直属上级
					var jParentLi = jCheckboxInput.parent("li");
					if(jParentLi.size() > 0){
						doChecked(jParentLi.attr("id"), checkedValue);
					}
				}
			}
    	} 
    	
    	$(function(){
    		$("#tree").treeview();
    		var initPermissionIds = JSON.parse('${rolePermissionsIdsList}');
    		var checkboxs = $("input[type=checkbox][name=resourceIdList]");
    		for(var a =0 ;a<initPermissionIds.length;a++){
    				for(var b =0 ;b<checkboxs.length;b++){
    	    			if(initPermissionIds[a].spermissionid==$(checkboxs[b]).attr("id").split("_")[1]){
    	    				$(checkboxs[b]).attr("checked", "checked");
    	    				$(checkboxs[b]).parent().parent().prev().prev().attr("checked", "checked").parent().parent().prev().prev().attr("checked", "checked");
    	    			}
    	    		}
    		}
    		
    	});
    	function submitForm(event){
    		//阻止冒泡
    		ChkUtil.stopBubbleEvent(event);
    		if($("input[type=checkbox][checked=checked]").length>0){
    			document.forms[0].submit();
    		}else{
    			alert("请选择");
    		}
    		
    	}
    </script>
	<!-- header -->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">正在为【${role.sroleName}】设置权限</a></li>
	</ul>
	
<!--显示表单内容-->
<div >
    <form action="${ctx}/permission/setPermission.htm" method="post">
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
					<!--表头-->
					<thead>
						<tr align="LEFT" valign="MIDDLE" id="TableTitle">
							<td width="300px" style="padding-left: 7px;">
								<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
								<input type="CHECKBOX" id="cbSelectAll" onClick="selectAll(this.checked)"/>
								<label for="cbSelectAll">全选</label>
							</td>
						</tr>
					</thead>
                   
			   		<!--显示数据列表-->
					<tbody id="TableData">
						<tr class="TableDetail1">
							<!-- 显示权限树 -->
							<td>
<ul id='tree'>
   	<c:if test="${not empty menuList}">
					<c:forEach items="${menuList}" var="menu">
							<li id='li_${menu.guid}'>
		                       <input type='checkbox' name='resourceIdList' id='cb_${menu.guid}' value="" onclick='doChecked("li_${menu.guid}", this.checked)'/>
		                       <label for='cb_${menu.guid}'><span class='folder' id='${menu.guid}'>${menu.name}</span></label>
		                       	<c:if test="${not empty menu.chirdlen}">
		                       	<ul>
							        <c:forEach items="${menu.chirdlen}" var="menuChildren">
							           		
	                                        	<li id='li_${menuChildren.guid}'>
		                                            	<input type='checkbox' name='resourceIdList' id='cb_${menuChildren.guid}' value="" onclick='doChecked("li_${menuChildren.guid}", this.checked)'/>
				                                        <label for='cb_${menuChildren.guid}'><span class='folder' id='${menuChildren.guid}'>${menuChildren.name}</span></label>
				                                        	<c:if test="${not empty menuChildren.permissions}">
				                                        	<ul>
							                                      <c:forEach items="${menuChildren.permissions}" var="permission">
							           	                     	      
	                                        	                           <li id='li_${permission.guid}'>
		                                                                 	<input type='checkbox' name='resourceIdList' id='cb_${permission.guid}' value="${permission.guid}" onclick='doChecked("li_${permission.guid}", this.checked)'/>
				                                                            <label for='cb_${permission.guid}'><span class='folder' id='${permission.guid}'>${permission.permissionName}</span></label>
				                                          	</li>
							                       </c:forEach>
							                       </ul>
						                       </c:if>
				                            	</li>
							        </c:forEach>
							        </ul>
						         </c:if>
		                    </li>
					</c:forEach>
	</c:if>
	
</ul>

</td>
						</tr>
					</tbody>
                </table>
            </div>
        </div>
        <input type="hidden" name="roleId" value="${role.sguid}">
    </form>
     <div id="InputDetailBar">
     
     <button type="button" class='btn blue' onclick="submitForm(event)"><i class="icon-ok"></i> 保存</button>
     
     <a href="javascript:history.go(-1);" class='btn' onclick="submitForm(event)">返回</a>
          <!--  <input type="image" src="${ctx }/css/images/save.png" onclick="submitForm(event)"/>
            <a href="javascript:history.go(-1);"><img src="${ctx }/css/images/goBack.png"/></a> --> 
        </div>
</div>
<%@ include file="/include/footer.jsp"%>
