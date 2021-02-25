package edu.eci.ieti.rentopolis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"edu.eci.ieti.rentopolis"})
public class RentopolisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentopolisApplication.class, args);
	}

}
