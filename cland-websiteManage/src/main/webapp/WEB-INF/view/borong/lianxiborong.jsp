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
    <title>联系博融</title>
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
            <h3>联系我们</h3>
            <p>Contact</p>
        </div>
    </div>
    <!-- banner -->
    <!-- 内容 -->
    <div class="main">
        <div class="m-h2">
            <div class="top">
                <div class="wp">
                    <h2>如果您有合作意向，欢迎与我们取得联系</h2>
                    <div class="box">
                        <div class="l">
                            <div id="allmap"></div>
                        </div>
                        <div class="txt">
                            <h3>联系方式</h3>
                            <ul class="ul-h2">
                                <li style="background-image:url(images/h7.png)">
                                    <p>电话：010-82626909</p>
                                </li>
                                <li style="background-image:url(images/h8.png)">
                                    <p>邮箱：consult@orinf.cn（市场与咨询业务）</p>
                                </li>
                                <li style="background-image:url(images/h9.png)">
                                    <p>微信：orinf-consulting</p>
                                </li>
                                <li style="background-image:url(images/h10.png)">
                                    <p>地址：北京市海淀区中关村东路89号恒兴大厦306</p>
                                </li>
                                <li style="background-image:url(images/h11.png)">
                                    <p>路线：地铁10号线知春里站B口出向东步行400米左转进入中关村东路辅路向北步行570米即到。</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="g-form">
            <form action="">
                <div class="wp">
                    <h2>留言合作</h2>
                    <div class="box">
                        <div class="item">
                            <p>联系人：</p>
                            <input type="text" class="inp" placeholder="请输入您的姓名" />
                        </div>
                        <div class="item">
                            <p>联系电话：</p>
                            <input type="text" class="inp" placeholder="请输入您的联系电话" />
                        </div>
                        <div class="item">
                            <p>公司名称：</p>
                            <input type="text" class="inp" placeholder="请在此填写您公司全称" />
                        </div>
                    </div>
                    <div class="ly">
                        <p>合作意向：</p>
                        <textarea placeholder="请概述您的问题或建议" class="text"></textarea>
                    </div>
                    <input type="submit" class="sub" value="立即提交" />
                </div>
            </form>
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
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=P6QfOGrhFllpZodPYeF7RW1nN1B9rp62"></script>
    <script type="text/javascript">
        // 百度地图API功能 
        var map = new BMap.Map("allmap");
        var point = new BMap.Point(116.339374, 39.988641);
        map.centerAndZoom(point, 15); //创建小狐狸    
        var pt = new BMap.Point(116.339374, 39.988641);
        var myIcon = new BMap.Icon("${ctx}/borong/images/map.png", new BMap.Size(48, 48));
        var marker2 = new BMap.Marker(pt, {
            icon: myIcon
        }); // 创建标注       
        map.addOverlay(marker2); // 将标注添加到地图中  
    </script>
</body>

</html>