package com.borderline.web.cmd;

import com.domain.web.Protocol;
import lombok.Data;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 5.
 */
@Data
public class CreateSiteCmd {
  private URL    url;
  private String description;

  public CreateSiteCmd() {
  }

  public CreateSiteCmd(Protocol protocol, String host) throws MalformedURLException {
    this.url = new URL(protocol.getName().toLowerCase(), host, "");
  }

  public CreateSiteCmd(Protocol protocol, String host, String description) throws MalformedURLException {
    this(protocol, host);
    this.description = description;
  }
}
