package com.co.prft.javahub.academicregistry.config;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class AcademicRegistryTestConfiguration implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        var postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:13"))
                .withDatabaseName("academicregistry")
                .withUsername("admin")
                .withPassword("admin");
        postgres.start();

        TestPropertyValues.of(
                "postgreSQL.datasource.url=" + postgres.getJdbcUrl(),
                "postgreSQL.datasource.db.name=" + postgres.getDatabaseName(),
                "postgreSQL.datasource.username=" + postgres.getUsername(),
                "postgreSQL.datasource.password=" + postgres.getPassword()
        ).applyTo(applicationContext.getEnvironment());

    }
}