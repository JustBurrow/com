package com.domain.base;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Element<V> extends Attribute<V> {
  /**
   * @return
   */
  int getIndex();
}
