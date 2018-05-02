/**
 * 
 */
package com.jeeplus.modules.webapi;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author MikeSun
 *
 */
public class MD5Util {


    // 全局数组
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    public MD5Util() {
    }

    // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    @SuppressWarnings("unused")
	private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }

    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    /**
     * get the value encrypted by md5
     * @param strObj need encrypted string
     * @return encrypted string
     */
    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
            System.out.println(md.digest(strObj.getBytes()));
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
    
    public static String getMd5(String strObj,String encoder) {
    	 String resultString = null;
         try {
             resultString = new String(strObj);
             MessageDigest md = MessageDigest.getInstance("MD5");
             // md.digest() 该函数返回值为存放哈希值结果的byte数组
             try {
            	 if("utf8".equalsIgnoreCase(encoder)) {
            		 md.update(strObj.getBytes("utf-8"));
            	 } else {
            		 md.update(strObj.getBytes());
            	 }
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
             StringBuilder sb = new StringBuilder(40);
             for(byte x:md.digest()) {
                 if((x & 0xff)>>4 == 0) {
                     sb.append("0").append(Integer.toHexString(x & 0xff));
                 } else {
                     sb.append(Integer.toHexString(x & 0xff));
                 }
             }
             resultString = sb.toString();
         } catch (NoSuchAlgorithmException ex) {
             ex.printStackTrace();
         }
         return resultString;
    }


}
