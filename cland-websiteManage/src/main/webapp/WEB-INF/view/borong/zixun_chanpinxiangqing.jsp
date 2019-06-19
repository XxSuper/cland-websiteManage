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
    <title>咨询服务-产品详情单页</title>
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
    <div class="m-tab">
        <div class="wp">
            <ul class="ul-tab TAB_CLICK" id=".tab1">
                <li <c:if test="${queryType == 1 }"> class="on"</c:if>>
                    <a href="javascript:;">
                        <p>道</p>
                        <span>战略管理体系</span>
                    </a>
                </li>
                <li <c:if test="${queryType == 2 }"> class="on"</c:if>>
                    <a href="javascript:;">
                        <p>术</p>
                        <span>内部组织管理体系</span>
                    </a>
                </li>
                <li <c:if test="${queryType == 3 }"> class="on"</c:if>>
                    <a href="javascript:;">
                        <p>法</p>
                        <span>流程绩效体系</span>
                    </a>
                </li>
                <li <c:if test="${queryType == 4 }"> class="on"</c:if>>
                    <a href="javascript:;">
                        <p>器</p>
                        <span>信息化建设体系</span>
                    </a>
                </li>
                <li <c:if test="${queryType == 5 }"> class="on"</c:if>>
                    <a href="javascript:;">
                        <p>财</p>
                        <span>投融资咨询</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="tab1 <c:if test="${queryType != 1 }"> dn</c:if>">
        <div class="ban-1" style="background-image: url(${ctx}/borong/images/ban-1.png);">
            <div class="wp hs">
                <div class="txt">
                    <span>道</span>
                    <div class="con">
                        <h3>战术管理体系</h3>
                        <em>Tactical Management System</em>
                        <p>我们以战略咨询为导向，为帮助客户推动战略落地，根据客户实际需求提供支撑战略实现的“1+X”保姆式咨询服务（敢于承诺、长期跟踪）。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="tab1 <c:if test="${queryType != 2 }"> dn</c:if>">
        <div class="ban-1" style="background-image: url(${ctx}/borong/images/ban-1.png);">
            <div class="wp hs">
                <div class="txt">
                    <span>术</span>
                    <div class="con">
                        <h3>战术管理体系</h3>
                        <em>Tactical Management System</em>
                        <p>我们以战略咨询为导向，为帮助客户推动战略落地，根据客户实际需求提供支撑战略实现的“1+X”保姆式咨询服务（敢于承诺、长期跟踪）。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="tab1 <c:if test="${queryType != 3 }"> dn</c:if>">
        <div class="ban-1" style="background-image: url(${ctx}/borong/images/ban-1.png);">
            <div class="wp hs">
                <div class="txt">
                    <span>法</span>
                    <div class="con">
                        <h3>战术管理体系</h3>
                        <em>Tactical Management System</em>
                        <p>我们以战略咨询为导向，为帮助客户推动战略落地，根据客户实际需求提供支撑战略实现的“1+X”保姆式咨询服务（敢于承诺、长期跟踪）。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="tab1 <c:if test="${queryType != 4 }"> dn</c:if>">
        <div class="ban-1" style="background-image: url(${ctx}/borong/images/ban-1.png);">
            <div class="wp hs">
                <div class="txt">
                    <span>器</span>
                    <div class="con">
                        <h3>战术管理体系</h3>
                        <em>Tactical Management System</em>
                        <p>我们以战略咨询为导向，为帮助客户推动战略落地，根据客户实际需求提供支撑战略实现的“1+X”保姆式咨询服务（敢于承诺、长期跟踪）。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="tab1 <c:if test="${queryType != 5 }"> dn</c:if>">
        <div class="ban-1" style="background-image: url(${ctx}/borong/images/ban-1.png);">
            <div class="wp hs">
                <div class="txt">
                    <span>财</span>
                    <div class="con">
                        <h3>战术管理体系</h3>
                        <em>Tactical Management System</em>
                        <p>我们以战略咨询为导向，为帮助客户推动战略落地，根据客户实际需求提供支撑战略实现的“1+X”保姆式咨询服务（敢于承诺、长期跟踪）。</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="row-bg1">
            <div class="wp">
                <!-- 服务概述 -->
                <div class="g-titq1">
                    <h3><span>服务概述</span></h3>
                    <em>Service overview</em>
                </div>
                <div class="m-service">
                    <div class="pic"><img src="${gs.sBannerImage }" alt=""></div>
                    <div class="con">
                        <h4>${gs.sTitle }</h4>
                        <p>${gs.sIntroduce }</p>
                        <a href="" class="g-btn1">立即咨询</a>
                    </div>
                </div>
                <!-- 主要模块 -->
                <div class="g-titq1">
                    <h3><span>主要模块</span></h3>
                    <em>Main module</em>
                </div>
                <div class="m-slide1">
                	<c:forEach items="${mainModel }" varStatus="status" var="obj">
                		<div class="item">
	                        <div class="con">
	                            <em class="num">${status.index }</em>
	                            <div class="tit">
	                                <h4>${obj.sTitle}</h4>
	                                <span>${obj.remark}</span>
	                            </div>
	                            <div class="txt">${obj.sIntroduce}</div>
	                            ${obj.sNewContent}
	                            <div class="pic"><img src="${obj.sBannerImage}" alt=""></div>
	                        </div>
	                    </div>
                	</c:forEach>
                </div>
            </div>
        </div>
        <!-- 应用领域 -->
        <div class="row-bg2">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>应用领域</span></h3>
                    <em>application area</em>
                </div>
                <ul class="m-list1">
                	<c:forEach items="${areaList }" varStatus="status" var="obj">
                		<li>
	                        <a href="" onclick="return false;" class="con">
	                            <div class="pic"><img src="${obj.sBannerImage}" alt=""></div>
	                            <span>${obj.sTitle}</span>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <a href="serviceList.htm" class="g-btn1">查看案例</a>
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
    <link rel="stylesheet" href="${ctx}/borong/css/slick.css">
    <script src="${ctx}/borong/js/slick.min.js"></script>
    <script type="text/javascript">
        $('.m-slide1').slick({
            dots: true,
            arrows: true,
            autoplay: false,
            slidesToShow: 3,
            slidesToScroll: 3,
            autoplaySpeed: 5000,
            pauseOnHover: false,
            responsive: [{
                    breakpoint: 800,
                    settings: {
                        arrows: false,
                        slidesToScroll: 2,
                        slidesToShow: 2
                    }
                },
                {
                    breakpoint: 500,
                    settings: {
                        arrows: false,
                        slidesToScroll: 1,
                        slidesToShow: 1
                    }
                }
            ]
        });
    </script>
</body>

</html>