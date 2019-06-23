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
    <c:if test="${clumnsSize > 5 && clumns[5].childSize > 1}">
	    	<div class="ban" style="background-image: url(${clumns[5].clist[1].sBannerImage });">
		        <div class="txt">
		            <h3>${clumns[5].clist[1].sTitle }</h3>
		            <p>${clumns[5].clist[1].sTitleEn }</p>
		        </div>
		    </div>
	    </c:if>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <ul class="g-links">
            <li class="on"><a href="companyInfo.htm">集团简介</a></li>
            <li><a href="xinwen.htm">博融新闻</a></li>
            <li><a href="borongTeam.htm">博融团队</a></li>
            <li><a href="rongyuzhengshu.htm">博融荣誉</a></li>
            <li><a href="zhaoxian.htm">招贤纳士</a></li>
        </ul>
        <div class="row-h5">
            <div class="m-jianjie">
                <div class="wp">
                    <div class="box">
                        <div class="pic">
                            <img src="${ctx}/borong/images/h22.png" alt="" />
                        </div>
                        <div class="txt">
                            <div class="tit">
                                <h3>董事长<span>致辞</span></h3>
                                <p>Address by the Chairman</p>
                                <i></i>
                            </div>
                            <div class="desc">
                                ${info.sNewContent }
                            </div>
                            <div class="c"></div>
                            <div class="di">-------您的朋友，董事长</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="m-group">
                <div class="wp">
                    <div class="txt">
                        <div class="g-titq1">
                            <h3><span>集团简介</span></h3>
                            <em>Group Introduction</em>
                        </div>
                        <div class="desc">
                            <h3>北京东方博融管理咨询有限公司</h3>
                            <p>${info.sIntroduce }
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="m-hs1">
                <div class="wp">
                    <ul class="ul-tabh2 TAB_CLICK" id=".tabh2">
                    	<c:forEach items="${listInfo }" var="obj" varStatus="i">
                    		
                    		<li <c:if test="${i.index == 0 }">class="on"</c:if>><a href="javascript:;">${obj.sTitle }</a></li>
                    	</c:forEach>
                        <li class="last"><a href="">更多</a></li>
                    </ul>
                    <c:forEach items="${listInfo }" var="obj" varStatus="i">
                    	<div class="tabh2 <c:if test='${i.index > 0 }'>dn</c:if>">
	                        <div class="tab">
	                            <div class="l">
	                                <div class="pic">
	                                    <img src="${obj.sBannerImage }" alt="" />
	                                </div>
	                            </div>
	                            <div class="txt">
	                                ${obj.sNewContent }
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                </div>
            </div>
            <div class="m-hs2">
                <div class="wp">
                    <div class="g-titq1">
                        <h3><span>组织框架</span></h3>
                        <em>Organizational framework</em>
                    </div>
                    <div class="img">
                        <img src="${info.sBannerImage }" alt="" />
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
</body>

</html>