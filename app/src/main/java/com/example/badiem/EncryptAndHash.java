package com.example.badiem;

import android.util.Base64;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class EncryptAndHash {
    public String Encrypter(String string){
        String str = Des(string);
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
    public String Des(String plaint){
        String encrypted = "";
        try {
            DESKeySpec keySpec = new DESKeySpec("qwertykey".getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            byte[] cleartext = plaint.getBytes();

            Cipher cipher = Cipher.getInstance("DES/ECB/ZeroBytePadding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            encrypted = Base64.encodeToString(cipher.doFinal(cleartext),Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }
}
