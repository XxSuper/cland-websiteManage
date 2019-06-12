package com.maiyajf.loan.manage.loan.banner.service;

import java.util.List;
import java.util.Map;

import com.maiyajf.loan.manage.common.persistence.Page;
import com.maiyajf.loan.manage.loan.banner.po.BannerInfo;
import com.maiyajf.loan.manage.loan.banner.po.FileInfo;
import com.maiyajf.loan.manage.loan.banner.vo.BannerInfoVo;
import com.maiyajf.loan.manage.loan.sys.po.User;


public interface BannerService {

  Page<BannerInfoVo> queryBanners(User user, BannerInfoVo activityInfo, Page<BannerInfoVo> page);

  void deleteBannerById(String bannerId);

  void deleteFileByInfo(Map<String, String> parames);

  void insertBanner(BannerInfo bannerInfo);

  void dealInvalidBanner();

  void auditBanner(String bannerId, String auditResult);

  void addBannerFiles(BannerInfo bannerInfo, List<FileInfo> fileInfos);

  void stopBannerById(String bannerId);

  void startBannerById(String bannerId);

  BannerInfoVo getById(String bannerId);
}
