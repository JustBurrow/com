package com.app.editor.web.controller.req;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author justburrow
 * @since 2017. 4. 4.
 */
@Data
public class CreateSiteReq {
  @Range(min = 0, max = 1)
  private int    protocol;
  @NotNull
  @Pattern(regexp = "(\\w+\\.)+\\w{2,}")
  private String host;
  private String description;

  public CreateSiteReq() {
  }

  public CreateSiteReq(int protocol, String host) {
    this.protocol = protocol;
    this.host = host;
  }

  public CreateSiteReq(int protocol, String host, String description) {
    this(protocol, host);
    this.description = description;
  }
}
