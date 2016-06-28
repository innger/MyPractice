package com.ryl.learn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
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
        HttpGet get = new HttpGet("http://www.gc-home.com/index.php/Login/index/verify?0.9408039614357924");

        get.setHeader("Cookie", "HPSESSID=ibiflhni9f04fn0vb7ia2tbou1; incap_ses_222_826927=YSGdI1rN+g0A2S7nEbUUA4/uaFcAAAAAxA9pjtgmdvYmWS/hh2A3nQ==; incap_ses_401_826927=gJdJW7/9tlCK6MCylaOQBR0AaVcAAAAAVokAy8yKJEhS+6uWVo9ILg==; visid_incap_826927=56gpyh9IQ4KK7Ze/Zge7wSGfaFcAAAAAQUIPAAAAAACPoV/SFbekgYfNaSuz9XbT; incap_ses_406_826927=b8wzOZti1wcFrPeld2eiBeoAaVcAAAAAE/gJ/TFDFjpPSL9B2niXng==");

        for (int i = 0; i < 20; i++) {
            service.submit(new Worker(client, get, i));
        }

    }

    static class Worker implements Runnable {

        private static AtomicInteger num = new AtomicInteger(0);
        private HttpAsyncClient client;
        private HttpGet get;
        private Integer thread;

        public Worker(HttpAsyncClient client, HttpGet get, Integer thread) {
            this.client = client;
            this.get = get;
            this.thread = thread;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Future<HttpResponse> future = client.execute(get, null);
                    Integer temp = num.getAndIncrement();
                    if(temp % 10 == 0) {
                        System.out.println(temp +" "+Thread.currentThread().getName());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
