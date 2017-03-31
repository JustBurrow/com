package com.domain.base;

/**
 * @param <V>
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface ContentList<V> extends Content, ContentCollection<V> {
  @Override
  default ContentType getType() {
    return ContentType.LIST;
  }

  /**
   * @param index
   * @param value
   */
  void add(int index, V value);
}
