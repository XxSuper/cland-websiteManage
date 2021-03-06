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
    <title>服务案例</title>
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
    <c:if test="${clumnsSize > 2}">
    	<div class="ban" style="background-image: url(${clumns[2].sBannerImage });">
	        <div class="txt">
	            <h3>${clumns[2].sTitle }</h3>
	            <p>${clumns[2].sTitleEn }</p>
	        </div>
	    </div>
    </c:if>
    <c:if test="${clumnsSize <= 2}">
    	<div class="ban" style="background-image: url(${ctx}/borong/images/ban-2.png);">
	        <div class="txt">
	            <h3>服务案例</h3>
	            <p>Contact</p>
	        </div>
	    </div>
    </c:if>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="m-classic" style="background-image: url(${ctx}/borong/images/bgq5.jpg);">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>经典案例</span></h3>
                    <em>Classic case</em>
                </div>
                <ul class="ul-txtq1 TAB_CLICK" id=".tabbox">
                	<c:forEach items="${jList}" varStatus="i" var="obj">
                		<li <c:if test="${i.index == 0 }">class="on"</c:if>><a href="javascript:;">${obj.sTitle }</a></li>
                	</c:forEach>
                </ul>
                <c:forEach items="${jList}" varStatus="i" var="obj">
                	<div class="tabbox <c:if test='${i.index > 0 }'>dn</c:if>">
	                    <div class="m-cont">
	                        <div class="pic">
	                        	<img src="${obj.sBannerImage}" alt="" />
	                        </div>
	                        <div class="txt">
	                        	${obj.sNewContent}
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
            </div>
        </div>
        <div class="m-morecase" style="background-image: url(images/bgq6.jpg);">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>更多案例</span></h3>
                    <em>More cases</em>
                </div>
                <ul class="ul-imgtxtq2">
                	<c:forEach items="${pageInfo.page.list}" var="pageData" varStatus="varStatus">
                		<li>
	                        <a href="fuwuDetail.htm?sNewsNo=${pageData.sNewsNo}">
	                            <div class="txt">
	                                <h3>${pageData.sTitle}</h3>
	                                <p>${pageData.sIntroduce}</p>
	                            </div>
	                            <div class="pic">
	                                <img src="${pageData.sBannerImage}" alt="">
	                            </div>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <!--页码-->
                <div class="pages">
                    <ul>
                        <li class="prev"><a href="serviceList.htm?pageNumber=${pageInfo.prePage}&queryType=${queryType}">上一页</a></li>
                        <c:forEach items="${pageInfo.pNos}" var="pNo">
                        	<c:if test="${pNo == pageInfo.pageNumber}">
                        		<li class="on"><a href="serviceList.htm?pageNumber=${pNo}&queryType=${queryType}">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo != pageInfo.pageNumber && pNo != '...'}">
                        		<li><a href="serviceList.htm?pageNumber=${pNo}&queryType=${queryType}">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo == '...'}">
                        		<li><a href="javascript:void(0);">${pNo}</a></li>
                        	</c:if>
                        </c:forEach>
                        <li class="next"><a href="serviceList.htm?pageNumber=${pageInfo.nextPage}&queryType=${queryType}">下一页</a></li>
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

</html>