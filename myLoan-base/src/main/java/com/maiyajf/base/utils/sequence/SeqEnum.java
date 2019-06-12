package com.maiyajf.base.utils.sequence;

import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ConcurrentMap;

/**
 * INFO: 同步ORACLE的sys_seq表记录
 * User: zhaokai
 * Date: 2016/11/3
 * Version: 1.0
 * History: <p>如果有修改过程，请记录</P>
 */

public enum SeqEnum {
    HY_SMALLTASK("HY_SMALLTASK", "RWZB", "小额任务总表编号"),
    HY_SMALLTASKINFO("HY_SMALLTASKINFO", "RWSRXX", "小额任务输入信息表编号"),
    HY_SMALLENTRYTASK("HY_SMALLENTRYTASK", "ZRRW", "小额准入任务表编号"),
    HY_SMALLENTRYTASKNODE("HY_SMALLENTRYTASKNODE", "ZRRWJD", "小额准入任务节点表编号"),
    HY_SMALLSCORETASK("HY_SMALLSCORETASK", "HKPFRW", "小额还款评分任务表编号"),
    HY_SMALLSCORESUBTASK("HY_SMALLSCORESUBTASK", "HKPFZ", "小额还款评分子任务表编号"),
    HK_BADCOLLTASKLOG("HK_BADCOLLTASKLOG", "HZDSRZ", "坏账代收日志表编号（暂不考虑）"),
    HY_MSSCORESUBTASKNODE("HY_MSSCORESUBTASKNODE", "HKZJD", "小额还款评分子任务节点表编号"),
    HK_BADCOLLTASK("HK_BADCOLLTASK", "HZDSRW", "坏账代收任务表编号（暂不考虑）"),
    WJ_USERFILE("WJ_USERFILE", "WJXX", "用户文件信息表编号"),
    HY_SMALLENTRYCHECK("HY_SMALLENTRYCHECK", "ZRXSH", "用户小额准入项审核表编号"),
    HY_MSREPAYEVALUATESCORE("HY_MSREPAYEVALUATESCORE", "HKZLDF", "用户小额还款子类得分表编号"),
    HY_MEMBERREGISTER("HY_MEMBERREGISTER", "YHXXZC", "用户信息注册表编号"),
    ZJ_FUNDACCOUNT("ZJ_FUNDACCOUNT", "HYZJZH", "会员资金账户表编号"),
    ZJ_FUNDFROZENINFO("ZJ_FUNDFROZENINFO", "ZJDJJL", "资金冻结记录表编号"),
    ZJ_MEMBERFUNDSERIAL("ZJ_MEMBERFUNDSERIAL", "HYZJLS", "会员资金流水表编号"),
    HY_QUICKPASSCARD("HY_QUICKPASSCARD", "KJZFK", "快捷支付银行卡表编号"),
    HY_CARDCERLOG("HY_CARDCERLOG", "RZRZ", "银行卡认证日志表编号"),
    HY_COLLECTIONCARD("HY_COLLECTIONCARD", "DSKBD", "代收银行卡绑定表编号"),
    HY_LOANBINDCARD("HY_LOANBINDCARD", "JKKBD", "借款银行卡绑定表编号"),
    ZJ_RECHARGERECORD("ZJ_RECHARGERECORD", "CZJL", "充值记录表编号"),
    HY_OUTAPPLY("HY_OUTAPPLY", "TXSQ", "会员提现申请表编号"),
    HY_OUTAPPLYCHECK("HY_OUTAPPLYCHECK", "TXSHJL", "会员提现审核记录表编号"),
    HZ_COOPERATION("HZ_COOPERATION", "YWHZHB", "业务合作伙伴表编号"),
    HZ_ENTERPRISEREGISTER("HZ_ENTERPRISEREGISTER", "QYDJ", "企业登记表编号"),
    HZ_PERSONALREGISTER("HZ_PERSONALREGISTER", "GRDJ", "个人登记表编号"),
    JK_APPLY("JK_APPLY", "JKSQ", "借款申请表编号"),
    JK_MANUALAUDITTASK("JK_MANUALAUDITTASK", "RGXSRW", "借款人工信审任务表编号"),
    JK_CONTRACT("JK_CONTRACT", "HT", "借款合同表编号"),
    JK_GRANTAUDIT("JK_GRANTAUDIT", "FKSH", "放款审核表编号"),
    JK_GRANTTASK("JK_GRANTTASK", "FKRW", "放款任务表编号"),
    JK_GRANTAUDITLOG("JK_GRANTAUDITLOG", "FKSHRZ", "放款审核日志表编号"),
    JK_GRANTEXECUTELOG("JK_GRANTEXECUTELOG", "FKZXRZ", "放款执行日志表编号"),
    JK_GRANTRECORD("JK_GRANTRECORD", "FKJL", "放款记录表编号"),
    JK_PAYBATCH("JK_PAYBATCH", "FKDFPC", "放款代付批次表编号"),
    JK_PAYRECORD("JK_PAYRECORD", "FKDFJL", "放款代付记录表编号"),
    HK_BILL("HK_BILL", "HKZD", "还款账单表编号"),
    HK_REPAYRECORD("HK_REPAYRECORD", "HKJL", "还款记录表编号"),
    HK_REPAYSPLITRECORD("HK_REPAYSPLITRECORD", "HKFZJL", "还款分账记录表编号"),
    HK_COLLECTIONTASK("HK_COLLECTIONTASK", "DSRW", "代收任务表编号"),
    HK_COLLECTIONRECORD("HK_COLLECTIONRECORD", "DSJL", "代收记录表编号"),
    HK_COLLECTIONTASKLOG("HK_COLLECTIONTASKLOG", "DSRZ", "代收日志表编号"),
    
    HK_REPAYBILL("HK_REPAYBILL", "HKDB", "还款单表"),
    HK_RECHARGEBILL("HK_RECHARGEBILL", "HKCZD", "还款充值单"),
    
    JS_PUNISHRECORD("JS_PUNISHRECORD", "FXJL", "罚息记录表编号"),
    SYS_USER("SYS_USER", "XTYH", "系统用户表编号"),
    SYS_ROLE("SYS_ROLE", "XTJS", "系统角色表编号"),
    SYS_MENU("SYS_MENU", "XTCD", "系统菜单表编号"),
    SYS_PERMISSION("SYS_PERMISSION", "XTQX", "系统权限表编号"),
    ZJ_PRODUCT("ZJ_PRODUCT", "CP", "产品表编号"),
    ZD_TABCATEGORY("ZD_TABCATEGORY", "BQFL", "标签分类表编号"),
    ZD_TAB("ZD_TAB", "BQ", "标签表编号"),
    ZD_REFUSEREASON("ZD_REFUSEREASON", "JJYYZD", "拒绝原因字典表编号"),
    ZD_MAPROJECTCLASS("ZD_MAPROJECTCLASS", "SHXFL", "人工审核项分类表编号"),
    ZD_MAPROJECT("ZD_MAPROJECT", "SHXM", "人工审核项目表编号"),
    SYS_PARAMETERGROUP("SYS_PARAMETERGROUP", "CSJH", "参数集合主表编号"),
    HD_ACTIVITYINFO("HD_ACTIVITYINFO", "HDFB", "活动发布表编号"),
    ZD_VERSIONUPDATELOG("ZD_VERSIONUPDATELOG", "BBGX", "版本更新日志表编号"),
    HY_USERINFO("HY_USERINFO", "YHXX", "用户信息表编号"),
    HY_LINKMANREALTION("HY_LINKMANREALTION", "LXRGX", "联系人关系表编号"),
    PF_SMALLENTRYCLASS("PF_SMALLENTRYCLASS", "ZRDL", "小额准入大类表编号"),
    PF_SMALLENTRY("PF_SMALLENTRY", "ZRX", "小额准入项表编号"),
    PF_SMALLREPAYMENTCLASS("PF_SMALLREPAYMENTCLASS", "HKPFDL", "还款评分大类表编号"),
    HY_SMALLREPAYEVALUATEDEF("HY_SMALLREPAYEVALUATEDEF", "HKPFZX", "小额评分还款评估子类项表编号"),
    CS_URGENTRECALLTASK("CS_URGENTRECALLTASK", "CSURT", "会员催收任务表编号"),
    CS_TRANSFERAPPLICATION("CS_TRANSFERAPPLICATION", "CSTA", "催收转单申请表"),
    CS_URGENTRECALLRECORDS("CS_URGENTRECALLRECORDS", "CSURR", "催收记录表"),
    DZ_CHECKLEDGERRECORD("DZ_CHECKLEDGERRECORD", "ZZHD", "总账核对记录表"),
    DZ_RECHARGEBILL("DZ_RECHARGEBILL", "CZZD", "充值账单表"),
    DZ_COLLECTIONBILL("DZ_COLLECTIONBILL", "DSZD", "代收账单表"),
    DZ_PAYBILL("DZ_PAYBILL", "DFZD", "代付账单记录表"),
    HK_OFFLINEREPAYAPPLY("HK_OFFLINEREPAYAPPLY", "XXHKSQ", "会员线下还款申请表编号"),
    HK_OFFLINEREPAYAPPLYCHECK("HK_OFFLINEREPAYAPPLYCHECK", "XXHKSQSH", "会员线下还款申请审核表编号"),
    HD_USERTICKET("HD_USERTICKET", "YHUHQ", "用户优惠券表编号"),
    HY_OUTCARDCER("HY_OUTCARDCER", "HYRZ", "会员银行卡认证表"),
    HY_CARDCERAPPLY("HY_CARDCERAPPLY", "HYRZSQ", "会员银行卡认证申请表"),
    HD_COUPONINFO("HD_COUPONINFO", "YHQPZXX", "优惠券配置信息表"),
    HY_RULECHAINTASK("HY_RULECHAINTASK", "GZLRWZB", "规则链执行任务总表编号"),
    HY_RULETASK("HY_RULETASK", "GZLRW", "规则链任务执行编号"),
    HY_RULETASKNODE("HY_RULETASKNODE", "GZLRWJD", "规则节点任务编号"),
    HY_CREDITBINDCARD("HY_CREDITBINDCARD", "RWZB", "用户信用卡绑定表编号"),
    HD_THIRDCOOPERATOR("HD_THIRDCOOPERATOR", "SFHZ", "三方合作商户表编号"),
    
    // 支付建设增加
    PAY_DEBITREBILL("PAY_DEBITREBILL", "KKZFD", "扣款支付单编号"),
    // 用户群编码
    HD_USERGROUP("HD_USERGROUPTMP", "YHQ", "用户群编号"),
    // 奖项编码
    CJ_AWARDITEM("CJ_AWARDPOOLTMPITEM", "JXBH", "奖项编号"),
    // 奖池编码
    CJ_AWARDPOOL("CJ_AWARDPOOLTMP", "JCBH", "奖池编号"),
    // 活动用户群编号
    HD_ACTIVITYUSERGROUP("HD_ACTIVITYUSERGROUP", "AYHQ", "活动用户群编号"),
    
    //征信测评单
    HY_MEMBERCREDITBILL("HY_MEMBERCREDITBILL", "ZXCPD", "征信测评单编号"),
    
    NOT_FUOUND("", "MAIYAJF", "无匹配");


    /**
     * @param code   code
     * @param prefix 前缀
     * @param desc   code描述
     */
    SeqEnum(String code, String prefix, String desc) {
        this.code = code;
        this.desc = desc;
        this.prefix = prefix;
    }

    private String code;
    private String prefix;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDesc() {
        return desc;
    }

    //存储格式
    private static final ConcurrentMap<String, SeqEnum> enumMap = Maps.newConcurrentMap();

    public static SeqEnum getEnum(String code) {
        if (MapUtils.isEmpty(enumMap)) {
            //初始化ma
            for (SeqEnum e : SeqEnum.values()) {
                enumMap.putIfAbsent(StringUtils.upperCase(e.getCode()), e);
            }
        }
        SeqEnum e = enumMap.get(StringUtils.upperCase(code));
        if (null != e) {
            return e;
        }
        return SeqEnum.NOT_FUOUND;
    }
}
