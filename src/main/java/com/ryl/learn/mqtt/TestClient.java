package com.ryl.learn.mqtt;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * mqtt client示例代码
 * Created on 16/2/22.
 */
public class TestClient {
    
    private static final Logger logger = LoggerFactory.getLogger(TestClient.class);
    
    private static String hostLocal = "tcp://127.0.0.1:1883";
    private static String hostDaily = "tcp://100.69.214.64:1883";
    private static String hostPub = "tcp://cmg.amap.com:80"; //140.205.61.30
    private static String hostPre = "tcp://140.205.173.46:80";
    
    private String username = "clientuser";
    private String password = "clientuser";
    
    private MqttClient client;
    private MqttConnectOptions options;
    
    private ScheduledExecutorService scheduler;
    private String clientID;
    private String host;
    
    public TestClient(String clientID, String host) {
        this.clientID = clientID;
        this.host = host;
    }
    
    public TestClient() {
    }
    
    public static void main(String[] args) throws InterruptedException {
        logger.info("begin");
        /*int pool = 100;
        ExecutorService service = Executors.newFixedThreadPool(pool);
        for (int i = 0; i < 1; i++) {
            service.execute(() -> {
                //VgpUYx8bX4kDADo+ouGrO+Nf
                //Vbl3qJ+gJx0DAG417p8TpRRC
                String clientID = StringUtils.remove(UUID.randomUUID().toString(),"-");
                clientID = "VgpUYx8bX4kDADo+ouGrO+Nf";
                TestClient client01 = new TestClient(clientID, hostPub);
                client01.init();
            });
        }*/
        //"C81F662B8ADDC81F662B8AAA" "VqliqZ8RCeIDAGoFiWoeic+Z" "VR47gRd8UGUDAAW8KIIQn8T812","VR47gRd8UGUDAAW8KIIQn8T813", "Vjxy6OdR7KIDANJzIuKS2tX1"
        String[] tids = new String[]{"C81F662B8ADDC81F662B8AAA"};
        for (String tid : tids) {
            logger.info("tid={}", tid);
            TestClient client = new TestClient(tid, hostDaily);
            client.init();
        }
//        socketConnect();
    }
    
    private static void socketConnect() {
        try {
            Socket socket = new Socket("127.0.0.1", 1883);
            InputStream is = socket.getInputStream();
            while (true) {
                byte[] bytes = new byte[1024];
                int n = is.read(bytes);
                if (n == -1) break;
                System.out.println(new String(bytes));
            }
            System.out.println("end");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            client = new MqttClient(host, clientID, new MemoryPersistence());
            //MQTT的连接设置
            options = new MqttConnectOptions();
            //设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(false);
            //设置连接的用户名
            options.setUserName(username);
            //设置连接的密码  E4fMLkiLJeHdBhlK3AFxTLoZSc1bBjtG
            password = DigestUtils.md5Hex(username + "@" + "xDgLf9ARoS1HN1QEvnWAdstAD8HKy1jR"); 
            options.setPassword(password.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(5);
            Map<String, Object> will = Maps.newHashMap();
            will.put("tid", clientID);
            will.put("channel", "auto_amap");
            will.put("dip", 17020);
            will.put("dic", "C04020001234");
            will.put("diu", "fdajkfdklafdndjfdjkl2r49djfaj4kjj");
            will.put("uid", 30885752); //1699077
            will.put("sessionid", "19jfrqyajzm9dvccc68ebkdh01vthz4i");
            will.put("deviceid", "aaaa");
            will.put("autodiv", "ANDA0203000");
            options.setWill("user", JSON.toJSONBytes(will), 1, false);
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
            logger.info("{} connect to server {}", clientID, host);
            logger.info("will message={}", JSON.toJSONString(will));
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
