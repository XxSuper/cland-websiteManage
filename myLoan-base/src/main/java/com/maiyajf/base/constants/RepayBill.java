package com.maiyajf.base.constants;

/**
 * 还款账单常量值<br>
 * 〈功能详细描述〉
 *
 * @author yangning
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RepayBill {

	/**
	 * 还款状态，10：未还款 20：部分还款 30：已还清
	 */
	public static final int REPAY_STATUS_NO = 10;

	/**
	 * 还款状态，10：未还款 20：部分还款 30：已还清
	 */
	public static final int REPAY_STATUS_PART_OF = 20;

	/**
	 * 还款状态，10：未还款 20：部分还款 30：已还清
	 */
	public static final int REPAY_STATUS_YES = 30;
	
	/**
	 * 现金白卡还款状态，-1：未出账 0：未还款 1：已还款
	 */
	public static final int XJBK_REPAY_STATUS_YES = 1;
	
	/**
	 * 现金白卡还款状态，-1：未出账 0：未还款 1：已还款
	 */
	public static final int XJBK_REPAY_STATUS_NO = 0;
	
	/**
	 * 还款支付方式; 如: 0.未还款 1. 主动还款 2.系统扣款 3. 支付宝转账 4. 银行转账或其它方式
	 */
	public static final int PAY_TYPE_0 = 0;
	
	/**
	 * 还款支付方式; 如: 0.未还款 1. 主动还款 2.系统扣款 3. 支付宝转账 4. 银行转账或其它方式
	 */
	public static final int PAY_TYPE_1 = 1;

	
}
