package com.service.web.params;

import com.domain.web.Layout;
import com.domain.web.Site;
import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 10.
 */
@Data
public class UpdatePageParams {
  private Site   site;
  private int    id;
  private String path;
  private String title;
  private Layout layout;
  private String description;

  public UpdatePageParams() {
  }

  public UpdatePageParams(Site site, int id, String path, String title, Layout layout, String description) {
    this.site = site;
    this.id = id;
    this.path = path;
    this.title = title;
    this.layout = layout;
    this.description = description;
  }
}
