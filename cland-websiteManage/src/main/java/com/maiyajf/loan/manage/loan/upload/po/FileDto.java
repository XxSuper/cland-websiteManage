package com.maiyajf.loan.manage.loan.upload.po;

import java.io.Serializable;

/**
 * 
 * 〈文件Dto〉<br>
 * 〈功能详细简述〉
 * 
 * @author: yangning
 * @see [相关类/方法]（可选）
 * @since [产品/模板版本] （可选）
 */
public class FileDto implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 85960005672480378L;

	/**
	 * 文件名
	 */
	private String fileName;

	/**
	 * 文件格式
	 */
	private String fileFormart;

	/**
	 * 文件大小
	 */
	private Long fileSize;

	/**
	 * 完整路径
	 */
	private String completeSavePath;

	/**
	 * 上传类型 1，阿里静态服务器 2，大数据
	 */
	private Integer uploadType;
	/**
	 * 文件内容
	 */
	private byte[] fileContent;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileFormart() {
		return fileFormart;
	}

	public void setFileFormart(String fileFormart) {
		this.fileFormart = fileFormart;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public String getCompleteSavePath() {
		return completeSavePath;
	}

	public void setCompleteSavePath(String completeSavePath) {
		this.completeSavePath = completeSavePath;
	}

	public Integer getUploadType() {
		return uploadType;
	}

	public void setUploadType(Integer uploadType) {
		this.uploadType = uploadType;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

}
