package mustache.practice.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "article3")
@Entity
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;


    public Article(String title,String contents) {
        this.title = title;
        this.contents = contents;
    }
}
