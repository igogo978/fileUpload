package app.contest;

import app.contest.storage.StorageProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ContestApplication {

    private static final Logger logger = LoggerFactory.getLogger(ContestApplication.class);

   
     
    public static void main(String[] args) {

        SpringApplication.run(ContestApplication.class, args);
    }

}
