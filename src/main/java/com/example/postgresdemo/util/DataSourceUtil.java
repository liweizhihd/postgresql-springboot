package com.example.postgresdemo.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 11:14
 * @Description:
 */
public class DataSourceUtil {
    /**
     * 给指定路径下的mapper.xml绑定数据源
     *
     * @param dataSource     数据源
     * @param mapperLocation xml路径，例如：classpath*:com/test/mapper/mapping/*.xml
     * @return
     * @throws Exception
     */
    public static SqlSessionFactory getSqlSessionFactory(DataSource dataSource, String mapperLocation)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        return bean.getObject();

    }

    /**
     * 给指定路径下的mapper.xml绑定数据源
     *
     * @param dataSource     数据源
     * @return
     * @throws Exception
     */
    public static SqlSessionFactory getSqlSessionFactory(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();

    }
}
