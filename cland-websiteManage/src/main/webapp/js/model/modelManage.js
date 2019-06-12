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
	if ($("input[name='modelId']:checked").length == 0) {
		BootstrapDialog.alert("请选择至少一条信息！！");
		return;
	}
	var str = "";
	$("input[name='modelId']:checked").each(function() {
		if ($(this).attr("checked")) {
			str += $(this).val() + ","
		}
	})
	BootstrapDialog.confirm("确定删除吗", function(isOk){
		if(isOk){
			$.ajax({
				url : ctx + "/model/delAllModels.htm",
				type : "post",
				data : {
					ids : str
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

function deleteModel(id) {
	BootstrapDialog.confirm("确定删除吗", function(isOk){
		if(isOk){
			$.ajax({
				url : ctx + "/model/delModel.htm",
				type : "post",
				data : {
					id : id
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

function addActivity(id){
	window.location.href = ctx + "/activity/activityQuery.htm?sModularId=" + id;
}

function showSaveModel() {
	window.location.href = ctx + "/model/addModel.htm";
}

function editModel(id) {
	window.location.href = ctx + "/model/editModel.htm?id=" + id;
}