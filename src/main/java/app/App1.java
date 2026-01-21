package app;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App1 {
    private static final Logger logger = LoggerFactory.getLogger(App1.class);

    public static void main(String[] args) {
        logger.info("Hello from Java in Docker!");
    }
}
