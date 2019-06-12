package com.maiyajf.loan.manage.loan.banner.vo;

import java.util.Date;

import com.maiyajf.loan.manage.common.persistence.DataEntity;

/**
 * @ClassName: BannerInfoVo
 * @Description: bannerInfoVo
 * @author: zhuangsheng.chen
 * @date: 2016年2月17日 下午2:39:00
 */
public class BannerInfoVo extends DataEntity<BannerInfoVo> {
  private String queryBannerNo;
  private String bannerNo;
  private String title;
  private String queryLocation;
  private String location;
  private String pubStartDate;
  private String pubEndDate;
  private Date endDate;
  private Date startDate;
  private String queryStatus;
  private String istatus;
  private Date publishDate; 
  private String link;
  private String bannerPhoto;
  private String queryHasLink;
  private String id;
  private String queryTitle;
  private String addPerson;
  private String auditPerson;
  private String bannerUrl;
  private String sourceName;
  private String isOperator="false";
  
  public String getSourceName() {
    return sourceName;
  }

  public void setSourceName(String sourceName) {
    this.sourceName = sourceName;
  }

  public String getIsOperator() {
    return isOperator;
  }

  public void setIsOperator(String isOperator) {
    this.isOperator = isOperator;
  }

  public String getBannerUrl() {
    return bannerUrl;
  }

  public void setBannerUrl(String bannerUrl) {
    this.bannerUrl = bannerUrl;
  }

  public String getQueryBannerNo() {
    return queryBannerNo;
  }

  public void setQueryBannerNo(String queryBannerNo) {
    this.queryBannerNo = queryBannerNo;
  }

  public String getBannerNo() {
    return bannerNo;
  }

  public String getAddPerson() {
    return addPerson;
  }

  public void setAddPerson(String addPerson) {
    this.addPerson = addPerson;
  }

  public String getAuditPerson() {
    return auditPerson;
  }

  public void setAuditPerson(String auditPerson) {
    this.auditPerson = auditPerson;
  }

  public void setBannerNo(String bannerNo) {
    this.bannerNo = bannerNo;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getQueryLocation() {
    return queryLocation;
  }

  public void setQueryLocation(String queryLocation) {
    this.queryLocation = queryLocation;
  }

  public String getLocation() {
    return location;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getPubStartDate() {
    return pubStartDate;
  }

  public void setPubStartDate(String pubStartDate) {
    this.pubStartDate = pubStartDate;
  }

  public String getPubEndDate() {
    return pubEndDate;
  }

  public void setPubEndDate(String pubEndDate) {
    this.pubEndDate = pubEndDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getQueryStatus() {
    return queryStatus;
  }

  public void setQueryStatus(String queryStatus) {
    this.queryStatus = queryStatus;
  }

  

  public String getIstatus() {
    return istatus;
  }

  public void setIstatus(String istatus) {
    this.istatus = istatus;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getBannerPhoto() {
    return bannerPhoto;
  }

  public void setBannerPhoto(String bannerPhoto) {
    this.bannerPhoto = bannerPhoto;
  }

  public String getQueryHasLink() {
    return queryHasLink;
  }

  public void setQueryHasLink(String queryHasLink) {
    this.queryHasLink = queryHasLink;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getQueryTitle() {
    return queryTitle;
  }

  public void setQueryTitle(String queryTitle) {
    this.queryTitle = queryTitle;
  }

}
