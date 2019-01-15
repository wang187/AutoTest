package com.wang.post;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSONObject;

/**
 * post���󣬲�������json��ʽ
 *
 * @author Administrator
 */
public class Common {
    static JSONObject response = null;

    public static String dopost(String url, JSONObject json) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            StringEntity se = new StringEntity(json.toString());
            se.setContentEncoding("Utf-8");
            //����json������Ҫ����contentType
            se.setContentType("application/json");
            httpPost.setEntity(se);
            try {
                HttpResponse res = httpClient.execute(httpPost);
                if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = EntityUtils.toString(res.getEntity());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取json里面的值ֵ
     *
     * @param args
     */
    public static String getJsonString(String result, String data, String jsonId) {
        if (result == null && result.trim().length() < 1 && data == null && jsonId == null) {
            return null;
        }
        response = JSONObject.parseObject(result);
        System.out.println(response);
        JSONObject json = response.getJSONObject(data);
        String value = json.getString(jsonId);
        return value;
    }

    /**
     * ��ȡjson�г�data֮�������
     *
     * @param args
     */
    public static String getJsonString(String result, String jsonId) {
        if (result == null && result.length() < 1 && jsonId == null) {
            return null;
        }
        response = JSONObject.parseObject(result);
        String value = response.getString(jsonId);
        return value;
    }


    public static void main(String[] args) {
        String url = "http://10.100.200.68:8083/user/login";

        JSONObject res = new JSONObject();
        res.put("chanelStyle", "MOBILE");
        res.put("pwd", "123456");
        res.put("userName", "00002000");

        String result = dopost(url, res);
        System.out.println("result:" + result);

        String value = getJsonString(result, "data", "token");
        System.out.println("token :" + value);
        String value1 = getJsonString(result, "code");
        System.out.println("code :" + value1);

    }
}
