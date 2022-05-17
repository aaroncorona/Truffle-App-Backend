package com.example.fansbackend;

import com.example.fansbackend.Controller.FanController;
import com.example.fansbackend.Repository.FanRepository;
import com.example.fansbackend.Service.FanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;

@SpringBootApplication
public class FansBackendApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(FansBackendApplication.class, args);

	}

}
