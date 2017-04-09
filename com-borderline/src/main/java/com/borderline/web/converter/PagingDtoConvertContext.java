package com.borderline.web.converter;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Data
public class PagingDtoConvertContext implements DtoConvertContext {
  private int page;
  private int size;

  public PagingDtoConvertContext() {
  }

  public PagingDtoConvertContext(int page) {
    this.page = page;
  }

  public PagingDtoConvertContext(int page, int size) {
    this(page);
    this.size = size;
  }
}
