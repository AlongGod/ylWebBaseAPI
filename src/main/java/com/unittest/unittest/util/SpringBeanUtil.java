package com.unittest.unittest.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author https://www.ixushu.com
 * @Description: 直接通过Spring上下文获取SpringBean
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext content = null;

    public static void setContent(ApplicationContext content) {
        SpringBeanUtil.content = content;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContent(applicationContext);
    }

    public static Object getBeanByName(String beanName) {
        if (content == null){
            return null;
        }
        return content.getBean(beanName);
    }

    public static <T> T getBean(Class<T> type) {
        return content.getBean(type);
    }

}
