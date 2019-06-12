$(function(){
	$(".js_px_input").blur(function(){
		$.ajax({
			url : ctx + "/industry/saveIndustry.htm",
			type : "post",
			data : {
				iType : 11,
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
	if ($("input[name='industryId']:checked").length == 0) {
		BootstrapDialog.alert("请选择至少一条信息！！");
		return;
	}
	var str = "";
	$("input[name='industryId']:checked").each(function() {
		if ($(this).attr("checked")) {
			str += $(this).val() + ","
		}
	})
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

function deleteIndustry(id) {
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

function showSaveIndustry() {
	window.location.href = ctx + "/industry/addIndustry.htm";
}

function editIndustry(id) {
	window.location.href = ctx + "/industry/editIndustry.htm?sNewsNo=" + id;
}