package io.syd.aum.ucore.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @description: 切面基类--限制切面方法
 * @program: aum
 * @author: yc
 * @date: 2023-03-06 10:20
 **/
public interface BaseAspect {
    /**
     * 前置通知
     *
     * @param joinPoint 切点
     */
    void doBefore(JoinPoint joinPoint);

    /**
     * 环绕通知
     *
     * @param pjp 切点
     * @return 继续执行
     * @throws Throwable 异常
     */
    Object around(ProceedingJoinPoint pjp) throws Throwable;

    /**
     * 后置通知
     *
     * @param joinPoint 切点
     */
    void after(JoinPoint joinPoint);

    /**
     * 后置返回通知
     *
     * @param joinPoint 切点
     */
    void afterReturn(JoinPoint joinPoint);

    /**
     * 异常通知
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    void doAfterThrowing(JoinPoint joinPoint, Throwable e);
}

