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
    <title>首页</title>
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" href="${ctx}/borong/css/style.css" />
    <script src="${ctx}/borong/js/jquery.js"></script>
    <script src="${ctx}/borong/js/lib.js"></script>
</head>

<body class="index">
    <!-- 头部 -->
    <div class="header">
        <div class="wp">
            <div class="logo">
                <a href="">
                    <img src="${ctx}/borong/images/logo.png" alt="" class="img1" />
                    <img src="${ctx}/borong/images/logo2.png" alt="" class="img2" />
                </a>
            </div>
            <span class="menuBtn"></span>
            <div class="hdr">
                <ul class="nav">
                    <li class="">
                        <a href="" class="v1">首页</a>
                    </li>
                    <li class="">
                        <a href="" class="v1">咨询服务</a>
                        <dl>
                            <dd>
                                <a href="">道-战略管理体系</a>
                            </dd>
                            <dd>
                                <a href="">术-内部组织管理体系</a>
                            </dd>
                            <dd>
                                <a href="">法-流程绩效体系</a>
                            </dd>
                            <dd>
                                <a href="">器-信息化建设体系</a>
                            </dd>
                            <dd>
                                <a href="">财-投融资咨询</a>
                            </dd>
                        </dl>
                    </li>
                    <li class="">
                        <a href="" class="v1">服务案例</a>
                    </li>
                    <li class="">
                        <a href="" class="v1">博融智库</a>
                        <dl>
                            <dd>
                                <a href="">博融观点</a>
                            </dd>
                            <dd>
                                <a href="">理论本土化</a>
                            </dd>
                        </dl>
                    </li>
                    <li class="">
                        <a href="" class="v1">信息化产品</a>
                    </li>
                    <li class="">
                        <a href="" class="v1">认识博融</a>
                        <dl>
                            <dd>
                                <a href="">集团简介</a>
                            </dd>
                            <dd>
                                <a href="">博融新闻</a>
                            </dd>
                            <dd>
                                <a href="">博融团队</a>
                            </dd>
                            <dd>
                                <a href="">博融荣誉</a>
                            </dd>
                            <dd>
                                <a href="">招贤纳士</a>
                            </dd>
                        </dl>
                    </li>
                    <li class="">
                        <a href="" class="v1">联系博融</a>
                    </li>
                </ul>
                <div class="sobox">
                    <form action="">
                        <span class="tit"></span>
                        <div class="so">
                            <input type="text" class="inp" />
                            <input type="submit" class="sub" value="" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- 头部 -->
    <!-- banner -->
    <div class="banner">
    	<c:forEach items="${bannerList}" var="obj">
    		<div class="item" style="background-image: url(${obj.sBannerImage});">
	            <div class="wp">
	                <div class="txt">
	                    <h3>为客户企业<br />实现可持续发展服务<em>Service for Sustainable Development of Customer Enterprises</em></h3>
	                    <p>图片预览，待文案确定后会重新设计</p>
	                </div>
	            </div>
	        </div>
    	</c:forEach>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="row1" style="background-image: url(${ctx}/borong/images/bgq2.jpg);">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>核心行业</span></h3>
                    <em>Core industry</em>
                </div>
                <ul class="ul-imgtxtq1">
                	<c:forEach items="${coreList}" begin="0" end="1" var="obj">
                		<li>
	                        <a href="">
	                            <div class="pic">
	                                <img src="${obj.sBannerImage}" alt="" />
	                                <div class="con">
	                                    <div class="txt">
	                                        <h3>${obj.sTitle}</h3>
	                                        <p>${obj.sIntroduce}</p>
	                                        <span>咨询合作</span>
	                                    </div>
	                                </div>
	                            </div>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <div class="m-imgtxtq1">
                	<c:forEach items="${coreList}" begin="2" var="obj">
                		<div class="item">
	                        <a href="">
	                            <div class="pic">
	                                <img src="${obj.sBannerImage}" alt="" />
	                                <span>${obj.sTitle}</span>
	                            </div>
	                        </a>
	                    </div>
                	</c:forEach>
                </div>
            </div>
        </div>
        <div class="row2" style="background-image: url(${ctx}/borong/images/bgq3.jpg);">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>服务案例</span></h3>
                    <em>Service case</em>
                </div>
                <ul class="ul-imgtxtq2">
                	<c:forEach items="${serviceList}" varStatus="i" var="obj">
	                	<li>
	                        <a href="">
	                            <i>${i.index}</i>
	                            <div class="txt">
	                                <h3>${obj.sTitle}</h3>
	                                <p>${obj.sIntroduce}</p>
	                            </div>
	                            <div class="pic">
	                                <img src="${obj.sBannerImage}" alt="" />
	                            </div>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <a href="" class="g-more">更多案例&gt;&gt;</a>
            </div>
        </div>
        <div class="row3" style="background-image: url(${ctx}/borong/images/bgq4.jpg);">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>团队介绍</span></h3>
                    <em>Team Introduction</em>
                </div>
                <ul class="ul-imgtxtq3">
                	<c:forEach items="${empList}" varStatus="i" var="obj">
	                    <li>
	                        <a href="">
	                            <div class="pic"><img src="${obj.sBannerImage}" alt="" /></div>
	                            <h3>${obj.sTitle}<em>${obj.remark}</em></h3>
	                            <div class="txt">
	                                <h3>${obj.sTitle}<em>${obj.remark}</em></h3>
	                                <p>${obj.sIntroduce}</p>
	                                <span>了解更多&gt;&gt;</span>
	                            </div>
	                        </a>
	                    </li>
                    </c:forEach>
                </ul>
                <a href="" class="g-more">更多介绍&gt;&gt;</a>
            </div>
        </div>
        <div class="row4" style="background-image: url(${ctx}/borong/images/bgq2.jpg);">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>荣誉资质</span></h3>
                    <em>honor</em>
                    <p>${ryshow.sIntroduce }</p>
                </div>
                <ul class="ul-imgtxtq4">
                	<c:forEach items="${ryList}" varStatus="i" var="obj">
                		<li>
	                        <a href="">
	                            <div class="pic"><img src="${obj.sMediaImage}" alt="" /></div>
	                            <h3>${obj.sTitle}</h3>
	                        </a>
	                    </li>
                	</c:forEach>
                </ul>
                <a href="" class="g-more">更多荣誉&gt;&gt;</a>
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <div class="footer" style="background-image: url(${ctx}/borong/images/bgq1.jpg);">
        <div class="fd-top">
            <div class="wp">
                <div class="addr">
                    <h3>为客户企业<br />实现可持续发展服务</h3>
                    <div class="txt">
                        <p>电话：010-8262-6909</p>
                        <p>咨询：<a href="mailto:consult@orinf.cn">consult@orinf.cn</a></p>
                        <p>地址：北京市海淀区中关村东路89号恒兴大厦306</p>
                    </div>
                </div>
                <div class="ma">
                    <span>关注我们</span>
                    <div class="pic"><img src="${ctx}/borong/images/ma.jpg" alt="" /></div>
                </div>
                <div class="fdnav">
                    <dl>
                        <dt>咨询服务</dt>
                        <dd>
                            <a href="">道-战略管理体系</a>
                            <a href="">术-内部组织管理体系</a>
                            <a href="">法-流程绩效体系</a>
                            <a href="">器-信息化建设体系</a>
                            <a href="">财-投融资咨询</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>博融智库</dt>
                        <dd>
                            <a href="">博融观点</a>
                            <a href="">理论本土化</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>认识博融</dt>
                        <dd>
                            <a href="">集团简介</a>
                            <a href="">博融新闻</a>
                            <a href="">博融团队</a>
                            <a href="">博融荣誉</a>
                            <a href="">招贤纳士</a>
                        </dd>
                    </dl>
                </div>
            </div>
        </div>
        <div class="fd-bot">
            <div class="wp">
                <div class="link">
                    <span>友情链接：</span>
                    <c:forEach items="${linkList}" varStatus="i" var="obj">
                    	<a href="${obj.remark}">${obj.sTitle}</a>
                    </c:forEach>
                </div>
                <div class="copy">
                    <p>Copyright © 2015 - 2019 www.orinf.cn All Rights Reserved. 北京东方博融管理咨询有限公司 京ICP备12345678号-1</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
    <link rel="stylesheet" href="${ctx}/borong/css/slick.css">
    <script src="${ctx}/borong/js/slick.min.js"></script>
    <script type="text/javascript">
        $('.banner').slick({
            dots: true,
            arrows: false,
            autoplay: false,
            slidesToShow: 1,
            autoplaySpeed: 5000,
            pauseOnHover: false
        });
        $('.m-imgtxtq1').slick({
            dots: true,
            arrows: true,
            autoplay: false,
            slidesToShow: 4,
            slidesToScroll: 4,
            autoplaySpeed: 5000,
            pauseOnHover: false,
            responsive: [{
                    breakpoint: 800,
                    settings: {
                        slidesToScroll: 3,
                        slidesToShow: 3
                    }
                },
                {
                    breakpoint: 500,
                    settings: {
                        rows: 2,
                        slidesToScroll: 2,
                        slidesToShow: 2
                    }
                }
            ]
        });
        // 滚动导航悬浮
        $(document).on('scroll', function() {
            var scrollH = $(this).scrollTop();
            if (scrollH > $('.header').height()) {
                $('body').removeClass('index');
            } else {
                $('body').addClass('index');
            }
        })
    </script>
</body>

</html>