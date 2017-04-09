package com.domain.web;

import com.domain.base.Content;

import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Page extends WebObject {
  /**
   * @return
   */
  Site getSite();

  /**
   * @return URL pattern.
   */
  String getPath();

  /**
   * @param path URL pattern.
   */
  void setPath(String path);

  String getTitle();

  void setTitle(String title);

  /**
   * @return
   */
  Layout getLayout();

  /**
   * @return
   */
  Map<String, Content> getContents();

  /**
   * @param name
   * @return
   */
  Content getContent(String name);

  /**
   * @param name
   * @param content
   * @return
   */
  Content setContent(String name, Content content);
}
