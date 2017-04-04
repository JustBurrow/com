package com.app.editor.web.controller.req;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 4.
 */
@Data
public class CreateSiteReq {
  private int    protocol;
  private String host;

  public CreateSiteReq() {
  }

  public CreateSiteReq(int protocol, String host) {
    this.protocol = protocol;
    this.host = host;
  }
}
