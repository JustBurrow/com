package com.domain.web;

import com.util.PartialList;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public interface Site {
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
  int getPort();

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
