package com.service.web;

import com.domain.web.Site;
import com.service.ServiceModuleTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
  public void testList() throws Exception {
    // When
    List<Site> list = this.siteService.list();

    // Then
    assertThat(list).isNotNull()
                    .isEmpty();
  }
}
