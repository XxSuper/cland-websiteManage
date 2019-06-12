$(function(){
	$(".js_px_input").blur(function(){
		$.ajax({
			url : ctx + "/banner/saveBanner.htm",
			type : "post",
			data : {
				iType : 3,
				show : 1,
				sNewsNo : $(this).attr("id"),
				operate : 'edit',
				iSortNum : $(this).val()
			},
			dataType : "json",
			success : function(res) {
				// 页面刷新,提交表单
				$('#searchForm').submit();
			}
		})
	})
})

// 提交分页查询
function goPage(page) {
	$("#pageNumber").val(page);
	// 默认第一个表单提交
	document.forms[0].submit();
};

function selectAll() {
	var a = $('#select').val();
	if ("true" == a) {
		$(":checkbox").parent().addClass("checked");
		$(":checkbox").attr("checked", a);
		$('#select').val(false);
	} else {
		$(":checkbox").parent().removeClass("checked");
		$(":checkbox").removeAttr("checked");// 取消全选
		$('#select').val(true);
	}
}

function doDeleteAll() {
//	if ($("input[name='bannerId']:checked").length == 0) {
//		BootstrapDialog.alert("请选择至少一条信息！！");
//		return;
//	}
	var str = "";
	$("input[name='bannerId']").each(function() {
		if ($(this).parent().attr('class') == 'checked') {
			str += $(this).val() + ","
		}
	})
	if(str == ""){
		BootstrapDialog.alert("请选择至少一条信息！！");
		return;
	}
	BootstrapDialog.confirm("确定删除吗", function(isOk){
		if(isOk){
			$.ajax({
				url : ctx + "/news/deleteAllNews.htm",
				type : "post",
				data : {
					newsNos : str
				},
				dataType : "json",
				success : function(res) {
					// 页面刷新,提交表单
					$('#searchForm').submit();
				}
			})
		}
	})
}

function deleteBanner(id) {
	BootstrapDialog.confirm("确定删除吗", function(isOk){
		if(isOk){
			$.ajax({
				url : ctx + "/news/deleteNews.htm",
				type : "post",
				data : {
					newsNo : id
				},
				dataType : "json",
				success : function(res) {
					// 页面刷新,提交表单
					$('#searchForm').submit();
				}
			})
		}
	})
}

function showSaveBanners() {
	window.location.href = ctx + "/banner/addBanner.htm";
}

function editBanner(id) {
	window.location.href = ctx + "/banner/editBanner.htm?sNewsNo=" + id;
}