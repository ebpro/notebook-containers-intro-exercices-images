package app;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.nio.file.Files;
import java.nio.file.Path;

public class App2 {
    private static final Logger logger = LoggerFactory.getLogger(App2.class);

    public static void main(String[] args) {

        try {
            String gitCommit = Files.readString(Path.of("/app/GIT_COMMIT")).trim();
            logger.info("Git commit (build-time) : " + gitCommit);
        } catch (Exception e) {
            logger.error("Failed to read GIT_COMMIT file", e);
        }
        String logLevel = System.getenv("LOG_LEVEL");

        logger.info("Log level (run-time)    : " + logLevel);
    }
}
