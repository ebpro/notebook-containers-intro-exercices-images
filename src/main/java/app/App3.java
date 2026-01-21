package app;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class App3 {
    private static final Logger logger = LoggerFactory.getLogger(App3.class);

    public static void main(String[] args) {
        String name = Optional.ofNullable(System.getenv("NAME")).orElse("World");
        logger.info("Hello " + name + "!");
    }
}
