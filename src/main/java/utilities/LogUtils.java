package utilities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LogUtils {
    private static final  Logger logger = LogManager.getLogger();

    public static void info(String msg){
        logger.info(msg);
    }

    public static void warn(String msg){
        logger.warn(msg);
    }
}
