package io.syd.aum.ucore.dao.mapper;

import io.syd.aum.ucore.dao.mapper.impl.PgSqlBatchMapperImpl;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description: 批量Mapper--PgSql
 * @program: aum
 * @author: yc
 * @date: 2023-03-23 23:19
 **/
public interface PgSqlBatchMapper<T, I> {
    /**
     * 批量新增--自增主键
     *
     * @param objs 新增对象列表
     * @return 数据插入量
     */
    @InsertProvider(type = PgSqlBatchMapperImpl.class, method = "dynamicSQL")
    Integer insertBatchSkipId(@Param("list") List<T> objs);

    /**
     * 批量删除
     *
     * @param ids 主键列表
     * @return 数据删除量
     */
    @DeleteProvider(type = PgSqlBatchMapperImpl.class, method = "dynamicSQL")
    Integer deleteBatch(@Param("idList") List<I> ids);

    /**
     * 批量修改--依据主键
     *
     * @param list 数据列表
     * @return 修改的数量
     */
    @InsertProvider(type = PgSqlBatchMapperImpl.class, method = "dynamicSQL")
    Integer updateBatch(List<T> list);
}