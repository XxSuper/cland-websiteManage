package com.maiyajf.loan.manage.loan.upload.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.maiyajf.base.exception.ServiceException;
import com.maiyajf.base.utils.log.DebugLogger;
import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.Constants;
import com.maiyajf.loan.manage.common.utils.FtpConfig;
import com.maiyajf.loan.manage.common.utils.FtpUtil;
import com.maiyajf.loan.manage.common.utils.SFTPUtil;
import com.maiyajf.loan.manage.loan.upload.po.FileDto;

/**
 * 
 * 〈图片上传删除接口〉<br>
 * 〈功能详细简述〉
 * 
 * @author: yangning
 * @see [相关类/方法]（可选）
 * @since [产品/模板版本] （可选）
 */
@Service
public class FileService {

	@Value("${ftp.server.host}")
	private String host;

	@Value("${ftp.server.username}")
	private String username;

	@Value("${ftp.server.password}")
	private String password;

	@Value("${ftp.server.port}")
	private int port;
	
	@Value("${ftp.server.defaultpath}")
	private String defaultpath;
	
	@Value("${ftp.server.visitpath}")
	private String visitpath;
	

	/**
	 * 
	 * @Title: saveFile
	 * @Description: 上传图片
	 * @param request
	 * @param moduleType
	 * @return
	 * @throws IOException
	 * @return: UploadFile
	 * @throws ServiceException
	 */
	public FileDto saveFile(HttpServletRequest request) throws IOException, ServiceException {
		// 转换为文件类型的request
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获取对应file对象
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		Iterator<String> fileIterator = multipartRequest.getFileNames();
		FileDto file = null;
		while (fileIterator.hasNext()) {
			String fileKey = fileIterator.next();
			// 获取对应文件
			MultipartFile multipartFile = fileMap.get(fileKey);
			if (multipartFile.getSize() != 0L) {
				String contentType = multipartFile.getContentType();
				String type = contentType.substring(contentType.indexOf("/") + 1);
				String fileName = new Random().nextInt(1000000) + "";
				// 阿里静态服务器上传方式
				try {
					DebugLogger.debug("上传图片ftp");
					// 完成读取路径
					fileName = Constants.SFTP_SERVER_IMAGE_FOLDER + '-' + fileName + "." + type;
					// 调用ftp upload开始上传
					FtpUtil.uploadToFtpServer(multipartFile.getInputStream(), defaultpath, fileName, new FtpConfig(this.username, this.password, this.host, this.port + ""));
					// 封装了一个简单的file对象，增加了几个属性
					file = new FileDto();
					file.setCompleteSavePath(defaultpath + fileName);
					file.setFileSize(multipartFile.getSize());
					file.setFileName(fileName);
					file.setUploadType(Constants.UPLOAD_TYPE_ALI);
					DebugLogger.debug("上传图片---END---");
				} catch (Exception e) {
					e.printStackTrace();
					ExceptionLogger.error(e);
				} 
			}
		}

		return file;
	}

	/**
	 * 
	 * @Title: deletePhoto
	 * @Description: 删除图片
	 * @param url
	 * @throws IOException
	 * @return: void
	 */
	public void deletePhoto(String url) throws IOException {
		try {
			DebugLogger.debug("删除图片---START---");
			FtpUtil.removeFile(url, new FtpConfig(this.username, this.password, this.host, this.port + ""));
			DebugLogger.debug("删除图片---END---");
		} catch (Exception e) {
			ExceptionLogger.error(e);
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: getSFTPUtil
	 * @Description: 获取SFTP链接
	 * @return
	 * @return: SFTPUtil
	 */
	private SFTPUtil getSFTPUtil() {
//		if (sftpUtil != null) {
//			return sftpUtil;
//		} else {
//			sftpUtil = new SFTPUtil(username, password, host, port);
//			return sftpUtil;
//		}
		return null;
	}
}
