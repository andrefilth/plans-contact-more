package br.com.vivo.api.plans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class PlansApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlansApplication.class, args);
	}

}
