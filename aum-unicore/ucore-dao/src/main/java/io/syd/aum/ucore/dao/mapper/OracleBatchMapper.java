package io.syd.aum.ucore.dao.mapper;

import io.syd.aum.ucore.dao.mapper.impl.OracleBatchMapperImpl;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:批量Mapper--Oracle
 * @program: aum
 * @author: yc
 * @date: 2023-03-02 21:39
 **/
@SuppressWarnings("unused")
public interface OracleBatchMapper<T, I> {

    @InsertProvider(
            type = OracleBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer insertBatch(List<T> var1);

    @InsertProvider(
            type = OracleBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer insertBatchWithoutPK(List<T> var1);

    @DeleteProvider(
            type = OracleBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer deleteBatch(@Param("idList") List<I> ids);

    @InsertProvider(
            type = OracleBatchMapperImpl.class,
            method = "dynamicSQL"
    )
    Integer updateBatch(List<T> list);
}
