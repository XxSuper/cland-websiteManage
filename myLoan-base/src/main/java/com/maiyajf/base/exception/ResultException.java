


package com.maiyajf.base.exception;

/**
 * INFO: info
 * User: zhaokai
 * Date: 2016/10/26
 * Version: 1.0
 * History: <p>如果有修改过程，请记录</P>
 */

public class ResultException extends Exception {

    private static final long serialVersionUID = 5645227164781802573L;

    public ResultException(String message) {
        super(message);
    }

    public ResultException(Throwable cause) {
        super(cause);
    }

    public ResultException(String message, Throwable cause) {
        super(message, cause);
    }

}