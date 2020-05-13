package com.example.demo.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.github.pagehelper.PageInterceptor;

import tk.mybatis.spring.annotation.MapperScan;
@Configuration
@MapperScan(basePackages = {"com.example.demo.mapper.mysql"}, sqlSessionFactoryRef = "sqlSessionFactoryDb1")
public class MySqlConfig {
	@Autowired
    @Qualifier("mysql")
    private DataSource dataSourceMysql;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDb1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        PageInterceptor interceptor1 = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        interceptor1.setProperties(properties);
        factoryBean.setPlugins(new Interceptor[] {interceptor1});
        factoryBean.setDataSource(dataSourceMysql);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/demo/mapper/mysql/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDb1());
    }
}
