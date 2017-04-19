package com.domain.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.domain.base.Content;

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
   * @return
   */
  default URL getUrl() {
    URL siteUrl = getSite().getUrl();
    try {
      return new URL(siteUrl.getProtocol(), siteUrl.getHost(), getPath());
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @param path
   *          URL pattern.
   */
  void setPath(String path);

  /**
   * @return
   */
  String getTitle();

  /**
   * @param title
   */
  void setTitle(String title);

  /**
   * @return
   */
  Layout getLayout();

  /**
   * @param layout
   */
  void setLayout(Layout layout);

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
