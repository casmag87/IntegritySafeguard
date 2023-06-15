package DTO;

public class ArticleDTO {

    Long id;
    String title;
    String opening;
    String imgUrl;
    String published;
    String MainSection;


    public ArticleDTO() {
    }

    public ArticleDTO(Long id, String title, String opening, String imgUrl, String published, String mainSection) {
        this.id = id;
        this.title = title;
        this.opening = opening;
        this.imgUrl = imgUrl;
        this.published = published;
        MainSection = mainSection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getMainSection() {
        return MainSection;
    }

    public void setMainSection(String mainSection) {
        MainSection = mainSection;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", opening='" + opening + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", published='" + published + '\'' +
                ", MainSection='" + MainSection + '\'' +
                '}';
    }
}
