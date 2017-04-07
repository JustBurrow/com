package com.service.web.params;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 7.
 */
@Data
public class UpdateSiteParams {
  private int    id;
  private String description;

  public UpdateSiteParams() {
  }

  public UpdateSiteParams(int id, String description) {
    this.id = id;
    this.description = description;
  }
}
