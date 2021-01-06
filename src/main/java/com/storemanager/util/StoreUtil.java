package com.storemanager.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StoreUtil {
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String generateId() {
        return  "SUV" + String.valueOf(Math.abs(UUID.randomUUID().getLeastSignificantBits()))
                .substring(10, 15)+ randomAlphaNumeric(4);
    }
    private static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateStoreId() {
        return  "STOR" + String.valueOf(Math.abs(UUID.randomUUID().getLeastSignificantBits()))
                .substring(10, 15)+ randomAlphaNumeric(4);
    }

    public static String generateInventoryId() {
        return  "INVEN" + String.valueOf(Math.abs(UUID.randomUUID().getLeastSignificantBits()))
                .substring(10, 15)+ randomAlphaNumeric(4);
    }

}
