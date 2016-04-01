package com.ryl.learn.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 16/4/1 上午9:49.
 * 记录日常遇到的正则表达式问题
 */
public class RegexTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void getUrlParamTest() {
        String[] strArr = new String[]{"abcifa=teststring&a=b", "abcifa=teststring&", "abcifa=teststring"};
        //要截取cifa参数值,teststring 反复尝试最后试出来的
        //很常见的问题,获取url中指定参数名的值
        Pattern pattern = Pattern.compile("cifa=(.*?)(&|$)", Pattern.CASE_INSENSITIVE);
        for (String str : strArr) {
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                logger.info("str={} res={}", str, matcher.group(1));
            }
        }
    }

}
