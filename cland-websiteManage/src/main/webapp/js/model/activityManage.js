$(function(){
	$(".js_px_input").blur(function(){
		$.ajax({
			url : ctx + "/activity/saveActivity.htm",
			type : "post",
			data : {
				iType : 7,
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
function deleteActivity(newsNo) {
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
					window.location.reload();
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
function editActivity(newsNo) {
	var sModularId = $("#sModularId").val();
	window.location.href = ctx + "/activity/editActivity.htm?sNewsNo=" + newsNo + "&sModularId= " + sModularId;
}

function doDeleteAll() {
	if ($("input[type='checkbox']:checked").length == 0) {
		BootstrapDialog.alert("请选择至少一条信息！！");
		return;
	}
	var str = "";
	$("input[name='activityId']:checked").each(function() {
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
					window.location.reload();
				}
			})
		}
	})
}

function showSaveActivitys(sModularId) {
	window.location.href = ctx + "/activity/addActivity.htm?sModularId=" + sModularId;
}

function backModel(){
	window.location.href = ctx + "/model/modelQuery.htm";
}