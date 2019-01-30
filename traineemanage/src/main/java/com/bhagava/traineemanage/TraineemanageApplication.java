package com.bhagava.traineemanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication(scanBasePackages="com.bhagava")
@MapperScan("com.bhagava.traineemanage.mapper")*/
@SpringBootApplication
@MapperScan("com.bhagava.traineemanage.mapper")
public class TraineemanageApplication {
	public static void main(String[] args) {
		SpringApplication.run(TraineemanageApplication.class, args);
	}

}

