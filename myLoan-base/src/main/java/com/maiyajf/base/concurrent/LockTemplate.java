package com.maiyajf.base.concurrent;


/**
 * 并发锁处理模版<br>
 * 防止在请求并发下，业务重复处理<br>
 * 使用redis缓存实现
 * @author MYSJPXH
 */
public interface LockTemplate {

    /**
     * 执行
     * 默认，排队，默认排队时间10秒，并发锁有效期60秒
     * @param lockBean
     * @param callBack
     * @return 执行结果
     */
    <T> T execute(LockBean lockBean, CallBack<T> callBack);

    /**
     * 执行
     * waitInQueue：true:排队. false:不排队
     * @param lockBean 
     * @param waitInQueue
     * @param timeoutMsecs
     * @param expireMsecs
     * @param callBack 
     * @return 执行结果
     */
    <T> T execute(LockBean lockBean, boolean waitInQueue, int timeoutMsecs, int expireMsecs, CallBack<T> callBack);

    public <T> T executeNoWait(LockBean lockBean, CallBack<T> callBack);
    
    public <T> T executeNoWait(LockBean lockBean, int expireMsecs, CallBack<T> callBack);

}
