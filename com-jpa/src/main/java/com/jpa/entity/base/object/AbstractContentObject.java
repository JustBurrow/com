package com.jpa.entity.base.object;

import com.jpa.entity.base.AbstractContent;
import com.jpa.listener.TimestampEntityListener;

import javax.persistence.*;

/**
 * @author justburrow
 * @since 2017. 4. 30.
 */
@Entity(name = "ContentObject")
@EntityListeners({TimestampEntityListener.class})
@Table(name = "master_content_object")
@DiscriminatorColumn(name = "model", discriminatorType = DiscriminatorType.INTEGER)
public abstract class AbstractContentObject extends AbstractContent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private long id;

  protected AbstractContentObject() {
  }

  @Override
  public long getId() {
    return this.id;
  }
}
