package com.borderline.web.dto;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PageDto extends WebObjectDto {
  private URL                      site;
  private String                   path;
  private String                   title;
  private LayoutDto                layout;
  private Map<String, FractionDto> fractions;

  public PageDto() {
    this.fractions = new LinkedHashMap<>();
  }

  public PageDto(URL site, String path, String title, LayoutDto layout) {
    this();
    this.site = site;
    this.path = path;
    this.title = title;
    this.layout = layout;
  }

  public FractionDto fraction(String name) {
    return this.fractions.get(name);
  }

  public void putFraction(String name, FractionDto fraction) {
    this.fractions.put(name, fraction);
  }
}
