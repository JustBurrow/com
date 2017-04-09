package com.jpa;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@SpringBootApplication
public class JpaModuleTestConfiguration {
  public static final Random RANDOM = new Random(new SecureRandom().nextLong());
}
