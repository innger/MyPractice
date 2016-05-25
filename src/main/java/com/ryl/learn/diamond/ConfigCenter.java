package com.ryl.learn.diamond;

import com.taobao.diamond.client.Diamond;
import com.taobao.diamond.manager.ManagerListenerAdapter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

/**
 * 配置中心，管理所有动态配置;基本用法
 * <p>
 * Created on 16/5/25 下午2:38.
 */
public class ConfigCenter {
    // 属性/开关
    private static String config = "";

    private static void initConfig() {
        // 启动只用一次场景，直接get获取配置值
        try {
            String configInfo = Diamond
                    .getConfig("dataId", "group", 1000);
            System.out.println("initConfig configInfo=" + configInfo);
        } catch (IOException e1) {

        }

        // 启动用，并且变化需要立即推送最新值
        Diamond.addListener("dataId", "group",
                new ManagerListenerAdapter() {
                    public void receiveConfigInfo(String configInfo) {
                        try {
                            config = configInfo;
                            System.out.println("initConfig receiveConfigInfo=" + configInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

    public static void main(String[] args) throws IOException {
        String content = RandomStringUtils.randomAlphabetic(10);
        System.out.println("publish configInfo=" + content);
        Diamond.publishSingle("dataId", "group", content);
        // 如果使用spring，此类等同于init方法
        initConfig();
        // 测试让主线程不退出，因为订阅配置是守护线程，主线程退出守护线程就会退出，实际代码中不需要。
        int i = 5;
        while (i > 0) {
            try {
                Thread.sleep(1000);
                i--;
            } catch (InterruptedException e) {
            }
        }
    }

    // 通过get接口把配置值暴露出去使用
    public static String getConfig() {
        return config;
    }
}
