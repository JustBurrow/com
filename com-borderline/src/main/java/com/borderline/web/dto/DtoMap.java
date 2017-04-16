package com.borderline.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 14.
 */
@Data
public class DtoMap {
  private Map<String, Object> dtoMap;

  public DtoMap() {
    this.dtoMap = new LinkedHashMap<>();
  }

  public DtoMap(Map<String, Object> dtoMap) {
    this.dtoMap = dtoMap;
  }

  public Object put(String name, Object dto) {
    return this.dtoMap.put(name, dto);
  }

  public Object get(String name) {
    return this.dtoMap.get(name);
  }
}
