package com.interaktive.test.helper;

import android.util.Base64;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;


public class StringHelper {

    public static String getSecureRandomString() {
        return new BigInteger(130, new SecureRandom()).toString(32);
    }

    public static String getRandomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        StringBuilder buffer = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (new Random().nextFloat() * (rightLimit - leftLimit));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public static String getUnicString(String prefix) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(prefix);
        buffer.append((new java.util.Date()).getTime());
        return buffer.toString();
    }


    public static String encodeBase64(String str) {
        byte[] data = str.getBytes();
        return Base64.encodeToString(data, Base64.DEFAULT);
    }

    public static String decodeBase64(String str) {
        byte[] data = Base64.decode(str, Base64.DEFAULT);
        return new String(data);
    }

}


