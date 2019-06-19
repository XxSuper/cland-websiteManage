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
    <title>关于我们</title>
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
    <div class="ban" style="background-image: url(${ctx}/borong/images/ban-h2.png);">
        <div class="txt">
            <h3>关于我们</h3>
            <p>About</p>
        </div>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <ul class="g-links">
            <li><a href="companyInfo.htm">集团简介</a></li>
            <li><a href="xinwen.htm">博融新闻</a></li>
            <li class="on"><a href="borongTeam.htm">博融团队</a></li>
            <li><a href="rongyuzhengshu.htm">博融荣誉</a></li>
            <li><a href="zhaoxian.htm">招贤纳士</a></li>
        </ul>
        <div class="m-h4">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>博融团队</span></h3>
                    <em>Bo Rong team</em>
                </div>
                <ul class="ul-imgtxtq3">
                	<c:forEach items="${pageInfo.page.list}" var="pageData" varStatus="varStatus">
                		<li>
	                        <a href="">
	                            <div class="pic"><img src="${pageData.sBannerImage }" alt=""></div>
	                            <h3>${pageData.sTitle }<em>${pageData.remark }</em></h3>
	                            <div class="txt">
	                                <h3>${pageData.sTitle }<em>${pageData.remark }</em></h3>
	                                <p>${pageData.sIntroduce }</p>
	                                <span>了解更多&gt;&gt;</span>
	                            </div>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <!--页码-->
                <div class="pages">
                    <ul>
                        <li class="prev"><a href="borongTeam.htm?pageNumber=${pageInfo.prePage}">上一页</a></li>
                        <c:forEach items="${pageInfo.pNos}" var="pNo">
                        	<c:if test="${pNo == pageInfo.pageNumber}">
                        		<li class="on"><a href="borongTeam.htm?pageNumber=${pNo}">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo != pageInfo.pageNumber && pNo != '...'}">
                        		<li><a href="borongTeam.htm?pageNumber=${pNo}">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo == '...'}">
                        		<li><a href="javascript:void(0);">${pNo}</a></li>
                        	</c:if>
                        </c:forEach>
                        <li class="next"><a href="borongTeam.htm?pageNumber=${pageInfo.nextPage}">下一页</a></li>
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