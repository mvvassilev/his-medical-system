package com.neuedu.hismedicalsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.neuedu.hismedicalsystem.model.mapper")
public class HisMedicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisMedicalSystemApplication.class, args);
	}

}
