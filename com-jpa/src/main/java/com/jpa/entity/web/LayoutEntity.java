package com.jpa.entity.web;

import com.domain.web.Fraction;
import com.domain.web.Layout;
import com.domain.web.Site;
import com.domain.web.WebObjectType;
import com.jpa.listener.TimestampEntityListener;

import javax.persistence.*;
import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Entity(name = "Layout")
@EntityListeners(TimestampEntityListener.class)
@Table(name = "master_layout",
    uniqueConstraints = @UniqueConstraint(name = "UQ_LAYOUT", columnNames = {"site", "name"}))
public class LayoutEntity extends AbstractWebObject implements Layout {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int    id;
  @ManyToOne(targetEntity = SiteEntity.class)
  @JoinColumn(name = "site",
      foreignKey = @ForeignKey(name = "FK_LAYOUT_PK_SITE"),
      referencedColumnName = "id",
      nullable = false,
      updatable = false)
  private Site   site;
  @Column(name = "name", nullable = false)
  private String name;

  private LayoutEntity() {
  }

  public LayoutEntity(Site site, String name) {
    this.site = site;
    this.name = name;
  }

  public LayoutEntity(Site site, String name, String description) {
    this(site, name);
    setDescription(description);
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public WebObjectType getType() {
    return WebObjectTypes.LAYOUT;
  }

  @Override
  public Site getSite() {
    return this.site;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Map<String, Fraction> getFractions() {
    return null;
  }

  @Override
  public Fraction getFraction(String name) {
    return null;
  }

  @Override
  public Fraction setFraction(String name, Fraction fraction) {
    return null;
  }

  @Override
  public int hashCode() {
    return this.id;
  }

  @Override
  public boolean equals(Object obj) {
    if (0 < this.id && null != obj && obj instanceof LayoutEntity) {
      return this.id == ((LayoutEntity) obj).id;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return toString(LayoutEntity.class, new StringBuilder()
        .append("site=").append(null == this.site ? null : this.site.getUrl())
        .append("name=").append(this.name));
  }
}
