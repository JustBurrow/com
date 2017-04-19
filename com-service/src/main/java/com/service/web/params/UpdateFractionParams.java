package com.service.web.params;

import com.domain.web.Site;

import lombok.Data;

@Data
public class UpdateFractionParams {
  private Site   site;
  private int    page;
  private String fraction;
  private String description;

  public UpdateFractionParams(Site site, int page) {
    this.site = site;
    this.page = page;
  }

  public UpdateFractionParams(Site site, int page, String fraction, String description) {
    this(site, page);
    this.fraction = fraction;
    this.description = description;
  }
}
