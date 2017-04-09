package com.borderline.web.cmd;

import lombok.Data;

/**
 * @author justburrow
 * @since 2017. 4. 10.
 */
@Data
public class ReadPageCmd {
  private int site;
  private int page;

  public ReadPageCmd() {
  }

  public ReadPageCmd(int site, int page) {
    this.site = site;
    this.page = page;
  }
}
