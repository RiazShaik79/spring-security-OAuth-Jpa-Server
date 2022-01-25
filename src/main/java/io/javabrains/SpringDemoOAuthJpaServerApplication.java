package io.javabrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableAuthorizationServer
public class SpringDemoOAuthJpaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoOAuthJpaServerApplication.class, args);
		
		
	}
	   @Bean
	   public Sampler defaultSampler() {
		   return Sampler.ALWAYS_SAMPLE;
	   }

}
