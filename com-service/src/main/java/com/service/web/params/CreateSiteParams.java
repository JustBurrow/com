package com.service.web.params;

import com.domain.web.Protocol;
import lombok.Data;

import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 5.
 */
@Data
public class CreateSiteParams {
  private URL    url;
  private String description;

  public CreateSiteParams() {
  }

  public CreateSiteParams(URL url) {
    this.url = url;
  }

  public CreateSiteParams(URL url, String description) {
    this(url);
    this.description = description;
  }

  public Protocol getProtocol() {
    return Protocol.valueOf(this.url);
  }

  public String getHost() {
    return this.url.getHost();
  }
}
