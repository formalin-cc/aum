package io.syd.aum.ucore.logger;

import lombok.Data;

import java.util.Date;

/**
 * @description: 抽象日志父类，统一日志持久层实现
 * @program: aum
 * @author: yc
 * @date: 2023-03-20 22:44
 **/
@Data
public class BaseSysLog {
    transient Long id;
    transient Date createTime;
    transient Date updateTime;
    transient String type;
    transient String operateUser;
    transient String operateType;
    transient String operateInfo;
    transient String operateParam;
    transient String operateResult;
    transient String relatedSql;
}
