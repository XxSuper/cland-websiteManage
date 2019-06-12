<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<%@ include file="/include/left.jsp"%>
	<!--页面标题-->
	<h3 class="page-title"></h3>

	<!--面包屑导航-->
	<ul class="breadcrumb">
		<li><i class="icon-home"></i> <a href="${ctx}/sys/index.htm">首页</a>
			<i class="icon-angle-right"></i></li>
		<li><a href="javascript:void(0)">新增/修改菜单</a></li>
	</ul>
<div >

	<div class="">
		<!-- edit form -->
		<form id="tab" action="${ctx}/menu/edit.htm" method="POST" class="form-horizontal">
			
			
			
			
			
						
		<div class="control-group">
    			<label class="control-label" for="parentId">上级菜单</label>
  					  <div class="controls">
     					
			 <select name="parentId" class="input-xlarge"  id="parentId">
				<option value="0"
					<c:if test="${empty menu.guid}">selected="selected"</c:if>>请选择上级菜单</option>
				<c:if test="${not empty menuList}">
					<c:forEach items="${menuList}" var="menuMap">
						<option value="${menuMap.guid}"
							<c:if test="${menu.parentId==menuMap.guid}">selected="selected"</c:if>>${menuMap.name }</option>
						<c:if test="${not empty menuMap.chirdlen}">
							<c:forEach items="${menuMap.chirdlen}" var="menuChildren">
								<option value="${menuChildren.guid}"
									<c:if test="${menu.parentId==menuChildren.guid}">selected="selected"</c:if>>${menuChildren.name }</option>
							</c:forEach>
						</c:if>
					</c:forEach>
				</c:if>
			</select> 
				
    				</div>
 			 </div>
			
			
		
				
		<div class="control-group">
    			<label class="control-label" for="name">名称</label>
  					  <div class="controls">
     					<input type="text" name="name" id="name"
				class="input-xlarge search-query" value="${menu.name }" required> 
				
    				</div>
 			 </div>
		
			
				
				<div class="control-group">
    			<label class="control-label" for="url">访问路径</label>
  					  <div class="controls">
     					<input type="text" name="url" id="url" class="input-xlarge search-query"
				value="${menu.url }"> 
				
    				</div>
 			 </div>
				
				
				
			<div class="control-group">
    			<label class="control-label" for="sMenuImage">菜单图标</label>
  					  <div class="controls">
     					<input type="text" name="sMenuImage" id="sMenuImage" class="input-xlarge search-query"
				value="${menu.sMenuImage }">  <c:if test="${empty menu.sMenuImage}">例如:icon-glass</c:if>
    				</div>
 			 </div>
				
			
			 <div class="control-group">
    			<label class="control-label" for=""></label>
  					  <div class="controls">
  					  <button type="button"  class="btn blue" onclick="save(event)" ><i class="icon-ok"></i> 提交</button>
  					 

		<c:if test="${empty parentMenuId}">
				<a href="${ctx}/menu/menu.htm"  class="btn">返回</a>
		</c:if>
		<c:if test="${not empty parentMenuId}">
				<a href="${ctx}/menu/childrenMenu.htm?id=${parentMenuId}" class="btn">返回</a>
		</c:if>
			
			
			
			
			
			
    				</div>
 			 </div>
			
			
			
			
				<input type="hidden" name="guid" id="guid" value="${menu.guid }">
			 <input type="hidden" name="id" value="${parentMenuId}">
		</form>
		
	</div>
	<div class="">
	<div class="page-header">
            <h1> <small>可选图标</small></h1>
          </div>
	
			 <table>
           <tr >
            <td><i class="icon-glass"></i> icon-glass</td>
            <td><i class="icon-music"></i> icon-music</td>
            <td><i class="icon-search"></i> icon-search</td>
            <td><i class="icon-envelope"></i> icon-envelope</td>
            <td><i class="icon-heart"></i> icon-heart</td>
            <td><i class="icon-star"></i> icon-star</td>
            <td><i class="icon-star-empty"></i> icon-star-empty</td>
            <td><i class="icon-user"></i> icon-user</td>
            <td><i class="icon-film"></i> icon-film</td>
            <td><i class="icon-th-large"></i> icon-th-large</td> </tr > <tr >
            <td><i class="icon-th"></i> icon-th</td>
            <td><i class="icon-th-tdst"></i> icon-th-tdst</td>
            <td><i class="icon-ok"></i> icon-ok</td>
            <td><i class="icon-remove"></i> icon-remove</td>
            <td><i class="icon-zoom-in"></i> icon-zoom-in</td>
            <td><i class="icon-zoom-out"></i> icon-zoom-out</td>
            <td><i class="icon-off"></i> icon-off</td>
            <td><i class="icon-signal"></i> icon-signal</td>
            <td><i class="icon-cog"></i> icon-cog</td>
            <td><i class="icon-trash"></i> icon-trash</td></tr>
            <tr>
            <td><i class="icon-home"></i> icon-home</td>
            <td><i class="icon-file"></i> icon-file</td>
            <td><i class="icon-time"></i> icon-time</td>
            <td><i class="icon-road"></i> icon-road</td>
            <td><i class="icon-download-alt"></i> icon-download-alt</td>
            <td><i class="icon-download"></i> icon-download</td>
            <td><i class="icon-upload"></i> icon-upload</td>
            <td><i class="icon-inbox"></i> icon-inbox</td>
            <td><i class="icon-play-circle"></i> icon-play-circle</td>
            <td><i class="icon-repeat"></i> icon-repeat</td> </tr > <tr >
            <td><i class="icon-refresh"></i> icon-refresh</td>
            <td><i class="icon-tdst-alt"></i> icon-tdst-alt</td>
            <td><i class="icon-lock"></i> icon-lock</td>
            <td><i class="icon-flag"></i> icon-flag</td>
            <td><i class="icon-headphones"></i> icon-headphones</td>
            <td><i class="icon-volume-off"></i> icon-volume-off</td>
            <td><i class="icon-volume-down"></i> icon-volume-down</td>
            <td><i class="icon-volume-up"></i> icon-volume-up</td>
            <td><i class="icon-qrcode"></i> icon-qrcode</td>
            <td><i class="icon-barcode"></i> icon-barcode</td></tr>
            <tr>
            <td><i class="icon-tag"></i> icon-tag</td>
            <td><i class="icon-tags"></i> icon-tags</td>
            <td><i class="icon-book"></i> icon-book</td>
            <td><i class="icon-bookmark"></i> icon-bookmark</td>
            <td><i class="icon-print"></i> icon-print</td>
            <td><i class="icon-camera"></i> icon-camera</td>
            <td><i class="icon-font"></i> icon-font</td>
            <td><i class="icon-bold"></i> icon-bold</td>
            <td><i class="icon-itatdc"></i> icon-itatdc</td>
            <td><i class="icon-text-height"></i> icon-text-height</td> </tr > <tr >
            <td><i class="icon-text-width"></i> icon-text-width</td>
            <td><i class="icon-atdgn-left"></i> icon-atdgn-left</td>
            <td><i class="icon-atdgn-center"></i> icon-atdgn-center</td>
            <td><i class="icon-atdgn-right"></i> icon-atdgn-right</td>
            <td><i class="icon-atdgn-justify"></i> icon-atdgn-justify</td>
            <td><i class="icon-tdst"></i> icon-tdst</td>
            <td><i class="icon-indent-left"></i> icon-indent-left</td>
            <td><i class="icon-indent-right"></i> icon-indent-right</td>
            <td><i class="icon-facetime-video"></i> icon-facetime-video</td>
            <td><i class="icon-picture"></i> icon-picture</td>
            </tr>
            <tr>
            <td><i class="icon-pencil"></i> icon-pencil</td>
            <td><i class="icon-map-marker"></i> icon-map-marker</td>
            <td><i class="icon-adjust"></i> icon-adjust</td>
            <td><i class="icon-tint"></i> icon-tint</td>
            <td><i class="icon-edit"></i> icon-edit</td>
            <td><i class="icon-share"></i> icon-share</td>
            <td><i class="icon-check"></i> icon-check</td>
            <td><i class="icon-move"></i> icon-move</td>
            <td><i class="icon-step-backward"></i> icon-step-backward</td>
            <td><i class="icon-fast-backward"></i> icon-fast-backward</td> </tr > <tr >
            <td><i class="icon-backward"></i> icon-backward</td>
            <td><i class="icon-play"></i> icon-play</td>
            <td><i class="icon-pause"></i> icon-pause</td>
            <td><i class="icon-stop"></i> icon-stop</td>
            <td><i class="icon-forward"></i> icon-forward</td>
            <td><i class="icon-fast-forward"></i> icon-fast-forward</td>
            <td><i class="icon-step-forward"></i> icon-step-forward</td>
            <td><i class="icon-eject"></i> icon-eject</td>
            <td><i class="icon-chevron-left"></i> icon-chevron-left</td>
            <td><i class="icon-chevron-right"></i> icon-chevron-right</td>
            </tr>
            <tr>
            <td><i class="icon-plus-sign"></i> icon-plus-sign</td>
            <td><i class="icon-minus-sign"></i> icon-minus-sign</td>
            <td><i class="icon-remove-sign"></i> icon-remove-sign</td>
            <td><i class="icon-ok-sign"></i> icon-ok-sign</td>
            <td><i class="icon-question-sign"></i> icon-question-sign</td>
            <td><i class="icon-info-sign"></i> icon-info-sign</td>
            <td><i class="icon-screenshot"></i> icon-screenshot</td>
            <td><i class="icon-remove-circle"></i> icon-remove-circle</td>
            <td><i class="icon-ok-circle"></i> icon-ok-circle</td>
            <td><i class="icon-ban-circle"></i> icon-ban-circle</td> </tr > <tr >
            <td><i class="icon-arrow-left"></i> icon-arrow-left</td>
            <td><i class="icon-arrow-right"></i> icon-arrow-right</td>
            <td><i class="icon-arrow-up"></i> icon-arrow-up</td>
            <td><i class="icon-arrow-down"></i> icon-arrow-down</td>
            <td><i class="icon-share-alt"></i> icon-share-alt</td>
            <td><i class="icon-resize-full"></i> icon-resize-full</td>
            <td><i class="icon-resize-small"></i> icon-resize-small</td>
            <td><i class="icon-plus"></i> icon-plus</td>
            <td><i class="icon-minus"></i> icon-minus</td>
            <td><i class="icon-asterisk"></i> icon-asterisk</td>
            </tr><tr>
            <td><i class="icon-exclamation-sign"></i> icon-exclamation-sign</td>
            <td><i class="icon-gift"></i> icon-gift</td>
            <td><i class="icon-leaf"></i> icon-leaf</td>
            <td><i class="icon-fire"></i> icon-fire</td>
            <td><i class="icon-eye-open"></i> icon-eye-open</td>
            <td><i class="icon-eye-close"></i> icon-eye-close</td>
            <td><i class="icon-warning-sign"></i> icon-warning-sign</td>
            <td><i class="icon-plane"></i> icon-plane</td>
            <td><i class="icon-calendar"></i> icon-calendar</td>
            <td><i class="icon-random"></i> icon-random</td> </tr > <tr >
            <td><i class="icon-comment"></i> icon-comment</td>
            <td><i class="icon-magnet"></i> icon-magnet</td>
            <td><i class="icon-chevron-up"></i> icon-chevron-up</td>
            <td><i class="icon-chevron-down"></i> icon-chevron-down</td>
            <td><i class="icon-retweet"></i> icon-retweet</td>
            <td><i class="icon-shopping-cart"></i> icon-shopping-cart</td>
            <td><i class="icon-folder-close"></i> icon-folder-close</td>
            <td><i class="icon-folder-open"></i> icon-folder-open</td>
            <td><i class="icon-resize-vertical"></i> icon-resize-vertical</td>
            <td><i class="icon-resize-horizontal"></i> icon-resize-horizontal</td>
           </tr>
        </table>
	</div>
</div>
<script>
	function save(event) {
		//阻止冒泡
		ChkUtil.stopBubbleEvent(event);
		if (check()) {
			$("#tab").submit();
		}
	}
	function check() {
		var name = $("#name").val();
		var url = $("#url").val();
		var sMenuImage = $("#sMenuImage").val();
		if (ChkUtil.isNull(name)) {
			alert("名称不能为空!");
			return false;
		}
		if (ChkUtil.isNull(url)) {
			alert("访问路径不能为空!");
			return false;
		}
		if (!ChkUtil.isNull(sMenuImage)) {
			sMenuImage = sMenuImage.replace(/(^\s*)|(\s*$)/g, "");// 删除二边空格
			$("#sMenuImage").val(sMenuImage);
		}
		return true;
	}
</script>
<%@ include file="/include/footer.jsp"%>