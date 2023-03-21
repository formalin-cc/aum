package io.syd.aum.ucore.logger;

import com.alibaba.fastjson.JSON;
import io.syd.aum.ucore.advice.BaseAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * @description: 全局日志采集--记录入内存队列
 * @program: aum
 * @author: yc
 * @date: 2023-03-21 21:59
 **/
@Aspect
@Component
public class LogToMemQueue implements BaseAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogToMemQueue.class);

    private BaseSysLog sysLog;

    private RequestMapping operateLog;

    @Resource
    private LogQueueHelper logQueueHelper;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void operateLogAspect() {

    }

    @Before("operateLogAspect()")
    @Override
    public void doBefore(JoinPoint joinPoint) {
        sysLog = new SysLogPgSql();
        sysLog.setCreateTime(new Date(new java.util.Date().getTime()));
        //@RequestMapping中的value作为操作类型
        operateLog = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(RequestMapping.class);
        if (operateLog.value().length == 0) return;
        sysLog.setOperateType(operateLog.value()[0]);
    }

    @Around(value = "operateLogAspect()")
    @Override
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object res;
        String methodName = pjp.getSignature().toShortString();
        StopWatch stopWatch = new StopWatch(methodName);
        stopWatch.start();
        try {//不要尝试捕获，会影响@RestControllerAdvice功能
            res = pjp.proceed();
        } finally {
            stopWatch.stop();
            sysLog.setOperateInfo(methodName + "执行耗时" + stopWatch.getTotalTimeMillis() + "毫秒");
        }
        if (operateLog.value().length != 0) {
            if (!operateLog.value()[0].startsWith("get")
                    && !operateLog.value()[0].startsWith("query")) {
                logQueueHelper.add(sysLog);
                logger.info("<--：" + JSON.toJSONString(sysLog));
            } else
                logger.info("~~~：" + JSON.toJSONString(sysLog));
        }
        return res;
    }

    @After("operateLogAspect()")
    @Override
    public void after(JoinPoint joinPoint) {
        sysLog.setUpdateTime(new Date(new java.util.Date().getTime()));
    }

    @AfterReturning("operateLogAspect()")
    @Override
    public void afterReturn(JoinPoint joinPoint) {
        //TODO 需要重新实现
    }

    @AfterThrowing(value = "operateLogAspect()", throwing = "e")
    @Override
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        sysLog.setOperateInfo("执行出错");
    }
}