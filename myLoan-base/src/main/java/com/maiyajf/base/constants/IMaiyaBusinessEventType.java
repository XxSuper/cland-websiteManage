package com.maiyajf.base.constants;

/**
 * @ClassName: IMaiyaBusinessEventType
 * @Description: 麦芽贷业务事件类型
 * @author: yunlei.hua
 * @date: 2017年3月22日 下午2:08:24
 */
public interface IMaiyaBusinessEventType {
	/** 借款申请审核通过 */
	String APPLY_PASS = "APPLY_PASS";
	
	/** 借款申请审核拒绝 */
	String APPLY_REFUSE = "APPLY_REFUSE";
	
	/** 放款完成 */
	String GRANT_SUCCESS = "GRANT_SUCCESS";
	
	/** 逾期天数变化 */
	String OVERDUE_CHANGE = "OVERDUE_CHANGE";
	
	/** 还款完成（结清） */
	String PAY_OFF = "PAY_OFF";
	
	/** 用户放款借款 */
	String USER_CANCEL = "USER_CANCEL";
	
	/** 预授信拒绝  */
	String PREEMPTION_CREDIT = "PREEMPTION_CREDIT";
	
}
