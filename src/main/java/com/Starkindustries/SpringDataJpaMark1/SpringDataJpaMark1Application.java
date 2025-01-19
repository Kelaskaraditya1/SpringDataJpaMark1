package com.Starkindustries.SpringDataJpaMark1;

import com.Starkindustries.SpringDataJpaMark1.Model.User;
import com.Starkindustries.SpringDataJpaMark1.Repository.CustomMethodRepo;
import com.Starkindustries.SpringDataJpaMark1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaMark1Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaMark1Application.class, args);
	}

}
