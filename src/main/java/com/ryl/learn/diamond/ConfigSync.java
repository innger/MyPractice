package com.ryl.learn.diamond;

import com.taobao.diamond.client.Diamond;
import com.taobao.diamond.manager.ManagerListener;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created on 16/5/25 下午1:58.
 */
public class ConfigSync {

    private static final Logger logger = LoggerFactory.getLogger(ConfigSync.class);

    private String appname = "ryl.diamond.appname";
    private String dataId = "ryl.diamond.dataId";
    private String group = "ryl.diamond.group";

    public static void main(String[] args) {
        ConfigSync sync = new ConfigSync();
        sync.syncConfig();

        sync.publishConfig(RandomStringUtils.randomAlphabetic(10));
    }

    private void publishConfig(String content) {
//        boolean res = Diamond.publishSingle(dataId, group, content);
        boolean res = Diamond.publishSingle(dataId, group, appname, content);
        logger.info("publishConfig content={} res={}", content, res);
    }

    private void syncConfig() {
        Diamond.addListener(dataId, group, new ManagerListener() {
            @Override
            public Executor getExecutor() {
                return Executors.newCachedThreadPool();
            }

            @Override
            public void receiveConfigInfo(String s) {
                logger.info("syncConfig receiveConfigInfo s={}" ,s);
            }
        });

    }




}
