package com.maiyajf.loan.manage.loan.banner.po;

import org.springframework.web.multipart.MultipartFile;

 
/**
 * @ClassName: BannerInfo
 * @Description: banner信息
 * @author: zhuangsheng.chen
 * @date: 2016年2月17日 下午2:18:55
 */
public class BannerInfo {
  private String id;
  private String bannerNo;
  private String title;
  private String location;
  private MultipartFile bannerPhoto; 
  private String endDate;
  private String publishDate; 
  private String detailLink;
  private String isQuery;
  private String iStatus;
  private String addPerson;
  
  public String getAddPerson() {
    return addPerson;
  }

  public void setAddPerson(String addPerson) {
    this.addPerson = addPerson;
  }

  public String getiStatus() {
    return iStatus;
  }

  public void setiStatus(String iStatus) {
    this.iStatus = iStatus;
  }

  public String getIsQuery() {
    return isQuery;
  }

  public void setIsQuery(String isQuery) {
    this.isQuery = isQuery;
  }

  
  public String getDetailLink() {
    return detailLink;
  }

  public void setDetailLink(String detailLink) {
    this.detailLink = detailLink;
  }

  

  public String getId() {
    return id;
  }

  public String getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(String publishDate) {
    this.publishDate = publishDate;
  }

  public void setId(String id) {
    this.id = id;
  }

  

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  
  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public String getBannerNo() {
    return bannerNo;
  }

  public void setBannerNo(String bannerNo) {
    this.bannerNo = bannerNo;
  }

  public MultipartFile getBannerPhoto() {
    return bannerPhoto;
  }

  public void setBannerPhoto(MultipartFile bannerPhoto) {
    this.bannerPhoto = bannerPhoto;
  }
   
}
