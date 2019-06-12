package com.maiyajf.loan.manage.loan.banner.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maiyajf.base.utils.base.DateUtils;
import com.maiyajf.loan.manage.common.persistence.Page;
import com.maiyajf.loan.manage.common.security.shiro.ShiroUtils;
import com.maiyajf.loan.manage.loan.banner.dao.BannerDao;
import com.maiyajf.loan.manage.loan.banner.dao.FileInfoDao;
import com.maiyajf.loan.manage.loan.banner.po.BannerInfo;
import com.maiyajf.loan.manage.loan.banner.po.FileInfo;
import com.maiyajf.loan.manage.loan.banner.service.BannerService;
import com.maiyajf.loan.manage.loan.banner.vo.BannerInfoVo;
import com.maiyajf.loan.manage.loan.sys.po.User;

@Service("bannerServiceImpl")
public class BannerServiceImpl implements BannerService {
  @Autowired
  private BannerDao bannerDao;
  @Autowired
  private FileInfoDao fileInfoDao;

  @Override
  public Page<BannerInfoVo> queryBanners(User user, BannerInfoVo bannerInfoVo,
      Page<BannerInfoVo> page) {
    bannerInfoVo.setPage(page);
    Map<String, String> parames = new HashMap<String, String>();
    if (bannerInfoVo.getQueryTitle() != null && !"".equals(bannerInfoVo.getQueryTitle())) {
      parames.put("title", bannerInfoVo.getQueryTitle());
    }
    if (bannerInfoVo.getQueryLocation() != null && !"all".equals(bannerInfoVo.getQueryLocation())) {
      parames.put("location", bannerInfoVo.getQueryLocation());
    }
    if (bannerInfoVo.getQueryHasLink() != null && !"all".equals(bannerInfoVo.getQueryHasLink())) {
      parames.put("hasLink", bannerInfoVo.getQueryHasLink());
    }

    if (bannerInfoVo.getPubStartDate() != null && !"".equals(bannerInfoVo.getPubStartDate())) {
      parames.put("pubStartDate", bannerInfoVo.getPubStartDate());
    }
    if (bannerInfoVo.getPubEndDate() != null && !"".equals(bannerInfoVo.getPubEndDate())) {
      parames.put("pubEndDate", DateUtils.dateParseShortString(
          DateUtils.addDays(DateUtils.parseDate(bannerInfoVo.getPubEndDate()), 1)));
    }
    if (bannerInfoVo.getQueryStatus() != null && !"".equals(bannerInfoVo.getQueryStatus())) {
      parames.put("status", bannerInfoVo.getQueryStatus());
    }
    if (user != null) {
      parames.put("loginUser", user.getUserName());
    }
    int count = bannerDao.countByConditions(parames);
    List<BannerInfoVo> result = bannerDao.findByConditions(parames);
    page.setCount(count);
    page.setList(result);
    return page;
  }

  @Transactional
  @Override
  public void deleteBannerById(String bannerId) {
    String[] ids = bannerId.split(",");
    bannerDao.deleteBannerByIds(Arrays.asList(ids));
    fileInfoDao.deleteByBannerIds(Arrays.asList(ids));

  }

  @Transactional
  @Override
  public void deleteFileByInfo(Map<String, String> parames) {
    fileInfoDao.deleteByinfos(parames);;

  }

  @Transactional
  @Override
  public void insertBanner(BannerInfo bannerInfo) {
    bannerDao.insertBanner(bannerInfo);;
  }

  @Transactional
  @Override
  public void dealInvalidBanner() {
    List<BannerInfo> banners = bannerDao.selectInvalidingBanners();
    for (BannerInfo ba : banners) {
      bannerDao.updateBannerExpired(ba.getId());;
    }
  }

  @Transactional
  @Override
  public void auditBanner(String bannerId, String auditResult) {
    if (auditResult.equals("2")) {
      bannerDao.updateBannerPass(bannerId, ShiroUtils.getCurrentUser().getRealName());
      BannerInfoVo vo = bannerDao.getById(bannerId);
      if (!DateUtils.dateCompare(DateUtils.addDays(vo.getEndDate(), 1),
          DateUtils.getCurrentTime())) {
        bannerDao.updateBannerExpired(bannerId);;
      }
    } else if (auditResult.equals("3")) {
      bannerDao.updateBannerRefuse(bannerId, ShiroUtils.getCurrentUser().getRealName());;
    }
  }

  @Transactional
  @Override
  public void addBannerFiles(BannerInfo bannerInfo, List<FileInfo> fileInfos) {

    for (FileInfo f : fileInfos) {
      f.setBannerId(bannerInfo.getId());
      f.setBannerNo(bannerInfo.getBannerNo());
      fileInfoDao.addBannerFile(f);;
    }
  }

  @Transactional
  @Override
  public void stopBannerById(String bannerId) {
    bannerDao.updateBannerStop(bannerId);;

  }

  @Transactional
  @Override
  public void startBannerById(String bannerId) {
    bannerDao.updateBannerStart(bannerId);
    BannerInfoVo vo = bannerDao.getById(bannerId);
    if (!DateUtils.dateCompare(DateUtils.addDays(vo.getEndDate(), 1), DateUtils.getCurrentTime())) {
      bannerDao.updateBannerExpired(bannerId);;
    }

  }

  @Transactional
  @Override
  public BannerInfoVo getById(String bannerId) {
    // TODO Auto-generated method stub
    return bannerDao.getById(bannerId);
  }
}
