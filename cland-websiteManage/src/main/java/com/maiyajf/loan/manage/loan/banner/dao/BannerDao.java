package com.maiyajf.loan.manage.loan.banner.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.maiyajf.loan.manage.loan.banner.po.BannerInfo;
import com.maiyajf.loan.manage.loan.banner.vo.BannerInfoVo;

/**
 * @ClassName: BannerDao
 * @Description: bannerDao
 * @author: zhuangsheng.chen
 * @date: 2016年2月17日 下午2:03:02
 */
public interface BannerDao {

  void deleteBannerById(@Param(value = "guid") String bannerId);

  void updateBannerPass(@Param(value = "guid") String id,
      @Param(value = "userName") String userName);

  List<BannerInfo> selectInvalidingBanners();

  void updateBannerRefuse(@Param(value = "guid") String id,
      @Param(value = "userName") String userName);


  void deleteBannerByIds(@Param("ids") List<String> ids);

  void insertBanner(BannerInfo bannerInfo);

  void updateBannerExpired(@Param(value = "guid") String id);

  void updateBanner(BannerInfo bannerInfo);

  List<BannerInfoVo> findByConditions(Map<String, String> parames);

  void updateBannerStop(@Param(value = "guid") String bannerId);

  void updateBannerStart(@Param(value = "guid") String bannerId);

  BannerInfoVo getById(@Param(value = "guid") String bannerId);

  int countByConditions(Map<String, String> parames);
}
