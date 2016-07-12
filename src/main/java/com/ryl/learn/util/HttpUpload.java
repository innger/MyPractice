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
//        uploadApk();
        uploadImage();
//        sendHttp();
    }

    public static void sendHttp() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
//            service.submit(new i2doWorker("http://wan.sogou.com/ajax/i2.do?_=1467959528114"));
//            service.submit(new i2doWorker("http://wan.sogou.com/msg/unreadnum/85646042?callback=jQuery1113009500109593701245_1467960097997&_=1467960097998"));
//            service.submit(new i2doWorker("http://wan.sogou.com/getUserAntiAddiction.do?1=1"));
            service.submit(new i2doWorker("http://mini.wan.sogou.com/v3/feedback.do?x=x"));
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
        url = "http://mini.wan.sogou.com/v1/feedback/upload.do?code=22f172_eppe222@sogou.com";
        url = "http://upload.i.sogou.com/upload.php?f=1&sw=50&lw=100&m=1&p=1&type=logo&upurl=http://haha.sogou.com/setting/";
        String filepath = "/Users/lz/Pictures/";
        for (int i = 0; i < 10; i++) {
            service.submit(new UploadWorker(url, filepath +i +".jpg"));
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
                    HttpPost post = new HttpPost(url + "&t=" + System.nanoTime());
                    post.addHeader("cookie", "SSUID=06FD5CB60350098A1C535E5829DC397F; IPLOC=CN3301; h=F5697B9938AD590725E24EC11D99DC31; r=1091; v=3.1.0.1083; source=1001000900001; JSESSIONID=aaaMaHqluoDL55EuFAjxv; SUV=00F9592CB65CFD06577F5684DFCAC142; swfLayer=1091; ppmdig=1467963221000000580499e60908a7322baac51822d0d3e7; IPLOC=CN3301; JSESSIONID=aaaFRP_LwS7-r4DusBjxv; refreshtoken=N8I6%2FXLSqXH%2BKeSsHykZQY5GtPFb2X0KYEyb%2Fb8LnoCZyBeNucJilCUSXNnwrjwTugX%2F9s3Mub7n7DDOqjCogQ%3D%3D; accesstoken=N8I6%2FXLSqXH%2BKeSsHykZQU0Bluyp%2BPdygN7gs%2BriJcst3ECSPBpHR1OsbvLmgvLUiL4IIxe8zGVrDai09KLhVg%3D%3D; ppinf=5|1467966174|1469175774|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTo3OmVwcGU0NDR8Y3J0OjEwOjE0Njc5NjYxNzR8cmVmbmljazowOnx1c2VyaWQ6MTc6ZXBwZTQ0NEBzb2dvdS5jb218; pprdig=PwcGkBu4-IkUW-5DQU_hDlFzTSrcpJF4pKCISwnZN2uNa0phq1NGEx5np0rFwGX8kHW4kcTIicEI6XIWZ0CQF29wGmfaqi_95wtJ98-GXZFLCdHuHgTjMpUlVSF3rR_MBUhRgv3x9_DIsZkNxD8Jqzj4yqfr3EDgo4ea_OLX9fA; passport=5|1467966174|1469175774|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTo3OmVwcGU0NDR8Y3J0OjEwOjE0Njc5NjYxNzR8cmVmbmljazowOnx1c2VyaWQ6MTc6ZXBwZTQ0NEBzb2dvdS5jb218|d91df07676|PwcGkBu4-IkUW-5DQU_hDlFzTSrcpJF4pKCISwnZN2uNa0phq1NGEx5np0rFwGX8kHW4kcTIicEI6XIWZ0CQF29wGmfaqi_95wtJ98-GXZFLCdHuHgTjMpUlVSF3rR_MBUhRgv3x9_DIsZkNxD8Jqzj4yqfr3EDgo4ea_OLX9fA; email=eppe444%40sogou.com; __limit=1467966171017; ppmdig=1467963221000000859871482f82cda57e5ccf9bf4c40b05; hostid=86087492; spid=1091");

                    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                    nvps.add(new BasicNameValuePair("content", "游戏难度有点大啊"));
                    nvps.add(new BasicNameValuePair("gid", "178"));
                    nvps.add(new BasicNameValuePair("phone", "13814567860"));
                    nvps.add(new BasicNameValuePair("pic", ""));
                    nvps.add(new BasicNameValuePair("qq", "1111"));
                    nvps.add(new BasicNameValuePair("role", "万世"));
                    nvps.add(new BasicNameValuePair("sid", "150"));
                    nvps.add(new BasicNameValuePair("time", "2016-01-01 00:00"));
                    nvps.add(new BasicNameValuePair("type", "10"));

                    post.setEntity(new UrlEncodedFormEntity(nvps, Charsets.UTF_8));

                    HttpResponse response = client.execute(post);
                    System.out.println(current + " " + Thread.currentThread().getName() + " " + count + " " + EntityUtils.toString(response.getEntity()));
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
            builder.addBinaryBody("Filedata", file, ContentType.DEFAULT_BINARY, RandomStringUtils.randomAlphanumeric(10) + ".jpg");
            HttpEntity entity = builder.build();
            HttpPost httppost = new HttpPost(url + "&t=" + System.nanoTime());
            httppost.setEntity(entity);
            httppost.addHeader("Cookie", "SUV=004F7D8DB65CFD03577C64796F108139; pgv_pvi=8242046976; pgv_si=s6700715008; _ga=GA1.2.791106921.1467774573; IPLOC=CN1101; CXID=78B03FEC87FDF83DF09FC8A6BB8480CB; ad=Tyllllllll2gKAAAlllllVNM33wlllllHO8dlkllll9lllllxCxlw@@@@@@@@@@@; SUID=03FD5CB65412940A00000000577CC9E4; ppinf=5|1467966019|1469175619|dHJ1c3Q6MToxfGNsaWVudGlkOjQ6MTEwMHx1bmlxbmFtZTowOnxjcnQ6MTA6MTQ2Nzk2NjAxOXxyZWZuaWNrOjA6fHVzZXJpZDoxNzplcHBlNDQ0QHNvZ291LmNvbXw; pprdig=IUYU9VFQwidsHJ34U_QUr1NYjqsB9MbR7OLFahpm2WEZLJDY02wCKz_Ko9pb-yULU4A_0xcESFEvzRUyecMNaeEDkZiXzNXeDSbSM0h6a-XoMNKl3-hqAUIqIix-hg4ioMGZqLbXRjcvV4LwIBfq_av60u01DIc7HMkDuRukVrs; GOTO=");

            while (true) {
                try {
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
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e);
                }
            }
        }
    }
}
