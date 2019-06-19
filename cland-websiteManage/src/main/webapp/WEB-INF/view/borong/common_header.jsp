 <!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <!-- 头部 -->
    <div class="header">
        <div class="wp">
            <div class="logo">
                <a href="index.htm">
                    <img src="${ctx}/borong/images/logo.png" alt="" class="img1" />
                    <img src="${ctx}/borong/images/logo2.png" alt="" class="img2" />
                </a>
            </div>
            <span class="menuBtn"></span>
            <div class="hdr">
                <ul class="nav">
                    <li class="">
                        <a href="index.htm" class="v1">首页</a>
                    </li>
                    <li class="">
                        <a href="" class="v1">咨询服务</a>
                        <dl>
                            <dd>
                                <a href="detailCP.htm?queryType=1">道-战略管理体系</a>
                            </dd>
                            <dd>
                                <a href="detailCP.htm?queryType=2">术-内部组织管理体系</a>
                            </dd>
                            <dd>
                                <a href="detailCP.htm?queryType=3">法-流程绩效体系</a>
                            </dd>
                            <dd>
                                <a href="detailCP.htm?queryType=4">器-信息化建设体系</a>
                            </dd>
                            <dd>
                                <a href="detailCP.htm?queryType=5">财-投融资咨询</a>
                            </dd>
                        </dl>
                    </li>
                    <li class="">
                        <a href="serviceList.htm" class="v1">服务案例</a>
                    </li>
                    <li class="">
                        <a href="zhiku.htm" class="v1">博融智库</a>
                        <dl>
                            <dd>
                                <a href="zhiku.htm?queryType=1">博融观点</a>
                            </dd>
                            <dd>
                                <a href="zhiku.htm?queryType=2">理论本土化</a>
                            </dd>
                        </dl>
                    </li>
                    <li class="">
                        <a href="detailCP.htm" class="v1">信息化产品</a>
                    </li>
                    <li class="">
                        <a href="companyInfo.htm" class="v1">认识博融</a>
                        <dl>
                            <dd>
                                <a href="companyInfo.htm">集团简介</a>
                            </dd>
                            <dd>
                                <a href="xinwen.htm">博融新闻</a>
                            </dd>
                            <dd>
                                <a href="borongTeam.htm">博融团队</a>
                            </dd>
                            <dd>
                                <a href="rongyuzhengshu.htm">博融荣誉</a>
                            </dd>
                            <dd>
                                <a href="zhaoxian.htm">招贤纳士</a>
                            </dd>
                        </dl>
                    </li>
                    <li class="">
                        <a href="lianxiborong.htm" class="v1">联系博融</a>
                    </li>
                </ul>
                <div class="sobox">
                        <span class="tit"></span>
                        <div class="so">
                            <input type="text" id="searchKey" class="inp" />
                            <input type="submit" onclick="searchp()" class="sub" value="" />
                        </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
	function searchp(){
		var key = $("#searchKey").val();
		window.location.href = "searchPage.htm?value=" + key + "&pageNumber=1";
	}
</script>
    <!-- 头部 -->