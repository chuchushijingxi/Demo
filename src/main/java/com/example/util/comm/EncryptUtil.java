package com.example.util.comm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author ZLF
 * @version 1.0
 */
public class EncryptUtil {
    
    public static String Md5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        md5.update((str).getBytes("UTF-8"));  
        byte b[] = md5.digest();  
        int i;  
        StringBuffer buf = new StringBuffer("");  
        for(int offset=0; offset<b.length; offset++){  
            i = b[offset];  
            if(i<0){  
                i+=256;  
            }  
            if(i<16){  
                buf.append("0");  
            }  
            buf.append(Integer.toHexString(i));  
        }  
        String result = buf.toString();
        return result;
    }
}
