package com.wang.util;

import java.io.IOException;

import javax.xml.ws.Response;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * ��װ��post��get����
 *
 * @author Administrator
 */
public class HttpClientUtil {
    /**
     * ��������json��ʽ
     *
     * @param url
     * @param json
     * @return
     * @throws Exception
     */
    public static String postJson(String url, String json) throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        StringEntity entity = new StringEntity(json);
        System.out.println("entity:" + entity);
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        //��ʵ���������post������
        post.setEntity(entity);
        //ִ������
        CloseableHttpResponse response = httpClient.execute(post);
        //����ȡ����Ӧת�����ַ���
        String entityFlow = EntityUtils.toString(response.getEntity());
        response.close();
        httpClient.close();

        return entityFlow;

    }

    /**
     * ����ͨ��ʽ��Post����
     *
     * @param url
     * @return
     * @throws IOException
     * @throws ClientProtocolException
     * @throws Exception
     */
    public static String post(String url, String param) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost();
        StringEntity entity = new StringEntity(param);
        httpPost.setHeader("content-type", "application/x-www-form-urlencoded");
        httpPost.setEntity(entity);
        CloseableHttpResponse rsponse = httpclient.execute(httpPost);
        String entityFlow = EntityUtils.toString(rsponse.getEntity());
        rsponse.close();
        httpclient.close();

        return entityFlow;
    }


    public String get(String url) throws Exception {
        //����һ��Ĭ�ϵ�httpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet();

        httpGet.setHeader("content-type", "application/json;charset=UTF-8");
        //��������
        CloseableHttpResponse response = httpclient.execute(httpGet);
        //��ȡ��Ӧ����
        String entityFlow = EntityUtils.toString(response.getEntity());

        response.close();
        httpclient.close();

        return entityFlow;

    }


}
