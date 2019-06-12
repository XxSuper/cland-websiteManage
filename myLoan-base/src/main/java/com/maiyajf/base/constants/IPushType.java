package com.maiyajf.base.constants;

/**
 * @ClassName: IPushType
 * @Description: 推送类型
 * @author: yunlei.hua
 * @date: 2015年11月11日 上午10:12:40
 */
public interface IPushType {

	/** 逾期推送 */
	int OVERDUE = 0;
	/** 罚息变更推送 */
	int PUNISH = 1;
	/** 代扣推送 */
	int COLLECTION = 2;
	/** 减免推送 */
	int REDUCE = 3;
	/** 合并账单推送 */
	int MERGEBILL = 4;
	/** 账单还款推送 */
	int REPAYMENR = 5;
	/** 线下还款推送 */
	int OFFLINEREPAY = 6;
	/** 用户主动还款推送 */
	int ACTIVEREPAY = 7;
}
