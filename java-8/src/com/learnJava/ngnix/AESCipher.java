package com.learnJava.ngnix;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESCipher {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

         final Key key= new SecretKeySpec("1IDAP3R45cL2k212".getBytes(), "AES");
         final Cipher cipher = Cipher.getInstance("AES");
         String input =  "eyJ0eXAiOiJKV1QiLCJ0b2tlbl90eXBlIjoiUiIsImFsZyI6IlJTMjU2Iiwia2lkIjoiY3NkbmtleTEifQ.eyJzdWIiOiJkYmNiMjBkMC1mMjBmLTQwOWMtYTRjMy0zNjVmYTIxYmQxZTEiLCJhdWQiOiJiMmUyNjAwZS1jMTllLTQzM2QtOTNjZC0zOThhNjM5NTEzODMiLCJkZXZpY2VfaWQiOm51bGwsImlzcyI6IkQ3NjgwMUZBLTUyMDUtNDdFNy1BQjZBLUQwRjU0MDhBQjFGQSIsInR5cGUiOiJzc28iLCJleHAiOjE2NDc0NDQwNjUsImlhdCI6MTYxNTkwODA2NSwianRpIjoiZGJjYjIwZDAtZjIwZi00MDljLWE0YzMtMzY1ZmEyMWJkMWUxfDE2MTU5MDgwNjU2NzkiLCJ1c2VybmFtZSI6ImlkYXVzZXI5QGdtYWlsLmNvbSJ9.SErZcA7QhNqMGu6k1oQtR4hHqRPnfprNuOuhta4cIvoBoUdoZZn8FpBfcZD4mHw2Y7CZWbUrHfoV1L0Sjwxrv3nK2KGlDgitGF3oACOmz5M28fVK-U3bVyE3T2AFPj6voxXV8fs0mmuT8S-Lb5EBKjDOzCWhzvOJS4N4Giy-J7K03nNSDoEVUhX-S2gahmHLIT9JbdXn6yyfKY8r7Af17Wega7PlnUijFDPT-D9x7DwVym7pEqotLs2cEwcbsjKNIWJigoyXGLNicpaLhp4VcVUowO60hqvNp0Hql3H_fU7XQCoYiUOpAYaVGwY-prlapug_OMSfS1NKBjJxS4ZHyA";
         System.out.println("Actual value: "+input);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //Encryption
        String encryptedData = Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes()));
        System.out.println("\n\nAfter Encryption: "+ encryptedData);

        //Decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        String decryptedData = new String(cipher.doFinal(Base64.getDecoder().decode(encryptedData.getBytes())));
        System.out.println("\n\nAfter Decryption: "+ decryptedData);


        System.out.println("[\uD800-\uDBFF][\\uDC00-\\uDFFF]");
    }
}
