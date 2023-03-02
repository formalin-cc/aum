package io.syd.aum.ucore.dao.mapper.impl;

import org.apache.ibatis.mapping.MappedStatement;

/**
 * @description:
 * @program: aum
 * @author: yc
 * @date: 2023-03-02 21:40
 **/
public class OracleBatchMapperImpl {
//    public OracleBatchMapperImpl(Class<?> mapperClass, MapperHelper mapperHelper) {
//        super(mapperClass, mapperHelper);
//    }

    /**
     * 批量添加
     *
     * @param ms SQL参数
     * @return 构造SQL
     */
    public String insertBatch(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();

//        Class<?> entityClass = this.getEntityClass(ms);
//        sql.append(SqlHelper.insertIntoTable(entityClass, this.tableName(entityClass)));
//        sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
//        Field[] declaredFields = entityClass.getDeclaredFields();
//
//        sql.append("SELECT ");
//        for (Field f : declaredFields) {
//            KeySql annotation = f.getAnnotation(KeySql.class);
//            if (annotation != null) {
//                String seqSql = annotation.sql();
//                sql.append(seqSql, seqSql.indexOf(" "), seqSql.indexOf(" ", 7)).append(",");
//                break;
//            }
//        }
//        sql.append("cd.* FROM (");
//        sql.append("<foreach collection=\"list\" item=\"record\" separator=\"UNION ALL\" >");
//        sql.append("SELECT ");
//        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
//        for (EntityColumn column : columnList) {
//            if (!column.isId() && column.isInsertable()) {
//                sql.append(column.getColumnHolder("record")).append(",");
//            }
//        }
//        sql.deleteCharAt(sql.length() - 1);
//        sql.append(" from dual");
//        sql.append("</foreach>");
//        sql.append(") cd");
        return sql.toString();
    }

    /**
     * 批量添加(无主键)
     *
     * @param ms SQL参数
     * @return 构造SQL
     */
    public String insertBatchWithoutPK(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();

//        Class<?> entityClass = this.getEntityClass(ms);
//        sql.append(SqlHelper.insertIntoTable(entityClass, this.tableName(entityClass)));
//        sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
//
//        sql.append("SELECT ");
//        sql.append("cd.* FROM (");
//        sql.append("<foreach collection=\"list\" item=\"record\" separator=\"UNION ALL\" >");
//        sql.append("SELECT ");
//        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
//        for (EntityColumn column : columnList) {
//            sql.append(column.getColumnHolder("record")).append(",");
//        }
//        sql.deleteCharAt(sql.length() - 1);
//        sql.append(" from dual");
//        sql.append("</foreach>");
//        sql.append(") cd");
        return sql.toString();
    }

    /**
     * 批量修改
     *
     * @param ms SQL参数
     * @return 构造SQL
     */
    public String updateBatch(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();

//        final Class<?> entityClass = getEntityClass(ms);
//        //开始拼sql
//        sql.append("<foreach collection=\"list\" index=\"index\" item=\"i\" open=\"begin\" close=\";end;\" separator=\";\">");
//        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
//        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");
//
//        //获取全部列
//        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
//        for (EntityColumn column : columnList) {
//            if (!column.isId() && column.isUpdatable()) {
//                sql.append("<if test=\"i.").append(column.getEntityField().getName()).append("!=null \">");
//                sql.append(column.getColumn()).append("=").append("#{i.").append(column.getEntityField().getName()).append("},");
//                sql.append(" </if>");
//            }
//        }
//        sql.append("</trim>");
//        sql.append("WHERE ");
//
//        String priKeyColumn = null;
//        String priKey = null;
//        Field[] declaredFields = entityClass.getDeclaredFields();
//        for (Field f : declaredFields) {
//            Id annotation = f.getAnnotation(Id.class);
//            if (annotation != null) {
//                priKeyColumn = f.getAnnotation(Column.class).name();
//                priKey = f.getName();
//                break;
//            }
//        }
//        if (priKeyColumn == null) {
//            return "主键为空";
//        }
//
//        sql.append(priKeyColumn).append("=#{i.").append(priKey).append("}");
//        sql.append("</foreach>");
        return sql.toString();
    }

    /**
     * 批量删除
     *
     * @param ms SQL参数
     * @return 构造SQL
     */
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
}

