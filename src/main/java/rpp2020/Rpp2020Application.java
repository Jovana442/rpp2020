package rpp2020;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;

@SpringBootApplication
public class Rpp2020Application {

	public static void main(String[] args) {
		SpringApplication.run(Rpp2020Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args ->{
			System.out.println("Beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName: beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
