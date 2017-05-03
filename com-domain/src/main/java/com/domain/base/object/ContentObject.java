package com.domain.base.object;

import com.domain.base.Content;
import com.domain.base.ContentType;
import com.domain.base.model.ContentModel;

/**
 * @param <C> 컨텐트 데이터 타입.
 * @author justburrow
 * @since 2017. 4. 27.
 */
public interface ContentObject<C> extends Content {
  /**
   * @return
   */
  default ContentType getType() {
    return ContentType.OBJECT;
  }

  /**
   * @return
   */
  ContentModel getModel();

  /**
   * @return
   */
  C getContent();

  /**
   * @param content
   */
  void setContent(C content);
}
