package app.contest;

import app.contest.storage.StorageProperties;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class ContestApplication implements CommandLineRunner {
    
    private static final Logger logger = LoggerFactory.getLogger(ContestApplication.class);
    
    @Value("${storage.location}")
    private String storageLocation;
    
    public static void main(String[] args) {
        
        SpringApplication.run(ContestApplication.class, args);
    }
    
    @Override
    public void run(String... strings) throws Exception {
        if (Files.isDirectory(Paths.get(storageLocation)) && Files.isWritable(Paths.get(storageLocation))) {
            logger.info("檔案儲存路徑:" + storageLocation);
        } else {
            logger.error("無法寫入儲存路徑");
        }
    }
    
}
