package com.jpa.entity.web;

import com.domain.web.Page;
import com.domain.web.Protocol;
import com.domain.web.Site;
import com.domain.web.WebObjectType;
import com.jpa.listener.TimestampEntityListener;
import com.util.PartialList;

import javax.persistence.*;
import java.net.URL;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@Entity(name = "Site")
@EntityListeners({TimestampEntityListener.class})
@Table(name = "master_site",
    uniqueConstraints = {@UniqueConstraint(name = "UQ_SITE", columnNames = {"protocol", "host"})})
public class SiteEntity extends AbstractWebObject implements Site {
  @Column(name = "protocol", nullable = false, updatable = false)
  @Enumerated
  private Protocol protocol;
  @Column(name = "host", nullable = false, updatable = false)
  private String   host;

  private SiteEntity() {
  }

  public SiteEntity(URL url) {
    this.protocol = Protocol.valueOf(url);
    this.host = url.getHost();
  }

  public SiteEntity(URL url, String description) {
    this(url);
    setDescription(description);
  }

  @Override
  public WebObjectType getType() {
    return WebObjectTypes.SITE;
  }

  @Override
  public Protocol getProtocol() {
    return this.protocol;
  }

  @Override
  public String getHost() {
    return this.host;
  }

  @Override
  public PartialList<Page> getPages(int page, int size) {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (0 < getId() && null != obj && obj instanceof SiteEntity) {
      return getId() == ((SiteEntity) obj).getId();
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return toString(SiteEntity.class, new StringBuilder("url=").append(getUrl()));
  }
}
