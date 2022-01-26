package com.df.dtss.domain.util;

import com.xy.cola.exception.BizException;
import com.xy.cola.exception.util.ArgumentAssert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 〈一句话介绍功能〉<br>
 * MD5加密工具类
 *
 * @author jierui on 2018-12-19.
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MD5CryptUtils {

    /**
     * 编码
     */
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    /**
     * md5加密
     *
     * @param inputText
     * @return
     */
    public static String md5(String inputText) {
        ArgumentAssert.hasText(inputText, "加密内容不能为空");
        return md5Encrypt(inputText.getBytes(CHARSET));
    }

    /**
     * md5加密
     *
     * @param data
     * @return
     */
    public static String md5(byte[] data) {
        return md5Encrypt(data);
    }

    /**
     * md5或者sha-1加密
     *
     * @param data 要加密的内容
     * @return
     */
    private static String md5Encrypt(byte[] data) {
        ArgumentAssert.isTrue(null != data && data.length > 0, "MD5加密数据不能为空");
        try {
            MessageDigest m = MessageDigest.getInstance("md5");
            m.update(data);
            byte s[] = m.digest();
            return hex(s);
        } catch (Exception e) {
            throw new BizException("md5加密失败", e);
        }
    }

    /**
     * 返回十六进制字符串
     *
     * @param arr
     * @return
     */
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5CryptUtils.md5("123456"));
    }

}
