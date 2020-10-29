package com.df.dtss.gatewayimpl.database;

import com.df.dtss.domain.query.AppInfoQuery;
import com.df.dtss.gatewayimpl.database.model.AppInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈任务所属应用信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2020-10-26
 */
@Mapper
public interface AppInfoMapper {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(AppInfo record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    AppInfo selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(AppInfo record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<AppInfo> selectByCondition(AppInfoQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(AppInfoQuery query);

    /**
     * 批量查询
     *
     * @param ids 查询参数
     */
    List<AppInfo> selectByIds(List<Long> ids);

    /**
     * 批量更新
     *
     * @param ids    更新ID
     * @param record 更新参数
     */
    void updateByIds(List<Long> ids, AppInfo record);

    /**
     * 获取所有appName
     *
     * @return 所有appName
     */
    List<String> getAllApps();

}