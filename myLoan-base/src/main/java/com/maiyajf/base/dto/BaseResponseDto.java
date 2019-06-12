package com.maiyajf.base.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;
import com.maiyajf.base.constants.IResponseCode;

public class BaseResponseDto  implements Serializable {
	
private static final long serialVersionUID = -1L;
public final static String SUCCESS_MSG = "操作成功";
public final static String ERROR_MSG = "操作失败";
	
    protected String respCode;// 返回代码
    protected String respMsg;//返回描述 
    
	
    public BaseResponseDto (){};
    public BaseResponseDto (String respCode, String respMsg) {
    	this.respCode = respCode;
    	this.respMsg = respMsg;
    };
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}	

    /**
     * 接口调用失败，有错误码和描述
     */
    public static BaseResponseDto newFailure(String code, String message) {
    	BaseResponseDto result = new BaseResponseDto();
        result.setRespCode(code);
        result.setRespMsg(message);
        return result;
    }

    /**
     * 接口调用失败，没有错误字符串码和描述
     */
    public static BaseResponseDto newFailure() {
    	BaseResponseDto result = new BaseResponseDto();
        result.setRespCode(IResponseCode.FAIL);
        result.setRespMsg(ERROR_MSG);
        return result;
    }

    /**
     * 接口调用失败，有描述
     */
    public static BaseResponseDto newFailure(String message) {
    	BaseResponseDto result = new BaseResponseDto();
        result.setRespMsg(IResponseCode.FAIL);
        result.setRespMsg(message);
        return result;
    }
    
    /**
     * 接口调用成功
     */
    public static BaseResponseDto newSuccess() {
    	BaseResponseDto result = new BaseResponseDto();
        result.setRespCode(IResponseCode.SUCCESS);
        result.setRespMsg(SUCCESS_MSG);
        return result;
    }
    
    /**
     * 判断返回结果是否成功
     */
    public boolean success() {
        return IResponseCode.SUCCESS.equals(respCode);
    }
}
