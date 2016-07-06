package com.ryl.learn.util;

import com.google.common.base.Charsets;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * wan图片上传
 * Created on 16/7/4 下午4:48.
 */
public class HttpUpload {

    private String username = "eppe123@sogou.com"; //eppe111 eppe222
    private String password = "123456";
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final String format = "yyyy-MM-dd HH:mm:ss";


    public static void main(String[] args) {
        uploadApk();
//        uploadImage();
//        sendHttp();
    }

    public static void sendHttp() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        String url = "http://www.clctrip.com/app/user/send_code.json";
        for (int i = 0; i < 1; i++) {
            service.submit(new i2doWorker(url));
        }
    }

    public static void uploadApk() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        String url = "http://open.wan.sogou.com/api/game/create/demo/upload?1=1";
        String filepath = "/Users/lz/Downloads/Animal_liqucn_1.33.apk";
        for (int i = 0; i < 10; i++) {
            service.submit(new UploadWorker(url, filepath));
        }
    }

    public static void uploadImage() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        String url = "http://wan.sogou.com/feedback/upload.do?code=70c03a_eppe333%40sogou.com";
        String filepath = "/Users/lz/Pictures/";
        for (int i = 0; i < 10; i++) {
            service.submit(new UploadWorker(url, filepath + i + ".jpg"));
        }
    }

    static class i2doWorker implements Runnable {

        private String url;

        public i2doWorker(String url) {
            this.url = url;
        }

        @Override
        public void run() {
            HttpClient client = HttpClientBuilder.create().build();
            while (true) {
                try {
                    String current = new DateTime().toString(format);
                    HttpPost post = new HttpPost(url);
                    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                    nvps.add(new BasicNameValuePair("to", "15210830381"));
                    post.setEntity(new UrlEncodedFormEntity(nvps, Charsets.UTF_8));
                    HttpResponse response = client.execute(post);
                    System.out.println(current + " " + Thread.currentThread().getName() + " " + EntityUtils.toString(response.getEntity()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class UploadWorker implements Runnable {

        private String url;
        private String filepath;

        public UploadWorker(String url, String filepath) {
            this.url = url;
            this.filepath = filepath;
        }

        @Override
        public void run() {
            HttpClient httpclient = HttpClientBuilder.create().build();
            File file = new File(filepath);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, RandomStringUtils.randomAlphanumeric(10) + ".jpg");
            HttpEntity entity = builder.build();
            while (true) {
                try {
                    HttpPost httppost = new HttpPost(url + "&t=" + System.nanoTime());
                    httppost.setEntity(entity);
                    httppost.addHeader("Cookie", "swfLayer=1; SUV=004F7D8DB65CFD03577C64796F108139; pgv_pvi=8242046976; pgv_si=s6700715008; GOTO=; _ga=GA1.2.791106921.1467774573; IPLOC=CN1101; SUID=03FD5CB65412940A00000000577CC9E4; source=0010000100000; countdate=1|1467801812; email=eppe333%40sogou.com; JSESSIONID=aaapRZJZYX1LthVxv69wv; hostid=85749493; ppinf=5|1467802164|1469011764|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTowOnxjcnQ6MTA6MTQ2NzgwMjE2NHxyZWZuaWNrOjA6fHVzZXJpZDoxNzplcHBlMjIyQHNvZ291LmNvbXw; pprdig=OiC292MQTFH5CuRgiZcWYrBSq-wsw9k7kLxwSztRq72wizaLBrYGzWVlddMFb6owA36VkVuhGjJpaWdvh1X8Ft29dQH51Uq_GymB1RWn8d1QWRDcAfdzeJG6Y--HwvBHtRzVFghxlwNXOrDe0eG6WKRD5zKtGyQ0WkQXnZOiDvU; ppmdig=1467802164000000e3476b8ff23581871d75913e5f53848d");
                    HttpResponse response = httpclient.execute(httppost);
                    String current = new DateTime().toString(format);
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode == HttpStatus.SC_OK) {
                        HttpEntity resEntity = response.getEntity();
                        String result = EntityUtils.toString(resEntity);
                        System.out.println(current + " " + Thread.currentThread().getName() + " " + statusCode + "/" + result + " " + count.incrementAndGet());
                    } else {
                        System.out.println(current + " " + Thread.currentThread().getName() + " " + statusCode);
                    }
//                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e);
                }
            }
        }
    }
}
