package com.ryl.learn.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.nio.client.HttpAsyncClient;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
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
//        uploadApk();
//        uploadImage();
        sendHttp();
    }

    public static void sendHttp() {
        ExecutorService service = Executors.newFixedThreadPool(9);
        for (int i = 0; i < 3; i++) {
            service.submit(new i2doWorker("http://wan.sogou.com/ajax/i2.do?_=1467959528114"));
            service.submit(new i2doWorker("http://wan.sogou.com/msg/unreadnum/85646042?callback=jQuery1113009500109593701245_1467960097997&_=1467960097998"));
            service.submit(new i2doWorker("http://wan.sogou.com/getUserAntiAddiction.do?1=1"));
        }
    }

    public static void uploadApk() {
        ExecutorService service = Executors.newFixedThreadPool(1);
        //open wan 上传接口没有做登录限制
        String url = "http://open.wan.sogou.com/api/game/create/demo/upload?1=1";
//        url = "http://open.wan.sogou.com/api/file/upload/image?1=1";
        String filepath = "/Users/lz/Downloads/Animal_liqucn_1.33.apk";
        for (int i = 0; i < 1; i++) {
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
//            HttpClient client = HttpClientBuilder.create().build();
            CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();
            client.start();
            while (true) {
                try {
                    String current = new DateTime().toString(format);
                    HttpGet get = new HttpGet(url + "&t=" + System.nanoTime());
                    get.addHeader("cookie", "SUV=004F7D8DB65CFD03577C64796F108139; IPLOC=CN3301; JSESSIONID=aaapRZJZYX1LthVxv69wv; IESESSION=alive; tencentSig=5346518016; pgv_pvi=8242046976; pgv_si=s6700715008; GOTO=; _ga=GA1.2.791106921.1467774573; IPLOC=CN1101; _qddab=3-ib1dbf.iqar31xl; countdate=1|1467801812; email=eppe333%40sogou.com; ppinf=5|1467858213|1469067813|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTowOnxjcnQ6MTA6MTQ2Nzg1ODIxM3xyZWZuaWNrOjA6fHVzZXJpZDoxNzplcHBlMjIyQHNvZ291LmNvbXw; pprdig=ALSd6GQgQCVSOvs65qdlddkvUx4ZtG0gtxihR2z2C3MGKmd-3gLTMad2_z_GdTGH6Hq-FNwNo6Yrj1jsm1jfR3tyaeHA7I_KQzZyoDwUCbUPO6GV2YlKmvLV692TAmJGP7U8UXmoFf01u68kAtVlOO6sStTHM3SO6J3O0DzqnQo; CXID=78B03FEC87FDF83DF09FC8A6BB8480CB; ad=Tyllllllll2gKAAAlllllVNM33wlllllHO8dlkllll9lllllxCxlw@@@@@@@@@@@; SUID=03FD5CB65412940A00000000577CC9E4; swfLayer=1; ppmdig=1467959249000000a75c14664d14701486b920be93bf553e; JSESSIONID=aaapRZJZYX1LthVxv69wv; source=0010000100000; hostid=85646042");
//                    HttpPost post = new HttpPost(url);
//                    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//                    nvps.add(new BasicNameValuePair("to", "15210830381"));
//                    post.setEntity(new UrlEncodedFormEntity(nvps, Charsets.UTF_8));
                    client.execute(get, new FutureCallback<HttpResponse>() {
                        @Override
                        public void completed(HttpResponse response) {
                            int num = count.incrementAndGet();
                            if(num % 1000 == 0) {
                                try {
                                    System.out.println(current + " " + Thread.currentThread().getName() + " " + num + " " + EntityUtils.toString(response.getEntity()));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }

                        @Override
                        public void failed(Exception e) {
                            System.err.println("failed" + e);
                        }

                        @Override
                        public void cancelled() {

                        }
                    });
                } catch (Exception e) {
                    System.err.println(e);
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
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e);
                }
            }
        }
    }
}
