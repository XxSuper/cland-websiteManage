<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
                            <a href="detailCP.htm?queryType=1">道-战略管理体系</a>
                            <a href="detailCP.htm?queryType=2">术-内部组织管理体系</a>
                            <a href="detailCP.htm?queryType=3">法-流程绩效体系</a>
                            <a href="detailCP.htm?queryType=4">器-信息化建设体系</a>
                            <a href="detailCP.htm?queryType=5">财-投融资咨询</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>博融智库</dt>
                        <dd>
                            <a href="zhiku.htm?queryType=1">博融观点</a>
                            <a href="zhiku.htm?queryType=2">理论本土化</a>
                        </dd>
                    </dl>
                    <dl>
                        <dt>认识博融</dt>
                        <dd>
                            <a href="companyInfo.htm">集团简介</a>
                            <a href="xinwen.htm">博融新闻</a>
                            <a href="borongTeam.htm">博融团队</a>
                            <a href="rongyuzhengshu.htm">博融荣誉</a>
                            <a href="zhaoxian.htm">招贤纳士</a>
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
