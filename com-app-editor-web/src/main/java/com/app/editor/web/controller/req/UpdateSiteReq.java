package com.app.editor.web.controller.req;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 7.
 */
@Data
public class UpdateSiteReq {
  private String description;

  public UpdateSiteReq() {
  }

  public UpdateSiteReq(String description) {
    this.description = description;
  }
}
