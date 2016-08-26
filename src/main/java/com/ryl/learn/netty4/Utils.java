package com.ryl.learn.netty4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * Created on 16/8/26 上午10:29.
 */
public class Utils {

    public static final Logger LOG = LoggerFactory.getLogger("netty4.example");

    public static final String LOCAL = "127.0.0.1";
    public static final int PORT = 5555;

    public static final String localAddress () {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return LOCAL;
        }
    }

}
