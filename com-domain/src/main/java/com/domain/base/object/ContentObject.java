package com.domain.base.object;

import com.domain.base.Content;
import com.domain.base.ContentType;

/**
 * @author justburrow
 * @since 2017. 4. 27.
 */
public interface ContentObject extends Content {
  /**
   * @return
   */
  default ContentType getType(){
    return ContentType.OBJECT;
  }
}
