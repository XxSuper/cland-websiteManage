package com.maiyajf.loan.manage.loan.banner.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.banner.po.FileInfo;

/**
 * @ClassName: FileInfoDao
 * @Description: 文件信息dao
 * @author: zhuangsheng.chen
 * @date: 2016年2月17日 下午2:05:21
 */
public interface FileInfoDao {

  void addBannerFile(FileInfo fileInfo);

  void deleteByBannerId(String bannerId);

  void deleteByBannerIds(@Param("ids") List<String> ids);

  void deleteByinfos(Map<String, String> parames);

}
