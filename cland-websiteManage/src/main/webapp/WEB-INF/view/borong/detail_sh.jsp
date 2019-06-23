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
    <title>博融生活-文章详情</title>
    <meta name="description" content="${seo.description}" />
    <meta name="keywords" content="${seo.keywords}" />
    <link rel="stylesheet" href="${ctx}/borong/css/style.css" />
    <script src="${ctx}/borong/js/jquery.js"></script>
    <script src="${ctx}/borong/js/lib.js"></script>
</head>
<c:if test="${iType == 16 || iType == 17 }">
	<c:set value="博融智库" var="pageName"></c:set>
	<c:set value="zhiku.htm" var="url"></c:set>
</c:if>
<c:if test="${iType == 14 }">
	<c:set value="博融生活" var="pageName"></c:set>
</c:if>
<c:if test="${iType == 2 }">
	<c:set value="博融新闻" var="pageName"></c:set>
	<c:set value="xinwen.htm" var="url"></c:set>
</c:if>
<body class="bg-f5">
    <!-- 头部 -->
    <%@ include file="common_header.jsp"%>
    <!-- 头部 -->
    <!-- banner -->
    <c:if test="${iType == 16 || iType == 17 }">
    	<c:if test="${clumnsSize > 3}">
	    	<div class="ban" style="background-image: url(${clumns[3].sBannerImage });">
		        <div class="txt">
		            <h3>${clumns[3].sTitle }</h3>
		            <p>${clumns[3].sTitleEn }</p>
		        </div>
		    </div>
	    </c:if>
    </c:if>
    <c:if test="${iType == 2 }">
    	<c:if test="${clumnsSize > 5 && clumns[5].childSize > 2}">
	    	<div class="ban" style="background-image: url(${clumns[5].clist[2].sBannerImage });">
		        <div class="txt">
		            <h3>${clumns[5].clist[2].sTitle }</h3>
		            <p>${clumns[5].clist[2].sTitleEn }</p>
		        </div>
		    </div>
	    </c:if>
    </c:if>
    <c:if test="${iType == 14 }">
    	<c:if test="${clumnsSize > 5 && clumns[5].childSize > 0}">
	    	<div class="ban" style="background-image: url(${clumns[5].clist[0].sBannerImage });">
		        <div class="txt">
		            <h3>${clumns[5].clist[0].sTitle }</h3>
		            <p>${clumns[5].clist[0].sTitleEn }</p>
		        </div>
		    </div>
	    </c:if>
    </c:if>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="cur">
            <div class="wp">
                当前位置：<a href="">首页</a>&nbsp;&gt;&nbsp;<a href="${url }">${pageName }</a>&nbsp;&gt;&nbsp;<span>文章详情</span>
            </div>
        </div>
        <div class="row-hs1">
            <div class="wp">
                <div class="g-box1">
                    <div class="box-txt1">
                        <h1>${info.newsInfo.sTitle }</h1>
                        <div class="info">
                        	<c:if test="${not empty info.newsInfo.sWriter }">
                        		<span>作者：${info.newsInfo.sWriter }</span>
                        	</c:if>
                            <span>时间：${info.newsInfo.dModifyDate }</span>
                            <span>浏览：${visitCount}</span>
                        </div>
                        <div class="txt">
                            ${info.newsInfo.sNewContent }
                        </div>
                        <div class="txt-share">
                            <div class="r">
                                <span>分享：</span>
                                <div class="bdsharebuttonbox">
                                    <a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
                                    <a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a>
                                    <a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a>
                                    <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a>
                                </div>
                            </div>
                            <div class="lab">
                               <c:forEach items="${bqs}" var="item">
                            		<span>${item }</span>
                            	</c:forEach>
                            </div>
                        </div>
                        <div class="m-arrows">
                            <div class="item">上一篇：
	                        	<c:if test="${not empty pre}">
	                        		<a href="lifeDetail.htm?sNewsNo=${pre.sNewsNo}">${pre.sTitle}</a>
	                        	</c:if>
                        	</div>
                        	<div class="item">下一篇：
	                            <c:if test="${not empty next}">
	                            	<a href="lifeDetail.htm?sNewsNo=${next.sNewsNo}">${next.sTitle}</a>
	                            </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="m-read">
                    <div class="g-htit">
                        <h3>推荐阅读</h3>
                    </div>
                    <ul class="ul-listh1">
                    	<c:forEach items="${tjList}" var="obj">
                    		<li>
	                            <div class="pic">
	                                <a href="lifeDetail.htm?sNewsNo=${obj.sNewsNo}"><img src="${obj.sBannerImage }" alt="" /></a>
	                            </div>
	                            <div class="txt">
	                                <h3><a href="lifeDetail.htm?sNewsNo=${obj.sNewsNo}">${obj.sTitle }</a></h3>
	                                <p>${obj.sIntroduce }</p>
	                            </div>
	                        </li>
                    	</c:forEach>
                        
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
    <script>
        window._bd_share_config = {
            "common": {
                "bdSnsKey": {},
                "bdText": "",
                "bdMini": "2",
                "bdMiniList": false,
                "bdPic": "",
                "bdStyle": "0",
                "bdSize": "16"
            },
            "share": {},
            "image": {
                "viewList": ["weixin", "sqq", "qzone", "tsina"],
                "viewText": "分享到：",
                "viewSize": "32"
            },
            "selectShare": {
                "bdContainerClass": null,
                "bdSelectMiniList": ["weixin", "sqq", "qzone", "tsina"]
            }
        };
        with(document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
    </script>
</body>

</html>