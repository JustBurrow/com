package com.jpa.entity.base;

import com.domain.base.Content;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@MappedSuperclass
public abstract class AbstractContent implements Content {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private long    id;
  @Column(name = "description")
  private String  description;
  @Column(name = "create_utc", nullable = false, updatable = false)
  private Instant create;
  @Column(name = "update_utc", nullable = false)
  private Instant update;

  protected StringBuilder toString(Class<? extends AbstractContent> clz, CharSequence sub) {
    return new StringBuilder(clz.getSimpleName())
        .append("{id=").append(this.id)
        .append(", description=").append(this.description)
        .append(", ").append(sub)
        .append(", create=").append(this.create)
        .append(", update=").append(this.update)
        .append('}');
  }

  @Override
  public long getId() {
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
    return Objects.hash(this.id);
  }

  @Override
  public boolean equals(Object obj) {
    if (0L < this.id && null != obj && obj instanceof AbstractContent) {
      return this.id == ((AbstractContent) obj).id;
    } else {
      return false;
    }
  }
}
