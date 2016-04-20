package com.ryl.learn.guava;

import com.google.common.base.Optional;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 16/4/20 上午9:44.
 */
public class BasicUtils {

    private static final Logger logger = LoggerFactory.getLogger(BasicUtils.class);

    @Test
    public void optional() {
        for (int i = 0; i < 100; i++) {
            Integer num = RandomUtils.nextInt(0,100);
            Optional<Integer> possible = Optional.fromNullable(num);

            logger.info("{} {} {}",possible.isPresent(), possible.get(), possible.or(0));
        }
    }

    @Test
    public void preconditions() {

    }

}
