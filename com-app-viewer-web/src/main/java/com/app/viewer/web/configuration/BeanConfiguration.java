package com.app.viewer.web.configuration;

import com.util.provider.SystemTimeProvider;
import com.util.provider.TimeProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@Configuration
public class BeanConfiguration {
  /**
   * @return
   */
  @Bean
  public TimeProvider timeProvider() {
    return SystemTimeProvider.createInstance();
  }
}
