package com.jpa.repository;

import com.domain.web.Site;
import com.jpa.JpaModuleTestConfiguration;
import com.jpa.entity.web.SiteEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

import static com.jpa.JpaModuleTestConfiguration.RANDOM;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 1.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaModuleTestConfiguration.class)
@DataJpaTest
public class SiteRepositoryTest {
  @Autowired
  private SiteRepository siteRepository;
  private Instant        before;

  public static SiteEntity randomSite() throws MalformedURLException {
    String        protocol = RANDOM.nextBoolean() ? "http" : "https";
    StringBuilder host     = new StringBuilder(randomAlphabetic(2, 8));
    for (int i = 0; i < 4 && RANDOM.nextBoolean(); i++) {
      host.append('.')
          .append(randomAlphabetic(3, 10));
    }
    String description = "jpa test site #" + RandomStringUtils.randomAlphanumeric(5, 10);

    return new SiteEntity(new URL(protocol, host.toString(), ""), description);
  }

  @Before
  public void setUp() throws Exception {
    assertThat(this.siteRepository).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testSave() throws Exception {
    // Given
    final SiteEntity expected = randomSite();

    // When
    final SiteEntity actual = this.siteRepository.save(expected);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(Site::getDescription, Site::getProtocol, Site::getHost, Site::getUrl)
        .containsExactly(expected.getDescription(), expected.getProtocol(), expected.getHost(), expected.getUrl());
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }
}
