package com.maiyajf.base.constants;

/**
 * @ClassName: IAppIDType
 * @Description: 应用ID
 * @author: yunlei.hua
 * @date: 2015年11月11日 上午10:12:40
 */
public interface IAppIDType {

	/** 管理后台 */
	String MYLOAN_MANAGER = "1001";
	/** 用户中心 */
	String MYLOAN_USERS = "1002";
	/** 借款中心 */
	String MYLOAN_APPLY = "1003";
	/** 还款中心 */
	String MYLOAN_REPAY = "1004";
	/** 放款中心 */
	String MYLOAN_GRANT = "1005";
	/** 监控中心 */
	String MYLOAN_MONITOR = "1006";
	/** 对账中心 */
	String MYLOAN_RECONCI = "1007";
	/** 线下进件 */
	String MYINCLUSIVE_INTEFACE = "1008";
	/** 征信中心 */
	String MYLOAN_APPROVAL = "1009";
	/** 任务中心 */
	String MYLOAN_TASKCENTER = "1010";
	/** 资金中心 */
	String MYLOAN_FUND = "1011";
	/** MOBILE接口层 */
	String MYLOAN_MOBILE = "1012";
	/** 征信中心-普惠 */
	String MYLOAN_APPROVAL_PH = "1013";
	/** 推送中心 */
	String MYDATA_PUSH = "1014";
	
	/** 支付统一接口层 **/
	String PAYCENTER_ADAPTER="1015";
	
	/** 支付中心 */
	String PAYCENTER_TRADE = "5001";
	/** 支付系统对账 */
	String PAYCENTER_RECON = "5002";

	/** 风控引擎 **/
	String FENGKOUYINQING = "gcs_web";
}
