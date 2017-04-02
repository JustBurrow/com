package com.app.editor.web.configuration;

import com.util.provider.SystemTimeProvider;
import com.util.provider.TimeProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 자동으로 인스턴스를 생성하지 않는 빈을 생성한다.
 *
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Configuration
public class BeanConfiguration {
  @Bean
  public TimeProvider timeProvider() {
    return SystemTimeProvider.createInstance();
  }
}
