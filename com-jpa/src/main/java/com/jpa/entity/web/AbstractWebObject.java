package com.jpa.entity.web;

import com.domain.web.WebObject;

import javax.persistence.*;
import java.time.Instant;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@MappedSuperclass
public abstract class AbstractWebObject implements WebObject {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int     id;
  @Column(name = "description")
  private String  description;
  @Column(name = "create_utc", nullable = false, updatable = false)
  private Instant create;
  @Column(name = "update_utc", nullable = false)
  private Instant update;

  protected AbstractWebObject() {
  }

  protected AbstractWebObject(String description) {
    setDescription(description);
  }


  protected String toString(Class<? extends WebObject> clz, CharSequence str) {
    return new StringBuilder(clz.getSimpleName())
        .append("{id=").append(this.id)
        .append(", description=").append(this.description)
        .append(", ").append(str)
        .append(", create=").append(this.create)
        .append(", update=").append(this.update)
        .append('}').toString();
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public String getDescription() {
    return this.description;
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public Instant getCreate() {
    return this.create;
  }

  @Override
  public Instant getUpdate() {
    return this.update;
  }

  @Override
  public int hashCode() {
    return this.id;
  }
}
