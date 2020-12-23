package com.evan.wj.utils;

import java.util.Random;

/***
 * @description  生成指定长度随机字符串的方法
 * @author diaoxiuze
 * @date 2020/12/23 15:45
 * @param
 * @return
 */
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }
}
