package com.util.time;

import java.time.Instant;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Creatable {
  /**
   * @return 생성 시각.
   */
  Instant getCreate();
}
