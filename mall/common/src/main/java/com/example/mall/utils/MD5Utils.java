package com.example.mall.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//MD5生成器
public class MD5Utils {
    public static String md5(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算MD5的值
            md.update(password.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}