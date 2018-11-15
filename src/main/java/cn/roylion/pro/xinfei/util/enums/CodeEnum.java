package cn.roylion.pro.xinfei.util.enums;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 17:32 2018/11/15
 */
public enum CodeEnum {

    SUCCESS("0000");

    private String code;

    CodeEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
