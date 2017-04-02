package com.service;

import com.jpa.JpaModuleAnchor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author justburrow
 * @since 2017. 4. 2.
 */
@SpringBootApplication(scanBasePackageClasses = {JpaModuleAnchor.class, ServiceModuleAnchor.class})
public class ServiceModuleTestConfiguration {
}
