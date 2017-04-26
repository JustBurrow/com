package com.domain.base.collection;

/**
 * @author justburrow
 * @since 2017. 4. 27.
 */
public interface CollectionList extends ContentCollection {
  default CollectionType getCollectionType(){
    return CollectionType.LIST;
  }
}
