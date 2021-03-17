package com.learnJava.ngnix;


import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class SigningMainExample {
    public static void main(String args[]) throws NoSuchAlgorithmException {
        String baseUrl = "https://ida-img-server-test.apps.pp01.useast.cf.ford.com";


        String URI = "/video/play_blue_icon.png";
        String secret = " idaFord2021";

        ZoneId zoneId = ZoneId.systemDefault();
        long epoch = LocalDateTime.now().plusSeconds(10).atZone(zoneId).toEpochSecond();
        String expiresAt = String.valueOf(epoch);


        String signature = NginxSecureUrlUtil.createSignedUrl(URI, expiresAt, secret);
        System.out.println(formatUrl(baseUrl, URI, signature, expiresAt));
    }

    private static String formatUrl(String baseUrl, String uri, String signature, String expiresAt) {
        String formatedUri = baseUrl + uri + "?md5=" + signature + "&expires=" + expiresAt;
        return formatedUri;
    }
}
