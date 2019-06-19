<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/left.jsp"%>
<%@ include file="/include/taglib.jsp"%>

<script src="${ctx}/js/commonpage/commonPageManage.js?20190609"></script>
<c:if test="${iType == 1}">
	<c:set var="pageName" value="核心行业"></c:set>
	<c:set var="titleName" value="核心行业"></c:set>
</c:if>
<c:if test="${iType == 4}">
	<c:set var="pageName" value="团队介绍"></c:set>
	<c:set var="titleName" value="姓名"></c:set>
	<c:set var="remarkName" value="职位"></c:set>
</c:if>
<c:if test="${iType == 8}">
	<c:set var="pageName" value="服务概述"></c:set>	
	<c:set var="titleName" value="标题"></c:set>
</c:if>
<c:if test="${iType == 9}">
	<c:set var="pageName" value="主要模块"></c:set>
	<c:set var="titleName" value="中文标题"></c:set>
	<c:set var="remarkName" value="英文标题"></c:set>
</c:if>
<c:if test="${iType == 10}">
	<c:set var="pageName" value="应用领域"></c:set>
	<c:set var="titleName" value="应用领域"></c:set>
</c:if>
<c:if test="${iType == 11}">
	<c:set var="pageName" value="核心能力"></c:set>
	<c:set var="titleName" value="核心能力"></c:set>
</c:if>
<c:if test="${iType == 13}">
	<c:set var="pageName" value="博融招聘"></c:set>
	<c:set var="titleName" value="职位"></c:set>
	<c:set var="remarkName" value="招聘标签"></c:set>
</c:if>
<c:if test="${iType == 14}">
	<c:set var="pageName" value="博融生活"></c:set>
	<c:set var="titleName" value="标题"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
	<c:set var="dateName" value="创建时间"></c:set>
</c:if>
<c:if test="${iType == 15}">
	<c:set var="pageName" value="友情链接"></c:set>
	<c:set var="titleName" value="链接名称"></c:set>
</c:if>
<c:if test="${iType == 16}">
	<c:set var="pageName" value="博融观点"></c:set>
	<c:set var="titleName" value="标题"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
	<c:set var="dateName" value="创建时间"></c:set>
</c:if>
<c:if test="${iType == 17}">
	<c:set var="pageName" value="理论本土化"></c:set>
	<c:set var="titleName" value="标题"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
	<c:set var="dateName" value="创建时间"></c:set>
</c:if>
<c:if test="${iType == 7 || iType == 12}">
	<c:set var="pageName" value="服务案例"></c:set>
	<c:set var="titleName" value="服务对象"></c:set>
	<c:set var="remarkName" value="标签"></c:set>
</c:if>

	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">${pageName }管理</a></li>
	</ul>
	
	<div >
		<!-- search button -->
		<form:form id="searchForm" modelAttribute="page" action="${ctx}/commonPage/query.htm" method="post" class="form-inline">
			
				<input id="pageNumber" name="pageNumber" type="hidden" value="1" />
				
				<button type="submit" class="btn blue"><i class="icon-search icon-white"></i> 查询 </button>
				
				<button type="button" class="btn blue" id="delete" onclick="doDeleteAll()"><i class="icon-trash icon-white"></i> 删除</button>
				
				<button type="button" class="btn blue" onclick="showSaveNews()"><i class="icon-plus icon-white"></i> 添加 </button>
				
				<input id="show" name="show" type="hidden" value="1" />

				<input id="iType" name="iType" type="hidden" value="${iType}" />
			
		</form:form>

		<table id="contentTable" class="table table-striped table-bordered table-hover">
			
			<thead>
				<tr>
					<th style='width:5%'></th>
					<th style='width:8%'>序号</th>
					<c:if test="${iType == 2 || iType == 14 || iType == 16 || iType == 17}">
						<th style='width:10%'>${dateName }</th>
					</c:if>
					<th style='width:10%'>${titleName}</th>
					<c:if test="${iType == 7 || iType == 12 || iType == 14}">
						<th style='width:10%'>作者</th>
					</c:if>
					
					<c:if test="${iType == 4 || iType == 7 || iType == 12 || iType == 9 || iType == 13 || iType == 14 || iType == 16 || iType == 17}">
						<th style='width:15%'>${remarkName}</th>
					</c:if>
					
					<c:if test="${iType == 1 || iType == 2 || iType == 4 || iType == 7 || iType == 12 || iType == 8 || iType == 9 || iType == 10 || iType == 11 || iType == 13 || iType == 14 || iType == 16 || iType == 17}">
						<th style='width:10%'>图片</th>
						<th style='width:18%'>简介</th>
					</c:if>
					
					<th style='width:14%'>操作</th>
					<th style='width:8%'>排序</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list}" var="newinfo" varStatus="varStatus">
					<tr>
						<td>
							<input type="checkbox" value="${newinfo.sNewsNo}" name="newsInfo">
						</td>
						<td>${newinfo.iSortNum}</td>
						<c:if test="${iType == 2}">
							<td>${newinfo.dPublishDate}</td>
						</c:if>
						<c:if test="${iType == 16 || iType == 17 || iType == 14}">
							<td>${newinfo.dModifyDate}</td>
						</c:if>
						<td>${newinfo.sTitle}</td>
						<c:if test="${iType == 7 || iType == 12 || iType == 14}">
							<td>${newinfo.sWriter}</td>
						</c:if>
						<c:if test="${iType == 4 || iType == 7 || iType == 12 || iType == 9 || iType == 13 || iType == 14 || iType == 16 || iType == 17}">
							<td>${newinfo.remark}</td>
						</c:if>
						<c:if test="${iType == 1 || iType == 2 || iType == 4 || iType == 7 || iType == 12 || iType == 8 || iType == 9 || iType == 10 || iType == 11 || iType == 13 || iType == 14 || iType == 16 || iType == 17}">
							<td>
								<c:if test="${not empty newinfo.sBannerImage}">
									<img src="${newinfo.sBannerImage}" style='height:30px;' />
								</c:if>
							</td>
							<td>${newinfo.sIntroduce}</td>
						</c:if>
						
						<td>
							<a href='javascript:;' onClick="showEditNews('${newinfo.sNewsNo}')" id="${newinfo.sNewsNo}">
								<i class="icon-edit icon-white"></i>编辑
							</a>
							<a href='javascript:;' onClick="deleteNews('${newinfo.sNewsNo}')" id="${newinfo.sNewsNo}">
								<i class="icon-trash icon-white"></i>删除
							</a>
							<c:choose>
								<c:when test="${newinfo.iHomeDisplay == 1}">
									<a href='javascript:;' onClick="setHomeDisplay('${newinfo.sNewsNo}','${newinfo.iHomeDisplay}')">
										<i class="icon-edit icon-white"></i>取消首页展示
									</a>
								</c:when>
								<c:otherwise>
									<a href='javascript:;' onClick="setHomeDisplay('${newinfo.sNewsNo}','${newinfo.iHomeDisplay}')">
										<i class="icon-edit icon-white"></i>置为首页展示
									</a>
								</c:otherwise>
							</c:choose>
						</td>
						<td>
							<input class='span8 js_px_input' type='text' id="${newinfo.sNewsNo}" value='${newinfo.iSortNum}' />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input id="select" type="hidden" value="true">
		<!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->
<!-- 		<button class="btn blue" onclick="selectAll()">	<i class="icon-check icon-white"></i> 全选</button> -->
		
		<div class="pagination text-right">
			<ul>
				<c:if test="${page.hasPreviousPage ==false}">
					<li class="disabled"><a href="#">&#171; 上一页</a></li>
				</c:if>
				<c:if test="${page.hasPreviousPage}">
					<li><a href="javascript:goPage(${page.pageNumber-1})">&#171;
							上一页</a></li>
				</c:if>
				<c:forEach var="pageIndex" items="${page.navigatePageNumbers}">
					<li
						<c:if test="${page.pageNumber == pageIndex}">class="disabled"</c:if>>
						<a href="javascript:goPage(${pageIndex})">${pageIndex}</a>
					</li>
				</c:forEach>
				<c:if test="${page.hasNextPage ==false}">
					<li class="disabled"><a href="#">下一页 &#187;</a></li>
				</c:if>
				<c:if test="${page.hasNextPage}">
					<li><a href="javascript:goPage(${page.pageNumber+1})">下一页
							&#187;</a></li>
				</c:if>
				<li class="disabled controls"><a href="#"> 共 ${page.total }条</a></li>
			</ul>
			<div style="clear: both;"></div>
		</div>
	</div>
<%@ include file="/include/footer.jsp"%>
