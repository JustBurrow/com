package com.domain.base;


import com.util.time.Updatable;

/**
 * 컨텐트 속성.
 *
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Attribute<V> extends Updatable {
  /**
   * @return 속성 값 유형.
   */
  AttributeType getType();

  /**
   * @return 속성 값.
   */
  V getValue();

  /**
   * @param value 속성 값.
   */
  void setValue(V value);
}
