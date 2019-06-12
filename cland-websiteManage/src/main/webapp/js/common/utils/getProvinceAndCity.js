$(function() {
	var city = $("#sCity").val();
	if (city == 'all') {
		$("#sCity").empty();
		$("#sCity").append("<option value='all'>请选择</option>");
	}
	var sProvince = $("#sProvince").val();
	if (sProvince != 'all') {
		$("#sProvince").empty();
		$("#sProvince").append("<option value='all'>请选择</option>");
		var url = ctx + "/province/queryAllChineseProvinces.htm";/* 后台url名 */
		var data = {
			"Time" : new Date().getMilliseconds()
		};/* 参数，可以什么都不写，但为了每次获取不同的数据，习惯上要传一个"时间戳"，后面还可以加你自己的数据，但必须是键值对类型的，如果有多个，用“，”隔开 */
		$.get(url, data, function(result) {/* 回调函数，其中data是从后台返回的html数据 */
			var provinces = eval(result);

			for (var i = 0; i < provinces.length; i++) {
				var op = "<option value=" + provinces[i].sName + ">"
						+ provinces[i].sName + "</option>";
				$("#sProvince").append(op);
			}
			$("#sProvince option[value='" + sProvince + "']").attr("selected",
			"selected");
			setCity(city);
		});
		

	} else {
		$("#sProvince").empty();
		$("#sProvince").append("<option value='all'>请选择</option>");
		var url = ctx + "/province/queryAllChineseProvinces.htm";/* 后台url名 */
		var data = {
			"Time" : new Date().getMilliseconds()
		};/* 参数，可以什么都不写，但为了每次获取不同的数据，习惯上要传一个"时间戳"，后面还可以加你自己的数据，但必须是键值对类型的，如果有多个，用“，”隔开 */
		$.get(url, data, function(result) {/* 回调函数，其中data是从后台返回的html数据 */
			var provinces = eval(result);

			for (var i = 0; i < provinces.length; i++) {
				var op = "<option value=" + provinces[i].sName + ">"
						+ provinces[i].sName + "</option>";
				$("#sProvince").append(op);
			}
		});
	}
});

function setCity(city) {
	 
	$("#sCity").empty();
	var provinceName = $("#sProvince").val();
	var url = ctx + "/city/queryAllCitysByProvinceName.htm";/* 后台url名 */
	var data = {
		"Time" : new Date().getMilliseconds(),
		provinceName : provinceName
	};/* 参数，可以什么都不写，但为了每次获取不同的数据，习惯上要传一个"时间戳"，后面还可以加你自己的数据，但必须是键值对类型的，如果有多个，用“，”隔开 */
	$.get(url, data, function(result) {/* 回调函数，其中data是从后台返回的html数据 */
		var citys = eval(result);
		for (var i = 0; i < citys.length; i++) {
			var op = "<option value=" + citys[i].sName + ">" + citys[i].sName
					+ "</option>";
			$("#sCity").append(op);
		}
		$("#sCity option[value='" + city + "']").attr("selected",
		"selected");
	});
}
function queryAllCitysByProvinceName(provinceId, cityId) {
	var provinceName = $("#" + provinceId).val();
	if (provinceId == "请选择") {
		alert("请先选择省份");
		return false;
	}
	$("#" + cityId).empty();
	var url = ctx + "/city/queryAllCitysByProvinceName.htm";/* 后台url名 */
	var data = {
		"Time" : new Date().getMilliseconds(),
		provinceName : provinceName
	};/* 参数，可以什么都不写，但为了每次获取不同的数据，习惯上要传一个"时间戳"，后面还可以加你自己的数据，但必须是键值对类型的，如果有多个，用“，”隔开 */
	$.get(url, data, function(result) {/* 回调函数，其中data是从后台返回的html数据 */
		var citys = eval(result);
		for (var i = 0; i < citys.length; i++) {
			var op = "<option value=" + citys[i].sName + ">" + citys[i].sName
					+ "</option>";
			$("#" + cityId).append(op);
		}
	});
}