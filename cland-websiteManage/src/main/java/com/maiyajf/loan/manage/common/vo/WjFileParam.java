package com.maiyajf.loan.manage.common.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title WjUserFileBeanParam.java
 * @Package com.maiyajf.file.param
 * @Description
 * @author zhangww
 * @date 2015年11月11日 下午4:37:41
 * @version V1.0
 */
public class WjFileParam {
	
	private List<WjFileBean> files = new ArrayList<WjFileBean>();
     
	public List<WjFileBean> getFiles() {
		return files;
	}

	public void setFiles(List<WjFileBean> files) {
		this.files = files;
	}
}