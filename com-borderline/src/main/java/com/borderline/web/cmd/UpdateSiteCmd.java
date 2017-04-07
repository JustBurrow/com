package com.borderline.web.cmd;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 7.
 */
@Data
public class UpdateSiteCmd {
  private int    id;
  private String description;

  public UpdateSiteCmd() {
  }

  public UpdateSiteCmd(int id, String description) {
    this.id = id;
    this.description = description;
  }
}
