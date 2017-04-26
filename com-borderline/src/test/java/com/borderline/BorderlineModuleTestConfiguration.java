package com.borderline;

import com.jpa.JpaModuleAnchor;
import com.service.ServiceModuleAnchor;
import com.util.provider.SystemTimeProvider;
import com.util.provider.TimeProvider;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@SpringBootApplication(scanBasePackageClasses = {
    BorderlineModuleAnchor.class,
    ServiceModuleAnchor.class,
    JpaModuleAnchor.class
})
public class BorderlineModuleTestConfiguration {
  public static final Random RANDOM = new Random(new Random().nextLong());

  @Bean
  public TimeProvider timeProvider() {
    return SystemTimeProvider.createInstance();
  }
}
