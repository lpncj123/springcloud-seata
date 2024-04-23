package cn.lp.springdubboorder.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @BelongsProject: springbootdubbo
 * @BelongsPackage: cn.lp.springdubboorder.config
 * @Author: lp
 * @CreateTime: 2023-04-27  13:44
 * @Description: TODO
 * @Version: 1.0
 */
//解决nacos配置数据源不能够先读到，导致seata失效的问题
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean
    public DataSource dataSource(){

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/indexexample");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("P@ssword123");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        DataSourceProxy dataSourceProxy = new DataSourceProxy(druidDataSource);
        return dataSourceProxy;

    }
}
