package com.aoto.framework.security.Ecmybatis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * For get beans from spring context
 *
 * @author ecmybatis
 */
@Component
public class SpringBeansLocator implements ApplicationContextAware {

  private static ApplicationContext CONTEXT;

  public static ApplicationContext context() {
    return CONTEXT;
  }
  
  public static <T> T getBean(Class<T> beanType, String name) {
    return CONTEXT.getBean(name, beanType);
  }

  public static <T> T getBean(Class<T> beanType) {
    return CONTEXT.getBean(beanType);
  }

  @Override
  public void setApplicationContext(ApplicationContext context) throws BeansException {
    CONTEXT = context;
  }
}
