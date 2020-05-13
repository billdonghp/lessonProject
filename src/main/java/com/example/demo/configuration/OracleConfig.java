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
@MapperScan(basePackages = {"com.example.demo.mapper.oracle"}, sqlSessionFactoryRef = "sqlSessionFactoryDb2")
public class OracleConfig {
	@Autowired
    @Qualifier("oracle")
    private DataSource dataSourceOracle;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDb2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      //分页插件
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "oracle");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
 
        interceptor.setProperties(properties);
 
        factoryBean.setPlugins(new Interceptor[] {interceptor});

        factoryBean.setDataSource(dataSourceOracle);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/example/demo/mapper/oracle/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDb2());
    }

}
