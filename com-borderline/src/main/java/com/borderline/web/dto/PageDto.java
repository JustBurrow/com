package com.borderline.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PageDto extends WebObjectDto {
  private URL       site;
  private String    path;
  private String    title;
  private LayoutDto layout;

  public PageDto() {
  }

  public PageDto(URL site, String path, String title, LayoutDto layout) {
    this.site = site;
    this.path = path;
    this.title = title;
    this.layout = layout;
  }
}
