package com.wang.meiyong;

import java.util.LinkedHashMap;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {

    public static String mapToJson(LinkedHashMap<String, String> map) {
        //����һ��json����
        JSONObject json = new JSONObject();
        //��map���ݴ�ŵ�json��
        json.put("map", map);
//		String jso = json.get(map).toString();
        String jso = json.toJSON(map).toString();
        System.out.println("ת����json���ݺ�" + jso);
        return jso;
    }

}
