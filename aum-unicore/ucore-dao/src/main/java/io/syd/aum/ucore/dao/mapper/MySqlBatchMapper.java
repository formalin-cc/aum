package io.syd.aum.ucore.dao.mapper;

import io.syd.aum.ucore.dao.mapper.impl.MySqlBatchMapperImpl;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @description: 批量Mapper--MySql
 * @program: aum
 * @author: yc
 * @date: 2023-03-01 22:27
 **/
@SuppressWarnings("unused")
public interface MySqlBatchMapper<T, I> {
    @Options(
            useGeneratedKeys = true,
            keyProperty = "id"
    )
    @InsertProvider(
            type = MySqlBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer insertBatch(List<T> var1);

    @DeleteProvider(
            type = MySqlBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer deleteBatch(@Param("idList") List<I> ids);

    @InsertProvider(
            type = MySqlBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer updateBatch(List<T> list);
}
