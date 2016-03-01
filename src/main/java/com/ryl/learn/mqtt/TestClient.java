package com.ryl.learn.mqtt;

import io.netty.util.CharsetUtil;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by renyulong on 16/2/22.
 */
public class TestClient {

    //    private String host = "tcp://30.28.177.59:1883";
    private String host = "tcp://127.0.0.1:1883";
    private String username = "clientuser";
    private String password = "testuser";

    private MqttClient client;
    private MqttConnectOptions options;

    private ScheduledExecutorService scheduler;
    private String clientID;

    private void startReconnect() {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Runnable() {
            public void run() {
                if (!client.isConnected()) {
                    connect();
                }
            }
        }, 0 * 1000, 10 * 1000, TimeUnit.MILLISECONDS);
    }

    private void init() {
        try {
            //host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            clientID = UUID.randomUUID().toString();
            client = new MqttClient(host, clientID, new MemoryPersistence());
            //MQTT的连接设置
            options = new MqttConnectOptions();
            //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            //设置连接的用户名
            options.setUserName(username);
            //设置连接的密码
            options.setPassword(password.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            //设置回调
            client.setCallback(new MqttCallback() {

                public void connectionLost(Throwable cause) {
                    //连接丢失后，一般在这里面进行重连
                    System.out.println("connectionLost----------");
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    //publish后会执行到这里
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }

                public void messageArrived(String topicName, MqttMessage message)
                        throws Exception {
                    //subscribe后得到的消息会执行到这里面
                    String str = new String(message.getPayload(), CharsetUtil.UTF_8);
                    System.out.println(clientID + " messageArrived---------- " + topicName + " " + str);
                }
            });
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
                    client.subscribe(CommonConst.COMMON_TOPIC);
                    String clientTopic = CommonConst.COMMON_TOPIC + "/" + clientID;
                    client.subscribe(clientTopic);

                    //登录
                    LoginMessage login = new LoginMessage();
                    login.setMessageId(System.currentTimeMillis());
                    login.setDate(new Date());
                    login.setUserId(clientID);
                    login.setToken(CommonConst.SEED);

                    MqttMessage message = new MqttMessage();
                    message.setQos(2);
                    message.setRetained(true);
                    message.setPayload(login.writeToByteArr());

                    client.getTopic(CommonConst.LOGIN_TOPIC).publish(message);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public static void main(String[] args) {
        TestClient client = new TestClient();
        client.init();
        client.connect();
    }

}