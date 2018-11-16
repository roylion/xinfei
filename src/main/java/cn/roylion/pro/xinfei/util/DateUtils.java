package cn.roylion.pro.xinfei.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 13:29 2018/11/16
 */
public class DateUtils {

    private DateUtils() {
    }


    public static String now(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static String now() {
        return DateUtils.now("yyyyMMdd");
    }
}
