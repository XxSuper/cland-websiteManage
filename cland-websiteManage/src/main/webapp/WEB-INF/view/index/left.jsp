<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<div class="sidebar-nav">
	<c:if test="${not empty menus}">
		<c:forEach items="${menus}" var="menu" varStatus="vs">
			<a href="javascript:showOrHide('${menu.guid}')" class="nav-header" >
			<c:choose>
			  <c:when test="${empty menu.sMenuImage}"><i class="icon-exclamation-sign"></i></c:when>
			  <c:otherwise><i class="${menu.sMenuImage}"></i></c:otherwise>
			</c:choose>
			${menu.name }</a>
			<c:if test="${not empty menu.chirdlen}">
				<c:choose>
					<c:when test="${vs.index=='0'}">
						<ul id="${menu.guid}" class="nav nav-list collapse in" style="display: block;">
					</c:when>
					<c:otherwise>
						<ul id="${menu.guid}" class="nav nav-list collapse in" style="display: none;">
					</c:otherwise>
				</c:choose>
				<c:forEach items="${menu.chirdlen}" var="menuChildren">
					<li><a
						href="${ctx}${menuChildren.url}"
						target="frame_center">${menuChildren.name}</a></li>
				</c:forEach>
				</ul>
				
			</c:if>
		</c:forEach>
	</c:if>
</div>
