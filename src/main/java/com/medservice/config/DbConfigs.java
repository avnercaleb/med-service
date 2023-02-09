package com.medservice.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfigs {
//   @Bean
//   public DataSource getDataSource() {
//       return DataSourceBuilder.create()
//        .driverClassName("com.mysql.cj.jdbc.Driver")
//         .url("jdbc:mysql://localhost:3306/medservice-db?createDatabaseIfNotExist=true")
//         .username("root")
//         .password("root")
//          .build();	
//   }
}
