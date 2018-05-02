/**
 * 
 */
package com.jeeplus.modules.tools.utils;

/**
 * @author MikeSun
 *
 */
public class MD5Utils {
	 /** 
     *  convert binary str to hex str
     * @return 将二进制转换为十六进制字符输出 
     */  
	public String binaryString2hexString(String bString)  {  
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)  
            return null;  
        StringBuffer tmp = new StringBuffer();  
        int iTmp = 0;  
        for (int i = 0; i < bString.length(); i += 4)  
        {  
            iTmp = 0;  
            for (int j = 0; j < 4; j++)  
            {  
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);  
            }  
            tmp.append(Integer.toHexString(iTmp));  
        }  
        return tmp.toString();  
    }  
	
	/**
	 * convert hex str to binary str
	 * @param hexString
	 * @return
	 */
	public  String hexString2binaryString(String hexString)  {  
        if (hexString == null || hexString.length() % 2 != 0)  
            return null;
        String bString = "", tmp;  
        for (int i = 0; i < hexString.length(); i++)  
        {  
            tmp = "0000"  
                    + Integer.toBinaryString(Integer.parseInt(hexString  
                            .substring(i, i + 1), 16));  
            bString += tmp.substring(tmp.length() - 4);  
        }  
        return bString;  
    }  
	
	public static void main(String[] args) {
		String bString = "010101010101010100111101";
//		                  010101010101010100111101
		MD5Utils impl = new MD5Utils();
		String yl = impl.binaryString2hexString(bString);
		System.out.println(yl);
		String b = impl.hexString2binaryString(yl);
		System.out.println(b);
		
		
		
	}

}
