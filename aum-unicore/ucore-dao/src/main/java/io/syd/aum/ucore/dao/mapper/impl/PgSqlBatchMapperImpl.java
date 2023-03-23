package io.syd.aum.ucore.dao.mapper.impl;

import org.apache.ibatis.mapping.MappedStatement;

/**
 * @description:
 * @program: aum
 * @author: yc
 * @date: 2023-03-23 23:20
 **/
public class PgSqlBatchMapperImpl {

    public String insertBatchSkipId(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();

//        Class<?> entityClass = this.getEntityClass(ms);
//        sql.append(SqlHelper.insertIntoTable(entityClass, this.tableName(entityClass)));
//        sql.append(SqlHelper.insertColumns(entityClass, true, false, false));
//        sql.append(" VALUES ");
//        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
//        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
//        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
//        for (EntityColumn column : columnList) {
//            if (!column.isId() && column.isInsertable()) {
//                sql.append(column.getColumnHolder("record")).append(",");
//            }
//        }
//        sql.append("</trim>");
//        sql.append("</foreach>");
        return sql.toString();
    }

    public String deleteBatch(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();

//        final Class<?> entityClass = this.getEntityClass(ms);
//        sql.append(SqlHelper.deleteFromTable(entityClass, this.tableName(entityClass)));
//        Set<EntityColumn> columnList = EntityHelper.getPKColumns(entityClass);
//        if (columnList.size() == 1) {
//            EntityColumn column = columnList.iterator().next();
//            sql.append(" where "); // use where it's safe
//            sql.append(column.getColumn()).append(" in ");
//            sql.append("<foreach collection='idList' index='index' item='id' open='(' separator=',' close=')'>");
//            sql.append(" #{id}");
//            sql.append("</foreach>");
//        } else {
//            throw new MapperException("继承 deleteByIds 方法的实体类[" + entityClass.getCanonicalName() + "]中必须只有一个带有 @Id 注解的字段");
//        }
        return sql.toString();
    }

    public String updateBatch(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();

//        final Class<?> entityClass = getEntityClass(ms);
//        //开始拼sql
//        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
//        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");
//
//        //获取全部列
//        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
//        for (EntityColumn column : columnList) {
//            if (!column.isId() && column.isUpdatable()) {
//                sql.append("  <trim prefix=\"").append(column.getColumn()).append(" =case\" suffix=\"end,\">");
//                sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
//                sql.append("      <if test=\"i.").append(column.getEntityField().getName()).append("!=null\">");
//                sql.append("         when id=#{i.id} then #{i.").append(column.getEntityField().getName()).append("}");
//                sql.append("      </if>");
//                sql.append("    </foreach>");
//                sql.append("  </trim>");
//            }
//        }
//        sql.append("</trim>");
//        sql.append("WHERE");
//        sql.append(" id IN ");
//        sql.append("<trim prefix=\"(\" suffix=\")\">");
//        sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
//        sql.append("#{i.id}");
//        sql.append("</foreach>");
//        sql.append("</trim>");
        return sql.toString();
    }
}
