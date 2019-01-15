package com.wang.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ��װ�������ݿⷽ��
 *
 * @author Administrator
 */
public class DataBaseUtil {
    /**
     * ��ȡsqlSeesion
     *
     * @return
     * @throws IOException
     */
    public static SqlSession getSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = factory.openSession();
        return sqlSession;

    }

}
