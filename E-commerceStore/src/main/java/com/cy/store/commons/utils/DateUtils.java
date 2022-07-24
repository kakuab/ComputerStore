package com.cy.store.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换工具类
 */
public class DateUtils {

    public static String formatDateTime(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
        return simpleDateFormat.format(date);
    }
}
