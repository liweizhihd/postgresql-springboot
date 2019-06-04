package com.example.postgresdemo.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.postgresdemo.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Auther: liweizhi
 * @Date: 2019/4/28 11:04
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.example.postgresdemo.dao.pocdb"}, sqlSessionTemplateRef = "pocdbSqlSessionTemplate")
public class DataSourcepocdb {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.pocdb")
    public DataSource pocdbDataSource() {
        //return DataSourceBuilder.create().build();
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactory pocdbSqlSessionFactory(@Qualifier("pocdbDataSource") DataSource dataSource)
            throws Exception {
        return DataSourceUtil.getSqlSessionFactory(dataSource, "classpath:mybatis/pocdb/*.xml");
    }

    /*@Bean
    public DataSourceTransactionManager pocdbTransactionManager(@Qualifier("pocdbDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }*/

    @Bean
    public SqlSessionTemplate pocdbSqlSessionTemplate(@Qualifier("pocdbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
