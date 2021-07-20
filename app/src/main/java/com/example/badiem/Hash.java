package com.example.badiem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public String getSHA512(String str){
        String generatePass = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(str.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }

            generatePass = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return generatePass;
    }

}
