package com.domain.web;

import com.util.PartialList;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Site extends WebObject {
  int PAGE_SIZE = 20;

  /**
   * @return
   */
  Protocol getProtocol();

  /**
   * @return
   */
  String getHost();

  /**
   * @return
   */
  default URL getUrl() {
    try {
      return new URL(getProtocol().name(), getHost(), "");
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * @param page
   * @param size
   * @return
   */
  PartialList<Page> getPages(int page, int size);

  /**
   * @param page
   * @return
   */
  default PartialList<Page> getPages(int page) {
    return getPages(page, PAGE_SIZE);
  }
}
