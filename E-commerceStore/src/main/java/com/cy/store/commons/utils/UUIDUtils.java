package com.cy.store.commons.utils;


import java.util.UUID;

/**
 * 盐值
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().toUpperCase();
    }
}
