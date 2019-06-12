/**
 * 删除的时候的确认框
 * 
 * @param sGuid
 * @returns {Boolean}
 */
function deleteImpress(newsNo) {
	if (confirm("确定删除吗")) {
		$.ajax({
			url : ctx + "/news/deleteNews.htm",
			type : "post",
			data : {
				newsNo : newsNo
			},
			dataType : "json",
			success : function(res) {
				// 页面刷新,提交表单
				$('#searchForm').submit();
			}
		})
	}
}

/**
 * 跳转编辑新闻框
 * 
 * @param newsNo
 */
function showEditImpress(newsNo) {
	window.location.href = ctx + "/impress/showEditImpress.htm?newsNo=" + newsNo;
}

function doDeleteAll() {
	if ($("input[type='checkbox']:checked").length == 0) {
		alert("请选择至少一条信息！！");
		return;
	}
	var str = "";
	$("input[name='newsInfo']:checked").each(function() {
		if ($(this).attr("checked")) {
			str += $(this).val() + ","
		}
	})
	if (confirm("确定删除吗")) {
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
}

function showSaveImpress() {
	window.location.href = ctx + "/impress/showSaveImpress.htm?iType=" + $('#iType').val();
}