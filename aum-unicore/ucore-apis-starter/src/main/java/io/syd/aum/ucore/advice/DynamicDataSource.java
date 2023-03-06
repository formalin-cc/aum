package io.syd.aum.ucore.advice;

import io.syd.aum.ucore.dao.RoutingWith;
import io.syd.aum.ucore.dao.datasource.RoutingDataSourceContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @description: 切面实现动态数据源切换
 * 于TX事物共用时需要设定优先级
 * @program: aum
 * @author: yc
 * @date: 2023-03-06 23:06
 **/
@Aspect
@Component
public class DynamicDataSource implements BaseAspect {
    @Pointcut("@annotation(io.syd.aum.ucore.dao.RoutingWith)")
    public void selectDataSource() {
    }

    @Override
    public void doBefore(JoinPoint joinPoint) {

    }

    @Around("selectDataSource()")
    @Override
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        RoutingWith routingWith = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(RoutingWith.class);
        if (null == routingWith) return null;
        String key = routingWith.value();
        try (RoutingDataSourceContext ctx = new RoutingDataSourceContext(key)) {
            return pjp.proceed();
        }
    }

    @Override
    public void after(JoinPoint joinPoint) {

    }

    @Override
    public void afterReturn(JoinPoint joinPoint) {

    }

    @Override
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

    }
}