<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/taglib.jsp"%>
<div class="header navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
         <a  class="brand" href="javascript:index()" style='float:left;'><img src='${ctx}/images/newsPreview/logo1.png' style='height:42px;float:left;'></a>
         <ul class="nav pull-right">
             <li   class="dropdown" >        
				<a href="#" class="dropdown-toggle" >
					 <i class="icon-user icon-white"></i> 
					<span class="username">欢迎您，${currentUser.userName }</span>
				</a>   
                </li>
                   <!--   <li id="fat-menu" class="dropdown">
                     <a  href="javascript:updatePassword()" id="drop3" role="button" class="dropdown-toggle" >
                        <i class="icon-user icon-white"></i> 修改密码
                        <i class="icon-caret-down"></i>
                    </a>
                </li> -->
                  <li  class="dropdown" >
                     <a href="javascript:logout()" id="drop3" role="button" class="dropdown-toggle" >
                        <i class="icon-user icon-white"></i> 安全退出
                    </a>
                </li>
            </ul>
    </div>
</div>
