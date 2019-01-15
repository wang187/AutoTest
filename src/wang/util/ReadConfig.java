package com.wang.util;

import java.util.Locale;
import java.util.ResourceBundle;

import lombok.Data;

/**
 * ��ȡ�����ļ�
 *
 * @author Administrator
 */
@Data
public class ReadConfig {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String URI = bundle.getString("login.url");
    public static String USER_LOGIN_PATH = bundle.getString("userLogin.url");
    public static String QUERY_CUSTOMER_LIST_PATH = bundle.getString("queryCustomerList.url");
    //后台adviser
    public static String QT_REST_API_URI = bundle.getString("qt.rest.api.url"); 
    //特别关心
    public static String GET_SPECIAL_CARE_LIST_URL =bundle.getString("getSpecialCareList.url");
    
    public static void main(String[] args) {
        String uri = ReadConfig.URI + ReadConfig.USER_LOGIN_PATH;
        System.out.println(uri);
    }

}


