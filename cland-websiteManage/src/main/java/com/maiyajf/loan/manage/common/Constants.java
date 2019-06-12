package com.maiyajf.loan.manage.common;

import java.io.File;

public class Constants {
  /**
   * 是/否
   */
  public static final String YES = "1";
  /**
   * 是/否
   */
  public static final int YES_INT = 1;
  /**
   * 是/否
   */
  public static final String NO = "0";
  /**
   * 是/否
   */
  public static final int NO_INT = 0;
  /**
   * 短信验证码有效时间
   */
  public static final int EXPIRE = 600;
  /**
   * 短信验证码发送间隔时间
   */
  public static final int COUNT_DOWN_EXPIRE = 60;
  /**
   * 短信验证码有效期限内错误次数限制
   */
  public static final int SMSERRORCOUNT = 10;

  /**
   * 24小时内号码提交短信失败次数
   */
  public static final int PHONEERRORCOUNT = 10;
  /**
   * 一天的秒数
   */
  public static final int DAY_OF_SECONDS = 86400;
  /**
   * 对/错
   */
  public static final String TRUE = "true";
  public static final String FALSE = "false";
  public static final String INIT_PASSWORD = "maiya_123456";// 初始化密码
  // ------------------借款合同放款状态--------------------
  public static final String ContractGrantStatus_TODo = "10";// 待放款
  public static final String ContractGrantStatus_Doing = "20";// 放款中
  public static final String ContractGrantStatus_Doed = "30";// 已放款
  // ------------------还款方式--------------------
  public static final int HKMethod_ONE = 10;// 一次性还款
  public static final int HKMethod_EPI = 20;// 等额本息
  public static final int HKStatus_NO = 10;// 未还款
  public static final int HKStatus_SOME = 20;// 已还部分
  public static final int HKStatus_ALL = 30;// 已还清
  // ------------------资金帐号流水来源类型--------------------
  public static final int FundSerialType_Grant = 10;// 放款
  public static final int FundSerialType_IEP = 11;// 代付放款
  public static final int FundSerialType_Fee = 12;// 放款手续费
  // ------------------短信发送状态--------------------

  public static final String MessageStatus_Success = "2";// 发送成功
  // ------------------资金冻结状态--------------------
  public static final int ZJFrozenStatus_Apply = 10;// 冻结申请
  public static final int ZJFrozenStatus_Freeze = 20;// 解冻
  public static final int ZJFrozenStatus_Frozen = 11;// 冻结
  public static final int ZJFrozenStatus_Cancel = 30;// 取消冻结
  // ------------------支付结果查询处理定时任务间隔--------------------
  public static final String PAY_INTERVAL = "pay_interval";
  // ------------------支付结果最终确定时间--------------------
  public static final String PAY_Result_Time = "grant.result.time";
  // ------------------放款定时任务间隔--------------------
  public static final String GrantTASK_INTERVAL = "grant_interval";
  // ------------------放款批量放款数量--------------------
  public static final String GrantBatch_Num = "grant.batchNum";
  // ------------------放款记录状态--------------------
  public static final int GrantRecordStatus_Doing = 30;// 放款中
  public static final int GrantRecordStatus_Exception = 40;// 放款中, 第三方异常
  public static final int GrantRecordStatus_Success = 10;// 放款成功
  public static final int GrantRecordStatus_Fail = 20;// 放款失败
  public static final int GrantRecordStatus_Undo = 0;// 待放款
  // ------------------代付通道--------------------
  public static final int GrantIEPChannel_Zj = 1;// 代付通道中金
  // ------------------图片ftp服务器信息--------------------
  public static final String FTP_SERVERURL = "ftp.server.url";// ftp服务器url
  public static final String FTP_USERNAME = "ftp.server.username";// ftp服务器帐号
  public static final String FTP_PASSWORD = "ftp.server.password";// ftp服务器密码
  public static final String FTP_SERVERPATH = "ftp.server.serverpath";// ftp服务器目录
  // ------------------文件服务器地址--------------------
  public static final String FILE_SERVERPATH = "imageServer_url";// 文件服务器地址key
  // ------------------代付状态--------------------
  public static final int GrantPayStatus_Undo = 0;// 待支付
  public static final int GrantPayStatus_Success = 1;// 支付成功
  public static final int GrantPayStatus_Fail = 2;// 支付失败
  public static final int GrantPayStatus_Exception = 3;// 支付异常
  // ------------------代付接口调用状态--------------------
  public static final int GrantCallStatus_Undo = 0;// 接口未调用
  public static final int GrantCallStatus_Success = 10;// 接口调用成功
  public static final int GrantCallStatus_Fail = 20;// 接口调用失败
  public static final int GrantCallStatus_Exception = 30;// 接口调用异常
  public static final int GrantCallStatus_ThirdException = 40;// 第三方异常
  // -------------------分账类型------------------
  public static final int SplitType_Other = 40;
  public static final int SplitType_LateFee = 31;
  public static final int SplitType_Penalty = 30;
  public static final int SplitType_Interest = 20;
  public static final int SplitType_Principal = 10;
  // -------------------名词常量------------------
  public static final String ALL = "全部";
  public static final String Empty_String = "";
  public static final String Interface_Error = "接口调用异常";
  // ------------------放款渠道--------------------
  public static final int GrantChannel_CICC = 10;// 中金放款
  // ------------------放款方式--------------------
  public static final int GrantMethod_DAIFU = 10;// 放款方式

  // -------------------第三方支付接口------------------
  public static final String OUTInterface_PayBatch = "payBatch_interface";

  // -------------------活动图片存放目录------------------
  public static final String HD_IMAGESDIR = "hd" + File.separator + "images";

  // -------------------banner图片存放目录------------------
  public static final String BANNER_IMAGESDIR =
      "gw" + File.separator + "banner" + File.separator + "images";
  
  // -------------------news图片存放目录------------------
  public static final String NEWS_IMAGESDIR =
      "gw" + File.separator + "news" + File.separator + "images";
  // ---------------平台资金账户标识----------------
  public static final int PlatformAcct_Member = 10;// 还款本金
  public static final int PlatformAcct_Grant = 20;// 放款
  public static final int PlatformAcct_RepayPrincipal = 21;// 还款本金
  public static final int PlatformAcct_RepayFee = 22;// 还款手续费
  public static final int PlatformAcct_RepayIntrerest = 23;// 还款利息
  public static final int PlatformAcct_RepayLateFee = 24;// 还款滞纳金
  public static final int PlatformAcct_RepayPenalty = 25;// 还款罚息
  // ------------------放款状态--------------------
  public static final int GrantStatus_Doing = 30;// 放款中
  public static final int GrantStatus_Success = 10;// 放款成功
  public static final int GrantStatus_Fail = 20;// 放款失败
  public static final int GrantStatus_Undo = 0;// 待放款
  public static final int GrantStatus_Exception = 40;// 放款中,第三方放款异常

  public static final String InstitutionID = "001064";// 快捷支付机构号码
  public static final String cardType = "10";// 快捷支付银行卡类型储蓄卡

  // ------------------充值记录状态---------------------
  public static final int WAIT = 0;// 待激活
  public static final int OK = 1;// 已激活
  public static final int ERR = 2;// 异常

  // ------------------系统角色---------------------
  public static final String SysRole_CreditAuditFirst = "信审初审";// 系统角色信审初审
  public static final String SysRole_CreditAuditReview = "信审复审";// 系统角色信审复审
  public static final String SysRole_CreditAuditAdmin = "信审管理员";// 系统角色信审管理员
  public static final String SysRoleId_CreditAuditFirst = "roleId_first";// 系统角色信审初审
  public static final String SysRoleId_CreditAuditReview = "roleId_final";// 系统角色信审复审
  public static final String SysRoleId_CreditAuditAdmin = "信审管理员";// 系统角色信审管理员
  // ------------------审核结果---------------------
  public static final String CreditAudit_Pass = "通过";// 审核通过
  public static final String CreditAudit_Fefuse = "拒绝";// 审核拒绝
  public static final String CreditAudit_Fail = "不通过";// 审核拒绝
  // ------------------查询类型---------------------
  public static final String CreditQueryType_Pass = "auditPass";
  public static final String CreditQueryType_Todo = "toDoAudit";
  public static final String CreditQueryType_Refuse = "auditRefuse";
  public static final String CreditQueryType_Black = "auditBlack";
  // ------------------审核阶段---------------------
  public static final String CreditAuditPhase_First = "初审";// 信审初审
  public static final String CreditAuditPhase_Review = "复审";// 信审复审
  public static final String CreditAuditPhase_All = "全部";// 信审初审
  public static final String CreditAuditPhase_Auditing = "待审核";// 信审待审核

  public static final String CreditAuditPhase_FirstCode = "10";// 信审初审
  public static final String CreditAuditPhase_ReviewCode = "20";// 信审复审

  public static final int CreditAuditStage_First = 10;// 信审初审
  public static final int CreditAuditStage_Review = 20;// 信审复审

  // ------------------催收角色---------------------
  public static final String UrgentRecallRole_D1_D15 = "D1-D15";
  public static final String UrgentRecallRole_D16_D30 = "D16-D30";
  public static final String UrgentRecallRole_M1 = "M1";
  public static final String UrgentRecallRole_M2 = "M2";
  public static final String UrgentRecallRole_M3 = "M3";
  public static final String UrgentRecallRole_M4 = "M4";
  // ------------------催收阶段---------------------
  public static final String UrgentRecallStage_D1_D15 = "D1-D15";
  public static final String UrgentRecallStage_D16_D30 = "D16-D30";
  public static final String UrgentRecallStage_M1 = "M1";
  public static final String UrgentRecallStage_M2 = "M2";
  public static final String UrgentRecallStage_M3 = "M3";
  public static final String UrgentRecallStage_M4 = "M4";

  // -------------催收审核结果
  public static final String UrgentRecallAUDITSTAGE_PASS = "10";// 通过
  public static final String UrgentRecallAUDITSTAGE_REFUSE = "20";// 拒绝
  // -------------申请阶段
  public static final int AUDITSTAGE_TODO = 0;// 待审核
  public static final int AUDITSTAGE_SYS = 10;// 系统审核
  public static final int AUDITSTAGE_HUMAN = 20;// 人工审核
  // -------------审核结果
  public static final int AUDITRESULT_PASS = 10;// 审核通过
  public static final int AUDITRESULT_REFUSE = 20;// 审核拒绝

  // ------------------银行id--------------------
  public static final String GrantBankId_TEST = "700";// 测试用

  // -----------审核任务状态
  public static final int AUDITTASKSTATUS_TODO = 0;// 待审核
  public static final int AUDITTASKSTATUS_DOING = 10;// 信审中
  public static final int AUDITTASKSTATUS_DONE = 20;// 信审结束
  // -----------人工信审明细阶段
  public static final int ManualAuditDetail_First = 1;// 初审
  public static final int ManualAuditDetail_Review = 2;// 复审
  /**
   * 黑名单
   */
  public static final int BLACKKEY = 0;// 关键字
  /**
   * 白名单
   */
  public static final int WHITEKEY = 1;// 关键字
  /**
   * 所有关键字
   */
  public static final int ALLKEY = 2;// 所有关键字

  // -------------审核最终结果
  public static final int AUDITTOTALRESULT_PASS = 1;// 审核通过
  public static final int AUDITTOTALRESULT_REFUSE = 2;// 审核拒绝

  // --------------放款状态
  public static final Integer LOANSTATUS_TODO = 10;// 待放款
  public static final Integer LOANSTATUS_DOING = 20;// 放款中
  public static final Integer LOANSTATUS_DONE = 30;// 已放款
  // --------------放款结果
  public static final String GRANTRESULT_SUCCESS = "success";// 成功
  public static final String GRANTRESULT_FAIL = "fail";// 失败
  // ------------还款状态
  public static final Integer REPAYSTATUS_TODO = 10;// 未还款
  public static final Integer REPAYSTATUS_PART = 20;// 部分还款
  public static final Integer REPAYSTATUS_ALL = 30;// 已还清

  // ------------逾期状态
  public static final Integer OVERDUESTATUS_NO = 10;// 未逾期
  public static final Integer OVERDUESTATUS_YES = 20;// 已逾期

  // -----------申请状态
  public static final String APPLYSTATUS_BLACK = "黑名单";
  public static final String APPLYSTATUS_TOAUDIT = "待审核";
  public static final String APPLYSTATUS_REFUSE = "已拒绝";
  public static final String APPLYSTATUS_LOANTODO = "待放款";
  public static final String APPLYSTATUS_LOANING = "放款中";
  public static final String APPLYSTATUS_LOANSUCCESS = "已放款";
  public static final String APPLYSTATUS_REPAYALL = "已结清";
  public static final String APPLYSTATUS_OVERDUEREPAING = "逾期还款中";
  public static final String APPLYSTATUS_OVERDUEREPAYALL = "逾期已结清";
  public static final String APPLYSTATUS_REPAYPART = "部分还款";
  // 后台用户管理日志
  public static final int USERMANAGER_REGIST = 10;// 注册
  public static final int USERMANAGER_FORBDDEN = 11;// 禁用
  public static final int USERMANAGER_DELETE = 12;// 删除
  public static final int USERMANAGER_USING = 13;// 启用
  public static final int USERMANAGER_CHANGEPERMISSION = 20;// 权限变更


  // 催收任务状态
  public static final int URGEN_TASK_STATUS_TODO = 0;// 待催
  public static final int URGEN_TASK_STATUS_ING = 10;// 催收中
  public static final int URGEN_TASK_STATUS_END = 20;// 催收结束



  // 系统菜单等级
  /**
   * @Fields SYS_MENU_LEVEL_0 系统顶级菜单
   */
  public static final String SYS_MENU_LEVEL_0 = "0";//
  /**
   * @Fields SYS_MENU_LEVEL_1 系统二级菜单
   */
  public static final String SYS_MENU_LEVEL_1 = "1";//

  /**
   * 内网ip
   */
  public static final String LOCAL_IP = "192.168";

  /**
   * 本地城市
   */
  public static final String LOCAL_CITY = "南京市";

  /**
   * 颜色 红
   */
  public static final String COLOR_RED = "#FF0000";
  /**
   * 颜色 蓝
   */
  public static final String COLOR_BLUE = "#0970CD";

  /**
   * 约定还款字段通过的天数
   */
  public static Integer AGREEPASSDAY = 4;

  /**
   * SFTP 好信用基础目录
   */
  public static final String SFTP_SERVER_BASE_FOLDER = "/cland";
	
  /**
   * SFTP 上传图片目录
   */
  public static final String SFTP_SERVER_IMAGE_FOLDER = "image";
	
  /**
   * SFTP 上传产品类型
   */
  public static final Integer UPLOAD_PRODUCT_TYPE = 1;
	
  /**
   * 上传方式 - 阿里静态服务器
   */
  public static final Integer UPLOAD_TYPE_ALI = 1;
}
