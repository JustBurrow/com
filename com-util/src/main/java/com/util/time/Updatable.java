package com.util.time;

import java.time.Instant;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Updatable extends Creatable {
  /**
   * @return 마지막 갱신 시각.
   */
  Instant getUpdate();
}
