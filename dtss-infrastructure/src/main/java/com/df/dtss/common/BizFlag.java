package com.df.dtss.common;

/**
 * <功能介绍><br>
 * <p>
 * <7位二进值，每位个代表一种业务标志（是/否）>
 *
 * @author xy on 2021/4/1.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BizFlag {

    /**
     * 初始值
     */
    public static final byte INIT_VALUE = 0x00;

    /**
     * 第1位 代表业务1
     */
    public static final int BIZ_ONE = 1;

    /**
     * 第2位 代表业务2
     */
    public static final int BIZ_TWO = 2;

    /**
     * 第3位 代表业务3
     */
    public static final int BIZ_THREE = 3;

    /**
     * 第4位 代表业务4
     */
    public static final int BIZ_FOUR = 4;

    /**
     * 第5位 代表业务5
     */
    public static final int BIZ_FIVE = 5;

    /**
     * 第6位 代表业务6
     */
    public static final int BIZ_SIX = 6;

    /**
     * 第7位 代表业务7
     */
    public static final int BIZ_SEVEN = 7;

    public static byte addFlag(byte storeFlag, int storeIndex) {
        int offset = storeIndex - 1;
        return (byte) (storeFlag | 0x01 << offset);
    }

    public static byte removeFlag(byte storeFlag, int storeIndex) {
        int offset = storeIndex - 1;
        return (byte) (storeFlag & (Byte.MAX_VALUE - (0x01 << offset)));
    }

    public static boolean hasFlag(byte storeFlag, int storeIndex) {
        int offset = storeIndex - 1;
        return (storeFlag >> offset & 0x01) == 1;
    }

    public static void main(String[] args) {
        byte storeFlag = INIT_VALUE;
        storeFlag = removeFlag(storeFlag, BIZ_ONE);
        System.out.println("remove BIZ_ONE:" + storeFlag);

        storeFlag = addFlag(storeFlag, BIZ_TWO);
        System.out.println("add BIZ_TWO:" + storeFlag);

        storeFlag = addFlag(storeFlag, BIZ_ONE);
        System.out.println("add BIZ_ONE:" + storeFlag);

        storeFlag = addFlag(storeFlag, BIZ_THREE);
        System.out.println("add BIZ_THREE:" + storeFlag);

        System.out.println("is BIZ_THREE:" + hasFlag(storeFlag, BIZ_THREE));
        System.out.println("is BIZ_ONE:" + hasFlag(storeFlag, BIZ_ONE));
        System.out.println("is BIZ_TWO:" + hasFlag(storeFlag, BIZ_TWO));
        System.out.println("is BIZ_FOUR:" + hasFlag(storeFlag, BIZ_FOUR));

        System.out.println("-------------------------");
        storeFlag = removeFlag(storeFlag, BIZ_TWO);
        System.out.println("remove BIZ_TWO:" + storeFlag);

        storeFlag = removeFlag(storeFlag, BIZ_ONE);
        System.out.println("remove BIZ_ONE:" + storeFlag);

        System.out.println("is BIZ_ONE:" + hasFlag(storeFlag, BIZ_ONE));

    }
}
