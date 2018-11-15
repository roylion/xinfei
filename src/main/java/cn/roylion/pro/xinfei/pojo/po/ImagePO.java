package cn.roylion.pro.xinfei.pojo.po;

/**
 * @Author: Roylion
 * @Description:
 * @Date: Created in 13:07 2018/11/15
 */
public class ImagePO {

    private Integer id;
    private String title;
    private String thumbsUrl;
    private String fullUrl;
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbsUrl() {
        return thumbsUrl;
    }

    public void setThumbsUrl(String thumbsUrl) {
        this.thumbsUrl = thumbsUrl;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
