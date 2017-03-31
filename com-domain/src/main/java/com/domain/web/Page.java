package com.domain.web;

import com.domain.base.Content;

import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Page {
  /**
   * @return
   */
  String getPath();

  /**
   * @return
   */
  Layout getLayout();

  Map<String, Content> getContents();

  Content getContent(String name);

  Content setContent(String name, Content content);
}
