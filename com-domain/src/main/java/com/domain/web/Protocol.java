package com.domain.web;

import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public enum Protocol {
  HTTP,
  HTTPS;

  /**
   * @param url
   * @return
   */
  public static Protocol valueOf(URL url) {
    return valueOf(url.getProtocol().toUpperCase());
  }

  public static Protocol valueOf(int ordinal) {
    return Protocol.values()[ordinal];
  }

  /**
   * @return
   */
  public int getId() {
    return ordinal();
  }

  /**
   * @return
   */
  public String getName() {
    return name();
  }
}
