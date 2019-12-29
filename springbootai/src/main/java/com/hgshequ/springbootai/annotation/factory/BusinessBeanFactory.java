package com.hgshequ.springbootai.annotation.factory;

import com.hgshequ.springbootai.annotation.BeanTypeEnum;
import com.hgshequ.springbootai.annotation.BusinessBeanRouteConfig;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@ConditionalOnClass(BusinessBeanRouteConfig.class)
public class BusinessBeanFactory implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext = null;

    private ConcurrentHashMap<String, Object> strategyMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("资方还款校验工厂开始");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            Object bean = applicationContext.getBean(beanName);
            BusinessBeanRouteConfig annotation = bean.getClass().getAnnotation(BusinessBeanRouteConfig.class);
            if (annotation != null) {
                String beanNameV2 = String.format("%s-%s", annotation.prefix(), annotation.businessType().getValue());
                this.strategyMap.putIfAbsent(beanNameV2, bean);
                for (String partnerCode : annotation.handlePartnerCode()) {
                    beanNameV2 = String.format("%s-%s", partnerCode, annotation.businessType());
                    this.strategyMap.putIfAbsent(partnerCode, bean);
                }
            }

        }
        log.info("BusinessBeanFactory,key:{}", strategyMap.keySet());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }

    public <T> T getBusinessBean(String partnerCode, BeanTypeEnum bsTypeEnum, Class<T> t) {
        String mapKey = String.format("%s-%s", partnerCode, bsTypeEnum.name().toLowerCase());
        BusinessBeanRouteConfig annotation = t.getClass().getAnnotation(BusinessBeanRouteConfig.class);
        Object o = strategyMap.get(mapKey);
        if (t.isInstance(o)) {
            return (T) o;
        }
        return null;
    }
}
