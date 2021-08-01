package com.shinasto.routingdatasource.common.config;

import com.shinasto.routingdatasource.common.datasource.DanjiRoutingDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DatabaseConfig {

  @Bean
  @Primary
  public DataSource routerDataSource() {
    HikariDataSource master = new HikariDataSource(createMasterDataSource());
    HikariDataSource slave = new HikariDataSource(createSlaveDataSource());
    return new DanjiRoutingDataSource(master, slave);
  }

  @Bean
  @ConfigurationProperties(prefix = "danji.datasource.master")
  public HikariConfig createMasterDataSource() {
    return new HikariConfig();
  }

  @Bean
  @ConfigurationProperties(prefix = "danji.datasource.slave")
  public HikariConfig createSlaveDataSource() {
    return new HikariConfig();
  }
}
