package com.util.provider;

import java.time.*;
import java.time.temporal.Temporal;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.util.Collections.unmodifiableMap;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public class SystemTimeProvider implements TimeProvider {
  /**
   * {@link SystemTimeProvider}가 지원하는 시각 정보.
   */
  public enum SupportTemporal {
    INSTANT(Instant.class),
    ZONE(ZonedDateTime.class),
    OFFSET(OffsetDateTime.class),
    LOCAL(LocalDateTime.class);

    private static Map<Class<? extends Temporal>, SupportTemporal> cache;
    private static final Object cacheLock = new Object();

    /**
     * @param clz
     * @return
     */
    public static SupportTemporal valueOf(Class<? extends Temporal> clz) {
      synchronized (cacheLock) {
        if (null == cache) {
          HashMap<Class<? extends Temporal>, SupportTemporal> temp = new HashMap<>();
          for (SupportTemporal s : SupportTemporal.values()) {
            temp.put(s.temporalClass, s);
          }
          cache = unmodifiableMap(temp);
        }
      }
      return cache.get(clz);
    }

    private final Class<? extends Temporal> temporalClass;

    SupportTemporal(Class<? extends Temporal> clz) {
      this.temporalClass = clz;
    }
  }

  /**
   * @return
   */
  public static final SystemTimeProvider createInstance() {
    return new SystemTimeProvider();
  }

  private ZoneId zone;

  /**
   */
  protected SystemTimeProvider() {
    this.zone = ZoneId.systemDefault();
  }

  @Override
  public Instant now() {
    return Instant.now();
  }

  @Override
  public <T extends Temporal> T now(Class<T> temporalClass) {
    if (null == temporalClass) {
      throw new IllegalArgumentException("temporal class is null.");
    }

    switch (SupportTemporal.valueOf(temporalClass)) {
      case INSTANT:
        return (T) now();
      case ZONE:
        return (T) now().atZone(this.zone);
      case OFFSET:
        return (T) now().atZone(this.zone).toOffsetDateTime();
      case LOCAL:
        return (T) toLocalDteTime(now());
      default:
        throw new UnsupportedTemporalTypeException(format("class=%s", temporalClass));
    }
  }

  @Override
  public LocalDateTime toLocalDteTime(Instant instant) {
    return instant.atZone(this.zone).toLocalDateTime();
  }
}
