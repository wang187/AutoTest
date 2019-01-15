package com.wang.cases;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.wang.model.GetSpecialCareListCase;
import com.wang.util.DataBaseUtil;
import com.wang.util.ReadConfig;

public class GetSpecialCareListTest 
{
     public void getSpecialCareListTest() throws IOException
     {
    	 SqlSession session = DataBaseUtil.getSession();
    	 GetSpecialCareListCase getSpecial= session.selectOne("getSpecial", 1);
    	 String url = ReadConfig.QT_REST_API_URI + ReadConfig.GET_SPECIAL_CARE_LIST_URL;
    	 
     }
	
}
