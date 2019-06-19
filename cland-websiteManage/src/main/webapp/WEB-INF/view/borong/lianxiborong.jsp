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
                                <li style="background-image:url(${ctx}/borong/images/h7.png)">
                                    <p>电话：010-82626909</p>
                                </li>
                                <li style="background-image:url(${ctx}/borong/images/h8.png)">
                                    <p>邮箱：consult@orinf.cn（市场与咨询业务）</p>
                                </li>
                                <li style="background-image:url(${ctx}/borong/images/h9.png)">
                                    <p>微信：orinf-consulting</p>
                                </li>
                                <li style="background-image:url(${ctx}/borong/images/h10.png)">
                                    <p>地址：北京市海淀区中关村东路89号恒兴大厦306</p>
                                </li>
                                <li style="background-image:url(${ctx}/borong/images/h11.png)">
                                    <p>路线：地铁10号线知春里站B口出向东步行400米左转进入中关村东路辅路向北步行570米即到。</p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="g-form">
            <form action="" id="hzform">
                <div class="wp">
                    <h2>留言合作</h2>
                    <div class="box">
                            <div class="item">
                                <p>联系人：</p>
                                <input type="text" name="sName" max="30" class="inp" placeholder="请输入您的姓名" />
                            </div>
                            <div class="item">
                                <p>联系电话：</p>
                                <input type="text" name="sPhone" maxlength="50" class="inp" placeholder="请输入您的联系电话" />
                            </div>
                            <div class="item">
                                <p>公司名称：</p>
                                <input type="text" name="sCompany" maxlength="150" class="inp" placeholder="请在此填写您公司全称" />
                            </div>
                        </div>
                        <div class="ly">
                            <p>合作意向：</p>
                            <textarea name="sDescription" placeholder="请概述您的问题或建议" class="text"></textarea>
                        </div>
                        <input type="button" onclick="hzsub()" class="sub" value="立即提交" />
                </div>
            </form>
        </div>
    </div>
    <!-- 内容 -->
    <!-- 底部 -->
    <%@ include file="common_foot.jsp"%>
    <!-- 底部 -->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=P6QfOGrhFllpZodPYeF7RW1nN1B9rp62"></script>
    <script type="text/javascript">
    var flag = false;
	function hzsub(){
		if(flag){
			alert("请不要重复提交");
			return;
		}
		flag = true;
		$.ajax({
			 type: "POST",//方法类型
             dataType: "json",//预期服务器返回的数据类型
             url: "submitCooperat.htm" ,//url
             data: $('#hzform').serialize(),
             success: function (result) {
                 if (result == "200") {
                     alert("您的留言提交成功");
                 }else{
                	 alert("系统繁忙，请稍后再试");
                 }
             },
             error : function() {
                 alert("系统繁忙，请稍后再试");
                 flag = false;
             }
		})
	}
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