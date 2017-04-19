package com.borderline.web.cmd;

import lombok.Data;

@Data
public class UpdateFractionCmd {
  private int    site;
  private int    page;
  private String fraction;

  private String description;

  public UpdateFractionCmd() {
  }

  public UpdateFractionCmd(int site, int page, String fraction) {
    this.site = site;
    this.page = page;
    this.fraction = fraction;
  }

  public UpdateFractionCmd(int site, int page, String fraction, String description) {
    this(site, page, fraction);
    this.description = description;
  }
}
