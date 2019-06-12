package com.maiyajf.loan.manage.common.persistence;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName: MultipleDataSource
 * @Description: 多数据源
 * @author: zhuangsheng.chen
 * @date: 2015年9月28日 下午5:22:55
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    return DatabaseContextHolder.getCustomerType();
  }

}
