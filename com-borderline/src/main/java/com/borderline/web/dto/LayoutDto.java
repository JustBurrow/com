package com.borderline.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LayoutDto extends WebObjectDto {
  private String                   layoutTemplate;
  private Map<String, FractionDto> fractions;

  public LayoutDto() {
  }

  public LayoutDto(String layoutTemplate) {
    this.layoutTemplate = layoutTemplate;
  }

  public FractionDto fraction(String name) {
    return this.fractions.get(name);
  }
}
