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
    <title>服务案例-文章详情</title>
    <meta name="description" content="${seo.description}" />
    <meta name="keywords" content="${seo.keywords}" />
    <link rel="stylesheet" href="${ctx}/borong/css/style.css" />
    <script src="${ctx}/borong/js/jquery.js"></script>
    <script src="${ctx}/borong/js/lib.js"></script>
</head>

<body class="bg-f5">
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
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="cur">
            <div class="wp">
                当前位置：<a href="">首页</a>&nbsp;&gt;&nbsp;<a href="serviceList.htm">${showType }</a>&nbsp;&gt;&nbsp;<a href="">文章详情</a>
            </div>
        </div>
        <div class="row-hs2">
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
	                        		<a href="fuwuDetail.htm?sNewsNo=${pre.sNewsNo}">${pre.sTitle}</a>
	                        	</c:if>
                        	</div>
                        	<div class="item">下一篇：
	                            <c:if test="${not empty next}">
	                            	<a href="fuwuDetail.htm?sNewsNo=${next.sNewsNo}">${next.sTitle}</a>
	                            </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="g-form">
                    <form action="" id="hzform">
                    	<input type="hidden" name="sLocation" value="服务案例" />
                        <div class="g-htit">
                            <h3>留言合作</h3>
                        </div>
                        <div class="box">
                            <div class="item">
                                <p>联系人：</p>
                                <input type="text" name="sName" max="30" class="inp" placeholder="请输入您的姓名" />
                            </div>
                            <div class="item">
                                <p>联系电话：</p>
                                <input type="text" name="sPhone" maxlength="50" class="inp" placeholder="请输入您的联系电话" />
                            </div>
                            <div class="item">
                                <p>公司名称：</p>
                                <input type="text" name="sCompany" maxlength="150" class="inp" placeholder="请在此填写您公司全称" />
                            </div>
                        </div>
                        <div class="ly">
                            <p>合作意向：</p>
                            <textarea name="sDescription" placeholder="请概述您的问题或建议" class="text"></textarea>
                        </div>
                        <input type="button" onclick="hzsub()" class="sub" value="立即提交" />
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
    <script>
    var flag = false;
    	function hzsub(){
    		var sName = $('input[name=sName]').val();
    		var sPhone = $('input[name=sPhone]').val();
    		var sCompany = $('input[name=sCompany]').val();
    		if(!sName){
    			alert("请填写联系人");
    			return;
    		}
    		if(!sPhone){
    			alert("请填写联系电话");
    			return;
    		}
    		if(!sCompany){
    			alert("请填写公司名称");
    			return;
    		}
    		if(flag){
    			alert("请不要重复提交");
    			return;
    		}
    		flag = true;
    		$.ajax({
    			 type: "POST",//方法类型
                 dataType: "json",//预期服务器返回的数据类型
                 url: "submitCooperat.htm" ,//url
                 data: $('#hzform').serialize(),
                 success: function (result) {
                     if (result == "200") {
                         alert("您的留言提交成功");
                     }
                 },
                 error : function() {
                     alert("系统繁忙，请稍后再试");
                     flag = false;
                 }
    		})
    	}
    
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