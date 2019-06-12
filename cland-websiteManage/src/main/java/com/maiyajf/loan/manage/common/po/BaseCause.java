package com.maiyajf.loan.manage.common.po;

/**
 * @Title BaseCause.java
 * @Package com.maiyajf.users.common.base
 * @Description 基础Cause公共类
 * @author zhangww
 * @date 2015年9月23日 下午7:42:45
 * @version V1.0
 */
public interface BaseCause {

  /** null */
  public static final String CAUSE_IGNORE = null;

  /** 等于 "=" */
  public static final String CAUSE_EQUALS = "=";

  /** 不等于 "!=" */
  public static final String CAUSE_NOT_EQUALS = "!=";

  /** 大于 ">" */
  public static final String CAUSE_GREATER_THAN = ">";

  /** 大于或等于 ">=" */
  public static final String CAUSE_GREATER_THAN_OR_EQUAL = ">=";

  /** 小于 "<" */
  public static final String CAUSE_LESS_THAN = "<";

  /** 小于或等于 "<=" */
  public static final String CAUSE_LESS_THAN_OR_EQUAL = "<=";

  /** 包含 "LIKE" */
  public static final String CAUSE_LIKE = "LIKE";

  /** 不包含 "NOT LIKE" */
  public static final String CAUSE_NOT_LIKE = "NOT LIKE";

  /** 与 "AND" */
  public static final String CAUSE_COMBINE_AND = "AND";

  /** 或 "OR" */
  public static final String CAUSE_COMBINE_OR = "OR";

  /**
   * 按指定字段（升[asc]|降[desc]）排序 <br>
   */
  public String getCauseOrderBy();

  public void setCauseOrderBy(String causeOrderBy);

  /**
   * 查询条件组合方式，'AND'|'OR'
   */
  public String getCauseCombine();

  public void setCauseCombine(String causeCombine);

  /**
   * 分页查询行开始位置
   */
  public int getCausePgnStart();

  public void setCausePgnStart(int causePgnStart);

  /**
   * 分页查询行偏移量（页大小数）
   */
  public int getCausePgnOffset();

  public void setCausePgnOffset(int causePgnOffset);

  /**
   * 特殊查询WHERE条件参数 <br>
   * 
   * @param causeWhereParam
   */
  public void setCauseWhereParam(String causeWhereParam);

  public String getCauseWhereParam();

  /**
   * 更新(UPDATE) SET 参数 <br>
   * 
   * @param causeUpdateParam
   */
  public void setCauseUpdateParam(String causeUpdateParam);

  public String getCauseUpdateParam();
}
