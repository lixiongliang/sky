package com.hgshequ.springbootai.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * spring bean name  route config
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BusinessBeanRouteConfig {


    /**
     * bean 业务类型
     * @return
     */
    BeanTypeEnum businessType () ;

    /**
     * bean name 前缀
     * @return
     */
    String prefix() ;

    /**
     * 需要处理资金渠道数组
     * @return
     */
    String []  handlePartnerCode() default {};


}
