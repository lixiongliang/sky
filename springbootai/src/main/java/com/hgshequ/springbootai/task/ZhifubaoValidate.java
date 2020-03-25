package com.hgshequ.springbootai.task;

import com.hgshequ.springbootai.annotation.BeanTypeEnum;
import com.hgshequ.springbootai.annotation.BusinessBeanRouteConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@BusinessBeanRouteConfig(prefix = "zhifubao", businessType = BeanTypeEnum.VALIDATE)
@Service
public class ZhifubaoValidate implements AbsValidate {

    @Override
    public boolean validate() {
        log.info("ZhifubaoValidate 验证成功");
        return true;
    }
}
