package mustache.practice.controller;

import lombok.extern.slf4j.Slf4j;
import mustache.practice.domain.ArticleDto;
import mustache.practice.domain.entity.Article;
import mustache.practice.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping(value = "/new")
    public String createPage() {
        return "articles/new";
    }

    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle = articleRepository.save((articleDto.toEntity()));
        log.info("generatedId:{}", savedArticle.getId());
        return "";
    }
}
