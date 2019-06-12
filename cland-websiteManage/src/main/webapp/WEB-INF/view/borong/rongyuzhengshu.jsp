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
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <link rel="stylesheet" href="${ctx}/borong/css/style.css" />
    <script src="${ctx}/borong/js/jquery.js"></script>
    <script src="${ctx}/borong/js/lib.js"></script>
</head>

<body class="">
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
    <div class="ban" style="background-image: url(images/ban-h2.png);">
        <div class="txt">
            <h3>关于我们</h3>
            <p>About</p>
        </div>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <ul class="g-links">
            <li><a href="">集团简介</a></li>
            <li><a href="">博融新闻</a></li>
            <li><a href="">博融团队</a></li>
            <li class="on"><a href="">博融荣誉</a></li>
            <li><a href="">招贤纳士</a></li>
        </ul>
        <div class="m-h4">
            <div class="wp">
                <div class="g-titq1">
                    <h3><span>荣誉资质</span></h3>
                    <em>honor</em>
                </div>
                <ul class="ul-imgtxtq4">
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq12.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq13.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq14.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq15.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq12.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq13.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq14.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                    <li>
                        <a href="">
                            <div class="pic"><img src="${ctx}/borong/images/picq15.jpg" alt=""></div>
                            <h3>这里是奖项名称</h3>
                        </a>
                    </li>
                </ul>
                <!--页码-->
                <div class="pages">
                    <ul>
                        <li class="prev"><a href="">上一页</a></li>
                        <li class="on"><a href="">1</a></li>
                        <li><a href="">2</a></li>
                        <li><a href="">3</a></li>
                        <li><span>...</span></li>
                        <li><a href="">9</a></li>
                        <li><a href="">10</a></li>
                        <li class="next"><a href="">下一页</a></li>
                    </ul>
                </div>
                <!--页码end-->
            </div>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <div class="footer" style="background-image: url(images/bgq1.jpg);">
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
                    <a href="">友情链接</a>
                    <a href="">友情链接</a>
                    <a href="">友情链接</a>
                    <a href="">友情链接</a>
                    <a href="">友情链接</a>
                    <a href="">友情链接</a>
                </div>
                <div class="copy">
                    <p>Copyright © 2015 - 2019 www.orinf.cn All Rights Reserved. 北京东方博融管理咨询有限公司 京ICP备12345678号-1</p>
                </div>
            </div>
        </div>
    </div>
    <!-- 底部 -->
</body>

</html>