package com.goldeneyes.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
 
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
public class DesUtil {
 
    public static void main(String[] args) throws Exception {
    	System.out.println(DESEncrypt("admin","jsy11111"));
 
    }
     
  //des加密后base64
  	public static String DESEncrypt(String inputData, String inputKey)
  			throws Exception {
  		byte[] DESkey = inputKey.getBytes();// 设置密钥
  		DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
  		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
  		Key key = keyFactory.generateSecret(keySpec);// 得到密钥对象

  		Cipher enCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");// 得到加密对象Cipher
  		enCipher.init(Cipher.ENCRYPT_MODE, key);// 设置工作模式为加密模式，给出密钥和向量
  		byte[] pasByte = enCipher.doFinal(inputData.getBytes("utf-8"));
  		BASE64Encoder base64Encoder = new BASE64Encoder();
  		return base64Encoder.encode(pasByte);
  	}
        //先反base64，然后
  	public static String DESDecrypt(String inputData, String inputKey)
  			throws Exception {
  		BASE64Decoder base64Decoder = new BASE64Decoder();
  		byte[] byteInputData = base64Decoder.decodeBuffer(inputData);

  		byte[] DESkey = inputKey.getBytes();// 设置密钥
  		DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
  		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
  		Key key = keyFactory.generateSecret(keySpec);// 得到密钥对象

  		// using DES in ECB mode
  		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
  		// 用密匙初始化Cipher对象
  		cipher.init(Cipher.DECRYPT_MODE, key);
  		byte decryptedData[] = cipher.doFinal(byteInputData);
  		String value = new String(decryptedData, "UTF-8");
  		return value;// decryptedData;
  	}
}
