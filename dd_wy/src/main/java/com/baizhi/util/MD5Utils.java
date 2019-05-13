package com.baizhi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Utils {

    //定义一个限定字符串
    static String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * @Author : ZK
     * @Description : 生成盐(一个8位的随机字符串)
     * @Return : 返回生成的盐
     * @Date : 20:55 2018/6/9
     */
    public static String getSalt(){
        StringBuffer salt = new StringBuffer();
        for (int i = 0; i <= 7; i++) {
            salt.append(str.charAt(new Random().nextInt(62)));
        }
        return salt.toString();
    }
    

    public static String getPassword(String upassword) {
        StringBuffer password = null;
        try {
            //指定加密的方式为md5
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(upassword.getBytes());
            password = new StringBuffer();
            for (byte b : digest) {
                //位运算
                int len = b & 0xff;
                if(len<15){
                    password.append("0");
                }
                password.append(Integer.toHexString(len));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return password.toString();
    }
}

