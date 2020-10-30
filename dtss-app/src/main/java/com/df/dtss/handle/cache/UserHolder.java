package com.df.dtss.handle.cache;

import com.df.dtss.gatewayimpl.database.model.UserAccount;

/**
 * <功能介绍><br>
 * <p>
 * <用户信息本地线程存储器>
 *
 * @author xy on 2020/9/24.
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class UserHolder {

    private static final ThreadLocal<UserAccount> USER_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取本地缓存用户信息
     *
     * @return 用户信息 user dto
     */
    public static UserAccount get() {
        return USER_THREAD_LOCAL.get();
    }

    /**
     * 添加本地缓存用户信息
     *
     * @param userAccount 用户信息
     */
    public static void add(UserAccount userAccount) {
        USER_THREAD_LOCAL.set(userAccount);
    }

    /**
     * 移除本地缓存用户信息
     */
    public static void remove() {
        USER_THREAD_LOCAL.remove();
    }
}
