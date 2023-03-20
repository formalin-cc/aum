package io.syd.aum.ucore.logger;


import io.mybatis.provider.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity.Table("sys_log")
/**
 * @description:
 * @program: aum
 * @author: yc
 * @date: 2023-03-20 22:44
 **/
public class SysLogPgSql extends BaseSysLog {
    /**
     * 日志唯一标识
     */
    @Entity.Column(id = true, value = "id", updatable = false)
    private Long id;

    /**
     * 日志产生时间
     */
    @Entity.Column(value = "create_time")
    private Date createTime;

    /**
     * 日志更新时间
     */
    @Entity.Column(value = "update_time")
    private Date updateTime;

    /**
     * 日志等级/类型
     */
    @Entity.Column(value = "type")
    private String type;

    /**
     * 操作用户
     */
    @Entity.Column(value = "operate_user")
    private String operateUser;

    /**
     * 操作类型
     */
    @Entity.Column(value = "operate_type")
    private String operateType;

    /**
     * 操作详情
     */
    @Entity.Column(value = "operate_info")
    private String operateInfo;

    /**
     * 操作入参
     */
    @Entity.Column(value = "operate_param")
    private String operateParam;

    /**
     * 操作结果
     */
    @Entity.Column(value = "operate_result")
    private String operateResult;

    /**
     * 触发的SQL
     */
    @Entity.Column(value = "related_sql")
    private String relatedSql;
}