package com.borderline.web.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Data
public class WebObjectDto implements Dto {
  private int           id;
  private String        description;
  private LocalDateTime create;
  private LocalDateTime update;

  public WebObjectDto() {
  }

  public WebObjectDto(int id, String description) {
    this.id = id;
    this.description = description;
  }

  public WebObjectDto(int id, String description, LocalDateTime create, LocalDateTime update) {
    this(id, description);
    this.create = create;
    this.update = update;
  }
}
