<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <meta name="format-detection" content="telephone=no" />
    <title>博融新闻</title>
    <meta name="description" content="${seo.description}" />
    <meta name="keywords" content="${seo.keywords}" />
    <link rel="stylesheet" href="${ctx}/borong/css/style.css" />
    <script src="${ctx}/borong/js/jquery.js"></script>
    <script src="${ctx}/borong/js/lib.js"></script>
</head>

<body class="">
    <!-- 头部 -->
    <%@ include file="common_header.jsp"%>
    <!-- 头部 -->
    <!-- banner -->
    <c:if test="${clumnsSize > 5 && clumns[5].childSize > 2}">
    	<div class="ban" style="background-image: url(${clumns[5].clist[2].sBannerImage });">
	        <div class="txt">
	            <h3>${clumns[5].clist[2].sTitle }</h3>
	            <p>${clumns[5].clist[2].sTitleEn }</p>
	        </div>
	    </div>
    </c:if>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="m-point" style="background-image: url(${ctx}/borong/images/bgq7.jpg);">
            <div class="wp">
                <ul class="ul-img1">
                	<c:forEach items="${pageInfo.page.list}" var="pageData" varStatus="varStatus">
                		<li>
	                        <a href="lifeDetail.htm?iType=2&&sNewsNo=${pageData.sNewsNo }">
	                            <div class="pic">
	                                <img src="${pageData.sBannerImage}" alt="" />
	                            </div>
	                            <div class="txt">
	                                <h3>${pageData.sTitle}</h3>
	                                <div class="bom">
	                                    <div class="r">${pageData.dModifyDate}</div>
	                                    <span>${pageData.remark}</span>
	                                </div>
	                            </div>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <!--页码-->
                <div class="pages">
                    <ul>
                        <li class="prev"><a href="" onclick="gotoPage(${queryType},${pageInfo.prePage})">上一页</a></li>
                        <c:forEach items="${pageInfo.pNos}" var="pNo">
                        	<c:if test="${pNo == pageInfo.pageNumber}">
                        		<li class="on"><a href="" onclick="gotoPage(${queryType},${pNo})">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo != pageInfo.pageNumber && pNo != '...'}">
                        		<li><a href=""  onclick="gotoPage(${queryType},${pNo})">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo == '...'}">
                        		<li><a href="javascript:void(0);">${pNo}</a></li>
                        	</c:if>
                        </c:forEach>
                        <li class="next"><a href="" onclick="gotoPage(${queryType},${pageInfo.nextPage})">下一页</a></li>
                    </ul>
                </div>
                <!--页码end-->
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
</body>
<script type="text/javascript">
function search(){
	var searchKey = $('#searchKey').val();
	var keyPath = "";
	if(searchKey){
		keyPath = "searchKey=" + searchKey;
	}
	window.location.href="xinwen.htm?" + keyPath;
}
function gotoPage(queryType, pageNumber){
	var searchKey = $('#searchKey').val();
	var keyPath = "";
	if(searchKey){
		keyPath = "&searchKey=" + searchKey;
	}
	window.location.href="xinwen.htm?pageNumber="+pageNumber + keyPath;
}
</script>
</html>