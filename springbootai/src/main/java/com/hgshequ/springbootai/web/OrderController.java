package com.hgshequ.springbootai.web;

import com.hgshequ.springbootai.annotation.BeanTypeEnum;
import com.hgshequ.springbootai.annotation.factory.BusinessBeanFactory;
import com.hgshequ.springbootai.service.OrderService;
import com.hgshequ.springbootai.task.AbsPay;
import com.hgshequ.springbootai.task.AbsValidate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    BusinessBeanFactory beanFactory;

    @GetMapping("/list")
    @ResponseBody
    public Object listOrder() {
        AbsPay weixin = beanFactory.getBusinessBean("weixin", BeanTypeEnum.PAY, AbsPay.class);
        log.info(">>>{}", weixin);
        if (weixin != null) {
            weixin.pay();
        }

        AbsValidate weixin2 = beanFactory.getBusinessBean("weixin", BeanTypeEnum.VALIDATE, AbsValidate.class);
        log.info(">>>2{}", weixin2);
        if (weixin2 != null) {
            weixin2.validate();
        }

        return orderService.listOrder();
    }


}
