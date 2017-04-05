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

import java.net.URL;
import java.time.Instant;
import java.util.List;

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

  private Instant before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.siteService).isNotNull();

    this.before = Instant.now();
  }

  @Test
  public void testCreate() throws Exception {
    // Given
    CreateSiteParams params = new CreateSiteParams(new URL("http://example.com"));

    // When
    Site site = this.siteService.create(params);

    // Then
    assertThat(site)
        .extracting(Site::getDescription, Site::getProtocol, Site::getHost)
        .containsExactly(null, Protocol.HTTP, "example.com");
    assertThat(site.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(site.getUpdate());
  }

  @Test
  public void testList() throws Exception {
    // When
    List<Site> list = this.siteService.list();

    // Then
    assertThat(list).isNotNull()
                    .isEmpty();
  }
}
