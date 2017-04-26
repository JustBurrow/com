package com.domain.base;

import java.util.Map;

/**
 * @param <V>
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface ContentMap<V> extends Content {
  @Override
  default ContentType getType() {
    return ContentType.MAP;
  }

  /**
   * @param name
   * @return
   */
  V get(String name);

  /**
   * @param name
   * @param value
   */
  void put(String name, V value);

  /**
   * @return
   */
  Map<String, V> getContent();
}
