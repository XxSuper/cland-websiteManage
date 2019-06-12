/**
 * 文件名称:  FtpConfig.java
 * 文件版权:  ygline Technologies Co., Ltd. Copyright 2014-2016, All rights reserved
 * 文件描述:  <描述>
 * 修改作者:  terryLi
 * 修改时间:  2014-6-7
 * 修改内容:  <修改内容>
 */
package com.maiyajf.loan.manage.common.utils;

/**
 * 
 * 类功能描述:  远程FTP基础配置信息
 * @author  terryLi
 * @version V1.0, 2014-6-7
 */
public class FtpConfig {
	public FtpConfig(){}
	
	public FtpConfig(String userName, String password, String ip , String port){
		this.userName = userName;
		this.password = password;
		this.ip = ip;
		this.port = port;
	}
	
    private String userName;
    private String password;
    private String ip;
    private String port;
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getIp() {
        return ip;
    }
    public String getPort() {
        return port;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public void setPort(String port) {
        this.port = port;
    }
}
