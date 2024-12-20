package main.java;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author meiguangya
 * @date 2024/12/20 上午11:54
 * @description TODO
 */
@Slf4j
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.debug("Hello, this is a debug message.");
        logger.info("Hello, this is an info message.");
        logger.warn("Hello, this is a warning message.");
        logger.error("Hello, this is an error message.");
    }

}
