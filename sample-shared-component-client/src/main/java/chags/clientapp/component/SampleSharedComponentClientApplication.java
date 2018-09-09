package chags.clientapp.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import chags.shared.component.SharedComponent;
import chags.shared.component.SharedComponentConfiguration;
import chags.shared.component.annotation.EnableSampleSharedComponent;

@SpringBootApplication
@EnableSampleSharedComponent(url="testMe", port="testMeToo")
public class SampleSharedComponentClientApplication {

	@Autowired
	public SharedComponent sharedComponent;

	public static void main(String[] args) {
		SpringApplication.run(SampleSharedComponentClientApplication.class, args);
	}
	

	@Bean
	CommandLineRunner testRunner() {
		return args -> {
			System.out.println("#######################"+sharedComponent.printConfig()+"#######################");
		};
	}
}
