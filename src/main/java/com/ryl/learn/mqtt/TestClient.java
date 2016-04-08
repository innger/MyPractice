package com.ryl.learn.mqtt;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by renyulong on 16/2/22.
 */
public class TestClient {

    private static final Logger logger = LoggerFactory.getLogger(TestClient.class);

//    private String host = "tcp://100.69.214.64:1883";
    private String host = "tcp://cmg.amap.com:80";
    private String username = "clientuser";
    private String password = "clientuser";

    private MqttClient client;
    private MqttConnectOptions options;

    private ScheduledExecutorService scheduler;
    private String clientID;

    public TestClient(String clientID) {
        this.clientID = clientID;
    }

    public static void main(String[] args) throws InterruptedException {
        logger.info("begin");
        TestClient client01 = new TestClient("VgpUYx8bX4kDADo+ouGrO+Nf123");
        client01.init();

//        TimeUnit.SECONDS.sleep(2);

//        TestClient client02 = new TestClient("abc");
//        client02.init();

//        client01.sendMessage();
//        client02.sendMessage();
    }

    private void startReconnect() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (!client.isConnected()) {
                    try {
                        client.connect(options);
                        logger.info("reconnect success.");
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0 * 1000, 10 * 1000, TimeUnit.MILLISECONDS);
    }

    private void init() {
        try {
            //host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
//            clientID = UUID.randomUUID().toString().replace("-", "");
            client = new MqttClient(host, clientID, new MemoryPersistence());
            //MQTT的连接设置
            options = new MqttConnectOptions();
            //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            //设置连接的用户名
            options.setUserName(username);
            //设置连接的密码s
            password = DigestUtils.md5Hex(username + "@" + "E4fMLkiLJeHdBhlK3AFxTLoZSc1bBjtG");
            options.setPassword(password.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(10);
            //设置回调
            client.setCallback(new MqttCallback() {

                public void connectionLost(Throwable cause) {
                    //连接丢失后，一般在这里面进行重连
                    logger.info("{} connectionLost reconnect...", clientID);
                    startReconnect();
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    //publish后会执行到这里
                    logger.info("{} deliveryComplete {}", clientID, token.isComplete());
                }

                public void messageArrived(String topicName, MqttMessage message)
                        throws Exception {
                    //subscribe后得到的消息会执行到这里面
//                    String str = new String(message.getPayload(), CharsetUtil.UTF_8);
//                    LoginMessage login = new LoginMessage();
//                    login.readFromByteArr(message.getPayload());

                    logger.info("{} messageArrived topic={} message={}", clientID, topicName, message);
                }
            });
            client.connect(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client.connect(options);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void sendMessage() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                //登录
                LoginMessage login = new LoginMessage();
                login.setMessageId(System.currentTimeMillis());
                login.setDate(new Date());
                login.setUserId(clientID);
                login.setToken(CommonConst.SEED);

                MqttMessage message = new MqttMessage();
                message.setQos(1);
                message.setRetained(true);
                message.setPayload(login.writeToByteArr());

                try {
                    String topic = CommonConst.TOPIC_LOCATION;
                    client.getTopic(topic).publish(message);
                    logger.info("{} send message topic={} {}", clientID, topic, login.toString());
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        }, 60 * 1000, 10 * 60 * 1000, TimeUnit.MILLISECONDS);

    }

}
