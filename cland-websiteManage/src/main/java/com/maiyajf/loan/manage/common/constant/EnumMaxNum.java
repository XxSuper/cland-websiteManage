/**
 * Copyright (C), 2012-2016, 江苏中地集团有限公司
 * Author:   LG
 * Date:     2016年7月29日 下午4:04:01
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.maiyajf.loan.manage.common.constant;

/**
 * 〈一句话功能简述〉首页展示条数类型枚举类<br>
 * 〈功能详细描述〉
 *
 * @author LG
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum EnumMaxNum {

    NEWS(NumberConstants.NUM_FOUR, NumberConstants.NUM_TWO),

    CHARITY(NumberConstants.NUM_THREE, NumberConstants.NUM_ONE);

    private int num;

    private int index;

    private EnumMaxNum(int num, int index) {
        this.num = num;
        this.index = index;
    }

    public static int getNum(int index) {
        for (EnumMaxNum c : EnumMaxNum.values()) {
            if (c.getIndex() == index) {
                return c.num;
            }
        }
        return 0;
    }

    public int getNum() {
        return num;
    }

    public int getIndex() {
        return index;
    }

}
