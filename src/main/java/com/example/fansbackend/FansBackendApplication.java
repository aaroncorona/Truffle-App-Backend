package com.example.fansbackend;

import com.example.fansbackend.Repository.FanRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FansBackendApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(FansBackendApplication.class, args);
	}

}
