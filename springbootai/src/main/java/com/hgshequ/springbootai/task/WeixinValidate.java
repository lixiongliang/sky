package com.hgshequ.springbootai.task;

import com.hgshequ.springbootai.annotation.BeanTypeEnum;
import com.hgshequ.springbootai.annotation.BusinessBeanRouteConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@BusinessBeanRouteConfig(prefix = "weixin", businessType = BeanTypeEnum.VALIDATE)
@Service
public class WeixinValidate implements AbsValidate {

    @Override
    public boolean validate() {

        log.info("WeixinValidate 验证失败");
        return false;
    }
}
