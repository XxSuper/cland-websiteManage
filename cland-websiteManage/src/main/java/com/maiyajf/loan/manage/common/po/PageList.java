package com.maiyajf.loan.manage.common.po;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title PageList.java
 * @Package com.maiyajf.users.common.base
 * @Description
 * @author zhangww
 * @date 2015年10月7日 下午2:12:46
 * @version V1.0
 */
public class PageList {

  @SuppressWarnings({"rawtypes", "unchecked"})
  public static Map<String, Object> list(BaseService service, BaseCause cause, int pageNum,
      int pageSize) {

    int rows_count = service.selectCountByCause(cause);

    int pgnStart = (pageNum - 1) * pageSize;

    int pgnOffset = pgnStart - rows_count > 0 ? rows_count % pageSize : pageSize;

    cause.setCausePgnStart(pgnStart);
    cause.setCausePgnOffset(pgnOffset);

    List<?> list = service.selectPgnByCause(cause);

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("total", rows_count);
    map.put("rows", list);

    return map;
  }
}
