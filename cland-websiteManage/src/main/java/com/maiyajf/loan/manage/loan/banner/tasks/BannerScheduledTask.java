package com.maiyajf.loan.manage.loan.banner.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.maiyajf.loan.manage.loan.banner.service.BannerService;

 
/**
 * @ClassName: BannerScheduledTask
 * @Description: Banner调度任务
 * @author: zhuangsheng.chen
 * @date: 2016年2月25日 上午11:30:47
 */
@Component
public class BannerScheduledTask {
  @Autowired
  private BannerService bannerService;
  
 //每天早上十点一十五触发
  @Scheduled(cron = "1 0 0 * * ?")
  public void dealInvalidActivity() {
    bannerService.dealInvalidBanner();
  }
 

}
