package com.borderline.web.cmd;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
public class CreatePageCmd {
  private int    site;
  private String path;
  private String title;
  private int    layout;
  private String description;

  public CreatePageCmd() {
  }

  public CreatePageCmd(int site, String path, String title) {
    this.site = site;
    this.path = path;
    this.title = title;
  }

  public CreatePageCmd(int site, String path, String title, int layout) {
    this(site, path, title);
    this.layout = layout;
  }

  public CreatePageCmd(int site, String path, String title, int layout, String description) {
    this(site, path, title, layout);
    this.description = description;
  }
}
