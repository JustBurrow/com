package com.service;

import com.jpa.JpaModuleAnchor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@SpringBootApplication(scanBasePackageClasses = {JpaModuleAnchor.class, ServiceModuleAnchor.class})
public class ServiceModuleTestConfiguration {
  public static final Random RANDOM = new Random(new Random().nextLong());
}
