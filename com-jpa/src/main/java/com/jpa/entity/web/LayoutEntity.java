package com.jpa.entity.web;

import com.domain.web.Fraction;
import com.domain.web.Layout;
import com.domain.web.Site;
import com.domain.web.WebObjectType;
import com.jpa.listener.TimestampEntityListener;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author justburrow
 * @since 2017. 4. 9.
 */
@Entity(name = "Layout")
@EntityListeners(TimestampEntityListener.class)
@Table(name = "master_layout",
    uniqueConstraints = @UniqueConstraint(name = "UQ_LAYOUT", columnNames = {"site", "template_name"}))
public class LayoutEntity extends AbstractWebObject implements Layout {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int                   id;
  @ManyToOne(targetEntity = SiteEntity.class)
  @JoinColumn(name = "site",
      foreignKey = @ForeignKey(name = "FK_LAYOUT_PK_SITE"),
      referencedColumnName = "id",
      nullable = false,
      updatable = false)
  private Site                  site;
  @Column(name = "template_name", nullable = false)
  private String                layoutTemplate;
  @ManyToMany(targetEntity = FractionEntity.class, cascade = CascadeType.ALL)
  @JoinTable(name = "rel_layout_fraction",
      joinColumns = @JoinColumn(name = "layout",
          foreignKey = @ForeignKey(name = "REL_FRACTION_TO_LAYOUT"),
          referencedColumnName = "id",
          nullable = false,
          updatable = false),
      inverseJoinColumns = @JoinColumn(name = "fraction",
          foreignKey = @ForeignKey(name = "REL_LAYOUT_TO_FRACTION"),
          referencedColumnName = "id",
          nullable = false,
          updatable = false))
  @MapKey(name = "name")
  private Map<String, Fraction> fractions;

  private LayoutEntity() {
    this.fractions = new HashMap<>();
  }

  public LayoutEntity(Site site, String templateName) {
    this();
    this.site = site;
    this.layoutTemplate = templateName;
  }

  public LayoutEntity(Site site, String templateName, String description) {
    this(site, templateName);
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
  public String getLayoutTemplate() {
    return this.layoutTemplate;
  }

  @Override
  public Map<String, Fraction> getFractions() {
    return Collections.unmodifiableMap(this.fractions);
  }

  @Override
  public Fraction getFraction(String name) {
    return this.fractions.get(name);
  }

  @Override
  public Fraction setFraction(Fraction fraction) {
    return this.fractions.put(fraction.getName(), fraction);
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
        .append("layoutTemplate=").append(this.layoutTemplate));
  }
}
