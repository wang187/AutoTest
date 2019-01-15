package com.wang.meiyong;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.http.client.ClientProtocolException;

import com.alibaba.fastjson.JSONObject;
import com.wang.util.HttpClientUtil;

public class Test {

    public static void main(String[] args) throws Exception {

        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

        String url = null;

        String filepath = "G://test.xlsx";

        JsonUtil jsonUtil = new JsonUtil();

        //��Excel�ж�ȡ����

        ExcelUtil excelUtil = new ExcelUtil();

        //��ȡExcel����е�URL

        url = excelUtil.read(filepath, "login", 1, 0);
        System.out.println("url:" + url);

        //forѭ����ȡExcel����е�����

        for (int j = 1; j <= 2; j++) {//ѭ��Excel���е���

            for (int i = 0; i <= 8; i++) {//ѭ��Excel������

                map.put(excelUtil.read(filepath, "login", 0, i), excelUtil.read(filepath, "login", j, i));
            }

            System.out.println(map.toString());//�����֤
            String json = JsonUtil.mapToJson(map);//ת��mapΪjson�������������
            //����httpclientʵ��
            HttpClientUtil httpclient = new HttpClientUtil();
            String entityFlow = httpclient.postJson(url, json);
            System.out.println(entityFlow);

//           //д��ӿڷ���ֵ
// 
//           excelUtil.write(filepath, "login", j, 10, entityFlow);
// 
//           //ת������ֵΪjson���ݣ��Ա�ȡ��resultcode�Զ�������״̬���У��
// 
//           JSONObject jo = new JSONObject(entityFlow);
// 
//           String resultCode = jo.get("resultCode").toString();
// 
//           if (resultCode.equals("1000")) {
// 
//              excelUtil.write(filepath, "login", j, 11, "pass");
// 
//           }else {
// 
//              excelUtil.write(filepath, "login", j, 11, "fail");
// 
//           }

        }

    }

}
