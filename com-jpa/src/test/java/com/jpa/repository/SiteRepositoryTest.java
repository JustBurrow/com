package com.jpa.repository;

import com.domain.web.Protocol;
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

import java.net.URL;
import java.time.Instant;

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

  private Instant before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.siteRepository).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testSave() throws Exception {
    // Given
    final URL        url         = new URL("http://example.com");
    final String     description = RandomStringUtils.randomAlphanumeric(30);
    final SiteEntity expected    = new SiteEntity(url, description);

    // When
    final SiteEntity actual = this.siteRepository.save(expected);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(Site::getDescription, Site::getProtocol, Site::getHost, Site::getUrl)
        .containsExactly(description, Protocol.HTTP, "example.com", url);
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }
}
