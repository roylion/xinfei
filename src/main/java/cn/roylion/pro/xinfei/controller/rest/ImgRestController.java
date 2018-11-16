package cn.roylion.pro.xinfei.controller.rest;

import cn.roylion.pro.xinfei.pojo.dto.ImageDTO;
import cn.roylion.pro.xinfei.pojo.po.ImagePO;
import cn.roylion.pro.xinfei.service.ImageService;
import cn.roylion.pro.xinfei.util.DateUtils;
import com.github.pagehelper.Page;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 12:31 2018/11/15
 */
@RestController
public class ImgRestController {

    @Resource
    private ImageService imageService;

    @Value("${xinfei.upload.path}")
    private String uploadPath;
    @Value("${xinfei.upload.prefixUrl}")
    private String prefixUrl;
    @Value("${xinfei.upload.thumbs.width}")
    private Integer width;
    @Value("${xinfei.upload.thumbs.height}")
    private Integer height;

    @PostMapping("getImgs/{pageNum}/{pageSize}")
    public Object getImages(@PathVariable Integer pageNum, @PathVariable Integer pageSize, @RequestBody(required = false) ImageDTO imageDTO) {
        Page<ImagePO> page = imageService.getImagesPage(imageDTO, pageNum, pageSize);
        return page;
    }

    @PostMapping("uploadImg")
    public Object upload(MultipartFile file, String title, String description) {
        String originalFilename = file.getOriginalFilename();
        String fullName = "/" + originalFilename;
        String thumbsName = fullName.replaceAll("^(.*)\\.(.*)$", "$1_t.$2");

        String now = DateUtils.now();
        String fullPath = uploadPath + "full/" + now;
        String thumbsPath = uploadPath + "thumbs/" + now;

        String fullUrl = prefixUrl + "full/" + now + fullName;
        String thumbsUrl = prefixUrl + "thumbs/" + now + thumbsName;

        File fullFile = new File(fullPath);
        File thumbsFile = new File(thumbsPath);
        if (!fullFile.exists()) {
            fullFile.mkdirs();
        }
        if (!thumbsFile.exists()) {
            thumbsFile.mkdirs();
        }
        try {
            BufferedImage bfImg = ImageIO.read(file.getInputStream());

            file.transferTo(new File(fullPath + fullName));

            int width = bfImg.getWidth(null);//原图宽度
            int height = bfImg.getHeight(null);//原图高度
            int rate1 = width / this.width;//宽度缩略比例
            int rate2 = height / this.height;//高度缩略比例
            int rate = rate1 > rate2 ? rate1 : rate2; //宽度缩略比例大于高度缩略比例，使用宽度缩略比例
            //计算缩略图最终的宽度和高度
            Thumbnails.of(bfImg).size(width / rate, height / rate).toFile(thumbsPath + thumbsName);

            ImagePO img = new ImagePO();
            img.setTitle(title);
            img.setFullUrl(fullUrl);
            img.setThumbsUrl(thumbsUrl);
            img.setDescription(description);
            imageService.saveImage(img);
        } catch (IOException e) {
            e.printStackTrace();
            return "faild";
        }

        return "success";
    }

}
