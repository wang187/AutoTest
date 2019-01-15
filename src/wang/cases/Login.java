package com.wang.cases;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.Reporter;
import com.alibaba.fastjson.JSONObject;
import com.wang.model.UserLoginCase;
import com.wang.post.Common;
import com.wang.util.DataBaseUtil;
import com.wang.util.HttpClientUtil;
import com.wang.util.ReadConfig;

public class Login
{
        public static String login() throws Exception
        {
            SqlSession session = DataBaseUtil.getSession();
            UserLoginCase userLogin = session.selectOne("loginCase", 1);
            
            String userName = userLogin.getUsername();
            String ver = userLogin.getVer();
            String device = userLogin.getDevice();
            String expected = userLogin.getExpected();
            //获取uri
            String uri = ReadConfig.URI + ReadConfig.USER_LOGIN_PATH;
            System.out.println("url :" + uri);
            Reporter.log("uri地址" + uri);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost(uri);
            JSONObject res = new JSONObject();
            res.put("chanelStyle", userLogin.getChanelStyle());
            res.put("pwd", userLogin.getPwd());
            res.put("userName", userLogin.getUsername());
            String  str = JSONObject.toJSONString(res);
            
            System.out.println("str  :" + str);

            StringEntity entity = new StringEntity(str);
            System.out.println("entity:" + entity);
            entity.setContentEncoding("UTF-8");
            entity.setContentType("form/data");
            post.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(post);
            String entityFlow = EntityUtils.toString(response.getEntity());
            System.out.println("entityFlow :" + entityFlow);

            String code = Common.getJsonString(entityFlow, "code");
            
            Assert.assertEquals(code, expected);
            return entityFlow;
        }
        
//        public static void main(String[] args) throws Exception {
//			String str = login();
//			System.out.println("str :" + str);
//		}
}
