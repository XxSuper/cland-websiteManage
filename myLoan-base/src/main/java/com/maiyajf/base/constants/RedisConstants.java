/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   LG
 * Date:     2016年7月29日 下午4:04:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.base.constants;

/**
 * redis常量类<br>
 * 〈功能详细描述〉
 *
 * @author LG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RedisConstants {

    /**
     * 10秒（毫秒单位）
     */
    public static final int SEC_10_IN_MILL = 10 * 1000;

    /**
     * 1分钟（毫秒单位）
     */
    public static final int MIN_IN_MILL = 60 * 1000;

    /**
     * 10分钟
     */
    public static final int TEN_IN_MIN = 10 * 60;

    /**
     * 1个小时
     */
    public static final int HOUR_1 = 1 * 60 * 60;

    /**
     * 3个小时
     */
    public static final int HOUR_3 = 3 * 60 * 60;

    /**
     * 一天的时间
     */
    public static final int DAYTIME = 24 * 60 * 60;

    /**
     * 三天的时间
     */
    public static final int THRESSDAYTIME = 3 * 24 * 60 * 60;
    /**
     * 一周的时间
     */
    public static final int WEEKTIME = 7 * 24 * 60 * 60;

    /**
     * 15天
     */
    public static final int HALF_MONTH_TIME = 15 * 24 * 60 * 60;

    /**
     * 一个月时间
     */
    public static final int MONTHTIME = 30 * 24 * 60 * 60;

    /**
     * 20年的时间
     */
    public static final int YEARTIME = 20 * 360 * 24 * 60 * 60;

    /**
     * 通用过期时间（1个小时）
     */
    public static final int COMMON_EXPIRE_TIME = 60 * 60;

    /**
     * key 匹配
     */
    public static final String KEYSPATTERN = "*";

    /**
     * 特殊日期表zd_specialDay Redis Key
     */
    public static final String SPECIAL_DAY_KEY = "zd:specialDay:";
    /**
     * 银行管理 Redis Key
     */
    public static final String CONF_BANK_KEY = "zd:bank:conf:";

    /**
     * 渠道银行管理 Redis Key
     */
    public static final String CHA_BANK_KEY = "zd:bank:coop:";

    /**
     * 银行支付渠道路由 Redis Key
     */
    public static final String BANK_CHANNEL_ROUTE_KEY = "zd:bank:rount:";
    
    /**
     * 资金方支付渠道路由 Redis Key
     */
    public static final String FUND_CHANNEL_ROUTE_KEY = "zd:fund:rount:";
    
    /**
     * 资金方费率信息 Redis Key
     */
    public static final String FUND_SOURCE_FEERATE_INFO_KEY = "zd:fund:rate:";
    /**
     * 资金方信息 Redis Key
     */
    public static final String FUND_SOURCE_INFO_KEY = "zd:fund:info:";
    /**
     * 渠道产品信息 Redis Key
     */
    public static final String TRANS_CHANNEL_KEY = "zd:trans:channel:";

    /**
     * 字典表编码CODE Redis Key
     */
    public static final String DICT_CODE_KEY = "zd:code:";
    
    //借款用途
    public static final String APPLY_USAGE="APPLY_USAGE";
    
    /**
     * 工作性质
     */
    public static final String WORK_NATURE="WORK_NATURE";

    /**
     * 请求黑名单 Redis Key
     */
    public static final String REQUEST_BLACKLIST = "request:black:";

    /**
     * 请求白名单 Redis Key
     */
    public static final String REQUEST_WHITELIST = "request:white:";

    /**
     * 用户资料缓存KEY
     */
    public static final String KEY_MAIYA_USER_INFO = "maiya:user:info:";

    /**
     * 接口限流
     */
    public static final String MOBILE_SERVER_LIMIT = "mobile:server:limit";
    
    /**
     * 参数配置
     */
    public static final String SYS_PARAM_CONFIG = "sys:param:config:";
    
    /**同步锁key start*/
    /**
     * 用户借款检验缓存KEY
     */
    public static final String KEY_APPLY_CHECK = "maiya:apply:check:";
    /**同步锁key end*/
    
    /**
     * 还款同步锁缓存KEY HEADER
     */
    public static final String KEY_REPAY_CHECK = "maiya:repay:check:";
    
    /**
    * @Fields KEY_CREDITBILL_CHECK
    */
    public static final String KEY_CREDITBILL_CHECK = "maiya:creditBill:check:";
    /**
     * 用户banner活动KEY
     */
    public static final String KEY_MAIYA_BANNER_INFO = "maiya:banner:info";

    /**
     * 用户found活动KEY
     */
    public static final String KEY_MAIYA_FOUND_INFO = "maiya:found:info";

    /**
     * 用户浮窗活动KEY
     */
    public static final String KEY_MAIYA_FLOATWINDOW_INFO = "maiya:floatwindow:info";

    /**
     * 用户广告活动KEY
     */
    public static final String KEY_MAIYA_AD_INFO = "maiya:ad:info";

    /**
     * 用户大资料项缓存
     */
    public static final String MAIYA_USERS_INFO_DETAIL = "maiya:users:info:detail";

    /**
     * 用户大资料项缓存
     */
    public static final String MAIYA_USERS_INFO_DETAILRELATION = "maiya:users:info:detailrelation";

    /**
     *活动图片KEY
     */
    public static final String KEY_MAIYA_ACTIVITY_PHOTO_INFO = "maiya:activity:photo:info";
    /**
     * 用户闪屏活动KEY
     */
    public static final String KEY_MAIYA_SCREEN_INFO = "maiya:screen:info";

    /**
     * 短信发送限流
     */
    public static final String KEY_MAIYA_MOBILE_INFO = "maiya:mobile:limit:max";
    
    /**
     * 麦芽贷计算器
     */
    public static final String KEY_MAIYA_JSQ_INFO = "maiya:jsq:info";

    /**
     * 三方商户信息
     */
    public static final String KEY_MAIYA_THIRD_COOPERATOR_INFO = "maiya:third:cooperator:info";
    
    /**
     * 借款产品信息
     */
	public static final String KEY_MAIYA_PRODUCT_INFO = "zd:product:";
	/**
     * 借款产品费率信息
     */
	public static final String KEY_MAIYA_PRODUCT_FEERATE_INFO  = "zd:product:feerate:";
	
	/**
     * 借款产品服务费策略信息
     */
	public static final String KEY_MAIYA_PRODUCT_SERVICEEFEE_INFO  = "zd:product:servicefee:";
    
    public RedisConstants() {

    }
    /**
     * 不过期
     */
    public static final int FOREVER = -1;
    
    
    // 支付系统	begin
    /**
     * 卡BIN Redis Key
     */
    public static final String CARDBIN_KEY = "pay:zd:cardbin:";
    
    // 支付系统	end
    
    /**
     * 抽奖平台活动详情
     */
    public static final String CJ_ACTIVITY_INFO_KEY = "cj:activity:info:";
    
    /**
     * 抽奖平台奖品信息
     */
    public static final String CJ_AWARDPOOL_LIST_KEY = "cj:awardpool:list:";
    
    /**
     * 抽奖平台用户抽奖次数
     */
    public static final String CJ_LOTTERY_TIMES_KEY = "cj:lottery:times:";
    
    /**
     * 抽奖平台抽奖机会配置
     */
    public static final String CJ_CHANCE_CONFIG_KEY = "cj:chance:config:";
    
    /**
     * 引流商户的配置
     */
    public static final String DR_DRAIN_MERCHANT_PRODUCT = "maiya:drain:merchant:product:";
    
    /**
     * 引流商户的配置
     */
    public static final String DR_DRAIN_MERCHANT_BANKS = "maiya:drain:merchant:banks:";
    
    /**
     * 一定时间内同一用户申请借款次数存放在redis中的header
     */
    public static final String REDIS_HEADER_LOAN_TIMES_LIMIT = "REDIS_HEADER_LOAN_TIMES_LIMIT:";

    /**
     * 网关层的用户信息当天推送次数
     */
    public static final String API_GATEWAY_PUSHUSERINFO_COUNT = "maiya:apigateway:pushUserInfo:count:";

}
