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
    <title>搜索页</title>
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
    <div class="ban" style="background-image: url(${ctx}/borong/images/ban-h1.png);">
        <div class="h-so">
               <input type="text" id="searchKey" class="inp" value="${searchKey }" placeholder="请在此输入您要搜索的内容或关键词" />
               <input type="submit" class="sub" onclick="search()" value="搜索" />
        </div>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="m-h1">
            <div class="jieguo">
                <div class="wp">
                    <p>当前已为您检索到<span>${pageInfo.total }</span>篇相关内容</p>
                </div>
            </div>
            <div class="wp">
                <ul class="ul-h1">
                	<c:forEach items="${pageInfo.page.list}" var="pageData" varStatus="varStatus">
                		<li>
	                        <div class="pic">
	                            <a href="searchDetail.htm?sNewsNo=${pageData.sNewsNo }"><img src="${pageData.sBannerImage}" alt="" /></a>
	                        </div>
	                        <div class="txt">
	                            <h3><a href="searchDetail.htm?sNewsNo=${pageData.sNewsNo }">${pageData.sTitle}</a></h3>
	                            <p>${pageData.sIntroduce}</p>
	                            <div class="bom">
	                                <div class="r">${pageData.dModifyDate}</div>
	                                <c:if test="${not empty  pageData.remark}">
	                                	<div class="noto">
		                                    <span>${pageData.remark}</span>
		                                </div>
	                                </c:if>
	                                
	                            </div>
	                        </div>
	                    </li>
                	</c:forEach>
                </ul>
                <!--页码-->
                <div class="pages">
                    <ul>
                        <li class="prev"><a href="javascript:void(0);" onclick="gotoPage(${pageInfo.prePage})">上一页</a></li>
                        <c:forEach items="${pageInfo.pNos}" var="pNo">
                        	<c:if test="${pNo == pageInfo.pageNumber}">
                        		<li class="on"><a href="javascript:void(0);" onclick="gotoPage(${pNo})">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo != pageInfo.pageNumber && pNo != '...'}">
                        		<li><a href="javascript:void(0);"  onclick="gotoPage(${pNo})">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo == '...'}">
                        		<li><a href="javascript:void(0);">${pNo}</a></li>
                        	</c:if>
                        </c:forEach>
                        <li class="next"><a href="javascript:void(0);" onclick="gotoPage(${pageInfo.nextPage})">下一页</a></li>
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
	var url = "searchPage.htm?value=" + searchKey + "&pageNumber=1";
	window.location.href=url;
}
function gotoPage(pageNumber){
	var searchKey = $('#searchKey').val();
	window.location.href=("searchPage.htm?pageNumber="+pageNumber + "&value=" + searchKey);
}
</script>
</html>