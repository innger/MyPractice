/**
 * Alipay.com Inc. Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.ryl.learn.mvel;

import com.google.common.collect.Maps;
import org.junit.Test;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author renyulong
 * @version $Id: MvelScriptDemo.java, v 0.1 2018年06月25日 下午2:42 renyulong Exp $
 */
public class MvelScriptDemo {


    @Test
    public void expressionTest() {
        Serializable expression = MVEL.compileExpression("1+2");
        System.out.println(MVEL.executeExpression(expression));

        Object obj = MVEL.eval("1+2");
        System.out.println(Integer.valueOf(String.valueOf(obj)));

        Map<String, Object> vars = Maps.newHashMap();
        vars.put("A", 1);
        vars.put("B", 1);
        vars.put("C", 2);
        Object res = MVEL.eval("A+B/C+3", vars);
        System.out.println(res);

    }

}