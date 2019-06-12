<%@ page language="java" pageEncoding="UTF-8"%>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<div class="page-sidebar nav-collapse collapse">

	<!-- BEGIN SIDEBAR MENU -->

	<ul class="page-sidebar-menu">

		<li>
			<!-- BEGIN SIDEBAR TOGGLER BUTTON -->

			<div class="sidebar-toggler hidden-phone"></div> <!-- BEGIN SIDEBAR TOGGLER BUTTON -->

		</li>

		<li>
			<div></div>
		</li>
		<c:if test="${not empty menus}">
			<c:forEach items="${menus}" var="menu" varStatus="vs">
				<c:choose>
					<c:when test="${vs.index == menu_index}">
						<li class="active">
					</c:when>
					<c:otherwise>
						<li>
					</c:otherwise>
				</c:choose>
					<a  href="javascript:;">
						<c:choose>
						  <c:when test="${empty menu.sMenuImage}">
						  	<i class="icon-exclamation-sign"></i>
						  </c:when>
						  <c:otherwise>
						  	<i class="${menu.sMenuImage}"></i>
						  </c:otherwise>
						</c:choose>
						<span class="title">${menu.name }</span><span class="arrow "></span></a>
					<c:if test="${not empty menu.chirdlen}">
						<ul id="${menu.guid}" class="sub-menu">
						<c:forEach items="${menu.chirdlen}" var="menuChildren" varStatus="vsChildren">
							<c:choose>
								<c:when test="${vsChildren.index == child_index}">
									<li class="active">
								</c:when>
								<c:otherwise>
									<li>
								</c:otherwise>
							</c:choose>
								<c:if test="${fn:contains(menuChildren.url, '?')}">
									<a href="${ctx}${menuChildren.url}&menu_index=${vs.index}&child_index=${vsChildren.index}">${menuChildren.name}</a>
								</c:if>
								<c:if test="${!fn:contains(menuChildren.url, '?')}">
									<a href="${ctx}${menuChildren.url}?menu_index=${vs.index}&child_index=${vsChildren.index}">${menuChildren.name}</a>
								</c:if>
							</li>
						</c:forEach>
						</ul>
					</c:if>
				</li>
			</c:forEach>
		</c:if>
</ul>
<!-- END SIDEBAR MENU -->
</div>
<div class="page-content">
	<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
	<div id="portlet-config" class="modal hide">
		<div class="modal-header">
			<button data-dismiss="modal" class="close" type="button"></button>
			<h3>Widget Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here will be a configuration form</p>
		</div>
	</div>
	<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
	<div class="container-fluid">
		<!-- BEGIN PAGE CONTENT-->
		<div class="row-fluid">