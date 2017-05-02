package my.mycompany.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.session.SessionAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={SessionAutoConfiguration.class})
public class SpringBootSampleShiroWebJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleShiroWebJspApplication.class, args);
	}
}
