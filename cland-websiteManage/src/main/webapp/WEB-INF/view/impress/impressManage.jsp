<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/left.jsp"%>
<%@ include file="/include/taglib.jsp"%>

<script src="${ctx}/js/impress/impressManage.js?20170103"></script>

	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">印象博融管理</a></li>
	</ul>
	
	<div >
		<!-- search button -->
		<form:form id="searchForm" modelAttribute="page" action="${ctx}/impress/query.htm" method="post" class="form-inline">
			
				<input id="pageNumber" name="pageNumber" type="hidden" value="1" />
				
				<button type="submit" class="btn blue"><i class="icon-search icon-white"></i> 查询 </button>
				
				<button type="button" class="btn blue" onclick="showSaveImpress()"><i class="icon-plus icon-white"></i> 添加 </button>
				
				<input id="show" name="show" type="hidden" value="1" />

				<input id="iType" name="iType" type="hidden" value="4" />
			
		</form:form>

		<table id="contentTable" class="table table-striped table-bordered table-hover">
			
			<thead>
				<tr>
					<th style='width:28%'>期数</th>
					<th style='width:30%'>图片</th>
					<th style='width:25%'>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list}" var="newinfo" varStatus="varStatus">
					<tr>
						<td>${newinfo.sTitle}</td>
						<td><img src="${newinfo.sBannerImage}" style='height:30px;' /></td>
						<td>
							<a href='javascript:;' onClick="showEditImpress('${newinfo.sNewsNo}')" id="${newinfo.sNewsNo}">
								<i class="icon-edit icon-white"></i>编辑
							</a>
							<c:if test="${varStatus.index == 0}">
								<a href='javascript:;' onClick="deleteImpress('${newinfo.sNewsNo}')" id="${newinfo.sNewsNo}">
									<i class="icon-trash icon-white"></i>删除
								</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="pagination">
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
