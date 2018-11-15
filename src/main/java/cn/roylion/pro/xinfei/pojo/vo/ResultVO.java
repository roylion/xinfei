package cn.roylion.pro.xinfei.pojo.vo;

import cn.roylion.pro.xinfei.util.enums.CodeEnum;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 17:31 2018/11/15
 */
public class ResultVO {

    private String code;
    private String msg;
    private Object data;

    private ResultVO() {
    }

    public ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.code = CodeEnum.SUCCESS.getCode();
        resultVO.msg = "success";
        return resultVO;
    }

}
