$(function(){
    $(".js_px_input").blur(function(){
        var sortNum = $(this).val();
        if(ChkUtil.isPlusInteger(sortNum)){
            $.ajax({
                url : ctx + "/news/saveNewsInfoJson.htm",
                type : "post",
                data : {
                    iType : 6,
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
 * @param guid
 * @returns {Boolean}
 */
function deleteOne(newsNo) {
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

// 提交分页查询
function goPage(page) {
    $("#pageNumber").val(page);
    // 默认第一个表单提交
    document.forms[0].submit();
};

/**
 * 跳转编辑框
 *
 * @param guid
 */
function showEdit(newsNo) {
    window.location.href = ctx + "/knowCland/showEditHonorQualification.htm?newsNo=" + newsNo;
}

function doDeleteAll() {
	var str = "";
	$("input[name='newsInfo']").each(function() {
		if ($(this).parent().attr('class') == 'checked') {
			str += $(this).val() + ","
		}
	})
	if(str == ""){
		BootstrapDialog.alert("请选择至少一条信息！！");
		return;
	}
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

/**
 * 跳转新建框
 *
 */
function showSave() {
    window.location.href = ctx + "/knowCland/showSaveHonorQualification.htm";
}

function doSummitHonorQualification() {
    var sMediaImage = $('#sMediaImage').val();
    var sIntroduce = $('#sIntroduce').val();
    // editor.sync();
    if (ChkUtil.isNull(sMediaImage)) {
        alert("请上传图片！");
        return false;
    } else {
        $('#news').submit();
    }
}