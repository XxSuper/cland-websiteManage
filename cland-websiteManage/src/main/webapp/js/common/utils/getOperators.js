function showAddNewsOperators(id, num) {
	var n = $("#" + num).val();
	if (n == 0) {
		$("#" + num).val(n + 1);
		$.ajax({
			url : ctx + "/Operators/queryAddNewsOperators.htm",
			type : "post",
			data : {
				"Time" : new Date().getMilliseconds()
			},
			dataType : "json",
			success : function(res) {
				if (null != res && res.length > 0) {
					var htmlStr = "<option value=''>请选择</option>";
					for (var a = 0; a < res.length; a++) {
						if (null != res[a]) {
							htmlStr += "<option value=" + res[a] + ">" + res[a]
									+ "</option>";
						}
					}
					$("#" + id).html(htmlStr);
				} else {
					alert("查无数据！！！");
				}
			}
		})
	}
}

function showApprovalNewsOperators(id, num) {
	var n = $("#" + num).val();
	if (n == 0) {
		$("#" + num).val(n + 1);
		$.ajax({
			url : ctx + "/Operators/queryApprovalNewsOperators.htm",
			type : "post",
			data : {
				"Time" : new Date().getMilliseconds()
			},
			dataType : "json",
			success : function(res) {
				if (null != res && res.length > 0) {
					var htmlStr = "<option value=''>请选择</option>";
					for (var a = 0; a < res.length; a++) {
						if (null != res[a]) {
							htmlStr += "<option value=" + res[a] + ">" + res[a]
									+ "</option>";
						}
					}
					$("#" + id).html(htmlStr);
				} else {
					alert("查无数据！！！");
				}
			}
		})
	}
}
