package com.borderline.web.cmd;

import lombok.Data;

@Data
public class ReadSiteCmd {
  private int site;
  private int page;

  public ReadSiteCmd() {
  }

  public ReadSiteCmd(int site, int page) {
    super();
    this.site = site;
    this.page = page;
  }
}
