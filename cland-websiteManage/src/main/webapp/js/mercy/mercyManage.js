$(function(){
	$(".js_px_input").blur(function(){
		$.ajax({
			url : ctx + "/mercy/saveMercy.htm",
			type : "post",
			data : {
				iType : 1,
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

/**
 * 删除的时候的确认框
 * 
 * @param sGuid
 * @returns {Boolean}
 */
function deleteNews(newsNo) {
	BootstrapDialog.confirm("确定删除吗", function(isOk){
		if(isOk){
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
	})
}

/**
 * 跳转编辑新闻框
 * 
 * @param newsNo
 */
function showEditNews(newsNo) {
	window.location.href = ctx + "/mercy/editMercy.htm?sNewsNo=" + newsNo;
}

function doDeleteAll() {
	if ($("input[type='checkbox']:checked").length == 0) {
		BootstrapDialog.alert("请选择至少一条信息！！");
		return;
	}
	var str = "";
	$("input[name='newsInfo']:checked").each(function() {
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

function setHomeDisplay(sNewsNo,iHomeDisplay) {
	$.ajax({
		url : ctx + "/news/setHomeDisplay.htm",
		type : "post",
		data : {
			sNewsNo : sNewsNo,
			iHomeDisplay : iHomeDisplay,
			iType : 1
		}, 
		dataType : "json",
		success : function(res) {
			if(res.code == 0) {
				window.location.reload();
			} else {
				BootstrapDialog.alert(res.message);
			}
		}
	})
}

function showSaveMercy() {
	window.location.href = ctx + "/mercy/addMercy.htm";
}