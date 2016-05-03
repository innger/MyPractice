package com.ryl.learn.guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created on 16/4/20 上午9:44.
 */
public class BasicUtils {

    private static final Logger logger = LoggerFactory.getLogger(BasicUtils.class);

    @Test
    public void optional() {
        for (int i = 0; i < 100; i++) {
            Integer num = RandomUtils.nextInt(0, 100);
            Optional<Integer> possible = Optional.fromNullable(num);

            logger.info("{} {} {}", possible.isPresent(), possible.get(), possible.or(0));
        }
    }

    @Test
    public void preconditions() {
        String s = Preconditions.checkNotNull("123");
        String ss = Preconditions.checkNotNull(null,"username must not null");
        logger.info("{} {}", s, ss);
        logger.info("{}", Preconditions.checkPositionIndex(11, 10));
        Preconditions.checkArgument(10 % 2 == 0);
    }

    @Test
    public void objects() {
        String name = "";
        Objects.isNull(name);
        Objects.requireNonNull(name);

    }

}
