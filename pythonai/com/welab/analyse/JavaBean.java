package com.welab.haiermoney.web.request;


import lombok.Data;


@Data
public  class JavaBean {
 
  /** 
 * 借据编号或贷款帐号或渠道编号+渠道业务流水号 
 */
  private String loanNo ; 
  /** 
 * 借据编号或贷款帐号或渠道编号+渠道业务流水号 
 */
  private String channelid ; 
  /** 
 * 借据编号或贷款帐号或渠道编号+渠道业务流水号 
 */
  private String bizNo ; 
  /** 
 * 借据编号或贷款帐号或渠道编号+渠道业务流水号 
 */
  private String loanacno ; 
  /** 
 * 格式：yyyymmdd 
 */
  private String calcDate ; 
  /** 
 * 1提前部分还本；2提前结清；
 
 */
  private Integer calcType ; 
  /** 
 * 1：确定还款本金金额
2：确定还款总金额 
 */
  private Integer aheaamtkind ; 
  /** 
 *  
 */
  private Decimal repayAmt ; 
  /** 
 * 1调整分期还款额； 
 */
  private Integer retuType ; 
  /** 
 * a：正常提前结清；b：代偿；c：回购 
 */
  private String preretutype ;
 }