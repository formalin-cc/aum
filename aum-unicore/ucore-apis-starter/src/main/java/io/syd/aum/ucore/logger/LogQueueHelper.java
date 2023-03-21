package io.syd.aum.ucore.logger;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @description: 日志持久层缓存队列
 * @program: aum
 * @author: yc
 * @date: 2023-03-21 21:58
 **/
@Component//必须使用默认的单例
public class LogQueueHelper {
    /**
     * 双向队列
     */
    private final BlockingDeque<BaseSysLog> blockingDeque = new LinkedBlockingDeque<>();

    /**
     * 队尾添加
     *
     * @param sysLog 日志
     */
    public void add(BaseSysLog sysLog) {
        blockingDeque.add(sysLog);
    }

    /**
     * 队首弹出
     *
     * @return 日志对象
     * @throws InterruptedException 异常
     */
    public BaseSysLog poll() throws InterruptedException {
        return blockingDeque.poll(1, TimeUnit.SECONDS);
    }
}
