package com.maiyajf.base.dto;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class BaseResquestDto  implements Serializable  {
	
	private static final long serialVersionUID = -1L;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
