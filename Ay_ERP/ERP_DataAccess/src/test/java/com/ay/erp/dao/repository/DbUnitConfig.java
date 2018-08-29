package com.ay.erp.dao.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@ComponentScan(basePackages = "com.ay.erp.dao",useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repository.class)
        })
@EntityScan(basePackages = "com.ay.erp.dao")
public class DbUnitConfig {
}
