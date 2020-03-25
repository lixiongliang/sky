package com.hgshequ.springbootai.config;

import com.hgshequ.springbootai.vo.HelloVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sky.li
 * @description
 * @since 2020/3/25 15:15
 */

@Configuration
//为带有@ConfigurationProperties注解的Bean提供有效的支持。
// 这个注解可以提供一种方便的方式来将带有@ConfigurationProperties注解的类注入为Spring容器的Bean。
@EnableConfigurationProperties(HelloProperties.class)//开启属性注入,通过@autowired注入
@ConditionalOnClass(HelloVo.class)//判断这个类是否在classpath中存在，如果存在，才会实例化一个Bean
// The Hello bean will be created if the hello.enable property exists and has a value other than false
// or the property doesn't exist at all.
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
@Slf4j
public class HelloAutoConfiguration {

    @Autowired
    private HelloProperties helloProperties;

    @Bean
    @ConditionalOnMissingBean(HelloVo.class)//容器中如果没有Hello这个类,那么自动配置这个Hello
    public HelloVo hello() {
        HelloVo hello = new HelloVo();
        hello.setMsg(helloProperties.getMsg());
        log.info("hello========" + hello.getMsg());
        return hello;
    }
}


