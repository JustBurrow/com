package com.borderline.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SiteDto extends WebObjectDto {
  private URL url;
}
