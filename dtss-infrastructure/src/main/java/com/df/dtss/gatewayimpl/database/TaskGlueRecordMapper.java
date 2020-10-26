package com.df.dtss.gatewayimpl.database;

import com.df.dtss.domain.query.TaskGlueRecordQuery;
import com.df.dtss.gatewayimpl.database.model.TaskGlueRecord;

import java.util.List;

/**
 * 〈glue记录信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2020-10-26
 */
public interface TaskGlueRecordMapper {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(TaskGlueRecord record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    TaskGlueRecord selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(TaskGlueRecord record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<TaskGlueRecord> selectByCondition(TaskGlueRecordQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(TaskGlueRecordQuery query);

    /**
    * 批量查询
    *
    * @param ids 查询参数
    */
    List<TaskGlueRecord> selectByIds(List<Long> ids);

    /**
    * 批量更新
    *
    * @param ids 更新ID
    * @param record 更新参数
    */
    void updateByIds(List<Long> ids, TaskGlueRecord record);

}