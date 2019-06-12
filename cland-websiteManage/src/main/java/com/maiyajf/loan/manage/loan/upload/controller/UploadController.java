package com.maiyajf.loan.manage.loan.upload.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maiyajf.base.utils.log.ExceptionLogger;
import com.maiyajf.loan.manage.common.po.AjaxResult;
import com.maiyajf.loan.manage.loan.upload.po.FileDto;
import com.maiyajf.loan.manage.loan.upload.service.FileService;

/**
 * @author rui23
 * @version 创建时间：2016年2月24日 下午2:22:36
 */
@Controller
@RequestMapping(value = "/file")
public class UploadController {

	@Autowired
	private FileService fileService;

	/**
	 * 
	 * @Title: uploadPhoto
	 * @Description: 上传图片
	 * @param request
	 * @param response
	 * @param moduleType
	 * @return
	 * @return: AjaxResult
	 */
	@RequestMapping(value = "fileUpload.htm", method = RequestMethod.POST)
	@ResponseBody
	public Object uploadPhoto(HttpServletRequest request, HttpServletResponse response) {
		try {
			FileDto fileDto = fileService.saveFile(request);
			if (fileDto != null) {
				Map<String, Object> succMap = new HashMap<String, Object>();
				succMap.put("error", 0);
				succMap.put("url", fileDto.getCompleteSavePath());
				return succMap;
			} else {
				return AjaxResult.failed(AjaxResult.ERROR_CODE);
			}
		} catch (Exception e) {
			ExceptionLogger.error(e);
			return AjaxResult.failed(AjaxResult.ERROR_CODE);
		}
	}

	/**
	 * 
	 * @Title: deletePhoto
	 * @Description: 删除图片
	 * @param url
	 * @return
	 * @return: AjaxResult
	 */
	@RequestMapping(value = "del", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deletePhoto(String url) {
		try {
			if (StringUtils.isBlank(url)) {
				return AjaxResult.success();
			}
			fileService.deletePhoto(url);
			return AjaxResult.success();
		} catch (Exception e) {
			ExceptionLogger.error(e);
			return AjaxResult.failed(AjaxResult.ERROR_CODE);
		}
	}
}
