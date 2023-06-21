package com.co.prft.javahub.academicregistry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DatabaseConfig {

    @Bean
    public PostgreSQLContainer<?> postgreSQLContainer() {
        var postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:13"));
        postgreSQLContainer.setPortBindings(List.of("5434:5432"));
        /*postgreSQLContainer.withCreateContainerCmdModifier(createContainerCmd ->
                createContainerCmd.withHostConfig(new HostConfig()
                        .withPortBindings(new PortBinding(Ports.Binding.bindPort(5432), new ExposedPort(5432)))));*/
        postgreSQLContainer.withExposedPorts(5432);
        postgreSQLContainer.withDatabaseName("academicregistry");
        postgreSQLContainer.withUsername("admin");
        postgreSQLContainer.withPassword("admin");
        //postgreSQLContainer.withInitScript("db/");
        postgreSQLContainer.withInitScript("db/create.sql");
        postgreSQLContainer.start();
        return postgreSQLContainer;
    }

    @Bean
    @DependsOn("postgreSQLContainer")
    public DataSource dataSource(PostgreSQLContainer<?> postgreSQLContainer) {
        org.apache.tomcat.jdbc.pool.DataSource tomcatDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        tomcatDataSource.setUrl(postgreSQLContainer.getJdbcUrl());
        tomcatDataSource.setUsername(postgreSQLContainer.getUsername());
        tomcatDataSource.setDriverClassName("org.postgresql.Driver");
        tomcatDataSource.setPassword(postgreSQLContainer.getPassword());
        return tomcatDataSource;
    }
}