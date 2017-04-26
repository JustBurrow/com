package com.borderline.web.cmd;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 10.
 */
@Data
public class UpdatePageCmd {
  private int    site;
  private int    page;
  private String path;
  private String title;
  private int    layout;
  private String description;

  public UpdatePageCmd() {
  }

  public UpdatePageCmd(int site, int page, String path, String title, int layout, String description) {
    this.site = site;
    this.page = page;
    this.path = path;
    this.title = title;
    this.layout = layout;
    this.description = description;
  }
}
