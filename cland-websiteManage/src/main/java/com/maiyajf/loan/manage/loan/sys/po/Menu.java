package com.maiyajf.loan.manage.loan.sys.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Menu implements Serializable {
	
  private static final long serialVersionUID = 1L;
	
  private List<Menu> chirdlen = new ArrayList<Menu>();
  
  private List<Permission> permissions = new ArrayList<Permission>();

  public List<Menu> getChirdlen() {
    return chirdlen;
  }

  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }

  public void setChirdlen(List<Menu> chirdlen) {
    this.chirdlen = chirdlen;
  }

  private String guid;
  private String menuNo;
  private String name;
  private String url;
  private String title;
  private Date addDate;
  private int isRoot;
  private int isLeaf;
  private String parentId;
  private int level;
  private String imageUrl;
  private String sMenuImage;
  private int iDelFlag;

  public String getsMenuImage() {
    return sMenuImage;
  }

  public void setsMenuImage(String sMenuImage) {
    this.sMenuImage = sMenuImage;
  }

  public int getiDelFlag() {
    return iDelFlag;
  }

  public void setiDelFlag(int iDelFlag) {
    this.iDelFlag = iDelFlag;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getMenuNo() {
    return menuNo;
  }

  public void setMenuNo(String menuNo) {
    this.menuNo = menuNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getAddDate() {
    return addDate;
  }

  public void setAddDate(Date addDate) {
    this.addDate = addDate;
  }

  public int getIsRoot() {
    return isRoot;
  }

  public void setIsRoot(int isRoot) {
    this.isRoot = isRoot;
  }

  public int getIsLeaf() {
    return isLeaf;
  }

  public void setIsLeaf(int isLeaf) {
    this.isLeaf = isLeaf;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((guid == null) ? 0 : guid.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Menu other = (Menu) obj;
    if (guid == null) {
      if (other.guid != null) return false;
    } else if (!guid.equals(other.guid)) return false;
    return true;
  }

  @Override
  public String toString() {
    return "Menu [chirdlen=" + chirdlen + ", permissions=" + permissions + ", guid=" + guid
        + ", menuNo=" + menuNo + ", name=" + name + ", url=" + url + ", title=" + title
        + ", addDate=" + addDate + ", isRoot=" + isRoot + ", isLeaf=" + isLeaf + ", parentId="
        + parentId + ", level=" + level + ", imageUrl=" + imageUrl + "]";
  }


}
