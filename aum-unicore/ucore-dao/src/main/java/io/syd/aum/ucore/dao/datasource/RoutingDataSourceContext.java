package io.syd.aum.ucore.dao.datasource;

/**
 * @description: ThreadLocal--存储数据源
 * @program: aum
 * @author: yc
 * @date: 2023-03-01 22:27
 **/
public class RoutingDataSourceContext implements AutoCloseable {
    static final ThreadLocal<String> threadLocalDataSourceKey = new ThreadLocal<>();

    public static String getDataSourceRoutingKey() {
        String key = threadLocalDataSourceKey.get();
        //key指向不存在的数据库时，将会使用@primary标识的数据源
        return key == null ? "datasource" : key;
    }

    /**
     * 初始化当前数据源
     *
     * @param key 数据源代号
     */
    public RoutingDataSourceContext(String key) {
        threadLocalDataSourceKey.set(key);
    }

    public void close() {
        threadLocalDataSourceKey.remove();
    }
}