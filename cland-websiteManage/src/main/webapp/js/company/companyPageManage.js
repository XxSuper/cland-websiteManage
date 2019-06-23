$(function(){
	$(".js_px_input").blur(function(){
		var sortNum = $(this).val();
		if(ChkUtil.isPlusInteger(sortNum)){
			$.ajax({
				url : ctx + "/commonPage/saveNewsInfoJson.htm",
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
			url : ctx + "/commonPage/deleteNews.htm",
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
function showEditCompany(sGuid, isAbout) {
	window.location.href = ctx + "/company/showEditCompany.htm?sGuid=" + sGuid + "&isAbout=" + isAbout;
}

function setHomeDisplay(sNewsNo,iHomeDisplay) {
	$.ajax({
		url : ctx + "/commonPage/setHomeDisplay.htm",
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