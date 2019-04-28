package application.controllers;

import application.entities.Article;
import application.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingsController {
    @Autowired
    private ArticleRepo articleRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", "Pureir");
        return "greeting";
    }



    @GetMapping("/withdata")
    public String mian (Map<String, Object> model) {
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "greeting";
    }

    @PostMapping
    public String add(
            @RequestParam String title,
            @RequestParam String text1,
            @RequestParam String text2,
            Map<String, Object> model) {
        Article article = new Article(title, text1, text2);
        articleRepo.save(article);
        Iterable<Article> articles = articleRepo.findAll();
        model.put("articles", articles);
        return "greeting";
    }
}
