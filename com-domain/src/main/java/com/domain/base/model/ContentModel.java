package com.domain.base.model;

import com.domain.base.Content;
import com.domain.base.ContentType;

/**
 * @author justburrow
 * @since 2017. 4. 27.
 */
public interface ContentModel extends Content {
  /**
   * @return
   */
  default ContentType getType() {
    return ContentType.MODEL;
  }
}
