package com.hx.edu;

import org.assertj.core.util.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = "com.hx.edu") // 为了让@Autowired不生效问题
public class EduonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EduonlineApplication.class, args);
	}
}
