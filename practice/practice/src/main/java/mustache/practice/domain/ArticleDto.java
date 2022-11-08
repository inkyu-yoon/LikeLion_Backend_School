package mustache.practice.domain;

import lombok.Getter;
import mustache.practice.domain.entity.Article;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class ArticleDto {

    private String title;


    public ArticleDto( String title) {

        this.title = title;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                '}';
    }
    public Article toEntity(){
        return new Article(this.title);
    }
}
