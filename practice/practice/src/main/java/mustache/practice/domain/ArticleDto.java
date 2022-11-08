package mustache.practice.domain;

import lombok.Getter;
import mustache.practice.domain.entity.Article;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public class ArticleDto {

    private String title;
    private String contents;


    public ArticleDto( String title,String contents) {

        this.title = title;
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

    public Article toEntity(){
        return new Article(this.title,this.contents);
    }
}
