package com.ryl.learn.diamond;

import com.taobao.diamond.client.Diamond;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.PropertiesListener;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 配置中心，管理所有动态配置；高级用法
 * <p>
 * Created on 16/5/25 下午2:40.
 */
public class ConfigCenterAdvance {

    // 属性/开关
    private static String switchKey = "";

    private static void initConfig() {

        // 用法1: 配置值是properties文件内容格式（key1=value1）
        PropertiesListener managerListener1 = new PropertiesListener() {
            @Override
            public void innerReceive(Properties properties) {
                switchKey = (String) properties.get("key1");
                System.out.println(getSwitchKey());
            }
        };
        Diamond.addListener("dataId1", "group", managerListener1);


        // 用法2: 配置值是简单的字符串，字符串的格式自己随意选择。 例如可以是json序列化后的字符串
        ManagerListener managerListener2 = new ManagerListener() {
            public void receiveConfigInfo(String configInfo) {
                try {
                    System.out.println(configInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public Executor getExecutor() {
                // 如果访问配置特别多，阻塞通知数据变更线程，可以传入自定义线程池；有性能问题才使用，默认不用处理。
                return null;
            }
        };
        Diamond.addListener("dataId2", "group", managerListener2);
    }


    public static void main(String[] args) throws IOException {
        // 如果使用spring，此类等同于init方法
        initConfig();

        // 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出，实际代码中不需要。
        int i = 10;
        while (i > 0) {
            try {
                Thread.sleep(1000);
                i--;
            } catch (InterruptedException e) {
            }
        }
    }

    // 通过get接口把配置值暴露出去使用
    public static String getSwitchKey() {
        return switchKey;
    }
}
