package com.util.provider;

import org.junit.Before;
import org.junit.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
public class SystemTimeProviderTest {
  private TimeProvider timeProvider;

  private Instant        beforeInstant;
  private ZonedDateTime  beforeZdt;
  private OffsetDateTime beforeOdt;
  private LocalDateTime  beforeLdt;

  @Before
  public void setUp() throws Exception {
    this.timeProvider = SystemTimeProvider.createInstance();
    this.beforeInstant = Instant.now();
    this.beforeZdt = this.beforeInstant.atZone(ZoneId.systemDefault());
    this.beforeOdt = this.beforeZdt.toOffsetDateTime();
    this.beforeLdt = this.beforeZdt.toLocalDateTime();
  }

  @Test
  public void testNow() throws Exception {
    // When
    Instant now = this.timeProvider.now();

    // Then
    assertThat(now)
        .isNotNull()
        .isGreaterThanOrEqualTo(this.beforeInstant);
  }

  @Test
  public void testNowWithClass() throws Exception {
    // When
    final Instant        instant = this.timeProvider.now(Instant.class);
    final ZonedDateTime  zdt     = this.timeProvider.now(ZonedDateTime.class);
    final OffsetDateTime odt     = this.timeProvider.now(OffsetDateTime.class);
    final LocalDateTime  ldt     = this.timeProvider.now(LocalDateTime.class);

    // Then
    assertThat(instant).isGreaterThanOrEqualTo(this.beforeInstant);
    assertThat(zdt).isAfterOrEqualTo(this.beforeZdt);
    assertThat(odt).isAfterOrEqualTo(this.beforeOdt);
    assertThat(ldt).isAfterOrEqualTo(this.beforeLdt);
  }
}
