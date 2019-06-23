<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/left.jsp"%>
<%@ include file="/include/taglib.jsp"%>

<script src="${ctx}/js/news/newsManage.js?20170103"></script>

	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">新闻管理</a></li>
	</ul>
	
	<div >
		<!-- search button -->
		<form:form id="searchForm" modelAttribute="page" action="${ctx}/news/query.htm" method="post" class="form-inline">
			
				<input id="pageNumber" name="pageNumber" type="hidden" value="1" />
				
				<button type="submit" class="btn blue"><i class="icon-search icon-white"></i> 查询 </button>
				
				<button type="button" class="btn blue" id="delete" onclick="doDeleteAll()"><i class="icon-trash icon-white"></i> 删除</button>
				
				<button type="button" class="btn blue" onclick="showSaveNews()"><i class="icon-plus icon-white"></i> 添加 </button>
				
				<input id="show" name="show" type="hidden" value="1" />

				<input id="iType" name="iType" type="hidden" value="2" />
			
		</form:form>

		<table id="contentTable" class="table table-striped table-bordered table-hover">
			
			<thead>
				<tr>
					<th style='width:5%'></th>
					<th style='width:8%'>序号</th>
					<th style='width:10%'>时间</th>
					<th style='width:15%'>标题</th>
					<th style='width:10%'>标签</th>
					<th style='width:10%'>图片</th>
					<th style='width:13%'>介绍</th>
					<th style='width:12%'>操作</th>
					<th>排序</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list}" var="newinfo" varStatus="varStatus">
					<tr>
						<td>
							<input type="checkbox" value="${newinfo.sNewsNo}" name="newsInfo">
						</td>
						<td>${newinfo.iSortNum}</td>
						<td>${newinfo.dPublishDate}</td>
						<td>${newinfo.sTitle}</td>
						<td>${newinfo.remark}</td>
						<td>
							<c:if test="${not empty newinfo.sBannerImage}">
								<img src="${newinfo.sBannerImage}" style='height:30px;' />
							</c:if>
						</td>
						<td>${newinfo.sIntroduce}</td>
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
										<i class="icon-edit icon-white"></i>取消推荐/首页显示
									</a>
								</c:when>
								<c:otherwise>
									<a href='javascript:;' onClick="setHomeDisplay('${newinfo.sNewsNo}','${newinfo.iHomeDisplay}')">
										<i class="icon-edit icon-white"></i>置为推荐/首页显示
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
