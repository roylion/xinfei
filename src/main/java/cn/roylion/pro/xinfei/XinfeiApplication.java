package cn.roylion.pro.xinfei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@SpringBootApplication
@MapperScan(basePackages = "cn.roylion.pro.xinfei.mapper")
public class XinfeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinfeiApplication.class, args);
    }
}
