package io.syd.aum.ucore.dao.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @description: 动态路由数据源
 * @program: aum
 * @author: yc
 * @date: 2023-03-01 22:26
 **/
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceContext.getDataSourceRoutingKey();
    }
}
