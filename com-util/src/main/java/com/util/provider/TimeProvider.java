package com.util.provider;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public interface TimeProvider {
  /**
   * @return
   */
  Instant now();

  /**
   * @param temporal
   * @param <T>
   * @return
   */
  <T extends Temporal> T now(Class<T> temporal);

  LocalDateTime toLocalDteTime(Instant instant);
}
