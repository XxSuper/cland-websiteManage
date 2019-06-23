package com.maiyajf.loan.manage.loan.company.po;

import java.io.Serializable;
import java.util.Date;

/**
 * company_message
 * @author
 */
public class CompanyMessageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sGuid;

    private String sName;

    private String sPhone;

    /**
     * 邮箱
     */
    private String sMailBox;

    /**
     * 微信
     */
    private String sWeChat;

    /**
     * 地址
     */
    private String sAddress;

    /**
     * 路线
     */
    private String sRoute;

    /**
     * 企业文化
     */
    private String sCulture;

    /**
     * 友情链接
     */
    private String sLinks;

    private String sCompany;

    /**
     * 著作权
     */
    private String sCopyRight;

    /**
     * 二维码
     */
    private String sQrCode;

    private Date addTime;

    /**
     * 邮箱
     */
    private String sAboutUsMail;

    /**
     * 电话
     */
    private String sAboutUsPhone;

    /**
     * 地址
     */
    private String sAboutUsAdress;

    public String getsGuid() {
        return sGuid;
    }

    public void setsGuid(String sGuid) {
        this.sGuid = sGuid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsMailBox() {
        return sMailBox;
    }

    public void setsMailBox(String sMailBox) {
        this.sMailBox = sMailBox;
    }

    public String getsWeChat() {
        return sWeChat;
    }

    public void setsWeChat(String sWeChat) {
        this.sWeChat = sWeChat;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsRoute() {
        return sRoute;
    }

    public void setsRoute(String sRoute) {
        this.sRoute = sRoute;
    }

    public String getsCulture() {
        return sCulture;
    }

    public void setsCulture(String sCulture) {
        this.sCulture = sCulture;
    }

    public String getsLinks() {
        return sLinks;
    }

    public void setsLinks(String sLinks) {
        this.sLinks = sLinks;
    }

    public String getsCompany() {
        return sCompany;
    }

    public void setsCompany(String sCompany) {
        this.sCompany = sCompany;
    }

    public String getsCopyRight() {
        return sCopyRight;
    }

    public void setsCopyRight(String sCopyRight) {
        this.sCopyRight = sCopyRight;
    }

    public String getsQrCode() {
        return sQrCode;
    }

    public void setsQrCode(String sQrCode) {
        this.sQrCode = sQrCode;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addtime) {
        this.addTime = addtime;
    }

    public String getsAboutUsMail() {
        return sAboutUsMail;
    }

    public void setsAboutUsMail(String sAboutUsMail) {
        this.sAboutUsMail = sAboutUsMail;
    }

    public String getsAboutUsPhone() {
        return sAboutUsPhone;
    }

    public void setsAboutUsPhone(String sAboutUsPhone) {
        this.sAboutUsPhone = sAboutUsPhone;
    }

    public String getsAboutUsAdress() {
        return sAboutUsAdress;
    }

    public void setsAboutUsAdress(String sAboutUsAdress) {
        this.sAboutUsAdress = sAboutUsAdress;
    }

    @Override
    public String toString() {
        return "CompanyMessageBean{" +
                "sGuid='" + sGuid + '\'' +
                ", sName='" + sName + '\'' +
                ", sPhone='" + sPhone + '\'' +
                ", sMailBox='" + sMailBox + '\'' +
                ", sWeChat='" + sWeChat + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", sRoute='" + sRoute + '\'' +
                ", sCulture='" + sCulture + '\'' +
                ", sLinks='" + sLinks + '\'' +
                ", sCompany='" + sCompany + '\'' +
                ", sCopyRight='" + sCopyRight + '\'' +
                ", sQrCode='" + sQrCode + '\'' +
                ", addTime=" + addTime +
                ", sAboutUsMail='" + sAboutUsMail + '\'' +
                ", sAboutUsPhone='" + sAboutUsPhone + '\'' +
                ", sAboutUsAdress='" + sAboutUsAdress + '\'' +
                '}';
    }
}