package com.maiyajf.base.constants;

public interface MQConstants {
	public String UserApprovalAdmittance="rulechain-item-admittance";//分期准入链
	public String UserApprovalBackcheat="rulechain-item-backcheat";//分期反欺诈链
	public String UserApprovalMention_YSX="thirdpartychannel-xjbk-newuser-ysx-chain";
	public String UserApprovalMention="rulechain-item-mention";//分期提档链
	public String ArtificialQuickSmallLoanIos="rulechain-item-ArtificialQuickSmallLoanIos";//人工快速放款小贷-IOS
	public String ArtificialQuickSmallLoanAndroid="rulechain-item-ArtificialQuickSmallLoanAndroid";//人工快速放款小贷-Android
	public String ArtificialQuickPeriodizationLoanIos="rulechain-item-ArtificialQuickPeriodizationLoanIos";//人工快速放款分期-IOS
	public String ArtificialQuickPeriodizationLoanAndroid="rulechain-item-ArtificialQuickPeriodizationLoanAndroid";//人工快速放款分期-Android
	public String SystemQuickLoanSmall="rulechain-item-SystemQuickLoanSmall";//系统快速放款小贷
	
	public String P2PBlack="rulechain-item-P2PBlack";//P2P黑名单规则链-提供借款中心查询
	
	public String SMALLREPEATLOANRULECHAIN = "rulechain-item-smallRepeatLoanRuleChain";//小贷复借审核规则链	
	public String AntiFraudCreditScoreModel = "rulechain-item-AntiFraudCreditScoreModel";//反欺诈信用评分模型规则链	
	public String PeriodAntiFraudScoreModelAndroid="rulechain-item-PeriodAntiFraudScoreModelAndroid";//分期反欺诈评分模型ANDROID
	public String PeriodAntiFraudScoreModelIos="rulechain-item-PeriodAntiFraudScoreModelIos";//分期反欺诈评分模型IOS	
	public String PeriodCreditScoreModelAndroid="rulechain-item-PeriodCreditScoreModelAndroid";//分期信用评分模型ANDROID
	public String PeriodCreditScoreModelIos="rulechain-item-PeriodCreditScoreModelIos";//分期信用评分模型IOS
	public String SmallAntiFraudScoreModelAndroid="rulechain-item-SmallAntiFraudScoreModelAndroid";//小贷反欺诈评分模型ANDROID
	public String SmallAntiFraudScoreModelIos="rulechain-item-SmallAntiFraudScoreModelIos";//小贷反欺诈评分模型IOS
	public String SmallCreditScoreModelAndroid="rulechain-item-SmallCreditScoreModelAndroid";//小贷信用评分模型ANDROID
	public String SmallCreditScoreModelIos="rulechain-item-SmallCreditScoreModelIos";//小贷信用评分模型IOS
	public String BigdataSmallLoanQuickModel="rulechain-item-bigdata-smallloan-quickmodel";//大数据小贷快速放款模型
	
	//-----------外部接口层通知放款中心的付融宝放款状态接口------------
	/**
	 * 修改标的编号对应的支付状态
	 */
	public String notify_sprojectno_payStatus="notify-sprojectno-payStatus";
	public String notify_jdGrant_payStatus="notify-jdGrant-payStatus";
	public String OverdueBillPushQueue = "overdue-bill-push-queue";
	
	/** 芝麻分反馈MQ */
	public String queueZhimafeedback = "queue.zhimafeedback";
	/** 资金中心通知放款中心支付状态 */
	public String queueFundTograntPaystatus = "queue_fundTogrant_paystatus";
	/** 放款中心通知借款中心生成合同 */
	public String queuegrantToApplyproduceContract = "queue_grantToApply_produceContract";
	/** 放款中心通知推送中心推送还款计划 */
	public String NOTIFY_PUSHCENTER_REPAYPLANS = "NOTIFY_PUSHCENTER_REPAYPLANS";
	
	/**
	 * 数据解析MQ
	 */
	public String QUEUEFORDATAANALYSIS="QUEUE_USERDATA_ANALYSIS";
	/** 放款中心通知推送中心发送路由complete事件 */
	public String NOTIFY_ROUTECOMPLETE = "NOTIFY_ROUTECOMPLETE";
	
	/** 推送中心通知电子合同签署系统发送请求签署事件 */
	public String NOTIFY_ECONTRACT_REQUESTSIGN = "ECONTRACT_SIGN";
	
	/** 推送中心通知放款中心preExecuteComplete事件 */
	public String NOTIFY_PREEXECUTECOMPLETE = "NOTIFY_PREEXECUTECOMPLETE";
	/** 借款中心通知放款中心恢复资金方额度 */
	public String queueCancleGrantBackUpLimit = "queue_cancleGrant_backUpLimit";
	/** 引流中心通知推送中心推送审核结果 */
	public String QUEUEAUDITRESULTNNOTIFY = "QUEUE_AUDITRESULTNOTIFY_TOPUSH";
	/** 放款中心通知引流中心放款结果 */
	public String QUEUEGRANTRESULT = "QUEUE_GRANTRESULT";
	public String QUEUEGRANTRESULTNOTIFY = "QUEUE_GRANTRESULTNOTIFY_TOPUSH";
	public String QUEUEHKBILLNOTIF = "QUEUE_HKBILL_NOTIFY_TOPUSH";
	
	/**审核预备结果通知
	* @Fields QUEUEPREPAREAUDIT
	*/
	public String QUEUEPREPAREAUDIT  ="queue_prepare_audit_result";
	

	/**检查引流状态通知
	* @Fields QUEUEPREPAREAUDIT
	*/
	public String QUEUECHECKDRAINSTATUS  ="QUEUE_CHECK_DRAIN_STATUS";
	
	/** 借款审核结果事件 */
	public String APPLYAUDITRESULTNOTIFY = "APPLYAUDITRESULTNOTIFY";
	
	/**还款计划更新
	* @Fields QUEUEHKBILLUPDATE
	*/
	public String QUEUEHKBILLUPDATE = "QUEUE_HKBILLUPDATE_TODRAIN";
	/**
	 * 借款成功添加活动参与次数
	 */
	public String queueAddActivityTimes = "ACTIVITY_FREQUENCY";
	
	/**
	 * 支付测评结果通知
	 */
	public String CREDITFEEPAYRESULT = "PAYRESULT_CREDITFEE_ZX";
	
	/**
	* @Fields 引流新用户审核
	*/
	public String NEWUSER_REXAMINATION = "XJBK_NEWUSER_REXAMINATION";
	/**
	 * 现金白卡预授信请求MQ_KEY
	 */
	public String XJBK_NEWUSER_YSX = "XJBK_NEWUSER_YSX";

	/**
	 * 现金白卡预授信请求通知推送中心MQ key
	 */
	public static  final String XJBK_NEWUSER_YSX_PUSH_CENTRAL = "XJBK_NEWUSER_YSX_PUSH_CENTRAL";
	/**
	 * 现金白卡还款结果请求通知推送中心MQ key
	 */
	public static  final String XJBK_NEWUSER_REPAYMENT_PUSH_CENTRAL = "XJBK_NEWUSER_REPAYMENT_PUSH_CENTRAL";
}
