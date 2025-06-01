package com.example.microservices_netcole_flix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesNetcoleFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesNetcoleFlixApplication.class, args);
	}
public class MovieServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieServiceApplication.class, args);
    }
}
public class SubscriberServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubscriberServiceApplication.class, args);
    }
}
}

