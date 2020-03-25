package com.hgshequ.springbootai.task;

import com.hgshequ.springbootai.annotation.BeanTypeEnum;
import com.hgshequ.springbootai.annotation.BusinessBeanRouteConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@BusinessBeanRouteConfig(prefix = "zhifubao", businessType = BeanTypeEnum.PAY)
@Service
@Slf4j
public class ZhifubaoPay implements AbsPay {

    @Override
    public String pay() {
        log.info("支付宝支付成功");
        return "支付宝支付成功";
    }

}
