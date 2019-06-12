package com.maiyajf.base.constants;

/**
 * 订单状态常量值<br>
 * 〈功能详细描述〉
 *
 * @author yangning
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderStatus {

	/**
	 * 操作类型，订单审批状态
	 */
	public static final int ORDER_APPROVE = 1;

	/**
	 * 操作类型，订单放款状态
	 */
	public static final int ORDER_LENDING = 3;

	/**
	 * 麦芽贷订单审批状态（0：审核中，1：通过，2：不通过，3：待审核）
	 */
	public static final int MYLOAN_ORDER_APPROVE_WAITING = 3;

	/**
	 * 麦芽贷订单审批状态（0：审核中，1：通过，2：不通过，3：待审核）
	 */
	public static final int MYLOAN_ORDER_APPROVE_DOING = 0;

	/**
	 * 麦芽贷订单审批状态（0：审核中，1：通过，2：不通过，3：待审核）
	 */
	public static final int MYLOAN_ORDER_APPROVE_PASS = 1;

	/**
	 * 麦芽贷订单审批状态（0：审核中，1：通过，2：不通过，3：待审核）
	 */
	public static final int MYLOAN_ORDER_APPROVE_REFUSE = 2;

	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_0 = 0;
	
	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_10 = 10;
	
	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_20 = 20;
	
	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_30 = 30;
	
	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_40 = 40;
	
	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_50 = 50;
	
	/**
	 * 放款状态（0：待放款10：放款成功20：放款失败30：放款中 40:处理异常 50:重新放款 60:重新路由）
	 */
	public static final int MYLOAN_ORDER_LENDING_60 = 60;

	/**
	 * 现金白卡订单审批状态，100：待审批
	 */
	public static final String MYDRAIN_ORDER_APPROVE_WAITING = "100";

	/**
	 * 现金白卡订单审批状态，200：审批通过
	 */
	public static final String MYDRAIN_ORDER_APPROVE_PASS = "200";

	/**
	 * 现金白卡订单审批状态，403：审批拒绝
	 */
	public static final String MYDRAIN_ORDER_APPROVE_REFUSE = "403";

	/**
	 * 现金白卡订单放款状态，100：待放款
	 */
	public static final String MYDRAIN_ORDER_LENDING_WAITING = "100";

	/**
	 * 现金白卡订单放款状态，200：放款通过
	 */
	public static final String MYDRAIN_ORDER_LENDING_PASS = "200";

	/**
	 * 现金白卡订单放款状态，401：放款拒绝
	 */
	public static final String MYDRAIN_ORDER_LENDING_REFUSE = "401";
}
