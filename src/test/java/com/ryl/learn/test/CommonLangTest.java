package com.ryl.learn.test;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jboss.netty.util.NetUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 16/5/5 上午10:06.
 */
public class CommonLangTest {

    private Logger logger = LoggerFactory.getLogger(CommonLangTest.class);

    @Test
    public void commonTest01() {
        logger.info("{}",NumberUtils.isNumber("-123L"));
        System.out.println(NumberUtils.isDigits("222a"));
        ObjectUtils.CONST(true);

    }

}
