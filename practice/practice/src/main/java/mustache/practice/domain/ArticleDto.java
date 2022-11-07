package mustache.practice.domain;

import lombok.Getter;
import mustache.practice.domain.entity.Article;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public ArticleDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
    public Article toEntity(){
        return new Article(title, content);
    }
}
