<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<script src="${ctx }/js/common/md5.js"></script>
<script src="${ctx }/js/login/login.js?20160105"></script>
<style type="text/css">
    body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
    }
</style>
</head>
<body>
<div class="container">
    <form id="myForm" class="form-signin">
        <h1 class="form-signin-heading">密码修改</h1>
        <input type="password" class="input-block-level" placeholder="旧密码" required name="oldPassWord" id="oldPassWord">
        <input type="password" class="input-block-level" placeholder="新密码"  required name="passWord" id="passWord">
        <input type="password" class="input-block-level" placeholder="重复新密码"  required name="repassWord" id="repassWord"  >
        <button class="btn btn-large btn-primary" type="button" onclick="submitUpdatePassword(event)">提交</button>
    </form>
</div>
</body>
</html>