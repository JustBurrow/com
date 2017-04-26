package com.domain.base.collection;


import com.domain.base.Content;
import com.domain.base.ContentType;
import com.domain.base.object.ContentObject;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface ContentCollection extends Content {
  /**
   * @return
   */
  default ContentType getType() {
    return ContentType.COLLECTION;
  }

  /**
   * @return
   */
  CollectionType getCollectionType();

  /**
   * @return
   */
  List<ContentObject> getContents();

  /**
   * @return
   */
  int size();
}
