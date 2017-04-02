package com.jpa.listener;

import com.util.provider.SystemTimeProvider;
import com.util.provider.TimeProvider;
import org.springframework.util.ReflectionUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class TimestampEntityListener {
  public static final  Set<String>  CREATE_TIMESTAMP_FIELD = unmodifiableSet(new HashSet<>(asList("create", "update")));
  public static final  Set<String>  UPDATE_TIMESTAMP_FIELD = unmodifiableSet(new HashSet<>(asList("update")));
  private static final TimeProvider TIME_PROVIDER          = SystemTimeProvider.createInstance();

  private void setTimestamp(Object entity, Field field, Instant now) {
    final boolean accessible = field.isAccessible();
    if (!accessible) {
      field.setAccessible(true);
    }

    try {
      field.set(entity, now);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } finally {
      if (!accessible) {
        field.setAccessible(false);
      }
    }
  }

  @PrePersist
  public void prePersist(Object entity) {
    Instant now = TIME_PROVIDER.now();

    for (String name : CREATE_TIMESTAMP_FIELD) {
      Field field = ReflectionUtils.findField(entity.getClass(), name, Instant.class);
      if (null != field) {
        setTimestamp(entity, field, now);
      }
    }
  }


  @PreUpdate
  public void preUpdate(Object entity) {
    Instant now = TIME_PROVIDER.now();

    for (String name : UPDATE_TIMESTAMP_FIELD) {
      Field field = ReflectionUtils.findField(entity.getClass(), name, Instant.class);
      if (null != field) {
        setTimestamp(entity, field, now);
      }
    }
  }
}
