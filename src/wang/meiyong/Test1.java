package com.wang.meiyong;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.util.EntityUtils;

/**
 * post�������������ͨ�ĸ�ʽ
 *
 * @author Administrator
 */
public class Test1 {
    static HttpClientContext context = HttpClientContext.create();
    static CloseableHttpClient httpClient;

    public static String sendPost(String url, String postData) {
        String result = "";
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        //�����Ľ��б��봦��
        StringEntity entity = new StringEntity(postData, "UTF-8");
        //���ñ���
        entity.setContentEncoding("UTF-8");
        //���������������ͣ�json��form
        entity.setContentType("application/x-www-form-urlencoded");
        httpPost.setEntity(entity);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost, context);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * ��ȡcookie
     *
     * @param name
     * @return
     */
    public static String getCookies(String name) {
        List<Cookie> cookies = context.getCookieStore().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("JSESSIONID")) {
                String JSESSIONID = cookie.getValue();
                System.out.println("JSESSIONID : " + JSESSIONID);
                return JSESSIONID;

            } else if (cookie.getName().equals("cookie_user")) {
                String cookie_user = cookie.getValue();
                System.out.println(cookie_user);
                return cookie_user;
            }
        }
        return null;

    }

    private static CookieStore cookieStore;

    static {
        cookieStore = new BasicCookieStore();
        // ��CookieStore���õ�httpClient��
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    }

    /**
     *
     */


    /**
     * @param args
     */
//      public static void 
    public static void main(String[] args) {
        String url = "http://10.100.200.101:81";
        String data = "loginName=admin&loginPwd=gq12345";

        String url1 = "http://10.100.200.101:81/customer/syncCustInfoToLend?";
        String data1 = "ids=1080817";

//		String data = "businessNumber=";

        String str = sendPost(url, data);
        String cookie = getCookies(str);
        System.out.println(str);
        System.out.println("cookie :" + cookie);
    }

}
