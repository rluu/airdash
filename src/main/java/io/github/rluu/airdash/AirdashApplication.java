package io.github.rluu.airdash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@ComponentScan
@EntityScan
@EnableJpaRepositories
@EnableTransactionManagement
@EnableAdminServer
public class AirdashApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirdashApplication.class, args);
	}

}
