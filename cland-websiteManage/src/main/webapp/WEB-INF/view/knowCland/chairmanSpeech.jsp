<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ include file="/include/left.jsp"%>
<%@ include file="/include/taglib.jsp"%>

<script src="${ctx }/js/knowCland/chairmanSpeech.js?20171018"></script>

<!--页面标题-->
<h3 class="page-title"></h3>

<!--面包屑导航-->
<ul class="breadcrumb">
    <li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
        <i class="icon-angle-right"></i></li>
    <li><a href="javascript:void(0)">董事长致辞</a></li>
</ul>

<div >
    <!-- search button -->
    <form:form id="searchForm" modelAttribute="page" action="${ctx}/knowCland/chairmanSpeechQuery.htm" method="post" class="form-inline">

        <input id="pageNumber" name="pageNumber" type="hidden" value="1" />

        <button type="button" class="btn blue" onclick="showSave()"><i class="icon-plus icon-white"></i> 添加 </button>

        <input id="show" name="show" type="hidden" value="1" />

        <input id="iType" name="iType" type="hidden" value="12" />

    </form:form>

    <table id="contentTable" class="table table-striped table-bordered table-hover">

        <thead>
        <tr>
            <th>图片</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list}" var="dto" varStatus="varStatus">
            <tr>
                <td>
                	<c:if test="${not empty dto.sMediaImage}">
						<img src="${dto.sMediaImage}" style='height:30px;' />
					</c:if>
                </td>
                <td>
                    <a href='javascript:;' onClick="showEdit('${dto.sNewsNo}')" id="${dto.sNewsNo}">
                        <i class="icon-edit icon-white"></i>编辑
                    </a>
                    <a href='javascript:;' onClick="deleteOne('${dto.sNewsNo}')" id="${dto.sNewsNo}">
                        <i class="icon-trash icon-white"></i>删除
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <input id="select" type="hidden" value="true">
    <!-- 如果把全选元素的id指定为selectAll，并且有函数selectAll()，就会有错。因为有一种用法：可以直接用id引用元素 -->

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