$(function(){
	$(".js_px_input").blur(function(){
		var sortNum = $(this).val();
		if(ChkUtil.isPlusInteger(sortNum)){
			$.ajax({
				url : ctx + "/news/saveNewsInfoJson.htm",
				type : "post",
				data : {
					iType : 2,
					show : 1,
					sNewsNo : $(this).attr("id"),
					operate : 'edit',
					iSortNum : sortNum
				},
				dataType : "json",
				success : function(res) {
					// 页面刷新,提交表单
					$('#searchForm').submit();
				}
			});
		} else {
			alert("请输入正确的配排序序号！");
		}
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

/**
 * 删除的时候的确认框
 * 
 * @param sGuid
 * @returns {Boolean}
 */
function deleteNews(newsNo) {
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
function showEditNews(newsNo) {
	window.location.href = ctx + "/news/showEditNews.htm?newsNo=" + newsNo;
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

function setHomeDisplay(sNewsNo,iHomeDisplay) {
	$.ajax({
		url : ctx + "/news/setHomeDisplay.htm",
		type : "post",
		data : {
			sNewsNo : sNewsNo,
			iHomeDisplay : iHomeDisplay,
			iType : $("#iType").val()
		},
		dataType : "json",
		success : function(res) {
			//debugger;
			if(res.code == 0) {
				// 页面刷新,提交表单
				$('#searchForm').submit();
			} else {
				alert(res.message);
			}
		}
	})
}

function showSaveNews() {
	window.location.href = ctx + "/news/showSaveNews.htm";
}