package com.a1systems.utils;

import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

/**
 * Created by Aristarkhov on 07.06.2016.
 */
public class Config {
    final static Logger logger = Logger.getLogger(Config.class);
    private static final String DRIVER_OPTION = "driver";
    private static final String DRIVER_PATH_OPTION = "driverpath";
    @Getter @Setter
    private static String driver;
    @Getter @Setter
    private static String driverPath ;

    public static void readConfig(String[] arg) {
        for (int i = 0; i < arg.length; i++) {
            logger.debug(arg[i]);
            if (arg[i].startsWith("-")) {
                String option = arg[i].replaceFirst("-","") ;
                switch (option) {
                    case DRIVER_OPTION:
                        driver = arg[i+1];
                        break;
                    case DRIVER_PATH_OPTION:
                        driverPath = arg[i+1];
                        break;
                }
            }
        }
    }
}
