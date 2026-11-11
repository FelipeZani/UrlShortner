package com.example.demo.utils;

import java.util.UUID;

public final class Base62Handler {
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String encode(UUID id, String url){
        if(url == null || url.isBlank()) throw new IllegalArgumentException("Invalid Url");
        int uuid32 = (int) id.getMostSignificantBits();

        long value = Integer.toUnsignedLong(uuid32);
        value += Integer.toUnsignedLong(url.hashCode());

        if (value < 0) throw new IllegalArgumentException("negative: " + value);
        if (value == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.append(ALPHABET.charAt((int) (value % 62)));
            value /= 62;
        }
        return sb.reverse().toString();

    }


}
