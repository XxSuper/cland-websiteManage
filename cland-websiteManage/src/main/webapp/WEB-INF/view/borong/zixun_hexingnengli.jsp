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
    <title>咨询服务-核心能力</title>
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
            <h3>核心能力</h3>
            <p>Core competence</p>
        </div>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="m-competence" style="background-image: url(${ctx}/borong/images/bgq2.jpg);">
            <div class="wp">
                <ul class="ul-imgtxtq5">
                	<c:forEach items="${coreNl }" var="info">
	                    <li>
	                        <a href="fuwuDetail.htm?sNewsNo=${info.sNewsNo }">
	                            <div class="pic">
	                                <img src="${info.sBannerImage }" alt="" />
	                                <div class="con">
	                                    <div class="txt">
	                                        <h3>${info.sTitle }</h3>
	                                        <div class="box">
	                                            <p>${info.sIntroduce }</p>
	                                            <span>咨询合作</span>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </a>
	                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
</body>

</html>