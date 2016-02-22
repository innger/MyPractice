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
 * http://docs.emqtt.cn/zh_CN/latest/getstarted.html
 * http://emqtt.cn/
 * Created by renyulong on 16/2/22.
 */
public class MqttServer {

    private MqttClient mqttClient;
    private String host = "tcp://127.0.0.1:1883";

    private String username = "testserverid1";
    private String password = "";

    private MqttTopic topic;
    private MqttMessage message;

    private String myTopic = "test/topic";

    private ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public MqttServer() {
        try {
            String clientId = UUID.randomUUID().toString();
            mqttClient = new MqttClient(host, clientId, new MemoryPersistence());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            mqttClient.setCallback(new MqttCallback() {
                public void connectionLost(Throwable cause) {
                    System.err.println("connectionLost-----------");
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }

                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("messageArrived----------" + topic + message);

                }
            });

            topic = mqttClient.getTopic(myTopic);
            mqttClient.connect(options);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sendMessage() {
        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    System.out.println("sendMessage begin ...");
                    message = new MqttMessage();
                    message.setQos(1);
                    message.setRetained(true);
                    message.setPayload((new Date().toString() + " renyulong-test-message").getBytes(CharsetUtil.UTF_8));
                    topic.publish(message);
                    System.out.println("sendMessage finish.");
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);

    }

    public static void main(String[] args) {
        MqttServer server = new MqttServer();
        server.connect();
        server.sendMessage();
    }

}
