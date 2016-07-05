package com.ryl.learn.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
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

    private String username = "eppe123@sogou.com";
    private String password = "123456";
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final String format = "yyyy-MM-dd HH:mm:ss";


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        String url = "http://wan.sogou.com/feedback/upload.do?code=72089c_eppe123%40sogou.com";
        String filepath = "/Users/lz/Pictures/8.jpg";
        url = "http://wan.sogou.com/ajax/i2.do?_=" + System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            service.submit(new i2doWorker(url));
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
                    HttpGet get = new HttpGet(url + "&t=" + System.nanoTime());
                    get.setHeader("Cookie", "CXID=3876CF391442AC65E57C17541A202744; SUV=00A0649FB65CFD07575D3579A0098619; IPLOC=CN1101; sct=1; LSTMV=184%2C245; LCLKINT=4544; ad=VZllllllll2ggFq1lllllVNKda1lllllHO8dxZlllltlllllRs9QRs@@@@@@@@@@; SUID=07FD5CB66573860A575D357400089E8A; _ga=GA1.2.1038229258.1467621207; JSESSIONID=aaasrk7wW84xn8FfPc1wv; ppinf=5|1467626713|1468836313|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTowOnxjcnQ6MTA6MTQ2NzYyNjcxM3xyZWZuaWNrOjA6fHVzZXJpZDoxNzplcHBlMTIzQHNvZ291LmNvbXw; pprdig=wXSPKNWFTA_Pcp7Fzvl9hSJxlEYJH5J9gB_UM-2g1phRrNResNv70OPXwsFDt6S8YNWd43_WeP1HhEBoQgCLrsCrhLMWOPa58Iu_CTC0EpyPpmMoKh7_4NStTq0YmTcbYjxBb2P-Jqm0E7pjTIWwrj5aekS-TPfno99Ey5cpsT0; email=eppe123%40sogou.com; ppmdig=14677109800000008cda4c9c60a31fe0d072826047746c4b; swfLayer=1; JSESSIONID=aaasrk7wW84xn8FfPc1wv; source=0010000100000; hostid=85159915");
                    HttpResponse response = client.execute(get);
                    System.out.println(current + " " + Thread.currentThread().getName() + " " + EntityUtils.toString(response.getEntity()).substring(0,100));
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
            HttpPost httppost = new HttpPost(url + "&t=" + System.currentTimeMillis());
            File file = new File(filepath);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, RandomStringUtils.randomAlphanumeric(10) + ".jpg");
            HttpEntity entity = builder.build();
            httppost.setEntity(entity);
            while (true) {
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    String current = new DateTime().toString(format);
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode == HttpStatus.SC_OK) {
                        HttpEntity resEntity = response.getEntity();
                        String result = EntityUtils.toString(resEntity);
                        System.out.println(current + " " + Thread.currentThread().getName() + " " + result + " " + count.incrementAndGet());
                    } else {
                        System.out.println(current + " " + Thread.currentThread().getName() + " " + statusCode);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e);
                }
            }
        }
    }
}
