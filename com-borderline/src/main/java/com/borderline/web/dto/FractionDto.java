package com.borderline.web.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author justburrow
 * @since 2017. 4. 12.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FractionDto extends WebObjectDto {
  private String name;

  public FractionDto() {
  }

  public FractionDto(String name) {
    this.name = name;
  }
}
