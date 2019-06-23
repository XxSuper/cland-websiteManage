package com.maiyajf.loan.manage.loan.column.po;

import java.io.Serializable;
import java.util.List;

/**
 * sys_column
 *
 * @author
 */
public class SysColumnBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sGuid;

    /**
     * 栏目层级：0一级 1二级
     */
    private Integer iLevel;

    /**
     * 栏目编号
     */
    private String sColumnNo;

    /**
     * 父级栏目编号
     */
    private String sFatherNo;

    /**
     * 父级栏目名称
     */
    private String sFatherName;

    /**
     * 标题
     */
    private String sTitle;
    
    private String sName;

    /**
     * 英文标题
     */
    private String sTitleEn;

    /**
     * SEO标题
     */
    private String sSeoTitle;

    /**
     * SEO关键字
     */
    private String sSeoKeyWords;
    
    private String sSeoDesc;

    /**
     * 排序序号
     */
    private Integer iSortNum;

    /**
     * banner图
     */
    private String sBannerImage;

    /**
     * 简介
     */
    private String sProfile;

    /**
     * 链接
     */
    private String sLink;
    
    private List<SysColumnBean> clist;
    
    private int childSize;
    
    public String getsSeoDesc() {
		return sSeoDesc;
	}

	public void setsSeoDesc(String sSeoDesc) {
		this.sSeoDesc = sSeoDesc;
	}

	public int getChildSize() {
		return childSize;
	}

	public void setChildSize(int childSize) {
		this.childSize = childSize;
	}

	public List<SysColumnBean> getClist() {
		return clist;
	}

	public void setClist(List<SysColumnBean> clist) {
		this.clist = clist;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsGuid() {
        return sGuid;
    }

    public void setsGuid(String sGuid) {
        this.sGuid = sGuid;
    }

    public Integer getiLevel() {
        return iLevel;
    }

    public void setiLevel(Integer iLevel) {
        this.iLevel = iLevel;
    }

    public String getsColumnNo() {
        return sColumnNo;
    }

    public void setsColumnNo(String sColumnNo) {
        this.sColumnNo = sColumnNo;
    }

    public String getsFatherNo() {
        return sFatherNo;
    }

    public void setsFatherNo(String sFatherNo) {
        this.sFatherNo = sFatherNo;
    }

    public String getsFatherName() {
        return sFatherName;
    }

    public void setsFatherName(String sFatherName) {
        this.sFatherName = sFatherName;
    }

    public String getsTitle() {
        return sTitle;
    }

    public void setsTitle(String sTitle) {
        this.sTitle = sTitle;
    }

    public String getsTitleEn() {
        return sTitleEn;
    }

    public void setsTitleEn(String sTitleEn) {
        this.sTitleEn = sTitleEn;
    }

    public String getsSeoTitle() {
        return sSeoTitle;
    }

    public void setsSeoTitle(String sSeoTitle) {
        this.sSeoTitle = sSeoTitle;
    }

    public String getsSeoKeyWords() {
        return sSeoKeyWords;
    }

    public void setsSeoKeyWords(String sSeoKeyWords) {
        this.sSeoKeyWords = sSeoKeyWords;
    }

    public Integer getiSortNum() {
        return iSortNum;
    }

    public void setiSortNum(Integer iSortNum) {
        this.iSortNum = iSortNum;
    }

    public String getsBannerImage() {
        return sBannerImage;
    }

    public void setsBannerImage(String sBannerImage) {
        this.sBannerImage = sBannerImage;
    }

    public String getsProfile() {
        return sProfile;
    }

    public void setsProfile(String sProfile) {
        this.sProfile = sProfile;
    }

    public String getsLink() {
        return sLink;
    }

    public void setsLink(String sLink) {
        this.sLink = sLink;
    }

    @Override
    public String toString() {
        return "SysColumnBean{" +
                "sGuid='" + sGuid + '\'' +
                ", iLevel=" + iLevel +
                ", sColumnNo='" + sColumnNo + '\'' +
                ", sFatherNo='" + sFatherNo + '\'' +
                ", sFatherName='" + sFatherName + '\'' +
                ", sTitle='" + sTitle + '\'' +
                ", sTitleEn='" + sTitleEn + '\'' +
                ", sSeoTitle='" + sSeoTitle + '\'' +
                ", sSeoKeyWords='" + sSeoKeyWords + '\'' +
                ", iSortNum=" + iSortNum +
                ", sBannerImage='" + sBannerImage + '\'' +
                ", sProfile='" + sProfile + '\'' +
                ", sLink='" + sLink + '\'' +
                '}';
    }
}