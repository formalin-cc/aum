package io.syd.aum.ucore.dao;

import java.lang.annotation.*;

/**
 * @description: 选择数据源
 * @program: aum
 * @author: yc
 * @date: 2023-03-01 22:25
 **/
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RoutingWith {
    /**
     * 默认指向为模块当前数据源
     *
     * @return 预定义的当前数据源：datasource
     */
    String value() default "datasource";
}

