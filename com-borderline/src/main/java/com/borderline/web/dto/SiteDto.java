package com.borderline.web.dto;

import java.net.URL;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SiteDto extends WebObjectDto {
  private URL url;

  public SiteDto() {
  }

  public SiteDto(int id, String description) {
    super(id, description);
  }

  public SiteDto(int id, String description, LocalDateTime create, LocalDateTime update) {
    super(id, description, create, update);
  }
}
