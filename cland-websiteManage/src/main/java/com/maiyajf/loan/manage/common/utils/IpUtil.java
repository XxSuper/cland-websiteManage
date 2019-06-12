package com.maiyajf.loan.manage.common.utils;

import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.loan.sys.service.SystemService;
import org.apache.commons.lang3.StringUtils;

/**
 * 项目名称：  myLoan-manage   
 * 类名称：  IpUtil   
 * 描述：  Ip地址工具类,调用新浪的api
 * @author  zhuzheng   
 * 创建时间：  2015年11月23日 下午5:41:53 
 * 修改人：zhuzheng    修改日期： 2015年11月23日
 * 修改备注：
 *
 */
public class IpUtil {

	/** 
	 * 方法名：  getCityByIp 
	 * 描述：  根据ip获取城市
	 * @author  zhuzheng   
	 * 创建时间：2015年11月23日 下午5:43:46
	 * @param ip
	 * @return
	 *
	 */
	public static String getCityByIp(String ip) {
		if (ip.startsWith(Constants.LOCAL_IP)) {
			return Constants.LOCAL_CITY;
		}
		Object sessionCity = ShiroUtils.getSessionAttribute("ip:" + ip);
		String city="";
		if (null != sessionCity) {
			city = String.valueOf(sessionCity);
		}else{
			// 查询本地ip地址库
			SystemService service = (SystemService) SpringBeanContainer.getBean("systemServiceImpl");
			long ipInt = ipToInt(ip);
//			city = service.getCityByIp(ipInt);
			city = "南京";
			if (StringUtils.isNotBlank(city)) {
				ShiroUtils.putToSession("ip:" + ip, city);
			}
		}
		return city;
	}

	/** 
	 * 方法名：  ipToInt 
	 * 描述：  ip转int
	 * @author  zhuzheng   
	 * 创建时间：2015年11月26日 上午11:53:21
	 * @param ip
	 * @return
	 *
	 */
	public static long ipToInt(String ip) {
		String[] addrArray = ip.split("\\.");
		long num = 0;
		for (int i = 0; i < addrArray.length; i++) {
			int power = 3 - i;
			num += ((Integer.parseInt(addrArray[i]) % 256 * Math.pow(256, power)));
		}
		return num;
	}
}
