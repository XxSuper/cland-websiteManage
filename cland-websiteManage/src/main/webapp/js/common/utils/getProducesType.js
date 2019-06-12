$(function() {
	var loanProductId=$("#loanProductId").val();
	if(loanProductId =='all')
	{
	$("#loanProductId").empty();
	$("#loanProductId").append("<option value='all'>请选择</option>");
	var url = ctx + "/product/queryAll.htm";/* 后台url名 */
	var data = {
		"Time" : new Date().getMilliseconds()
	};/* 参数，可以什么都不写，但为了每次获取不同的数据，习惯上要传一个"时间戳"，后面还可以加你自己的数据，但必须是键值对类型的，如果有多个，用“，”隔开 */
	$.get(url, data, function(result) {/* 回调函数，其中data是从后台返回的html数据 */
		var products = eval(result);
		for (var i = 0; i < products.length; i++) {
			var op = "<option value=" + products[i].sProductName + ">"
					+ products[i].sProductName + "</option>";
			$("#loanProductId").append(op);
		}
	});
	}
	else
	{
		$("#loanProductId").empty();
		$("#loanProductId").append("<option value='all'>请选择</option>");
		var url = ctx + "/product/queryAll.htm";/* 后台url名 */
		var data = {
			"Time" : new Date().getMilliseconds()
		};/* 参数，可以什么都不写，但为了每次获取不同的数据，习惯上要传一个"时间戳"，后面还可以加你自己的数据，但必须是键值对类型的，如果有多个，用“，”隔开 */
		$.get(url, data, function(result) {/* 回调函数，其中data是从后台返回的html数据 */
			var products = eval(result);
			for (var i = 0; i < products.length; i++) {
				var op = "<option value=" + products[i].sProductName + ">"
						+ products[i].sProductName + "</option>";
				$("#loanProductId").append(op);
			}
			$("#loanProductId option[value='" + loanProductId + "']").attr("selected",
			"selected");
		});	
	}
 
});