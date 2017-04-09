package com.app.editor.web.controller.req;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
public class CreatePageReq {
  @NotNull
  private String path;
  @NotNull
  @Size(min = 1)
  private String title;
  @Min(1)
  private int    layout;
  private String description;
}
