package com.welab.haiermoney.web.request;



import lombok.Data;


@Data
public  class JavaBean3 {
 
  /** 
 * 字段含义： 渠道业务流水号 
 * 备注：   
 */
  private String bizNo ; 
  /** 
 * 字段含义： 客户编号 
 * 备注：   
 */
  private String custId ; 
  /** 
 * 字段含义： 客户名称 
 * 备注：   
 */
  private String custName ; 
  /** 
 * 字段含义： 产品名称 
 * 备注：   
 */
  private String produName ; 
  /** 
 * 字段含义： 合同编号 
 * 备注：   
 */
  private String  contractNo ; 
  /** 
 * 字段含义： 借据编号 
 * 备注：   
 */
  private String loanNo ; 
  /** 
 * 字段含义： 贷款账号 
 * 备注：   
 */
  private String loanAcctNo ; 
  /** 
 * 字段含义： 查询日期 
 * 备注：  格式：yyyymmdd 
 */
  private String queryDate ; 
  /** 
 * 字段含义： 提款日期 
 * 备注：  格式：yyyymmdd 
 */
  private String loanDrawDate ; 
  /** 
 * 字段含义： 到期日期 
 * 备注：  格式：yyyymmdd 
 */
  private String LoanDueDate ; 
  /** 
 * 字段含义： 贷款余额 
 * 备注：   
 */
  private Double loanBalance ; 
  /** 
 * 字段含义： 还款计划信息 
 * 备注：  见还款计划信息表 
 */
  private List repayPlanItems ;
 }