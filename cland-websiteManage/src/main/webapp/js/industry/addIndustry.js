function doSummit() {
	var flag = true;
	var sTitle = $('#sTitle').val();
	if (ChkUtil.isNull(sTitle)) {
		BootstrapDialog.alert("请输入标题");
		flag = false;
		return;
	}
	var sLinkUrl = $('#sLinkUrl').val();
	if (!ChkUtil.isNull(sLinkUrl) && !ChkUtil.isUrl(sLinkUrl)) {
		BootstrapDialog.alert("请输入正确格式的超链接");
		flag = false;
		return;
	}
	if (flag) {
		$('#industry').submit();
	}
}