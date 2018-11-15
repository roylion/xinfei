package cn.roylion.pro.xinfei.service.impl;

import cn.roylion.pro.xinfei.mapper.ImageMapper;
import cn.roylion.pro.xinfei.pojo.dto.ImageDTO;
import cn.roylion.pro.xinfei.pojo.po.ImagePO;
import cn.roylion.pro.xinfei.service.ImageService;

import static cn.roylion.pro.xinfei.util.ObjectUtils.getDef;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 17:14 2018/11/15
 */
@Component
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    @Override
    public Page<ImagePO> getImagesPage(ImageDTO imageDTO, int pageNum, int pageSize) {
        Page<ImagePO> page = PageHelper.startPage(pageNum, pageSize);
        imageMapper.listImages();
        return page;
    }

    @Override
    public boolean saveImage(ImagePO imagePO) {
        int saveCount = imageMapper.saveOne(imagePO);
        return saveCount == 1;
    }
}
