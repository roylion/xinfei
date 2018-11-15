package cn.roylion.pro.xinfei.service;

import cn.roylion.pro.xinfei.pojo.dto.ImageDTO;
import cn.roylion.pro.xinfei.pojo.po.ImagePO;
import com.github.pagehelper.Page;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 17:11 2018/11/15
 */
public interface ImageService {

    Page<ImagePO> getImagesPage(ImageDTO imageDTO, int pageNum, int pageSize);

    boolean saveImage(ImagePO imagePO);
}
