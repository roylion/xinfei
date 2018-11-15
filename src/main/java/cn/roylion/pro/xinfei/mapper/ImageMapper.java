package cn.roylion.pro.xinfei.mapper;


import cn.roylion.pro.xinfei.pojo.po.ImagePO;

import java.util.List;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 13:44 2018/11/15
 */
public interface ImageMapper {

    List<ImagePO> listImages();

    int saveOne(ImagePO imagePO);
}
