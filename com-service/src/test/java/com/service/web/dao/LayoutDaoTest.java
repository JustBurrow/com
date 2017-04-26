package com.service.web.dao;

import com.domain.web.Fraction;
import com.domain.web.Layout;
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
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 12.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceModuleTestConfiguration.class)
@SpringBootTest
@Transactional
public class LayoutDaoTest {
  @Autowired
  private LayoutDao layoutDao;

  private Instant before;

  @Before
  public void setUp() throws Exception {
    assertThat(this.layoutDao).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testReadWithExampleData() throws Exception {
    // When
    Layout layout = this.layoutDao.read(1);

    // Then
    assertThat(layout).isNotNull();

    Map<String, Fraction> fractions = layout.getFractions();
    assertThat(fractions)
        .hasSize(4)
        .isEqualTo(layout.getFractions())
        .isNotSameAs(layout.getFractions());
    assertThat(fractions.keySet()).contains("content", "header", "footer", "sidebar");
  }
}
