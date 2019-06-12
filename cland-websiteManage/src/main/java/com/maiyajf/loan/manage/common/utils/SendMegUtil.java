package com.maiyajf.loan.manage.common.utils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.springframework.scheduling.annotation.Async;

import com.maiyajf.base.constants.IAppIDType;
import com.maiyajf.base.po.RealTimeSMSBean;
import com.maiyajf.base.utils.base.BeanUtils;
import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.base.utils.base.HttpAgent;
import com.maiyajf.base.utils.base.JsonUtil;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.base.utils.log.OutInterfaceLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.config.Global;
import com.maiyajf.loan.manage.loan.sys.utils.CommonUtil;

public class SendMegUtil {

	/**
	 * 
	 * @param phoneNo 手机号
	 * @param newMsg 发送内容
	 * @param channle 渠道
	 * @param serviceType 业务类型
	 * @param appId 调用方
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void send(String phoneNo, String newMsg, String channle, String serviceType, String appId)
			throws ClientProtocolException, IOException {
		
		RealTimeSMSBean sms = new RealTimeSMSBean();
		sms.setsMobile(phoneNo);
		sms.setServiceType(serviceType);
		sms.setSmsID(BeanUtils.getUUID());
		sms.setSmsContent(newMsg);
		sms.setChannelNo(channle);
		String reqParams = JsonUtil.objectToJson(sms);
		String url = Global.getConfig("sendSms_Url");
		HttpAgent agent = new HttpAgent(url);
		agent.addHeader("appID", appId);
		String result = "";
		Date beginDate = new Date();
		try {
			result = agent.doPost(reqParams);
		} catch (Exception e) {
			ExceptionLogger.error("sys", "后台系统调用短信平台发送短信异常reqParams="+reqParams, e);
		} finally {
			OutInterfaceLogger.info("调用短信平台发送短信", url, beginDate, reqParams, new Date(), result);
		}
	}

	
	/** 
	 * 方法名：  sendMessage 
	 * 描述：  发送短信的方法
	 * @author  zhuzheng   
	 * 创建时间：2015年11月20日 下午5:15:36
	 * @param sendMobile
	 * @param sendContent
	 * @return
	 *
	 */
	public static Map<String, Object> sendMessage(String sendMobile, String sendContent) {
		Map<String, Object> result = new HashMap<String, Object>();
		String flag = Constants.NO;
		if (StringUtil.isMobileNO(sendMobile) && StringUtils.isNotBlank(sendContent)) {
			try {
				if (!sendContent.contains("【麦芽贷】")) {
					// 没有匹配模板的短信
					sendContent = "【麦芽贷】" + sendContent;
				}
				SendMegUtil.send(sendMobile, sendContent, null, "1", IAppIDType.MYLOAN_MANAGER);
				flag =Constants.YES; 
			} catch (Exception e) {
				ExceptionLogger.error("sendSms", "调短信平台发送短信失败", e);
			}
		}
		result.put("flag", flag);
		return result;
	}
}
