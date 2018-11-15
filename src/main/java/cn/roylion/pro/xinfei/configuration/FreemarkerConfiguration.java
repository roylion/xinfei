package cn.roylion.pro.xinfei.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 12:18 2018/11/15
 */
@Configuration
public class FreemarkerConfiguration {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Value("${xinfei.freemarker.baseUrl}")
    private String baseUrl;


    // Spring 初始化的时候加载配置
    @PostConstruct
    public void setConfigure() throws Exception {
        // 加载html的资源路径
        configuration.setSharedVariable("baseUrl", baseUrl);

    }
}
