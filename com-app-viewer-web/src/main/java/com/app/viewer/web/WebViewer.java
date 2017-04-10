package com.app.viewer.web;

import com.borderline.BorderlineModuleAnchor;
import com.domain.DomainModuleAnchor;
import com.jpa.JpaModuleAnchor;
import com.service.ServiceModuleAnchor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author justburrow
 * @since 2017. 4. 11.
 */
@SpringBootApplication(scanBasePackageClasses = {
    WebViewserModuleAnchor.class,
    BorderlineModuleAnchor.class,
    ServiceModuleAnchor.class,
    JpaModuleAnchor.class,
    DomainModuleAnchor.class
})
public class WebViewer {
  public static void main(String[] args) {
    SpringApplication.run(WebViewer.class, args);
  }
}
