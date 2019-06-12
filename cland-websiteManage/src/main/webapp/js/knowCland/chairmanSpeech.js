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
    window.location.href = ctx + "/knowCland/showEditChairmanSpeech.htm?newsNo=" + newsNo;
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

/**
 * 跳转新建框
 *
 */
function showSave() {
    window.location.href = ctx + "/knowCland/showSaveChairmanSpeech.htm";
}

function doSummitChairmanSpeech() {
    var sMediaImage = $('#sMediaImage').val();
    // editor.sync();
    if (ChkUtil.isNull(sMediaImage)) {
        alert("请上传图片！");
        return false;
    } else {
        $('#news').submit();
    }
}