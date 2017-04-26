package com.domain.base.collection;

/**
 * @author justburrow
 * @since 2017. 4. 27.
 */
public interface CollectionMap extends ContentCollection {
  /**
   * @return
   */
  default CollectionType getCollectionType() {
    return CollectionType.MAP;
  }
}
