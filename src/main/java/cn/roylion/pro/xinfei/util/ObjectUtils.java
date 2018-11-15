package cn.roylion.pro.xinfei.util;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 17:18 2018/11/15
 */
public class ObjectUtils {

    private ObjectUtils() {
    }

    /**
     * @Author: Roylion
     * @Description: 获取默认值
     * @Date:  17:21 2018/11/15
     */
    public static <T> T getDef(T o1, T o2) {
        return o1 != null ? o1 : o2;
    }

}
