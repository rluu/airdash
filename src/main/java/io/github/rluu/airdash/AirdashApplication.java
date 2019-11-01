package io.github.rluu.airdash;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@ComponentScan
@EntityScan
@EnableJpaRepositories
@EnableTransactionManagement
//@EnableAdminServer
public class AirdashApplication {

    private static final Logger logger = LogManager.getLogger(AirdashApplication.class);

    public static void main(String[] args) {
        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");

        SpringApplication.run(AirdashApplication.class, args);

        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");
    }
}
