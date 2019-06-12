package com.maiyajf.loan.manage.common.persistence;

import org.aspectj.lang.JoinPoint;

public class DataSourceInterceptor {

  public void setDataSourceCredit(JoinPoint jp) {
    DatabaseContextHolder.setCustomerType("creditDataSource");
  }

  public void setDataSourceMyLoan(JoinPoint jp) {
    DatabaseContextHolder.setCustomerType("myloanDataSource");
  }
}
