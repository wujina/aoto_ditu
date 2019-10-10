package com.aoto.framework.security.web.Util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import sun.misc.BASE64Encoder;
/**
 * @program: framework-web
 * @description:
 * @author: Mr.wuj
 * @create: 2019-09-16 16:11
 **/
public class TokenUtil {

    private TokenUtil(){
    }
    /**
     * 返回类的对象
     * @return
     */
    public static TokenUtil getInstance(){
        return instance;
    }


    private static final TokenUtil instance = new TokenUtil();


    /**
     * 生成Token
     * Token：Nv6RRuGEVvmGjB+jimI/gw==
     * @return
     */
    public String makeToken(){

        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        //数据指纹   128位长   16个字节  md5
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            //对于给定数量的更新数据，digest 方法只能被调用一次。digest 方法被调用后，MessageDigest对象被重新设置成其初始状态。
            byte md5[] =  md.digest(token.getBytes());
            //base64编码--任意二进制编码明文字符   adfsdfsdfsf
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
