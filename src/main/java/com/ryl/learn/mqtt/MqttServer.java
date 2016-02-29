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
//    private String host = "tcp://30.28.177.59:1883";
    private String host = "tcp://mqtt.ons.aliyun.com:1883";


    private String username = "serveruser";
    private String password = "testuser";

    private MqttTopic topic;
    private MqttMessage message;

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
                    if(topic.equals(CommonConst.LOGIN_TOPIC)){
                        //验证登录
                        try {
                            LoginMessage login = new LoginMessage();
                            login.readFromByteArr(message.getPayload());
                            System.out.println(login.getUserId() + " login success.");

                            MqttMessage mmsg = new MqttMessage();
                            mmsg.setQos(2);
                            mmsg.setRetained(true);
                            mmsg.setPayload((new Date().toString() + " " + login.getUserId() + " login succes.").getBytes(CharsetUtil.UTF_8));
                            String ctopic = CommonConst.COMMON_TOPIC+"/"+login.getUserId();
                            mqttClient.getTopic(ctopic).publish(mmsg);
                        }catch (Exception ex){
                            System.err.println(ex);
                        }
                    }

                }
            });

            mqttClient.connect(options);
            mqttClient.subscribe(CommonConst.LOGIN_TOPIC);
            topic = mqttClient.getTopic(CommonConst.COMMON_TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sendMessage() {
        service.scheduleAtFixedRate(new Runnable() {
            public void run() {
                try {
                    System.out.println("sendMessage begin.");
                    message = new MqttMessage();
                    message.setQos(1);
                    message.setRetained(true);
                    message.setPayload((new Date().toString() + " 测试消息,测试消息").getBytes(CharsetUtil.UTF_8));
                    topic.publish(message);
                    System.out.println("sendMessage finish.");
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 60, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        MqttServer server = new MqttServer();
        server.connect();
        server.sendMessage();
    }

}
