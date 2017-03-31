package com.domain.base;

/**
 * @param <V>
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface ContentSet<V> extends Content, ContentCollection<V> {
  @Override
  default ContentType getType() {
    return ContentType.SET;
  }
}
