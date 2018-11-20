package cn.roylion.pro.xinfei.controller;

import cn.roylion.pro.xinfei.pojo.po.ImagePO;
import cn.roylion.pro.xinfei.service.ImageService;
import cn.roylion.pro.xinfei.util.ObjectUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 11:09 2018/11/15
 */
@Controller
public class IndexController {

    @Resource
    private ImageService imageService;

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("name", "柳大拿");
        return "hello";
    }

    @GetMapping("photos")
    public String photoWall(@RequestParam(required = false) Integer pageNum,
                            @RequestParam(required = false) Integer pageSize,
                            Map map) {

        Page<ImagePO> page = imageService.getImagesPage(null,
                ObjectUtils.getDef(pageNum, 1), ObjectUtils.getDef(pageSize, 50));

        Map data = new HashMap();
        data.put("imgs", page.getResult());
        data.put("total", page.getTotal());
        data.put("pageNum", page.getPageNum());
        data.put("pageSize", page.getPageSize());
        map.put("data", JSONObject.toJSONString(data));

        return "photo_wall";
    }
}
