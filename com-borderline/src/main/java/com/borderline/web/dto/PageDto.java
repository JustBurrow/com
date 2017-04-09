package com.borderline.web.dto;

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
  private String path;
  private String title;
}
