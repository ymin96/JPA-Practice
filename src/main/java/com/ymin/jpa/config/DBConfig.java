package com.ymin.jpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig {

    @Bean(name="dataSource")
    @ConfigurationProperties(prefix="spring.datasource.hikari")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager txManager()
    {
        return new DataSourceTransactionManager(dataSource());
    }
}
