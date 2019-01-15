package com.wang.cases;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.nodes.Entities;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSONObject;
import com.wang.model.QueryCustomerListCase;
import com.wang.post.Common;
import com.wang.util.DataBaseUtil;
import com.wang.util.HttpClientUtil;
import com.wang.util.ReadConfig;


public class QueryCustomerListTest {
    @Test(groups = "loginTrue", description = "获取用户列表")
    public void queryCustomerListTest() throws Exception {
    	//获取session操作数据库
        SqlSession session = DataBaseUtil.getSession();
        //查询一条数据
        QueryCustomerListCase queryCustomerList = session.selectOne("queryCustomerList", 1);
        String userName = queryCustomerList.getUserName();
        String ver = queryCustomerList.getVer();
        String device = queryCustomerList.getDevice();
        String expected = queryCustomerList.getExpected();
        
        //url拼接
        String url = ReadConfig.QT_REST_API_URI+ReadConfig.QUERY_CUSTOMER_LIST_PATH
        		  + "?" + "userName=" + userName + "&" + "ver=" + ver + "&"+ "device=" + device;

        System.out.println("拼接后的url地址为：" + url);
        //调用登录
        String str = Login.login();
        //获取token
        String value = Common.getJsonString(str, "data", "token");
        System.out.println("token:" + value);
        //创建一个http请求
      CloseableHttpClient  httpClient = HttpClients.createDefault();
      HttpPost httpPost = new HttpPost(url);
       //将token放入到header中
      httpPost.addHeader("token", value);
      
      Header[] he =  httpPost.getAllHeaders();
      for(Header hs:he)
      {
    	  System.out.println("hs :"+ hs);  
      }

      JSONObject param = new JSONObject();
      param.put("custCategory", "0");
      param.put("device", "ios");
      param.put("lendState", "0");
      param.put("pageSize", "25");
      param.put("pageNum", "1");
      param.put("secondCategory", "0");
      param.put("userName", "00002000");
      param.put("ver", "1.0.0");
//      String parm = JSONObject.toJSONString(param);
//       System.out.println("parm :" +parm );
       
      StringEntity entity = new StringEntity(param.toString());
      entity.setContentType("form/data");
      
      httpPost.setEntity(entity);
      System.out.println("entity:"+entity);
      CloseableHttpResponse response = httpClient.execute(httpPost);  
      System.out.println("response :" +response);
      String entityFlow = EntityUtils.toString(response.getEntity());
      System.out.println(entityFlow);
      
      String code = Common.getJsonString(entityFlow, "code");
      Assert.assertEquals(code, expected);
      

    }
}
