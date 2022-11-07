package mustache.practice.controller;

import lombok.extern.slf4j.Slf4j;
import mustache.practice.domain.ArticleDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/articles")
public class ArticleController {

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping(value = "/posts")
    public String newArticleForm(ArticleDto form) {
        log.info(form.toString());
        return "";
    }
}
