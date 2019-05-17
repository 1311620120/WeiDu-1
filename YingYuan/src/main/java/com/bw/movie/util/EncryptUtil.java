package com.bw.movie.util;

import com.bw.movie.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xyj on 2017/6/29.
 */
public class EncryptUtil {

    private static final String KEY = "12baweiyidong345";

    private static final String IV = "67baweiyidong899";

    /**
     *  AES加密
     * @param passWord
     * @return
     * @throws Exception
     */
    public static String encrypt(String passWord) {
        try {
            Key keySpec = new SecretKeySpec(KEY.getBytes(), "AES"); //两个参数，第一个为私钥字节数组， 第二个为加密方式 AES或者DES
            IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//实例化加密类，参数为加密方式，要写全
            cipher.init(Cipher.ENCRYPT_MODE,  keySpec, ivSpec);
            byte [] b = cipher.doFinal(passWord.getBytes());
            String ret = Base64.encode(b);
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  AES解密
     * @param password
     * @return
     * @throws Exception
     */
    public static String decrypt(String password){
        try {
            byte [] byte1 = Base64.decode(password);
            IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes());
            Key key = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE,  key, ivSpec);
            byte [] ret = cipher.doFinal(byte1);
            return new String(ret, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String [] args)throws Exception
    {
        String a = encrypt("111");
        System.err.println("加密后: " + a);
        String b = decrypt(a);
        System.err.println("解密后: " + b);
    }
    //MD5加密
    public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }


}
