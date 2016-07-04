package com.ryl.learn.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * wan图片上传
 * Created on 16/7/4 下午4:48.
 */
public class HttpUpload {

    private String username = "eppe123@sogou.com";
    private String password = "123456";
    private static final String url = "http://wan.sogou.com/feedback/upload.do?code=72089c_eppe123%40sogou.com";
    private static final String filepath = "/Users/alibaba/Documents/p1465257560.jpg";


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            service.submit(new UploadWorker());
        }
    }

    static class UploadWorker implements Runnable {
        @Override
        public void run() {
            HttpClient httpclient = HttpClientBuilder.create().build();
            HttpPost httppost = new HttpPost(url);
            File file = new File(filepath);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
            builder.addBinaryBody("file", file, ContentType.DEFAULT_BINARY, RandomStringUtils.randomAlphanumeric(10) + ".jpg");
            HttpEntity entity = builder.build();
            httppost.setEntity(entity);
            while (true) {
                try {
                    HttpResponse response = httpclient.execute(httppost);
                    int statusCode = response.getStatusLine().getStatusCode();
                    if (statusCode == HttpStatus.SC_OK) {
                        HttpEntity resEntity = response.getEntity();
                        String result = EntityUtils.toString(resEntity);
                        System.out.println(Thread.currentThread().getName() + " " + result);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
