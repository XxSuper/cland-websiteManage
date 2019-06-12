package com.maiyajf.base.utils.sequence;

import java.util.Date;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

/**
 * @ClassName: SequenceNoService
 * @Description:
 * @author: yunlei.hua
 * @date: 2016年1月19日 上午11:59:53
 */
@Service
public class SequenceNoService {

    //存储格式 ：  请求URL--当前请求总数
    private static final ConcurrentMap<String, AtomicLong>
            counterLimiterMap = Maps.newConcurrentMap();

//    private static final String jvmStartTime = DateFormatUtils.format(new Date(), "mmss");
    private static final String dateFormat = "yyMMdd";

    private static final long atomicLongMax = 99999L;

    public static final int atomicLongLength = String.valueOf(atomicLongMax).length();


    /**
     * @Title: getSequenceNo
     * @Description: 调用存储过程获得序号
     * @return: String
     */
    public String getSequenceNo(String tableName) {
        SeqEnum seqEnum = SeqEnum.getEnum(tableName);
        StringBuffer idStr = new StringBuffer(50);
        if (StringUtils.isNotBlank(seqEnum.getPrefix())) {
            idStr.append(seqEnum.getPrefix());
        }
        AtomicLong counterActomic = counterLimiterMap.get(seqEnum.getPrefix());
        if (counterActomic == null) {
            counterActomic = new AtomicLong(0L);
            AtomicLong tempObj
                    = counterLimiterMap.putIfAbsent(seqEnum.getPrefix(), counterActomic);
            if (tempObj != null) {
                counterActomic = tempObj;
            }
            tempObj = null;
        }

        // 当前map存储的值累加1
        long newActomicValue = counterActomic.incrementAndGet();
        if (newActomicValue > atomicLongMax) {
            //如果超出设置的最大值 则重新开始计数
            counterActomic.getAndSet(0l);
            newActomicValue = counterActomic.incrementAndGet();
        }

        idStr.append(DateFormatUtils.format(new Date(), dateFormat))
                .append(DateFormatUtils.format(new Date(), "HHmmss"))
                .append(formatString(newActomicValue, String.valueOf(atomicLongMax).length()));
        return idStr.toString();
    }

    /**
     * 将value 转成 formatLength 定长字符串
     *
     * @param value
     * @param formatLength
     * @return
     */
    public String formatString(Long value, Integer formatLength) {
        String newString = String.format("%0" + formatLength + "d", value);
        return newString;
    }
    
}
