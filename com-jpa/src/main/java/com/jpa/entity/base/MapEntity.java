package com.jpa.entity.base;

import com.domain.base.ContentMap;
import com.jpa.listener.TimestampEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Map;

/**
 * @param <V>
 * @author justburrow
 * @since 2017. 4. 1.
 */
@Entity(name = "Map")
@EntityListeners({TimestampEntityListener.class})
@Table(name = "master_content")
public abstract class MapEntity<V> extends AbstractContent implements ContentMap<V> {
  @Override
  public V get(String name) {
    return null;
  }

  @Override
  public void put(String name, V value) {

  }

  @Override
  public Map<String, V> getContent() {
    return null;
  }
}
