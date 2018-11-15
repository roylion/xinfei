package cn.roylion.pro.xinfei.controller;

import cn.roylion.pro.xinfei.mapper.ImageMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 11:09 2018/11/15
 */
@Controller
public class IndexController {

    @Resource
    private ImageMapper imageMapper;
    
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("name", "柳大拿");
        return "hello";
    }

    @GetMapping("photos")
    public String photoWall(Map map) {
        List imgs = imageMapper.listImages();
        map.put("imgs",imgs);
        System.out.println();
        return "photo_wall";
    }
}
