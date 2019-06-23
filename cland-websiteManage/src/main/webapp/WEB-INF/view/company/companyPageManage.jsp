<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/left.jsp"%>
<%@ include file="/include/taglib.jsp"%>

<script src="${ctx}/js/company/companyPageManage.js?20190609"></script>

<!--页面标题-->
<h3 class="page-title"></h3>

<!--面包屑导航-->
<ul class="breadcrumb">
	<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
		<i class="icon-angle-right"></i></li>
	<li>
		<a href="javascript:void(0)">
			<c:if test="${isAbout == 0}">页脚管理 </c:if>
			<c:if test="${isAbout == 1}">联系方式管理 </c:if>
		</a>
	</li>
</ul>

<div >
	<!-- search button -->
	<form:form id="searchForm" modelAttribute="page" action="${ctx}/company/query.htm?isAbout=${isAbout}" method="post" class="form-inline">

		<input id="pageNumber" name="pageNumber" type="hidden" value="1" />

		<button type="submit" class="btn blue"><i class="icon-search icon-white"></i> 查询 </button>

		<input id="show" name="show" type="hidden" value="1" />
	</form:form>

	<table id="contentTable" class="table table-striped table-bordered table-hover">

		<thead>
		<tr>
			<c:if test="${isAbout == 0}">
				<th style='width:5%'></th>
				<th style='width:10%'>企业文化</th>
				<th style='width:10%'>电话</th>
				<th style='width:10%'>咨询</th>
				<th style='width:10%'>地址</th>
				<th style='width:20%'>著作权</th>
				<th style='width:20%'>二维码</th>
				<th style='width:20%'>操作</th>
			</c:if>
			<c:if test="${isAbout == 1}">
				<th style='width:5%'></th>
				<th style='width:10%'>电话</th>
				<th style='width:10%'>邮箱</th>
				<th style='width:10%'>微信</th>
				<th style='width:10%'>地址</th>
				<th style='width:10%'>路线</th>
				<th style='width:20%'>操作</th>
			</c:if>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="companyInfo" varStatus="varStatus">
			<tr>
				<c:if test="${isAbout == 0}">
					<td>
						<input type="checkbox" value="${companyInfo.sGuid}" name="companyInfo">
					</td>
					<td>${companyInfo.sCulture}</td>
					<td>${companyInfo.sPhone}</td>
					<td>${companyInfo.sMailBox}</td>
					<td>${companyInfo.sAddress}</td>
					<td>${companyInfo.sCopyRight}</td>
					<td>
						<c:if test="${not empty companyInfo.sQrCode}">
							<img src="${companyInfo.sQrCode}" style='height:30px;' />
						</c:if>
					</td>
					<td>
						<a href='javascript:;' onClick="showEditCompany('${companyInfo.sGuid}', '${isAbout}')" id="${companyInfo.sGuid}">
							<i class="icon-edit icon-white"></i>编辑
						</a>
					</td>
				</c:if>
				<c:if test="${isAbout == 1}">
					<td>
						<input type="checkbox" value="${companyInfo.sGuid}" name="companyInfo">
					</td>
					<td>${companyInfo.sAboutUsPhone}</td>
					<td>${companyInfo.sAboutUsMail}</td>
					<td>${companyInfo.sWeChat}</td>
					<td>${companyInfo.sAboutUsAdress}</td>
					<td>${companyInfo.sRoute}</td>
					<td>
						<a href='javascript:;' onClick="showEditCompany('${companyInfo.sGuid}', '${isAbout}')" id="${companyInfo.sGuid}">
							<i class="icon-edit icon-white"></i>编辑
						</a>
					</td>
				</c:if>
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
