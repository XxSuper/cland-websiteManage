package com.maiyajf.base.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈麦芽贷系统各模块业务参数配置编码表〉<br>
 * 〈功能详细描述〉
 *
 * 参数编码按如下规则进行增加<br>
 * 用户中心（MYLOAN_USERS）：以字母A开头，接4位编码，以0001开始，依次往上增加； <br>
 * 接口中心（MYLOAN_MOBILE） ：以字母B开头，接4位编码，以0001开始，依次往上增加；<br>
 * 管理后台（MYLOAN_MANAGER） ：以字母C开头，接4位编码，以0001开始，依次往上增加；<br>
 * 借款中心（MYLOAN_APPLY） ：以字母D开头，接4位编码，以0001开始，依次往上增加；<br>
 * 放款中心（MYLOAN_GRANT） ：以字母E开头，接4位编码，以0001开始，依次往上增加；<br>
 * 监控中心（MYLOAN_MONITOR） ：以字母F开头，接4位编码，以0001开始，依次往上增加；<br>
 * 对账中心（MYLOAN_RECONCI） ：以字母G开头，接4位编码，以0001开始，依次往上增加； <br>
 * 线下进件（MYINCLUSIVE_INTEFACE） ：以字母H开头，接4位编码，以0001开始，依次往上增加；<br>
 * 征信中心（MYLOAN_APPROVAL） ：以字母J开头，接4位编码，以0001开始，依次往上增加； <br>
 * 任务中心（MYLOAN_TASKCENTER） ：以字母K开头，接4位编码，以0001开始，依次往上增加；<br>
 * 资金中心（MYLOAN_FUND） ：以字母I开头，接4位编码，以0001开始，依次往上增加； <br>
 * 活动中心（MYLOAN_ACTIVITY） ：以字母L开头，接4位编码，以0001开始，依次往上增加；<br>
 * 还款中心（MYLOAN_REPAY） ：以字母M开头，接4位编码，以0001开始，依次往上增加；<br>
 * 还款中心（MYOUTER_INTERFACE） ：以字母N开头，接4位编码，以0001开始，依次往上增加；<br>
 * 对账中心(支付)（PAYCENTER_RECONCI） ：以字母O开头，接4位编码，以0001开始，依次往上增加； <br>
 * 商户引流中心（MYLOAN_DRAIN） ：以字母P开头，接4位编码，以0001开始，依次往上增加； <br>
 * @author LG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IModuleParamConfig {
	
	/** 用户中心 */
	public final static String MYLOAN_USERS = "users";
    /** 接口中心 */
	public final static String MYLOAN_MOBILE = "mobile";
    /** 管理后台 */
	public final static String MYLOAN_MANAGER = "manage";
    /** 借款中心 */
	public final static String MYLOAN_APPLY = "apply";
    /** 放款中心 */
	public final static String MYLOAN_GRANT = "grant";
    /** 监控中心 */
	public final static String MYLOAN_MONITOR = "monitor";
    /** 对账中心 */
	public final static String MYLOAN_RECONCI = "reconci";
	
    /** 线下进件 */
	public final static String MYINCLUSIVE_INTEFACE = "inteface";
    /** 征信中心 */
	public final static String MYLOAN_APPROVAL = "approval";
    /** 任务中心 */
	public final static String MYLOAN_TASKCENTER = "taskcenter";
    /** 资金中心 */
	public final static String MYLOAN_FUND = "fund";
    /** 活动中心 */
	public final static String MYLOAN_ACTIVITY = "activity";
	/** 还款中心 */
	public final static String MYLOAN_REPAY = "repay";
	/** 外部接口*/
	public final static String MYOUTER_INTERFACE = "outerInterface";
	/** 罚息中心*/
	public final static String MYLOAN_PUNISH = "punish";
	
	/** 推送中心*/
	public final static String MYLOAN_DATA_PUSH = "mydata-push";

	/** 对账中心（支付） */
	public final static String PAYCENTER_RECONCI = "payreconci";
	
	/**
	* @Fields 商户引流中心
	*/
	public final static String MYLOAN_DRAIN = "drain";
	
    /********* APP接口中心begin **********/
    /** 后台服务停机开关 0-关闭；1-打开 */
	public final static String MYLOAN_MOBILE_SERVICE_ON_OFF = "B0001";
	public final static String MYLOAN_MOBILE_MAX_FILE_SIZE = "B0002";
	public final static String MYLOAN_MOBILE_MAX_LITMIT_SIZE = "B0003";
	public final static String MYLOAN_MOBILE_DRAINAGE_ON_OFF = "B0004";
	/** 采集短信、通讯录、通话记录时间间隔 */
	public final static String MYLOAN_MOBILE_CONTACTS_DATAGATHER_ON_OFF = "B0005";
	public final static String MYLOAN_MOBILE_SMS_DATAGATHER_ON_OFF = "B0006";
	public final static String MYLOAN_MOBILE_CALL_DATAGATHER_ON_OFF = "B0007";
	/** APP端是否展示芝麻分以及手机认证页面 */
	public final static String MYLOAN_MOBILE_SHOW_PHONE_ON_OFF = "B0008";
	public final static String MYLOAN_MOBILE_SHOW_ZHIMA_ON_OFF = "B0009";
	/** APP端是否展示测评页面 */
	public final static String MYLOAN_MOBILE_SHOW_CPF_ON_OFF = "B0010";
	/** 保险开关 */
	public final static String MYLOAN_MOBILE_INSURANCE_ON_OFF = "B0011";
	/** APP端是否展示学历页面 */
	public final static String MYLOAN_MOBILE_SHOW_XL_ON_OFF = "B0012";
	/** 米粒代扣保险开关  1：开启 0：关闭 */
	public final static String MYLOAN_MOBILE_MILIWITHHOLD_INSURANCE_ON_OFF = "B0013";
	/** 保险查看提示语 */
	public final static String MYLOAN_MOBILE_MILIWITHHOLD_COMFIRM_MSG = "B0014";

    /********* APP接口中心end **********/

    /********* 用户中心begin **********/
    /** 淘宝爬虫开关 0：开启 1：关闭 */
	public final static String MYLOAN_USERS_TAOBAO_ON_OFF = "A0001";
    /** 京东爬虫开关 0：开启 1：关闭 */
	public final static String MYLOAN_USERS_JD_ON_OFF = "A0002";
	
	 /** 实名认证有效期 */
	public final static String MYLOAN_USERS_AUTH_MONTH = "A0003";
	 /** 测评费用 */
	public final static String MYLOAN_USERS_MEMBER_CREDITFEE = "A0004";
	//测评送券配置
	public final static String MYLOAN_USERS_MEMBER_CREDITFEE_COUPON = "A0005";
    /********* 用户中心end **********/

    /********* 管理后台begin **********/
    /** 淘宝爬虫后台查询开关 0：开启 1：关闭 */
	public final static String MYLOAN_MANAGER_taobao_on_off = "C0001";
    /** 京东爬虫后台查询开关 0：开启 1：关闭 */
	public final static String MYLOAN_MANAGER_jd_on_off = "C0002";
	/**TXT批量导入用户最大总量*/
	public final static String MYLOAN_MANAGER_TXT_MAX_TOTAL = "C0003";
	/**TXT批量导入分批解析每批的量 */
	public static final String MYLOAN_MANAGER_BATCH_COUNT = "C0004";
	
    /********* 管理后台end **********/
	
	/********* 活动中心begin **********/
	public static final String MYLOAN_ACTIVITY_BATCH_PUSH_USER_COUNT = "L0001";
	/********* 活动中心end **********/

    /********* 征信中心begin **********/
    /** 芝麻分直接放款开关 0：开启 1：关闭 */
	public final static String MYLOAN_APPROVAL_ZHIMASCORE_A_ON_OFF = "J0001";
    /** IOS芝麻分直接放款开关 0：开启 1：关闭 */
	public final static  String MYLOAN_APPROVAL_IOS_ZHIMASCORE_A_ON_OFF = "J0002";
    /** IOS小贷申请时间开关 0：开启 1：关闭 */
	public final static String MYLOAN_APPROVAL_IOS_XDAPPLYTIME_ON_OFF = "J0003";
    /** IOS身份证归属地开关 0：开启 1：关闭 */
	public final static String MYLOAN_APPROVAL_IOS_IDCARDHOME_ON_OFF = "J0004";
    /** IOS设备匹配数开关 0：开启 1：关闭 */
	public final static String MYLOAN_APPROVAL_IOS_DEVICENUM_ON_OFF = "J0005";
    /** 芝麻分直接放款配置值 */
	public final static String MYLOAN_APPROVAL_ZHIMASCORE_A_VALUE = "J0006";
    /** IOS芝麻分直接放款配置值 */
	public final static String MYLOAN_APPROVAL_IOS_ZHIMASCORE_A_VALUE = "J0007";
    /** IOS小贷申请时间配置值 */
	public final static String MYLOAN_APPROVAL_IOS_XDAPPLYTIME_VALUE = "J0008";
    /** IOS身份证归属地配置值 */
	public final static String MYLOAN_APPROVAL_IOS_IDCARDHOME_VALUE = "J0009";
    /** IOS设备匹配数配置值 */
	public final static String MYLOAN_APPROVAL_IOS_DEVICENUM_VALUE = "J0010";
	/**分期安卓聚信力关机比例<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_JXLCLOSEPERCENT_VALUE = "J0030";
	/**分期安卓12个月消费金额排名<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_CUSTOMAMTORDER_VALUE = "J0031";	
	/**分期安卓12个月的消费次数排名<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_CUSTOMCNTORDER_VALUE = "J0032";
	/**分期安卓12个月有消费月份占比>指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_CUSTOMMONTHPERCENT_VALUE = "J0033";
	/**分期安卓12个月的消费总金额>指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_CUSTOMTOTALAMT_VALUE = "J0034";
	/**分期安卓聚信力夜间通话占比<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_JXLNIGHTCALLPERCENT_VALUE = "J0035";
	/**分期安卓聚信力手机使用月份>指定数值*/
	public final static String MYLOAN_APPROVAL_FQANDROID_JXLPHONEUSEMONTH_VALUE = "J0036";
	/**分期IOS借款设备登录用户匹配数=指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_APPLYDEVICELOGINCOUNT_VALUE = "J0050";
	/**分期IOS申请时间不在指定范围之内*/
	public final static String MYLOAN_APPROVAL_FQIOS_APPLYTIMENOTIN_VALUE = "J0051";
	/**分期IOS12个月平均消费次数>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_AVGCUSTOMCNT_VALUE = "J0052";	
	/**分期IOS聚信力最近3个月通话次数>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_JXLLATELYTHREEMONTHCALLCOUNT_VALUE = "J0053";
	/**分期IOS12个月消费金额平均排名<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_AVGCUSTOMAMT_VALUE = "J0054";
	/**分期IOS12个月消费城市数量>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_CUSTOMCITYCOUNT_VALUE = "J0055";
	/**分期IOS12个月消费次数排名<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_CUSTOMCNTORDER_VALUE = "J0056";
	/**分期IOS12个月消费月份占比>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_CUSTOMMONTHPERCENT_VALUE = "J0057";
	/**分期IOS12个月消费总金额>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_CUSTOMTOTALAMT_VALUE = "J0058";
	/**分期IOS12个月金融行业消费金额>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_JRHYCUSTOMAMT_VALUE = "J0059";
	/**分期IOS身份证归属地不在指定范围,地区之间使用英文状态下逗号分割*/
	public final static String MYLOAN_APPROVAL_FQIOS_IDNOADDRESSNOTIN_VALUE = "J0060";
	/**分期IOS12个月最大消费金额>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_MAXCUSTOMAMT_VALUE = "J0061";
	/**分期IOS聚信力夜间通话占比<=指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_JXLNIGHTCALLPERCENT_VALUE = "J0062";
	/**分期IOS12个月零售行业消费金额>指定数值*/
	public final static String MYLOAN_APPROVAL_FQIOS_LSHYCUSTOMAMT_VALUE = "J0063";	
	/**小贷安卓借款设备登录用户匹配数=指定数值*/
	public final static String MYLOAN_APPROVAL_XDANDROID_APPLYDEVICELOGINCOUNT_VALUE = "J0070";
	/**小贷安卓申请时间不在指定范围之内*/
	public final static String MYLOAN_APPROVAL_XDANDROID_APPLYTIMENOTIN_VALUE = "J0071";
	/**小贷安卓身份证归属地不在指定范围,地区之间使用英文状态下逗号分割*/
	public final static String MYLOAN_APPROVAL_XDANDROID_IDNOADDRESSNOTIN_VALUE = "J0072";
	/**小贷安卓宜信分>指定值通过准入项*/
	public final static String MYLOAN_APPROVAL_XDANDROID_YXSCORE_VALUE = "J0073";
	/**小贷安卓百融分>指定值通过准入项*/
	public final static String MYLOAN_APPROVAL_XDANDROID_BRSCORE_VALUE = "J0074";
	/**小贷安卓麦芽征信系统评分分>指定值通过准入项*/
	public final static String MYLOAN_APPROVAL_XDANDROID_MAIYASCORE_VALUE = "J0075";
	/**小贷安卓身份证归属地在该地区通过准入项,各个地区使用英文状态下逗号分隔*/
	public final static String MYLOAN_APPROVAL_XDANDROID_IDNOADDRESSIN_VALUE = "J0076";
	/**小贷安卓通讯录有效个数>指定值通过准入项*/
	public final static String MYLOAN_APPROVAL_XDANDROID_CONTACTCOUNT_VALUE = "J0077";
	/**小贷安卓芝麻分>指定值通过准入项*/
	public final static String MYLOAN_APPROVAL_XDANDROID_ZMSCORE_VALUE = "J0078";
	/**小贷IOS借款设备登录用户匹配数=指定数值*/
	public final static String MYLOAN_APPROVAL_XDIOS_APPLYDEVICELOGINCOUNT_VALUE = "J0090";
	/**小贷IOS申请时间不在指定范围之内*/
	public final static String MYLOAN_APPROVAL_XDIOS_APPLYTIMENOTIN_VALUE = "J0091";
	/**小贷IOS身份证归属地不在指定范围,地区之间使用英文状态下逗号分割*/
	public final static String MYLOAN_APPROVAL_XDIOS_IDNOADDRESSNOTIN_VALUE = "J0092";
	/**征信大数据通讯录负面信息接口告警开关设置*/
	public final static String MYLOAN_APPROVAL_BIGDATA_CONTACTS_VALUE = "J0100";
	/**征信大数据短信负面关键字接口告警开关设置*/
	public final static String MYLOAN_APPROVAL_BIGDATA_SMSNEGATIVE_VALUE = "J0101";
	/**征信大数据短信复合规则接口告警开关设置*/
	public final static String MYLOAN_APPROVAL_BIGDATA_SMSOVERDUE_VALUE = "J0102";
	/**征信大数据系统评分接口告警开关设置*/
	public final static String MYLOAN_APPROVAL_BIGDATA_MAIYASCORE_VALUE = "J0103";
    /********* 征信中心end **********/
	
	/********* 借款中心begin **********/
	/**小额贷借款时直接放款的芝麻分阈值*/
	public final static String MYLOAN_APPLY_ZHIMASCORE_XIAODAI_VALUE = "D0001";
	/**分期贷借款时直接放款的芝麻分阈值*/
	public final static String MYLOAN_APPLY_ZHIMASCORE_FENQI_VALUE = "D0002";
	/**借款直接拒绝的芝麻分阈值*/
	public final static String MYLOAN_APPLY_ZHIMASCORE_REFUSE_VALUE = "D0003";
	/**小贷人工信审开关*/
	public final static String MYLOAN_APPLY_XXD_MANAUL_AUDIT_VALUE = "D0004";
	/**分期人工信审开关*/
	public final static String MYLOAN_APPLY_FQD_MANAUL_AUDIT_VALUE = "D0005";
	/**小贷复借审核规则链开关 */
	public final static String MYLOAN_APPLY_XXD_FUJIE_AUDIT_RULECHAIN_VALUE = "D0006"; 
	
	/** 麦芽贷路由前校验开关   0:关闭   1:打开 */
	public final static String MYLOAN_APPLY_MAIYA_PREROUTECHEK_VALUE = "D0007"; 
	/** 安心花路由前校验开关   0:关闭   1:打开 */
	public final static String MYLOAN_APPLY_ANXINHUA_PREROUTECHEK_VALUE = "D0008"; 
	/** 鸭梨分期路由前校验开关   0:关闭   1:打开 */
	public final static String MYLOAN_APPLY_MAIYAFQ_PREROUTECHEK_VALUE = "D0009"; 
	/** 付融宝借款端路由前校验开关   0:关闭   1:打开 */
	public final static String MYLOAN_APPLY_FRBAO_PREROUTECHEK_VALUE = "D0010"; 
	/********* 借款中心end **********/
	
	/********* 资金中心begin **********/
	/**小视银行卡实名认证限制次数*/
	public final static String MYLOAN_FUND_XS_CARD_VERIFY_LIMIT_COUNT_VALUE = "I0001";
	/**小视银行卡实名认证限制天数*/
	public final static String MYLOAN_FUND_XS_CARD_VERIFY_LIMIT_DAYS_VALUE = "I0002";
	/**付融宝灰度控制开关*/
	public final static String MYLOAN_FUND_TEST_GRANT_SWITCH = "I0003";
	/**付融宝灰度控制已推送的数量*/
	public final static String MYLOAN_FUND_TEST_PUSH_COUNT = "I0004";
	/**付融宝灰度控制总数量*/
	public final static String MYLOAN_FUND_TEST_TOTAL_COUNT = "I0005";
	/**麦芽金服灰度控制开关*/
	public final static String MYLOAN_FUND_TEST_GRANT_MYJF_SWITCH = "I0006";
	/**麦芽金服灰度控制已推送的数量*/
	public final static String MYLOAN_FUND_TEST_PUSH_MYJF_COUNT = "I0007";
	/**麦芽金服灰度控制总数量*/
	public final static String MYLOAN_FUND_TEST_TOTAL_MYJF_COUNT = "I0008";
	/********* 资金中心end **********/
	
    /********* 外部接口中心begin **********/
    /** 客户端手机认证数据采集指定供应商 葫芦数据：Gourd，聚信力：JuXinLi，麦芽（内部爬虫）：MaiYa*/
	public final static String MYOUTER_INTERFACE_PHONE_AUTHENTICATION_SUPPLIER = "N0001";

    /********* 外部接口中心end **********/
	
	

	/********* 任务中心中心begin **********/
	/** 未逾期客户提醒短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4UNOVERDUE_ON_OFF = "K0001";
	
	/** 宽限期客户提醒短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4GRACEPERIOD_ON_OFF = "K0002";
	
	/** M1阶段提醒短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4M1REMIND_ON_OFF = "K0003";
	
	/** M1阶段催缴短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4M1URGE_ON_OFF = "K0004";
	
	/** M2阶段资信不良短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4M2CREDIT_ON_OFF = "K0005";
	
	/** M2阶段催缴短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4M2URGE_ON_OFF = "K0006";
	
	/** 承诺还款未兑现短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4COMMITMENTUNREALIZED_ON_OFF = "K0007";
	
	/** M1阶段提醒短信(分期)短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSG4M1REMIND4INSTALMENT_ON_OFF = "K0008";
	
	/** 全额结清转法务短信（分期）短信发送开关  0-关闭；1-打开  */
	public final static String SENDSHORTMSGURG4INSTALMENT_ON_OFF = "K0009";
	
	/********* 任务中心中心end **********/

	/************放款中心*****************/
	/***超时路由设置****/
	public final static String MYLOAN_GRANT_FUNDROUTE_TIMEOUT_HOURS = "F0001";
	

	/********* 对账中心begin **********/
    /** 支付建设上线灰度时间段内部充值对账取旧充值记录开关 0：开启 1：关闭 */
	public final static String MYLOAN_RECONCI_INNER_RECHARGE_OLD_ON_OFF = "G0001";
    /********* 对账中心end **********/
	
	/********* 监控中心begin **********/
    /** 快捷支付成功率监控阈值 */
	public final static String MYLOAN_MONITOR_PAY_SUCCESS_RATE_JK = "F0010";
	/** 支付成功率监控当前日期前几天（单位：天数） */
	public final static String MYLOAN_MONITOR_PAY_SUCCESS_RATE_DAYS = "F0011";
	/** 快捷支付超时交易监控开始时间，当前时间前推小时数（单位：小时）*/
	public final static String MYLOAN_MONITOR_PAY_KJ_OVER_TIME_BEGIN_HOURS = "F0012";
	/** 快捷支付超时交易监控结束时间 ，当前时间前推小时数（单位：小时）*/
	public final static String MYLOAN_MONITOR_PAY_KJ_OVER_TIME_END_HOURS = "F0013";
	/** 账户余额监控短信发送手机号 */
	public final static String MYLOAN_MONITOR_ACCOUNT_BALANCE_MOBILES = "F0014";
	/** 业务监控短信发送手机号 */
	public final static String MYLOAN_MONITOR_BUSINESS_MOBILES = "F0015";
	/** 征信、外部接口监控短信发送手机号 */
	public final static String MYLOAN_MONITOR_CREDIT_MOBILES = "F0016";
	/** 支付系统监控短信发送手机号 */
	public final static String MYLOAN_MONITOR_PAYCENTER_MOBILES = "F0017";
	/** 运营部相关监控短信发送手机号 */
	public final static String MYLOAN_MONITOR_OPERATION_MOBILES = "F0018";
	/** 代扣超时交易监控开始时间，当前时间前推小时数（单位：小时）*/
	public final static String MYLOAN_MONITOR_PAY_DK_OVER_TIME_BEGIN_HOURS = "F0019";
	/**代扣超时交易监控结束时间 ，当前时间前推小时数（单位：小时）*/
	public final static String MYLOAN_MONITOR_PAY_DK_OVER_TIME_END_HOURS = "F0020";
	/**爬虫监控短信发送手机号*/
	public static final String MYLOAN_MONITOR_CRAWL_MOBILES = "F0021";
	/**电子合同在线签署系统会员注册失败监控短信发送手机号*/
	public static final String MYLOAN_MONITOR_ECONTRACT_REGISTER_FAIL_MOBILES = "F0022";
	/**电子合同在线签署系统Topic积压监控短信发送手机号*/
	public static final String MYLOAN_MONITOR_ECONTRACT_TOPIC_BACKLOG_MOBILES = "F0023";
	/**电子合同在线签署系统Topic积压告警阀值*/
	public static final String MYLOAN_MONITOR_ECONTRACT_TOPIC_BACKLOG_VALVE = "F0024";
	/**电子合同在线签署系统创建合同Topic积压告警阀值*/
	public static final String MYLOAN_MONITOR_ECONTRACT_CREATECONTRACT_TOPIC_BACKLOG_VALVE = "F0025";
    /********* 监控中心end **********/
	
	/********* 还款中心 **********/
	/**批量代收时的批量大小*/
	public final static String MYLOAN_REPAY_COLLECTION_EXE_BATCHSIZE="H0001";
	/**生成代收任务时不光检查到期当天的账单，逾期2天的账单也在检查之列*/
	public final static String MYLOAN_REPAY_COLLECTION_GENERATE_BILLOVERDAYS="H0002"; 
	/**生成代收任务的批量大小*/
	public final static String MYLOAN_REPAY_COLLECTION_GEN_BATCHSIZE="H0003";
	/**补单任务补偿前几小时之内的数据*/
	public final static String MYLOAN_REPAY_SUPPLEMENTDEBIT_BEGIN_HOURS="H0004";
	/********* 还款中心end **********/
	
	
	/********* 对账中心（支付系统） **********/
	/**京东快捷明细对账开关*/
	public final static String PAYCENTER_RECON_JD_KJ_SWITCH_VALUE = "O0001";
	/**易宝快捷明细对账开关*/
	public final static String PAYCENTER_RECON_YB_KJ_SWITCH_VALUE = "O0002";
	/**中金代扣明细对账开关*/
	public final static String PAYCENTER_RECON_ZJ_DK_SWITCH_VALUE = "O0003";
	/**银生宝代扣明细对账开关*/
	public final static String PAYCENTER_RECON_YSB_DK_SWITCH_VALUE = "O0004";
	/**快捷通代扣明细对账开关*/
	public final static String PAYCENTER_RECON_KJT_DK_SWITCH_VALUE = "O0005";
	
	

	/*********商户引流中心 **********/
	/**数据解析重试时间  */
	public final static String MYLOAN_DRAIN_DATAANALYSIS_HOURS = "P0001";
	
	/**
	* @Fields 放款状态推送次数
	*/
	public final static String MYLOAN_DRAIN_GRANTSTATUS_PUSH_TIMES = "P0002";
	/**
	* @Fields 审核状态推送次数
	*/
	public final static String MYLOAN_DRAIN_AUDITSTATUS_PUSH_TIMES = "P0003";
	/**
	* @Fields 预售信状态推送次数
	*/
	public final static String MYLOAN_DRAIN_PRECREDITSTATUS_PUSH_TIMES = "P0004";
	
	
	public final static Map<String, String> modelMap = new HashMap<String, String>();  
	static {  
		modelMap.put(MYLOAN_USERS, "用户中心");
		modelMap.put(MYLOAN_MOBILE, "接口中心");
		modelMap.put(MYLOAN_MANAGER, "管理后台");
		modelMap.put(MYLOAN_APPLY, "借款中心");
		modelMap.put(MYLOAN_GRANT, "放款中心");
		modelMap.put(MYLOAN_MONITOR, "监控中心");
		modelMap.put(MYLOAN_RECONCI, "对账中心");
		modelMap.put(MYINCLUSIVE_INTEFACE, "线下进件");
		modelMap.put(MYLOAN_APPROVAL, "征信中心");
		modelMap.put(MYLOAN_TASKCENTER, "任务中心");
		modelMap.put(MYLOAN_FUND, "资金中心");
		modelMap.put(MYLOAN_ACTIVITY, "活动中心");
		modelMap.put(MYLOAN_REPAY, "还款中心");
		modelMap.put(MYLOAN_PUNISH, "罚息中心");
		modelMap.put(MYOUTER_INTERFACE, "外部接口中心");
		modelMap.put(MYLOAN_DATA_PUSH, "推送中心");
		modelMap.put(PAYCENTER_RECONCI, "对账中心(支付系统)");
		modelMap.put(MYLOAN_DRAIN, "商户引流中心");
	}
	
}
