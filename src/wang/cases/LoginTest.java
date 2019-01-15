package com.wang.cases;

import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSONObject;
import com.wang.model.UserLoginCase;
import com.wang.util.DataBaseUtil;
import com.wang.util.HttpClientUtil;
import com.wang.util.ReadConfig;

public class LoginTest {

    @Test(groups = "loginTrue", description = "测试登录成功")
    public void loginTest() throws Exception {
    	  Login.login();
    }

    @Test(groups = "loginFalse", description = "测试登录失败")
    public void loginTest2() throws Exception {
        SqlSession session = DataBaseUtil.getSession();
        UserLoginCase userLoginCase = session.selectOne("loginCase", 2);
        String url = ReadConfig.URI + ReadConfig.USER_LOGIN_PATH;
        JSONObject param = new JSONObject();
        param.put("mobile", userLoginCase.getChanelStyle());
        param.put("username", userLoginCase.getUsername());
        param.put("pwd", userLoginCase.getPwd());

        String result = HttpClientUtil.postJson(url, param.toString());
        System.out.println(result);
        JSONObject jsonObject = JSONObject.parseObject(result);

        Assert.assertEquals(jsonObject.getString("code"), userLoginCase.getExpected());

    }

}
