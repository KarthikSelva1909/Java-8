package com.learnJava.ngnix;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Pattern;

public class NginxSecureUrlUtil {
    public static String createSignedUrl(String... args) throws NoSuchAlgorithmException {
        StringBuilder temp = new StringBuilder();
        for (String str : args) {
            temp.append(str);
        }

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(temp.toString().getBytes());
        byte[] encoded = Base64.getEncoder().encode(hash);

        String signature = new String(encoded);
        signature = normalizeHash(signature);
        return signature;
    }

    private static String normalizeHash(String signature) {
        signature = signature.replaceAll(Pattern.quote("+"), "-");
        signature = signature.replaceAll(Pattern.quote("/"), "_");
        signature = signature.replaceAll(Pattern.quote("="), "");
        return signature;
    }
}
