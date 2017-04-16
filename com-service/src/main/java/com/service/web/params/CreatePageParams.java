package com.service.web.params;

import com.domain.web.Layout;
import com.domain.web.Site;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
public class CreatePageParams {
  private Site   site;
  private String path;
  private String title;
  private Layout layout;
  private String description;

  public CreatePageParams() {
  }

  public CreatePageParams(Site site, String path, String title, Layout layout, String description) {
    this.site = site;
    this.path = path;
    this.title = title;
    this.layout = layout;
    this.description = description;
  }
}
