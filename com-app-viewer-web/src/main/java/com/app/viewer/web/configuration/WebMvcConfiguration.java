package com.app.viewer.web.configuration;

import com.app.viewer.web.binding.GenericReqResolver;
import com.app.viewer.web.binding.UrlResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
  @Bean
  public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
    return new HiddenHttpMethodFilter();
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new GenericReqResolver());
    argumentResolvers.add(new UrlResolver());
  }
}
