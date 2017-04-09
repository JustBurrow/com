package com.app.editor.web.controller.req;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 10.
 */
@Data
public class UpdatePageReq {
  private String path;
  private String title;
  private int    layout;
  private String description;

  public UpdatePageReq() {
  }

  public UpdatePageReq(String path) {
    this.path = path;
  }

  public UpdatePageReq(String path, String title) {
    this(path);
    this.title = title;
  }

  public UpdatePageReq(String path, String title, int layout) {
    this(path, title);
    this.layout = layout;
  }

  public UpdatePageReq(String path, String title, int layout, String description) {
    this(path, title, layout);
    this.description = description;
  }
}
