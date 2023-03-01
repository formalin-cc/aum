package io.syd.aum.ucore.dao.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 多数据源配置--源于yml
 * <p>收纳所有模块的数据源配置
 * <p>数据源未设置url时将使用模块默认数据源进行初始化
 * @program: aum
 * @author: yc
 * @date: 2023-03-01 22:26
 **/
//@Configuration
public class MultiDataSourceConfig {
    /**
     * 默认配置
     *
     * @return 默认数据库配置
     */
    @Bean(name = "defaultDataSourceProperties")
    @Qualifier("defaultDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties defaultDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * RBAC配置
     *
     * @return RBAC数据库配置
     */
    @Bean(name = "dataSourceRbacProperties")
    @Qualifier("dataSourceRbacProperties")
    @ConfigurationProperties(prefix = "spring.datasource-rbac")
    public DataSourceProperties dataSourceRbacProperties() {
        return new DataSourceProperties();
    }

    /**
     * Log配置
     *
     * @return Log数据库配置
     */
    @Bean(name = "dataSourceLoggerProperties")
    @Qualifier("dataSourceLoggerProperties")
    @ConfigurationProperties(prefix = "spring.datasource-log")
    public DataSourceProperties dataSourceLoggerProperties() {
        return new DataSourceProperties();
    }


    /**
     * 模块默认数据源
     *
     * @return 模块默认数据源
     */
    @Bean(name = "datasource")
    public DataSource defaultDataSource() {
        return defaultDataSourceProperties().initializeDataSourceBuilder().build();
    }

    /**
     * RBAC数据源
     *
     * @return RBAC库数据源
     */
    @Bean(name = "datasource-rbac")
    public DataSource dataSourceRbac() {
        DataSourceProperties dataSourceProperties = dataSourceRbacProperties();
        if (null == dataSourceProperties.getUrl()) return defaultDataSource();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    /**
     * Log数据源
     *
     * @return 日志库数据源
     */
    @Bean(name = "datasource-log")
    public DataSource dataSourceLogger() {
        DataSourceProperties dataSourceProperties = dataSourceLoggerProperties();
        if (null == dataSourceProperties.getUrl()) return defaultDataSource();
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }


    /**
     * 设置主️数据源为模块默认数据源
     *
     * @param dataSource       模块默认数据源
     * @param dataSourceRbac   RBAC数据源
     * @param dataSourceLogger Log数据源
     * @return 模块默认数据源
     */
    @Bean
    @Primary
    DataSource primaryDataSource(
            @Autowired @Qualifier("datasource") DataSource dataSource,
            @Autowired @Qualifier("datasource-rbac") DataSource dataSourceRbac,
            @Autowired @Qualifier("datasource-log") DataSource dataSourceLogger
    ) {
        Map<Object, Object> map = new HashMap<>();
        map.put("dataSource", dataSource);
        map.put("datasource-rbac", dataSourceRbac);
        map.put("datasource-log", dataSourceLogger);
        RoutingDataSource routing = new RoutingDataSource();
        routing.setTargetDataSources(map);
        routing.setDefaultTargetDataSource(dataSource);
        return routing;
    }
}
