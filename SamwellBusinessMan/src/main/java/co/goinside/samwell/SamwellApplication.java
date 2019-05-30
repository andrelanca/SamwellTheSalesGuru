package co.goinside.samwell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication(scanBasePackages = "co.goinside.samwell")
public class SamwellApplication {
	

	public static void main(String[] args) { 
		
		SpringApplication.run(SamwellApplication.class, args);

	}

}
