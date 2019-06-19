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
                                <h4>亲爱的朋友们：</h4>
                                <p>沧海巨变，历史轮回！人类步入崭新的纪元，中国迎来自己的时代。中华儿女正满怀豪情，坚定地构筑着强国崛起之堤。强国之崛起首先是经济的崛起；经济之崛起，基础是企业的崛起；面对巨大的历史机遇和挑战，中国企业必须告别作坊经营、脱离粗放管理、避免跟随模仿，迎难而上，顺势变革！</p>
                                <p>发展的中国，需要具有核心竞争力的卓越企业，需要引领世界先进企业！</p>
                                <p>管理的伟大企业数年来，北京东方博融管理咨询有限公司肩负起“秉承东方文化，博采众家之长，融汇西方理论，创造中国模式“的发展使命，坚定不移地为实现这个理想而奋进。我们要做中国企业变革的推动者，要做中国管理理论的创造者，要做中国企业管理水平的提升者！我们将帮助中国企业实现卓越，走向伟大！</p>
                                <p>我们愿与志同道合的企业家携手并进,风雨同舟,共赢共荣,为中国企业之崛起,为中华民族之复兴而努力奋斗!</p>
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
                            <p>北京东方博融管理咨询有限公司是国内本土一流的综合性管理咨询公司，致力于推动中国企业变革和创造中国企业管理理论，专注于研究并解决中国企业发展中面临的管理问题。作为中国管理咨询20强、国家工信部2017首批推荐、2018最值得信赖的机构，公司拥有专业的咨询队伍，由来自国内外知名咨询机构的资深管理顾问和企业精英共同组成。东方博融以战略咨询为导向，以教练式服务为特色，注重咨询效果。拥有自己独创的战略理论、咨询工具和咨询技术，为客户提供长期优质服务，与客户建立长期合作关系，帮助中国企业实现卓越，走向伟大！东方博融的价值需要通过客户的成功来体现，因此我们奉行“客户至上，效果第一、专业一流、和谐共赢”的经营理念。东方博融将以卓越的服务品质和严谨的专业精神全心投入，帮助客户走向成功，并为中国的发展、繁荣奉献自己的力量！
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="m-hs1">
                <div class="wp">
                    <ul class="ul-tabh2 TAB_CLICK" id=".tabh2">
                        <li class="on"><a href="javascript:;">企业使命</a></li>
                        <li><a href="javascript:;">企业愿景</a></li>
                        <li><a href="javascript:;">企业宗旨</a></li>
                        <li><a href="javascript:;">企业精神</a></li>
                        <li><a href="javascript:;">核心价值观</a></li>
                        <li><a href="javascript:;">经营理念</a></li>
                        <li><a href="javascript:;">工作作风</a></li>
                        <li class="last"><a href="">更多</a></li>
                    </ul>
                    <div class="tabh2">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>1秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>01秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>2秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>3秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>4秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>5秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                    <div class="tabh2 dn">
                        <div class="tab">
                            <div class="l">
                                <div class="pic">
                                    <img src="${ctx}/borong/images/h20.png" alt="" />
                                </div>
                            </div>
                            <div class="txt">
                                <p>6秉承东方文化，博采众家之长，</p>
                                <p>融汇西方理论，创造中国模式。</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="m-hs2">
                <div class="wp">
                    <div class="g-titq1">
                        <h3><span>组织框架</span></h3>
                        <em>Organizational framework</em>
                    </div>
                    <div class="img">
                        <img src="${ctx}/borong/images/h21.png" alt="" />
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