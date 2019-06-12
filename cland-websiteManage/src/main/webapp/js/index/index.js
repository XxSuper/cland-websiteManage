$(document).ready(function() {
	$(".date-picker").datepicker({
		language : "zh-CN",
		autoclose : true
	});
})

function getLoginStatus(url) {
	$.ajax({
				url : ctx+"/sys/getLoginStatus.htm",
				type : "get",
				dataType : "json",
				success : function(res) {
					if (res.flag == '1') {
						window.parent.document.getElementById('frame_center').src = url;
					} else {
						window.parent.location.href = ctx+"/sys/login.htm";
					}

				}
			});
}
function showOrHide(obj) {
	var type = $("#" + obj).css("display");
	if (type == 'none') {
		$("ul").css("display", "none");
		$("#" + obj).css("display", "block");
	} else {
		$("#" + obj).css("display", "none");
	}
	;

}
function logout(){
	  window.location.href=ctx+"/sys/logout.htm";
}
function index(){
	  window.location.href=ctx+"/sys/index.htm";
}
function updatePassword(){
	  window.location.href=ctx+"/user/updatePassword.htm";
}
