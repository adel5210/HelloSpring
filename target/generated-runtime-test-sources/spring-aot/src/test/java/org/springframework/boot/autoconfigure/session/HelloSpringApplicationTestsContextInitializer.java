package org.springframework.boot.autoconfigure.session;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.session.web.http.DefaultCookieSerializer;

public final class HelloSpringApplicationTestsContextInitializer {
  public static void registerSessionAutoConfiguration_ServletSessionRepositoryImplementationValidator(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionRepositoryImplementationValidator", SessionAutoConfiguration.ServletSessionRepositoryImplementationValidator.class).withConstructor(ApplicationContext.class, SessionProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new SessionAutoConfiguration.ServletSessionRepositoryImplementationValidator(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerNoOpSessionConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.NoOpSessionConfiguration", NoOpSessionConfiguration.class)
        .instanceSupplier(NoOpSessionConfiguration::new).register(beanFactory);
  }

  public static void registerServletSessionConfiguration_ServletSessionRepositoryConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionConfiguration$ServletSessionRepositoryConfiguration", SessionAutoConfiguration.ServletSessionConfiguration.ServletSessionRepositoryConfiguration.class)
        .instanceSupplier(SessionAutoConfiguration.ServletSessionConfiguration.ServletSessionRepositoryConfiguration::new).register(beanFactory);
  }

  public static void registerSessionAutoConfiguration_ServletSessionRepositoryValidator(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionRepositoryValidator", SessionAutoConfiguration.ServletSessionRepositoryValidator.class).withConstructor(SessionProperties.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new SessionAutoConfiguration.ServletSessionRepositoryValidator(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerSessionAutoConfiguration_ServletSessionConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.session.SessionAutoConfiguration$ServletSessionConfiguration", SessionAutoConfiguration.ServletSessionConfiguration.class)
        .instanceSupplier(SessionAutoConfiguration.ServletSessionConfiguration::new).register(beanFactory);
  }

  public static void registerServletSessionConfiguration_cookieSerializer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("cookieSerializer", DefaultCookieSerializer.class).withFactoryMethod(SessionAutoConfiguration.ServletSessionConfiguration.class, "cookieSerializer", ServerProperties.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(SessionAutoConfiguration.ServletSessionConfiguration.class).cookieSerializer(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }
}
