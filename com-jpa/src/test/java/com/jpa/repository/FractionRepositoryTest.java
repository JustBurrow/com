package com.jpa.repository;

import com.domain.web.Fraction;
import com.jpa.JpaModuleTestConfiguration;
import com.jpa.entity.web.FractionEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Instant;

import static com.jpa.JpaModuleTestConfiguration.RANDOM;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JpaModuleTestConfiguration.class)
@DataJpaTest
public class FractionRepositoryTest {
  @Autowired
  private FractionRepository fractionRepository;
  private Instant            before;

  public static FractionEntity randomFraction() {
    String name     = "testFraction#" + randomAlphanumeric(5, 10);
    String template = "test/fraction/template/" + randomAlphanumeric(7, 13);

    FractionEntity fraction = new FractionEntity(name, template);
    fraction.setDescription(RANDOM.nextBoolean() ? null : "jpa modul test fraction #" + randomAlphanumeric(7, 20));
    return fraction;
  }

  @Before
  public void setUp() throws Exception {
    assertThat(this.fractionRepository).isNotNull();
    this.before = Instant.now();
  }

  @Test
  public void testFindAll() throws Exception {
    assertThat(this.fractionRepository.findAll()).isNotNull();
  }

  @Test
  public void testSaveWithRandom() throws Exception {
    // Given
    FractionEntity expected = randomFraction();

    // When
    FractionEntity actual = this.fractionRepository.save(expected);

    // Then
    assertThat(actual)
        .isNotNull()
        .extracting(Fraction::getName, Fraction::getTemplate, Fraction::getDescription)
        .containsExactly(expected.getName(), expected.getTemplate(), expected.getDescription());
    assertThat(actual.getId()).isGreaterThan(0);
    assertThat(actual.getCreate())
        .isGreaterThanOrEqualTo(this.before)
        .isEqualTo(actual.getUpdate());
  }
}
