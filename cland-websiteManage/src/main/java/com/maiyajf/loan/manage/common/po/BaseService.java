package com.maiyajf.loan.manage.common.po;

import java.util.List;

/**
 * @Title BaseService.java
 * @Package com.maiyajf.users.common.base
 * @Description
 * @author zhangww
 * @date 2015年10月7日 下午2:15:52
 * @version V1.0
 */
public interface BaseService<B, C extends BaseCause> {

  /**
   * 根据条件查询数据的数量
   * 
   * @param cause
   * @return
   */
  public int selectCountByCause(C cause);

  /**
   * 根据条件分页查询数据
   * 
   * @param cause
   * @return
   */
  public List<B> selectPgnByCause(C cause);

  /**
   * 根据条件查询数据
   * 
   * @param cause
   * @return
   */
  public List<B> selectByCause(C cause);
}
