package com.domain.web;

import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
public enum Protocol {
  HTTP(80),
  HTTPS(443);

  /**
   * @param url
   * @return
   */
  public static Protocol valueOf(URL url) {
    return valueOf(url.getProtocol().toUpperCase());
  }

  private final int defaultPort;

  Protocol(int defaultPort) {
    this.defaultPort = defaultPort;
  }

  /**
   * @return
   */
  public int defaultPort() {
    return this.defaultPort;
  }
}
