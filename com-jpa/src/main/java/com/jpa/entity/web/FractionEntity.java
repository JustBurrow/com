package com.jpa.entity.web;

import com.domain.base.ContentContext;
import com.domain.web.Fraction;
import com.domain.web.GenericReq;
import com.domain.web.WebObjectType;
import com.jpa.listener.TimestampEntityListener;

import javax.persistence.*;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@Entity(name = "Fraction")
@EntityListeners({TimestampEntityListener.class})
@Table(name = "master_fraction")
public class FractionEntity extends AbstractWebObject implements Fraction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int    id;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "template_name", nullable = false)
  private String fractionTemplate;

  public FractionEntity() {
  }

  public FractionEntity(String name, String templateName) {
    setName(name);
    setFractionTemplate(templateName);
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public WebObjectType getType() {
    return WebObjectTypes.FRACTION;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getFractionTemplate() {
    return this.fractionTemplate;
  }

  @Override
  public void setFractionTemplate(String templateName) {
    this.fractionTemplate = templateName;
  }

  @Override
  public ContentContext buildContext(GenericReq req) {
    return null;
  }

  @Override
  public int hashCode() {
    return this.id;
  }

  @Override
  public boolean equals(Object obj) {
    if (0 < this.id && null != obj && obj instanceof FractionEntity) {
      return this.id == ((FractionEntity) obj).id;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return toString(FractionEntity.class, new StringBuilder()
        .append("name=").append(this.name)
        .append(", fractionTemplate=").append(this.fractionTemplate));
  }
}
