package com.borderline.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@Data
public class WebObjectDto {
  private int           id;
  private String        description;
  private LocalDateTime create;
  private LocalDateTime update;
}
