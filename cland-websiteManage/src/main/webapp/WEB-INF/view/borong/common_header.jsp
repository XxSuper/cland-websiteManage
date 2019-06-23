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
                	
                    <li <c:if test="${columIndex == 1}">class="on"</c:if>>
                    	<c:if test="${clumnsSize > 0}">
                    		<a href="index.htm" class="v1">${clumns[0].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 0}">
                    		<a href="index.htm" class="v1">首页</a>
                    	</c:if>
                    </li>
                    <li <c:if test="${columIndex == 2}">class="on"</c:if>>
                    	<c:if test="${clumnsSize > 1}">
                    		<a href="detailCP.htm?queryType=1" class="v1">${clumns[1].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 1}">
                    		<a href="detailCP.htm?queryType=1" class="v1">咨询服务</a>
                    	</c:if>
                    	
                        <dl>
                            <dd>
                            	<c:if test="${clumnsSize > 1 && clumns[1].childSize > 0}">
                            		<a href="detailCP.htm?queryType=1">${clumns[1].clist[0].sName }</a>
                            	</c:if>
                                
                            </dd>
                            <dd>
                            	<c:if test="${clumnsSize > 1 && clumns[1].childSize > 1}">
                            		<a href="detailCP.htm?queryType=2">${clumns[1].clist[1].sName }</a>
                            	</c:if>
                            </dd>
                            <dd>
                            	<c:if test="${clumnsSize > 1 && clumns[1].childSize > 2}">
                            		<a href="detailCP.htm?queryType=3">${clumns[1].clist[2].sName }</a>
                            	</c:if>
                            </dd>
                            <dd>
                            	<c:if test="${clumnsSize > 1 && clumns[1].childSize > 3}">
                            		<a href="detailCP.htm?queryType=4">${clumns[1].clist[3].sName }</a>
                            	</c:if>
                            </dd>
                            <dd>
                            	<c:if test="${clumnsSize > 1 && clumns[1].childSize > 4}">
                            		<a href="detailCP.htm?queryType=5">${clumns[1].clist[4].sName }</a>
                            	</c:if>
                                
                            </dd>
                            <dd>
                            	<c:if test="${clumnsSize > 1 && clumns[1].childSize > 5}">
                            		<a href="coreNls.htm">${clumns[1].clist[5].sName }</a>
                            	</c:if>
                            </dd>
                        </dl>
                    </li>
                    <li <c:if test="${columIndex == 3}">class="on"</c:if>>
                    	<c:if test="${clumnsSize > 2}">
                    		<a href="serviceList.htm" class="v1">${clumns[2].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 2}">
                    		<a href="serviceList.htm" class="v1">服务案例</a>
                    	</c:if>
                    </li>
                    <li <c:if test="${columIndex == 4}">class="on"</c:if>>
                    	<c:if test="${clumnsSize > 3}">
                    		<a href="zhiku.htm" class="v1">${clumns[3].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 3}">
                    		<a href="zhiku.htm" class="v1">博融智库</a>
                    	</c:if>
                        
                        <dl>
                            <dd>
                                <a href="zhiku.htm?queryType=1">博融观点</a>
                            </dd>
                            <dd>
                                <a href="zhiku.htm?queryType=2">理论本土化</a>
                            </dd>
                        </dl>
                    </li>
                    <li  <c:if test="${columIndex == 5}">class="on"</c:if>>
                    
                    	<c:if test="${clumnsSize > 4}">
                    		<a href="${clumns[4].sLink }" class="v1">${clumns[4].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 4}">
                    		<a href="index.htm" class="v1">信息化产品</a>
                    	</c:if>
                    	
                    </li>
                    <li <c:if test="${columIndex == 6}">class="on"</c:if>>
                    	<c:if test="${clumnsSize > 5}">
                    		<a href="companyInfo.htm" class="v1">${clumns[5].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 5}">
                    		<a href="companyInfo.htm" class="v1">认识博融</a>
                    	</c:if>
                        
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
                    <li <c:if test="${columIndex == 7}">class="on"</c:if>>
                    	<c:if test="${clumnsSize > 6}">
                    		<a href="lianxiborong.htm" class="v1">${clumns[6].sName }</a>
                    	</c:if>
                    	<c:if test="${clumnsSize <= 6}">
                    		<a href="lianxiborong.htm" class="v1">联系博融</a>
                    	</c:if>
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