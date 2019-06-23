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
    <c:if test="${clumnsSize > 5 && clumns[5].childSize > 5}">
	    	<div class="ban" style="background-image: url(${clumns[5].clist[5].sBannerImage });">
		        <div class="txt">
		            <h3>${clumns[5].clist[5].sTitle }</h3>
		            <p>${clumns[5].clist[5].sTitleEn }</p>
		        </div>
		    </div>
	    </c:if>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <ul class="g-links">
            <li><a href="companyInfo.htm">集团简介</a></li>
            <li><a href="xinwen.htm">博融新闻</a></li>
            <li><a href="borongTeam.htm">博融团队</a></li>
            <li><a href="rongyuzhengshu.htm">博融荣誉</a></li>
            <li class="on"><a href="zhaoxian.htm">招贤纳士</a></li>
        </ul>
        <div class="m-h3">
            <div class="t1">
                <div class="wp">
                    <div class="g-titq1">
                        <h3><span>选择博融</span></h3>
                        <em>Choose us</em>
                    </div>
                    <div class="box2">
                        <div class="pic">
                            <img src="${chooseBr.sBannerImage }" alt="" />
                        </div>
                        <div class="txt">
                            ${chooseBr.sNewContent }
                            <div class="img">
                                <img src="${ctx}/borong/images/logo.png" alt="" />
                            </div>
                        </div>
                    </div>
                    <div class="box3">
                        <ul class="ul-htab TAB_CLICK" id=".tabh1">
                            <li class="on"><a href="javascript:;">社会招聘</a></li>
                            <li><a href="javascript:;">校园招聘</a></li>
                        </ul>
                        <div class="tabh1">
                            <div class="cuttle">
                            	<c:forEach items="${szList }" var="obj">
                            		<dl>
	                                    <dt class="ok">${obj.sTitle }</dt>
	                                    <dd style="border-top: 1px solid #DBDBDB; display:block;">
	                                        ${obj.sNewContent }
	                                        <p></p>
	                                    </dd>
	                                </dl>
                            	</c:forEach>
                            </div>
                        </div>
                        <div class="tabh1 dn">
                            <div class="cuttle">
                            	<c:forEach items="${xzList }" var="obj">
                            		<dl>
	                                    <dt class="ok">${obj.sTitle }</dt>
	                                    <dd style="border-top: 1px solid #DBDBDB; display:block;">
	                                        ${obj.sNewContent }
	                                        <p></p>
	                                    </dd>
	                                </dl>
                            	</c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="t2">
                <div class="wp">
                    <div class="g-titq1">
                        <h3><span>博融生活</span></h3>
                        <em>Choose us</em>
                        <c:if test="${clumnsSize > 5 && clumns[5].childSize >0}">
	                    	<p>${clumns[5].clist[0].sProfile }</p>
	                    </c:if>
                    </div>
                    <ul class="ul-img1">
                    	<c:forEach items="${pageInfo.page.list}" var="pageData" varStatus="varStatus">
                    		<li>
	                            <a href="lifeDetail.htm?sNewsNo=${pageData.sNewsNo }">
	                                <div class="pic">
	                                    <img src="${pageData.sBannerImage }" alt="" />
	                                </div>
	                                <div class="txt">
	                                    <h3>${pageData.sTitle }</h3>
	                                    <div class="bom">
	                                        <div class="r">${info.dModifyDate }</div>
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
                        <li class="prev"><a href="zhaoxian.htm?pageNumber=${pageInfo.prePage}">上一页</a></li>
                        <c:forEach items="${pageInfo.pNos}" var="pNo">
                        	<c:if test="${pNo == pageInfo.pageNumber}">
                        		<li class="on"><a href="zhaoxian.htm?pageNumber=${pNo}">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo != pageInfo.pageNumber && pNo != '...'}">
                        		<li><a href="zhaoxian.htm?pageNumber=${pNo}">${pNo}</a></li>
                        	</c:if>
                        	<c:if test="${pNo == '...'}">
                        		<li><a href="javascript:void(0);">${pNo}</a></li>
                        	</c:if>
                        </c:forEach>
                        <li class="next"><a href="zhaoxian.htm?pageNumber=${pageInfo.nextPage}">下一页</a></li>
                    </ul>
                </div>
                    <!--页码end-->
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