package com.jpa.entity.base.model;


import com.domain.base.model.ContentModel;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @author justburrow
 * @since 2017. 4. 30.
 */
public enum ContentModels implements ContentModel {
  TEXT(ZonedDateTime.parse("2017-04-30T11:34:00+09:00[Asia/Tokyo]").toInstant());

  private final Instant timestamp;

  ContentModels(Instant timestamp) {
    this.timestamp = timestamp;
  }

  @Override
  public long getId() {
    return ordinal();
  }

  @Override
  public String getDescription() {
    return String.format("%s.%s", ContentModel.class.getName(), name());
  }

  @Override
  public void setDescription(String description) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Instant getCreate() {
    return timestamp;
  }

  @Override
  public Instant getUpdate() {
    return timestamp;
  }
}
