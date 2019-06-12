package com.maiyajf.base.concurrent;

import java.util.Date;

/**
 * 并发处理记录bean
 * @author MYSJPXH
 */
public class LockBean {

    /** 类型 */
    private String lockType;//哪个中心

    /** ID */
    private String lockId;//用户Id

    /** 方法 */
    private String method;//类名加方法名("例: class-method")

    /** 创建时间 */
    private Date createTime;

    private String description;


    /**
     * 创建并发处理记录
     * 
     * @param lockType 类型
     * @param lockId ID
     * @param method 方法
     */
    public LockBean(String lockType, String lockId, String method) {
        this.lockType = lockType;
        this.lockId = lockId;
        this.method = method;
    }

    /**
     * 获取类型
     * 
     * @return 类型
     */
    public String getlockType() {
        return lockType;
    }

    /**
     * 设置类型
     * 
     * @param lockType 类型
     */
    public void setlockType(String lockType) {
        this.lockType = lockType;
    }

    /**
     * 获取ID
     * 
     * @return ID
     */
    public String getlockId() {
        return lockId;
    }

    /**
     * 设置ID
     * 
     * @param lockId ID
     */
    public void setlockId(String lockId) {
        this.lockId = lockId;
    }

    /**
     * 获取方法
     * 
     * @return 方法
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置方法
     * 
     * @param method 方法
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取创建时间
     * 
     * @return 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     * 
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the description
     */
    String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    void setDescription(String description) {
        this.description = description;
    }

}
