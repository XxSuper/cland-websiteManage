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
    <title>博融智库</title>
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
    <c:if test="${clumnsSize > 3}">
    	<div class="ban" style="background-image: url(${clumns[3].sBannerImage });">
	        <div class="txt">
	            <h3>${clumns[3].sTitle }</h3>
	            <p>${clumns[3].sTitleEn }</p>
	        </div>
	    </div>
    </c:if>
    <c:if test="${clumnsSize <= 3}">
    	<div class="ban" style="background-image: url(${ctx}/borong/images/ban-h2.png);">
	        <div class="txt">
	            <h3>博融智库</h3>
	            <p>Consultation</p>
	        </div>
	    </div>
    </c:if>
    
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="g-top">
            <div class="wp">
                <div class="search">
                    <input type="text" id="searchKey" value="${searchKey }" class="inp" placeholder="在此输入文章关键词" />
                    <input type="submit" class="sub" onclick="search()" value="" />
                </div>
                <ul class="g-links">
                	<c:if test="${queryType == 1}">
                		<li class="on"><a href="zhiku.htm?queryType=1" onclick="return false;">博融观点</a></li>
                    	<li><a href="zhiku.htm?queryType=2&searchKey=${searchKey }">理论本土化</a></li>
                	</c:if>
                	<c:if test="${queryType != 1}">
                		<li><a href="zhiku.htm?queryType=1&searchKey=${searchKey }">博融观点</a></li>
                    	<li class="on"><a href="zhiku.htm?queryType=2" onclick="return false;">理论本土化</a></li>
                	</c:if>
                    
                </ul>
            </div>
        </div>
        <div class="m-point" style="background-image: url(${ctx}/borong/images/bgq7.jpg);">
            <div class="wp">
                <ul class="ul-img1">
                	<c:forEach items="${pageInfo.page.list}" var="pageData" varStatus="varStatus">
                		<li>
	                        <a href="lifeDetail.htm?sNewsNo=${pageData.sNewsNo}">
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
		keyPath = "&searchKey=" + searchKey;
	}
	location.href="zhiku.htm?queryType=" + ${queryType} + keyPath;
}
function gotoPage(queryType, pageNumber){
	var searchKey = $('#searchKey').val();
	var keyPath = "";
	if(searchKey){
		keyPath = "&searchKey=" + searchKey;
	}
	location.href="zhiku.htm?pageNumber="+pageNumber+"&queryType=" + queryType + keyPath;
}
</script>
</html>