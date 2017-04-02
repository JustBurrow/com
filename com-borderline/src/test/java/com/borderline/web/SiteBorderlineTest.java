package com.borderline.web;

import com.borderline.BorderlineModuleTestConfiguration;
import com.borderline.web.dto.SiteDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BorderlineModuleTestConfiguration.class)
@SpringBootTest
public class SiteBorderlineTest {
  @Autowired
  private SiteBorderline siteBorderline;

  private LocalDateTime before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.siteBorderline).isNotNull();
    this.before = LocalDateTime.now();
  }

  @Test
  public void testList() throws Exception {
    // When
    List<SiteDto> sites = this.siteBorderline.list();

    // Then
    assertThat(sites)
        .isNotNull()
        .isEmpty();
  }
}
