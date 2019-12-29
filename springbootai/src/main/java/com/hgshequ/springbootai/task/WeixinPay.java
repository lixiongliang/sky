package com.hgshequ.springbootai.task;

import com.hgshequ.springbootai.annotation.BeanTypeEnum;
import com.hgshequ.springbootai.annotation.BusinessBeanRouteConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j

@Service("weixin-pay")
@BusinessBeanRouteConfig(prefix = "weixin",businessType = BeanTypeEnum.PAY)
public class WeixinPay implements AbsPay {

    @Override public String pay() {
        log.info("微信支付成功");
        return "微信支付成功";
    }
}
