package com.domain.base.collection;

/**
 * @author justburrow
 * @since 2017. 4. 27.
 */
public interface CollectionSet extends ContentCollection {
  /**
   * @return
   */
  default CollectionType getCollectionType() {
    return CollectionType.SET;
  }
}
