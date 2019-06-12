package com.maiyajf.base.concurrent;

/**
 *	回调接口
 * @param <T>
 * @author MYSJPXH
 */
public interface CallBack<T> {
    /**
     * 回调方法
     * @return T
     */
    T invoke();
}
