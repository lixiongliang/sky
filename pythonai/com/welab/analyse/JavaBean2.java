package com.welab.haiermoney.web.request;



 import java.math.BigDecimal;
import lombok.Data;


@Data
public  class JavaBean2 {
 
  /** 
 * 字段含义： 渠道业务流水号 
 * 备注：  提款业务唯一标识，不能重最长度不超过32位 
 */
  private String bizNo ; 
  /** 
 * 字段含义： 渠道编号 
 * 备注：  云贷分配给合作方的唯一标识，双方确认合作时，有云贷对接人员提供 
 */
  private String channelid ; 
  /** 
 * 字段含义： 授信编号 
 * 备注：   
 */
  private String credid ; 
  /** 
 * 字段含义： 来源渠道类型 
 * 备注：  代码表(来源渠道类型) 
 */
  private String channeltype ; 
  /** 
 * 字段含义： 客户名称 
 * 备注：   
 */
  private String custname ; 
  /** 
 * 字段含义： 证件类型 
 * 备注：  代码表(客户证件类型) 
 */
  private String licekind ; 
  /** 
 * 字段含义： 证件号码 
 * 备注：   
 */
  private String paperid ; 
  /** 
 * 字段含义： 产品编号 
 * 备注：  云贷内部的产品编号，双方确定合作时由云贷对接人员提供 
 */
  private String productid ; 
  /** 
 * 字段含义： 产品项目编号 
 * 备注：  是否必传，根据渠道而定； 
 */
  private String projnum ; 
  /** 
 * 字段含义： 客户经理 
 * 备注：   
 */
  private String permanager ; 
  /** 
 * 字段含义： 申请金额 
 * 备注：  单位：元； 
 */
  private Double tcapi ; 
  /** 
 * 字段含义： 申请日期 
 * 备注：  格式：yyyymmdd 
 */
  private String begindate ; 
  /** 
 * 字段含义： 申请期限 
 * 备注：   
 */
  private Integer tterm ; 
  /** 
 * 字段含义： 担保方式 
 * 备注：  代码表 
 */
  private Integer assukind ; 
  /** 
 * 字段含义： 投放行业 
 * 备注：  代码表(行业类别) 
 */
  private String industry ; 
  /** 
 * 字段含义： 投放区域 
 * 备注：  代码表(省市区) 
 */
  private String zone ; 
  /** 
 * 字段含义： 用途备注 
 * 备注：   
 */
  private String loanpurpose ; 
  /** 
 * 字段含义： 还款方式代码 
 * 备注：  001:按月等额本息 
 */
  private String retukind ; 
  /** 
 * 字段含义： 贷款期限类型 
 * 备注：  D：按天 
 */
  private String ttermtype ; 
  /** 
 * 字段含义： 放款账户_银行代码 
 * 备注：   
 */
  private String dAcctbankcode ; 
  /** 
 * 字段含义： 放款账户_银行名称 
 * 备注：  账户类型为“公司”时,必填 
 */
  private String dBankname ; 
  /** 
 * 字段含义： 放款账户_放款账号 
 * 备注：  _账户类型非2时必放款账户填 
 */
  private String dAcctno ; 
  /** 
 * 字段含义： 放款账户_账户类型 
 * 备注：  0：私人 
 */
  private String dAccttype ; 
  /** 
 * 字段含义： 放款账户_账户名称 
 * 备注：  账户类型非2时必放款账户填 
 */
  private String dAcctname ; 
  /** 
 * 字段含义： 放款账户_开户行号 
 * 备注：  账户类型为“公司”时，必填 
 */
  private String dAcctbankcnaps ; 
  /** 
 * 字段含义： 放款账户_清算行号 
 * 备注：   
 */
  private String dAcctbankcnapsclear ; 
  /** 
 * 字段含义： 放款账户_开户行名称 
 * 备注：  账户类型为“公司”时,必填 
 */
  private String dAcctbankname ; 
  /** 
 * 字段含义： 放款账户_开户行所在省 
 * 备注：   
 */
  private String dAcctbankprovince ; 
  /** 
 * 字段含义： 放款账户_开户行所在市 
 * 备注：   
 */
  private String dAcctbankcity ; 
  /** 
 * 字段含义： 放款账户_开户证件类型 
 * 备注：   
 */
  private Integer dAcctidtype ; 
  /** 
 * 字段含义： 放款账户_开户证件号 
 * 备注：  放款账户_开户证件号 
 */
  private String dAcctidnbr ; 
  /** 
 * 字段含义： 还款账户_账号 
 * 备注：  代扣时必填 
 */
  private String rAcctno ; 
  /** 
 * 字段含义： 还款渠道 
 * 备注：  1 : 线下处理 
 */
  private Integer chanType ; 
  /** 
 * 字段含义： 还款账户_账户类型 
 * 备注：  代扣时必填
0：私人 1：公司 
 */
  private Integer rAccttype ; 
  /** 
 * 字段含义： 还款账户_账户名称 
 * 备注：  代扣时必填 
 */
  private String rAcctname ; 
  /** 
 * 字段含义： 还款账户_身份证号码 
 * 备注：  还款账户_账户类型为“私人”时必传 
 */
  private String rAcctidnbr ; 
  /** 
 * 字段含义： 还款账户_开户行名称 
 * 备注：  银行名称或者开户行名称 
 */
  private String rAcctbankname ; 
  /** 
 * 字段含义： 还款账户_开户行号 
 * 备注：  银行代码或者开户行号 
 */
  private String rAcctbankcnaps ; 
  /** 
 * 字段含义： 还款账户_开户行所在省 
 * 备注：   
 */
  private String rAcctbankprovince ; 
  /** 
 * 字段含义： 还款账户_开户行所在市 
 * 备注：   
 */
  private String rAcctbankcity ; 
  /** 
 * 字段含义： 合同签署后转跳链接 
 * 备注：   
 */
  private String redirect_url ; 
  /** 
 * 字段含义： 资方编号 
 * 备注：   
 */
  private String capital_numb ; 
  /** 
 * 字段含义： 出资方备注 
 * 备注：   
 */
  private String capital_remark ; 
  /** 
 * 字段含义： 分账金额 
 * 备注：   
 */
  private BigDecimal releamount ; 
  /** 
 * 字段含义： 还款账户-银行预留手机号 
 * 备注：   
 */
  private String rAcctMblNo ; 
  /** 
 * 字段含义：  
 * 备注：   
 */
  private   ; 
  /** 
 * 字段含义： 抵押物信息 
 * 备注：  见 guarantyInfoList表 
 */
  private List guarantyInfoList ; 
  /** 
 * 字段含义： 提款申请特殊字段 
 * 备注：   
 */
  private Object ------- ;
 }