package com.ryl.learn.typesafe.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created on 17/1/23 15:23.
 */
public class LoadConfig {
    
    public static void main(String[] args) {
        //1.System.setProperty("config.file", "src/main/resources/complex.conf");
        //2.Config config = ConfigFactory.load("complex.conf");
        Config config = ConfigFactory.load("complex.conf");
        System.out.println(config.getString("complex-app.something"));
        System.out.println(config.getInt("complex-app.number"));
        System.out.println(config.getString("complex-app.simple-lib-context.simple-lib.foo"));
        System.out.printf(config.getString("simple-lib.whatever"));
        
    }
    
}

