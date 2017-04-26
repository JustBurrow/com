package com.service.web;

import com.domain.web.Protocol;
import com.domain.web.Site;
import com.service.ServiceModuleTestConfiguration;
import com.service.web.params.CreateSiteParams;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.List;

import static com.service.ServiceModuleTestConfiguration.RANDOM;
import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceModuleTestConfiguration.class)
@SpringBootTest
@Transactional
public class SiteServiceTest {
  @Autowired
  private SiteService siteService;
  private Instant     before;

  public static CreateSiteParams randomCreateSiteParams() throws MalformedURLException {
    URL url = new URL(
        (RANDOM.nextBoolean() ? "http" : "https"),
        format("%s.%s", randomAlphabetic(2, 10), randomAlphabetic(2, 4)).toLowerCase(), "");
    String description = format("service test : random site #%d", RANDOM.nextInt(Integer.MAX_VALUE));

    return new CreateSiteParams(url, description);
  }

  @Before
  public void setUp() throws Exception {
    assertThat(this.siteService).isNotNull();

    this.before = Instant.now();
  }

  @Test
  public void testCreate() throws Exception {
    // Given
    CreateSiteParams params = randomCreateSiteParams();

    // When
    Site site = this.siteService.create(params);

    // Then
    assertThat(site)
        .extracting(Site::getProtocol, Site::getHost, Site::getDescription)
        .containsExactly(Protocol.valueOf(params.getUrl()), params.getHost(), params.getDescription());
    assertThat(site.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(site.getUpdate());
  }

  @Test
  public void testList() throws Exception {
    // When
    List<Site> list = this.siteService.list();

    // Then
    assertThat(list).isNotNull();
  }
}
