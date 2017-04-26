package com.domain.base;

/**
 * @param <V>
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Entry<V> extends Attribute<V> {
  /**
   * @return
   */
  String getName();
}
