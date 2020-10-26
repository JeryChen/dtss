package com.df.dtss.gatewayimpl.database;

import com.df.dtss.domain.query.UserAccountQuery;
import com.df.dtss.gatewayimpl.database.model.UserAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 〈用户账户信息 DAO〉<p>
 * 〈功能详细描述〉
 *
 * @author
 * @date 2020-10-26
 */
@Mapper
public interface UserAccountMapper {

    /**
     * 新增一条记录
     *
     * @param record 保存对象
     */
    int insert(UserAccount record);

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     */
    UserAccount selectByPrimaryKey(Long id);

    /**
     * 根据主键更新数据
     *
     * @param record 更新参数
     */
    int updateByPrimaryKeySelective(UserAccount record);

    /**
     * 根据查询参数查询数据
     *
     * @param query 查询参数
     */
    List<UserAccount> selectByCondition(UserAccountQuery query);

    /**
     * 根据查询参数查询数据总量
     *
     * @param query 查询参数
     */
    Integer countByCondition(UserAccountQuery query);

}