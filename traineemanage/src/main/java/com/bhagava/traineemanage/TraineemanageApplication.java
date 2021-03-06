package com.bhagava.traineemanage;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication(scanBasePackages="com.bhagava")
@MapperScan("com.bhagava.traineemanage.mapper")*/
@SpringBootApplication
@MapperScan("com.bhagava.traineemanage.mapper")
public class TraineemanageApplication {
	public static void main(String[] args) {
		SpringApplication.run(new Class[]{TraineemanageApplication.class}, args);
	}

}

